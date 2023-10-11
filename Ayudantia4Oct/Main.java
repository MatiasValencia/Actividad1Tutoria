package Ayudantia4Oct;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese su nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese su rut: ");
        String rut = sc.nextLine();

        Cliente cliente = new Cliente(nombre, rut, new CuentaBancaria(rut));

        int opcion;
        do {
            System.out.println("Bienvenido " + cliente.getNombre() + ", ¿Qué desea hacer?");
            System.out.println("1. Mostrar información de la cuenta");
            System.out.println("2. Realizar una compra");
            System.out.println("3. Pagar crédito con débito");
            System.out.println("4. Retirar dinero");
            System.out.println("5. Realizar un avance");
            System.out.println("6. Salir");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    cliente.mostrarInformacionCuenta();
                    break;
                case 2:
                    cliente.realizarCompra();
                    break;
                case 3:
                    cliente.pagarCreditoconDebito(opcion);
                    break;
                case 4:
                    cliente.retirarDinero(opcion);
                    break;
                case 5:
                    cliente.avanceCredito();
                    break;
                case 6:
                    System.out.println("Gracias por usar nuestro programa");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 6);

        sc.close();
    }
}
