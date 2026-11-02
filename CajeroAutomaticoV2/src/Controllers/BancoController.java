package Controllers;

import Models.CuentaBancariaModel;
import Repository.CuentaRepository;
import Views.ConsoleView;

import java.util.Objects;

public class BancoController {
    private final ConsoleView vista = new ConsoleView();

    private final CuentaRepository repository = new CuentaRepository();

    public void iniciar()
    {
        boolean ejecutando = true;

        while (ejecutando) {
            vista.mostrarBienvenida();
            repository.cargar();

            switch (vista.leerOpciones()) {
                case 1:
                    login();
                    break;
                case 2:
                    crearCuenta();
                    break;
                case 3:
                    ejecutando = false;
                    vista.mostrarDespedida();
                    break;
                default:
                    //vista.mostrarOpcionInvalida();
                    break;
            }
        }
    }

    private void login()
    {
        String nombre = vista.leerUsuario();
        String contrasena = vista.leerPassword();

        for (CuentaBancariaModel c : repository.cuentasRegistradas) {
            if (c.getNombre().equals(nombre)
                    && c.validarPassword(contrasena)) {

                repository.cuenta = c;
                vista.mostrarLoginExitoso(nombre);

                menuPrincipal();
                return;
            }
        }

        vista.mostrarLoginFallido();
    }

    private void crearCuenta()
    {
        vista.mostrarTituloCrearCuenta();

        String nombreInput = vista.leerNuevoUsuario();
        String contrasenaInput = vista.leerNuevaPassword();
        String contrasenarepetidaInput = vista.leerConfirmacionPassword();

        if(Objects.equals(contrasenaInput, contrasenarepetidaInput))
        {
            CuentaBancariaModel nuevaCuenta = new CuentaBancariaModel(nombreInput, contrasenaInput, 0);
            if(repository.registrarCuenta(nuevaCuenta)) vista.mostrarCuentaCreada(nombreInput);
            else vista.mostrarNombreCuentaExistente();
        }
        else vista.mostrarPasswordsNoCoinciden();

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

    private void menuPrincipal()
    {
        boolean sesionActiva = true;

        while (sesionActiva) {
            vista.mostrarMenuPrincipal();

            switch (vista.leerOpciones()) {
                case 1:
                    mostrarInformacion();
                    break;

                case 2:
                    ingresarDinero();
                    break;

                case 3:
                    retirarDinero();
                    break;

                case 4:
                    tranferirDinero();
                    break;

                case 5:
                    sesionActiva = false;
                    cerrarSesion();
                    break;

                default:
                    //vista.mostrarOpcionInvalida();
                    break;
            }
        }
    }

    private void mostrarInformacion()
    {
        vista.mostrarInformacion(repository.cuenta.getNombre(), repository.cuenta.getSaldo());
    }

    private void ingresarDinero()
    {
        double deposito = vista.leerMontoDeposito();

        if(repository.depositar(deposito)) vista.mostrarDepositoExitoso();
        else vista.mostrarDepositoFallido();

    }

    private void retirarDinero()
    {
        double retiro = vista.leerMontoRetiro();

        if(repository.retirar(retiro)) vista.mostrarRetiroExitoso();
        else vista.mostrarRetiroFallido();
    }

    private void tranferirDinero()
    {
        vista.mostrarTituloTransferir();
        String addressee = vista.leerUsuarioDestino();
        double amount = vista.leerMontoTransferencia();

        vista.mostrarConfirmacionTransferencia(addressee, amount);
        if(vista.leerOpciones() == 1)
        {
            switch (repository.transferenciaDeDinero(addressee, amount))
            {
                case 0:
                    vista.mostrarTransferenciaExitosa(addressee, amount);
                    break;
                case 1:
                    vista.mostrarMontoTransferenciaInvalido();
                    break;
                case 2:
                    vista.mostrarTransferenciaAMismaCuenta();
                    break;
                case 3:
                    vista.mostrarSaldoInsuficiente();
                    break;
                case 4:
                    vista.mostrarDebitoFallido();
                    break;
                case 5:
                    vista.mostrarAcreditacionFallida();
                    break;
                case 6:
                    vista.mostrarErrorGuardandoTransferencia();
                    break;
                case 7:
                    vista.mostrarCuentaDestinoNoEncontrada();
                    break;
            }
        } else if (vista.leerOpciones() == 2) {
            vista.mostrarTransferenciaCancelada();
        }

       // menuPrincipal();
    }
}
