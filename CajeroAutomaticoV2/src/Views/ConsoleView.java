package Views;
import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner = new Scanner(System.in);

    public void mostrarBienvenida() {
        System.out.println("""
                ========================================
                       ¡BIENVENIDO A EZE-INC!
                ========================================
 
                1. Iniciar sesión.
                2. Salir.
                """);
    }

    public int leerOpciones() {
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public void mostrarTituloLogin() {
        System.out.println("""
                ========================================
                          INICIAR SESIÓN
                ========================================
                """);
    }

    public String leerUsuario() {
        System.out.print("Usuario: ");
        scanner.nextLine(); // limpia el buffer si venía de un nextInt()
        return scanner.nextLine();
    }

    public String leerPassword() {
        System.out.print("Contraseña: ");
        return scanner.nextLine();
    }

    public void mostrarLoginExitoso(String nombreUsuario) {
        System.out.println("""
                ========================================
                        ¡INICIO DE SESIÓN EXITOSO!
                ========================================
                """);
        System.out.println("¡Bienvenido nuevamente, " + nombreUsuario + "!");
        System.out.print("Presioná ENTER para continuar...");
        scanner.nextLine();
    }

    public void mostrarLoginFallido() {
        System.out.println("Usuario o contraseña incorrectos.\n");
    }

    public void mostrarMenuPrincipal() {
        System.out.println("""
                ========================================
                             MENÚ PRINCIPAL
                ========================================
                1. Mostrar mi información.
                2. Ingresar dinero.
                3. Retirar dinero.
                4. Cerrar sesión.
                """);
    }

    public void mostrarInformacion(String nombreUsuario, double saldo) {
        System.out.println("""
                ========================================
                          MI INFORMACIÓN
                ========================================""");
        System.out.println("Usuario: " + nombreUsuario);
        System.out.println("Saldo disponible: $" + saldo);
        System.out.println("========================================\n");
    }

    public float leerMontoDeposito() {
        System.out.print("Monto a depositar: ");
        return scanner.nextFloat();
    }

    public void mostrarDepositoExitoso() {
        System.out.println("Depósito realizado con éxito.\n");
    }

    public void mostrarDepositoFallido() {
        System.out.println("Monto inválido. Tiene que ser mayor a 0.\n");
    }

    public float leerMontoRetiro() {
        System.out.print("Monto a retirar: ");
        return scanner.nextFloat();
    }

    public void mostrarRetiroExitoso() {
        System.out.println("Retiro realizado con éxito.\n");
    }

    public void mostrarRetiroFallido() {
        System.out.println("Monto inválido o saldo insuficiente.\n");
    }

    public void mostrarConfirmacionCierreSesion() {
        System.out.println("""
                ========================================
                          CERRAR SESIÓN
                ========================================
                1. Sí, cerrar sesión.
                2. No, volver al menú.
                """);
    }

    public void mostrarDespedida() {
        System.out.println("¡Gracias por usar EZE-INC! Hasta la próxima.");
    }
}
