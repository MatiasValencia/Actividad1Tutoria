public class CuentaBancaria {
    private String idCuentaBancaria;
    private int saldoDebito;
    private int saldoCreditoMaximo;
    private int saldoCreditoActual;

    public CuentaBancaria(String idCuentaBancaria) {
        this.idCuentaBancaria = idCuentaBancaria;
        this.saldoDebito = 0;
        this.saldoCreditoMaximo = 1000000;
        this.saldoCreditoActual = 1000000;
    }
    //Getters
    public String getIdCuentaBancaria() {return idCuentaBancaria;}
    public int getSaldoDebito() {return saldoDebito;}
    public int getSaldoCreditoMaximo() {return saldoCreditoMaximo;}
    public int getSaldoCreditoActual() {return saldoCreditoActual;}

    //Setters
    public void setSaldoDebito(int saldoDebito) {this.saldoDebito = saldoDebito;}
    public void setSaldoCreditoActual(int saldoCreditoActual) {this.saldoCreditoActual = saldoCreditoActual;}

    public void restarSaldo(int montoARestar) {
        if (montoARestar > 0) {
            if (saldoDebito >= montoARestar) {
                saldoDebito -= montoARestar;
            } else if (saldoCreditoActual >= montoARestar) {
                saldoCreditoActual -= montoARestar;
            } else {
                System.out.println("No hay suficiente saldo para realizar la operación.");
            }
        } else {
            System.out.println("El monto a restar debe ser positivo.");
        }
    }
}