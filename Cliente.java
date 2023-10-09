import java.util.Scanner;

public class Cliente {
    private String nombre;
    private String rut;
    private CuentaBancaria cuentaBancaria;
    private int creditoPorCobrar;

    public Cliente(String nombre, String rut, CuentaBancaria cuentaBancaria) {
        this.nombre = nombre;
        this.rut = rut;
        this.cuentaBancaria = new CuentaBancaria(rut); // Se usa el RUT del cliente como ID de la cuenta bancaria
        this.creditoPorCobrar = 0;
    }
    // Getters
    public String getNombre() {return nombre;}
    public String getRut() {return rut;}
    public CuentaBancaria getCuentaBancaria() {return cuentaBancaria;}
    public int getCreditoPorCobrar() {return creditoPorCobrar;}

    // Setter
    public void setCreditoPorCobrar(int creditoPorCobrar) {this.creditoPorCobrar = creditoPorCobrar;}

    // Métodos
    public void mostrarInformacionCuenta() {
        System.out.println("El cliente "+getNombre()+" tiene una cuenta con ID "+getCuentaBancaria().getIdCuentaBancaria()+" con un saldo en debito de "+getCuentaBancaria().getSaldoDebito()+" y un saldo de credito"+getCuentaBancaria().getSaldoCreditoActual());
    }
    public void realizarCompra() {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuánto es el monto de la compra? (0 para volver al menú principal)");
        int montoCompra = sc.nextInt();
        if (montoCompra < 0) {
            System.out.println("El monto de la compra debe ser positivo");
        } else {
            System.out.println("¿Cómo desea realizar su compra?");
            System.out.println("1. Débito");
            System.out.println("2. Crédito");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    int saldoDebito = getCuentaBancaria().getSaldoDebito();
                    if (montoCompra <= saldoDebito) {
                        saldoDebito -= montoCompra;
                        getCuentaBancaria().setSaldoDebito(saldoDebito);
                        System.out.println("La compra ha sido realizada con éxito");
                    } else {
                        System.out.println("No se ha podido realizar la compra");
                    }
                    break;
                case 2:
                    int saldoCreditoActual = getCuentaBancaria().getSaldoCreditoActual();
                    if (montoCompra <= saldoCreditoActual) {
                        saldoCreditoActual -= montoCompra;
                        getCuentaBancaria().setSaldoCreditoActual(saldoCreditoActual);
                        creditoPorCobrar += montoCompra;
                        setCreditoPorCobrar(creditoPorCobrar);
                        System.out.println("La compra ha sido realizada con éxito");
                    } else {
                        System.out.println("No se ha podido realizar la compra");
                    }
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
        sc.close();
    }
            
    public void pagarCreditoconDebito(int montoPagar) {
        int saldoCreditoActual = getCuentaBancaria().getSaldoCreditoActual();
        int saldoDebito = getCuentaBancaria().getSaldoDebito();
        if (montoPagar <= saldoCreditoActual) {
            saldoCreditoActual -= montoPagar;
            getCuentaBancaria().setSaldoCreditoActual(saldoCreditoActual);
            saldoDebito += montoPagar;
            getCuentaBancaria().setSaldoDebito(saldoDebito);
            creditoPorCobrar -= montoPagar;
            setCreditoPorCobrar(creditoPorCobrar);
            System.out.println("El pago ha sido realizado con éxito");
        } else {
            System.out.println("No se ha podido realizar el pago");
        }
    }
    public void retirarDinero(int montoRetiro) {
        int saldoDebito = getCuentaBancaria().getSaldoDebito();
        if (montoRetiro <= saldoDebito) {
            saldoDebito -= montoRetiro;
            getCuentaBancaria().setSaldoDebito(saldoDebito);
            System.out.println("El retiro ha sido realizado con éxito");
        } else {
            System.out.println("No se ha podido realizar el retiro. No hay suficiente dinero en la cuenta.");
        }
    }
    public void avanceCredito() {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿De cuanto quiere su avance?");
        int montoAvance = sc.nextInt();
        if (montoAvance < 0) {
            System.out.println("El monto de la compra debe ser positivo");
        } else {
            int saldoCreditoActual = getCuentaBancaria().getSaldoCreditoActual();
            int saldoDebito = getCuentaBancaria().getSaldoDebito();
            if (montoAvance <= saldoCreditoActual) {
                saldoDebito += montoAvance;
                getCuentaBancaria().setSaldoDebito(saldoDebito);
                saldoCreditoActual -= montoAvance;
                getCuentaBancaria().setSaldoCreditoActual(saldoCreditoActual);
                creditoPorCobrar += montoAvance;
                setCreditoPorCobrar(creditoPorCobrar);
                System.out.println("El avance ha sido realizado con éxito");
            } else {
                System.out.println("No se pudo realizar el avance"); 
            }
        }
        sc.close();
    }   
}