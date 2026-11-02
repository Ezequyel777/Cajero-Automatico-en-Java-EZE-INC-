# EZE-INC | Cajero Automático

Aplicación de consola desarrollada en **Java**, que simula el funcionamiento de un cajero automático mediante la gestión de cuentas bancarias y operaciones financieras básicas.

El proyecto utiliza una organización basada en el patrón **MVC (Modelo-Vista-Controlador)**, separando las responsabilidades de la lógica de negocio, la interfaz de usuario y la gestión de datos.

## Funcionalidades

- **Registro de usuarios:** creación de nuevas cuentas bancarias.
- **Inicio de sesión:** autenticación mediante nombre de usuario y contraseña.
- **Consulta de saldo:** visualización de la información de la cuenta.
- **Depósitos:** ingreso de dinero a la cuenta bancaria.
- **Retiros:** extracción de dinero con validación de saldo disponible.
- **Transferencias:** envío de dinero entre diferentes cuentas registradas.
- **Validaciones:** control de montos inválidos, saldo insuficiente y nombres de usuario duplicados.
- **Persistencia de datos:** almacenamiento y actualización de la información mediante archivos `.txt`.

## Tecnologías utilizadas

- **Java:** lenguaje principal de desarrollo.
- **Java Collections:** utilización de `ArrayList` para administrar las cuentas registradas.
- **Java NIO:** manipulación y lectura de archivos mediante `Path`, `Files` e `InputStream`.
- **Git y GitHub:** control de versiones y almacenamiento del código fuente.

## Arquitectura del proyecto

El proyecto está organizado en diferentes paquetes para mantener una separación de responsabilidades.

| Paquete | Responsabilidad |
|---|---|
| `Models` | Representación de las cuentas bancarias y sus operaciones. |
| `Views` | Interacción con el usuario mediante la consola. |
| `Controllers` | Control del flujo de ejecución y coordinación de las operaciones. |
| `Repository` | Administración de las cuentas y persistencia de datos. |

## Estructura de directorios

```text
CajeroAutomaticoV2/
│
├── src/
│   ├── Controllers/
│   ├── Models/
│   ├── Repository/
│   ├── Views/
│   └── Main.java
│
├── data/
│   └── ListaUsuarios.txt
│
├── .gitignore
└── CajeroAutomaticoV2.iml
```

### Organización de clases

- `CuentaBancariaModel`: contiene los atributos de cada cuenta, como nombre, contraseña y saldo. También implementa las operaciones de depósito, retiro y validación de contraseña.
- `ConsoleView`: administra los mensajes, menús y entradas de datos del usuario.
- `BancoController`: gestiona la navegación, el inicio de sesión, el registro y las operaciones bancarias.
- `CuentaRepository`: administra las cuentas registradas y se encarga de almacenar y recuperar la información.

## Almacenamiento de datos

La aplicación utiliza un archivo de texto (`ListaUsuarios`) para almacenar la información de las cuentas.

Los registros utilizan el punto y coma (`;`) como separador entre campos:

```text
Nombre;Contraseña;Saldo;
Ezequiel;123456;10000;
Sofia;654321;5000;
```

De esta manera, la aplicación puede recuperar los datos almacenados y reconstruir las cuentas al iniciar su ejecución.

## Ejecución

1. Clonar el repositorio:

```bash
git clone https://github.com/Ezequyel777/CajeroAutomaticoV2.git
```

2. Abrir el proyecto desde un entorno de desarrollo compatible con Java, como IntelliJ IDEA, Eclipse o Visual Studio Code.

3. Verificar la configuración de la ruta del archivo `ListaUsuarios` en el repositorio.

4. Ejecutar la clase principal del proyecto.

## Objetivo del proyecto

Este proyecto tiene como objetivo poner en práctica los conocimientos adquiridos en programación orientada a objetos, estructuras de datos, separación de responsabilidades y manipulación de archivos.

También busca fortalecer la comprensión de conceptos como:

- Encapsulamiento.
- Clases y objetos.
- Referencias a objetos.
- Colecciones dinámicas.
- Manejo de excepciones.
- Validación de datos.
- Persistencia de información.
- Organización de código mediante una arquitectura MVC.

---

**Desarrollado por Ezequiel Agustín Santillan.**

*Proyecto personal de aprendizaje y práctica en Java.*
