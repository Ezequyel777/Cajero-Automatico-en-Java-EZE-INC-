package Repository;

import Models.CuentaBancariaModel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class CuentaRepository {
    private Path pathInputOutput = Path.of("data", "ListaUsuarios");
    private InputStream input;
    private OutputStream output;
    public ArrayList<CuentaBancariaModel> cuentasRegistradas = new ArrayList<CuentaBancariaModel>();
    public CuentaBancariaModel cuenta;

    private char[] construirCadenaDeDatos(CuentaBancariaModel newAccount)
    {
        String data = "";

        if(newAccount != null)
        {
            data += newAccount.getNombre() + ";";
            data += newAccount.getContrasena() + ";";
            data += "0" + ";";
        }

        for(CuentaBancariaModel cuenta : cuentasRegistradas)
        {
            data += cuenta.getNombre() + ";";
            data += cuenta.getContrasena() + ";";
            data += cuenta.getSaldo() + ";";
        }

        char[] cadenaDeDatos = data.toCharArray();

        return cadenaDeDatos;
    }

    public void cargar()
    {
        cuentasRegistradas.clear();
        CuentaBancariaModel cuenta = new CuentaBancariaModel();
        Data data = Data.nombre;

        try{
            input = Files.newInputStream(pathInputOutput, StandardOpenOption.READ);
            int i;
            String str = "";
            while (( i = input.read()) != -1) {

                if ((char) i == ';' && data == Data.nombre) {
                    if(!cuenta.setNombre(str)) System.out.print("Error al setear el nombre.");

                    data = Data.contrasena;
                    str = "";
                }
                else if ((char)i == ';' && data == Data.contrasena) {
                    if(!cuenta.setContrasena(str)) System.out.print("Error al setear la contrasena.");

                    data = Data.saldo;
                    str = "";
                }
                else if ((char)i == ';' && data == Data.saldo) {
                    double balance = Double.parseDouble(str);

                    if(!cuenta.setSaldo(balance)) System.out.print("Error al setear la contrasena.");

                    cuentasRegistradas.add(cuenta);
                    data = Data.nombre;
                    str = "";
                    cuenta = new CuentaBancariaModel();
                }
                else {
                    if ((char)i != '\n' && (char)i != '\r') {
                        str += (char) i;
                    }
                }
            }
            input.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private boolean actualizar(char[] dataRepository)
    {
        try{
            output = Files.newOutputStream(pathInputOutput, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
            for (char caracter : dataRepository)
            {
                output.write(caracter);
            }
            output.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    public boolean registrarCuenta(CuentaBancariaModel newAccount)
    {
        for (CuentaBancariaModel c : cuentasRegistradas)
        {
            if(c.getNombre().equals(newAccount.getNombre())) return false;
        }

        try{
            output = Files.newOutputStream(pathInputOutput, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
            for (char caracter : construirCadenaDeDatos(newAccount))
            {
                output.write(caracter);
            }
            output.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    public boolean depositar(double deposit)
    {
        if(deposit <= 0) return false;

        if(!cuenta.depositar(deposit)) return false;
        else {
            actualizar(construirCadenaDeDatos(null));
            return true;
        }
    }

    public boolean retirar(double remove)
    {
        if(remove <= 0) return false;

        if(!cuenta.retirar(remove)) return false;
        else {
            actualizar(construirCadenaDeDatos(null));
            return true;
        }
    }

    public int transferenciaDeDinero(String addressee, double amount)
    {
        if (amount <= 0) return 1;

        if(addressee.equals(cuenta.getNombre())) return 2;

        if(this.cuenta.getSaldo() < amount) return 3;

        for (CuentaBancariaModel c : cuentasRegistradas)
        {
            if(addressee.equals(c.getNombre()))
            {
                if(!cuenta.retirar(amount)) return 4;
                else if (!c.depositar(amount)) return 5;
                else if(!actualizar(construirCadenaDeDatos(null))) return 6;

                return 0;
            }
        }
        return 7;
    }


}

 enum Data {
    nombre,
    contrasena,
    saldo;
}