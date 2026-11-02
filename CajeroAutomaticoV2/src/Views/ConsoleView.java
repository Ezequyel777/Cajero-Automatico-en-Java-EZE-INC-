package Views;
import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner = new Scanner(System.in);

    public int leerOpciones() {
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    // region Bienvenida

    public void mostrarBienvenida() {
        System.out.println("""
                ========================================
                       ¡BIENVENIDO A EZE-INC!
                ========================================
 
                1. Iniciar sesión.
                2. Crear cuenta.
                3. Salir.
                """);
    }

    // endregion

    // region Crear Cuenta

    public void mostrarTituloCrearCuenta() {
        System.out.println("""
                ========================================
                            CREAR CUENTA
                ========================================
 
                Elegí un usuario y una contraseña.
                (No pueden estar vacíos ni contener ";")
                """);
    }

    public String leerNuevoUsuario() {
        System.out.print("Nuevo usuario: ");
        scanner.nextLine(); // limpia el buffer si venía de un nextInt()
        return scanner.nextLine();
    }

    public String leerNuevaPassword() {
        System.out.print("Nueva contraseña: ");
        return scanner.nextLine();
    }

    public String leerConfirmacionPassword() {
        System.out.print("Repetí la contraseña: ");
        return scanner.nextLine();
    }

    public void mostrarNombreCuentaExistente() {
        System.out.println("Ese nombre de usuario ya está registrado. Elegí otro.\n");
    }

    public void mostrarPasswordsNoCoinciden() {
        System.out.println("Las contraseñas no coinciden. No se creó la cuenta.\n");
    }

    public void mostrarCuentaCreada(String nombreUsuario) {
        System.out.println("""
                ========================================
                        ¡CUENTA CREADA CON ÉXITO!
                ========================================
                """);
        System.out.println("Ya podés iniciar sesión, " + nombreUsuario + ".");
        System.out.print("Presioná ENTER para continuar...");
        scanner.nextLine();
    }

    // endregion

    // region Inicio de Sesion

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

    // endregion

    // region Menu Principal

    public void mostrarMenuPrincipal() {
        System.out.println("""
        ========================================
                    MENÚ PRINCIPAL
        ========================================
        1. Mostrar mi información.
        2. Ingresar dinero.
        3. Retirar dinero.
        4. Transferir dinero.
        5. Cerrar sesión.
        """);
    }

    // endregion

    // region Informacion

    public void mostrarInformacion(String nombreUsuario, double saldo) {
        System.out.println("""
                ========================================
                          MI INFORMACIÓN
                ========================================""");
        System.out.println("Usuario: " + nombreUsuario);
        System.out.println("Saldo disponible: $" + saldo);
        System.out.println("========================================\n");
    }

    // endregion

    // region Deposito

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

    // endregion

    // region Retiro

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

    // endregion

    // region Tranferencia

    public void mostrarTituloTransferir() {
        System.out.println("""
                ========================================
                         TRANSFERIR DINERO
                ========================================
                """);
    }

    public String leerUsuarioDestino() {
        System.out.print("Usuario destino: ");
        scanner.nextLine(); // limpia el buffer si venía de un nextInt()
        return scanner.nextLine();
    }

    public double leerMontoTransferencia() {
        System.out.print("Monto a transferir: ");
        return scanner.nextFloat();
    }

    public void mostrarConfirmacionTransferencia(String destino, double monto) {
        System.out.println("""
                ========================================
                      CONFIRMAR TRANSFERENCIA
                ========================================""");
        System.out.println("Destino: " + destino);
        System.out.println("Monto: $" + monto);
        System.out.println("""
 
                1. Sí, transferir.
                2. No, cancelar.
                """);
    }

    public void mostrarTransferenciaExitosa(String destino, double monto) {
        System.out.println("Transferiste $" + monto + " a " + destino + " con éxito.\n");
    }

    public void mostrarTransferenciaCancelada() {
        System.out.println("Transferencia cancelada.\n");
    }

    public void mostrarTransferenciaFallida() {
        System.out.println("Cuenta no encontrada, monto inválido o saldo insuficiente.\n");
    }

    public void mostrarMontoTransferenciaInvalido() {
        System.out.println("El monto debe ser mayor a 0.\n");
    }

    public void mostrarCuentaDestinoNoEncontrada() {
        System.out.println("No se encontró la cuenta de destino.\n");
    }

    public void mostrarTransferenciaAMismaCuenta() {
        System.out.println("No podés transferir dinero a tu propia cuenta.\n");
    }

    public void mostrarAcreditacionFallida() {
        System.out.println("No se pudo acreditar el dinero en la cuenta de destino.\n");
    }

    public void mostrarDebitoFallido() {
        System.out.println("No se pudo debitar el dinero de tu cuenta.\n");
    }

    public void mostrarErrorGuardandoTransferencia() {
        System.out.println("Ocurrió un error al guardar la transferencia.\n");
    }

    public void mostrarSaldoInsuficiente() {
        System.out.println("Saldo insuficiente para realizar la transferencia.\n");
    }


    // endregion

    // region Cierre de Sesion

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

    // endregion
}
