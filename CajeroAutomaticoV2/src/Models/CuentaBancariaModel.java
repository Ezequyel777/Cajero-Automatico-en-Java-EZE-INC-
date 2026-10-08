package Models;

public class CuentaBancariaModel {

    private String nombreUsuario;
    private String contrasenaUsuario;
    private double saldo;

    public CuentaBancariaModel(String nombre, String contrasena, double saldo)
    {
        this.nombreUsuario = nombre;
        this.contrasenaUsuario = contrasena;
        this.saldo = saldo;
    }

    public String getNombreUsuario() { return nombreUsuario; }
    public String getContrasenaUsuario() {return contrasenaUsuario; }
    public double getSaldo() { return saldo; }

    public boolean depositar(double cantidad)
    {
        if(cantidad <= 0) return false;

        this.saldo += cantidad;

        return true;
    }

    public boolean retirar(double cantidad)
    {
        if (cantidad <= 0 || cantidad > this.saldo) return false;

        this.saldo -= cantidad;

        return true;
    }

    public boolean validarPassword(String passwordIngresada)
    {
        return this.contrasenaUsuario != null && this.contrasenaUsuario.equals(passwordIngresada);
    }
}

