package Controllers;

import Models.CuentaBancariaModel;
import Views.ConsoleView;

public class BancoController {
    private final ConsoleView vista = new ConsoleView();
    private CuentaBancariaModel cuenta;

    public void inicar(){
        vista.mostrarBienvenida();

        switch (vista.leerOpciones())
        {
            case 1 -> login();
            case 2 -> vista.mostrarDespedida();
        }
    }

    private void login(){
        CuentaBancariaModel cuentaRegistrada = new CuentaBancariaModel("Ezequiel", "290476mrs", 513000f);

        vista.mostrarTituloLogin();
        String usuarioInput = vista.leerUsuario();
        String passwordInput = vista.leerPassword();

        if(usuarioInput.equals(cuentaRegistrada.getNombreUsuario()) && cuentaRegistrada.validarPassword(passwordInput))
        {
            this.cuenta = cuentaRegistrada;
            vista.mostrarLoginExitoso(this.cuenta.getNombreUsuario());
            menuPrincipal();
        }
        else
        {
            vista.mostrarLoginFallido();
            inicar();
        }
    }

    private void menuPrincipal()
    {
        vista.mostrarMenuPrincipal();

        switch(vista.leerOpciones()) {
            case 1 -> this.mostrarInformacion();
            case 2 -> ingresarDinero();
            case 3 -> retirarDinero();
            case 4 -> cerrarSesion();
        }
    }

    private void mostrarInformacion()
    {
        vista.mostrarInformacion(this.cuenta.getNombreUsuario(), this.cuenta.getSaldo());
        menuPrincipal();
    }

    private void ingresarDinero()
    {
        double deposito = vista.leerMontoDeposito();

        if(this.cuenta.depositar(deposito))
        {
            vista.mostrarDepositoExitoso();
        }
        else
        {
            vista.mostrarDepositoFallido();
        }
        menuPrincipal();
    }

    private void retirarDinero()
    {
        double retiro = vista.leerMontoRetiro();

        if(this.cuenta.retirar(retiro))
        {
            vista.mostrarRetiroExitoso();
        }
        else
        {
            vista.mostrarRetiroFallido();
        }
        menuPrincipal();
    }

    private void cerrarSesion()
    {
        vista.mostrarConfirmacionCierreSesion();

        switch (vista.leerOpciones())
        {
            case 1 -> vista.mostrarDespedida();
            case 2 -> menuPrincipal();
        }
    }
}
