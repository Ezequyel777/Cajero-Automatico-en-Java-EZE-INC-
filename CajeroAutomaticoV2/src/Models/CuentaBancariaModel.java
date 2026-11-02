package Models;

public class CuentaBancariaModel {

    private String nombre;
    private String contrasena;
    private double saldo;

    public CuentaBancariaModel() {}

    public CuentaBancariaModel(String nombre, String contrasena, double saldo)
    {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.saldo = saldo;
    }

    public String getNombre()
    {
        return nombre;
    }

    public boolean setNombre(String name)
    {
        if (name == null || name.isBlank()) return false;
        this.nombre = name;
        return true;
    }

    public String getContrasena()
    {
        return contrasena;
    }

    public boolean setContrasena(String password)
    {
        if (password == null || password.isBlank()) return false;
        this.contrasena = password;
        return true;
    }

    public double getSaldo()
    {
        return saldo;
    }

    public boolean setSaldo(double amount)
    {
        if(amount < 0 || !Double.isFinite(amount)) return false;

        this.saldo = amount;

        return true;
    }

    public boolean depositar(double amount)
    {
        if(amount < 0 || !Double.isFinite(amount)) return false;

        this.saldo += amount;

        return true;
    }

    public boolean retirar(double amount)
    {
        if (amount < 0 || !Double.isFinite(amount) || amount > this.saldo) return false;

        this.saldo -= amount;

        return true;
    }

    public boolean validarPassword(String passwordEntered)
    {
        return this.contrasena != null && this.contrasena.equals(passwordEntered);
    }
}

