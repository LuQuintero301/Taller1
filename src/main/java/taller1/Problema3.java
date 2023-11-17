package taller1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Cliente {

    private String nombres;
    private String apellidos;
    private int edad;
    private Cliente representante;

    public Cliente(String nombres, String apellidos, int edad) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.representante = null;
    }

    public Cliente(String nombres, String apellidos, int edad, Cliente representante) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.representante = representante;
    }
}

class Cuenta {

    public double getSaldo() {
        return this.saldo;
    }

    protected static final double TASA_RENDIMIENTO_ANUAL = 0.022;

    private static final double MONTO_MINIMO_CORRIENTE = 200000;
    private static final double TASA_MANTENIMIENTO_MENSUAL = 0.015;
    private static final double COSTO_CHEQUE_EMITIDO = 3000;
    private static final double MONTO_DESCUENTO_1 = 7000;
    private static final double MONTO_DESCUENTO_2 = 5000;
    private static final double TASA_DESCUENTO_2 = 0.02;
    private static final double MONTO_DESCUENTO_3 = 4000;
    private static final double TASA_DESCUENTO_3 = 0.02;
    private static final double TASA_DESCUENTO_4 = 0.033;

    private Cliente cliente;
    private double saldo;

    public Cuenta(Cliente cliente) {
        this.cliente = cliente;
        this.saldo = 0;
    }

    public void depositar(double monto) {
       
    }

    public void retirar(double monto) {
       
    }

    public void cobrarComisiones() {
        
    }

   
}

class CuentaAhorro extends Cuenta {

    private static final double MONTO_DESCUENTO_4_AHORRO = 3000;
    private static final double TASA_DESCUENTO_1_AHORRO = 0.01;
    private static final double MONTO_DESCUENTO_2_AHORRO = 2000;
    private static final double TASA_DESCUENTO_2_AHORRO = 0.005;
    private static final double TASA_DESCUENTO_3_AHORRO = 0.018;

    public CuentaAhorro(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void depositar(double monto) {
       
    }

   
}

class CuentaCorriente extends Cuenta {

    private static final double MONTO_DESCUENTO_4_CORRIENTE = 4500;

    public CuentaCorriente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void depositar(double monto) {
        if (monto > 0) {
            
            super.depositar(monto);

            
            if (monto < 500000) {
                super.retirar(7000);
            } else if (monto >= 500000 && monto < 2000000) {
                double descuento = 5000 + monto * 0.02;
                super.retirar(descuento);
            } else if (monto >= 2000000 && monto <= 10000000) {
                double descuento = 4000 + monto * 0.02;
                super.retirar(descuento);
            } else if (monto > 10000000 && monto < 100000000) {
                double descuento = monto * 0.033;
                super.retirar(descuento);
            } else if (monto >= 100000000) {
                double descuento = monto * 0.02;
                super.retirar(descuento);
            }

            System.out.println("Depósito realizado en cuenta corriente. Nuevo saldo: " + getSaldo());
        } else {
            System.out.println("El monto del depósito debe ser mayor que cero.");}
        
    }
}

class Banco {

    private List<Cuenta> cuentas;

        public Banco() {
            this.cuentas = new ArrayList<>();
        }

        public void abrirCuentaAhorro(Cliente cliente) {
            CuentaAhorro cuentaAhorro = new CuentaAhorro(cliente);
            cuentas.add(cuentaAhorro);
            System.out.println("¡Cuenta de ahorro abierta exitosamente!");
        }

        public void abrirCuentaCorriente(Cliente cliente) {
            CuentaCorriente cuentaCorriente = new CuentaCorriente(cliente);
            cuentas.add(cuentaCorriente);
            System.out.println("¡Cuenta corriente abierta exitosamente!");

        }

        public void hacerTransferencia(Cuenta origen, Cuenta destino, double monto) {
            if (origen == null || destino == null) {
                System.out.println("Cuentas inválidas para la transferencia.");
                return;
            }

            if (monto <= 0) {
                System.out.println("El monto de la transferencia debe ser mayor que cero.");
                return;
            }

            if (origen.getSaldo() >= monto) {
            
                origen.retirar(monto);
                destino.depositar(monto);

                System.out.println("Transferencia realizada exitosamente.");
                System.out.println("Nuevo saldo en la cuenta de origen: " + origen.getSaldo());
                System.out.println("Nuevo saldo en la cuenta de destino: " + destino.getSaldo());
            } else {
                System.out.println("Saldo insuficiente en la cuenta de origen para realizar la transferencia.");
            }
        }

        public void depositar(Cuenta cuenta, double monto) {
            cuenta.depositar(monto);
            System.out.println("Depósito realizado exitosamente.");
        }

        public void retirar(Cuenta cuenta, double monto) {
            cuenta.retirar(monto);
            System.out.println("Retiro realizado exitosamente.");
        }

        public void cobrarComisiones(Cuenta cuenta) {
            cuenta.cobrarComisiones();
            System.out.println("Comisiones cobradas exitosamente.");
        }

        public void generarEstadoCuenta(Cuenta cuenta) {
            
        }

}    
    
public class Problema3 {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("Menú:");
            System.out.println("1. Aperturas de Cuentas: Ahorro y Corriente");
            System.out.println("2. Transferencias");
            System.out.println("3. Cajero Automático");
            System.out.println("4. Cierre de mes (Estado de Cuenta)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Seleccione el tipo de cuenta:");
                    System.out.println("1. Cuenta de Ahorro");
                    System.out.println("2. Cuenta Corriente");
                    int tipoCuenta = scanner.nextInt();

                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombres = scanner.next();

                    System.out.print("Ingrese el apellido del cliente: ");
                    String apellidos = scanner.next();

                    System.out.print("Ingrese la edad del cliente: ");
                    int edad = scanner.nextInt();

                    Cliente cliente = new Cliente(nombres, apellidos, edad);

                    if (tipoCuenta == 1) {
                        banco.abrirCuentaAhorro(cliente);
                    } else if (tipoCuenta == 2) {
                        banco.abrirCuentaCorriente(cliente);
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;

                case 2:
                  
                    break;

                case 3:
                    System.out.println("Seleccione la operación en el Cajero Automático:");
                    System.out.println("1. Retirar dinero");
                    System.out.println("2. Depositar dinero");
                    int operacionCajero = scanner.nextInt();

                    System.out.print("Ingrese el número de cuenta: ");
                    int numeroCuenta = scanner.nextInt();

               
                    Cuenta cuentaSeleccionada = obtenerCuentaPorNumero(banco, numeroCuenta);

                    if (cuentaSeleccionada != null) {
                        if (operacionCajero == 1) {
                           
                        } else if (operacionCajero == 2) {
                          
                        } else {
                            System.out.println("Opción no válida.");
                        }
                    } else {
                        System.out.println("Cuenta no encontrada.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el número de cuenta para generar el Estado de Cuenta: ");
                    int numeroCuentaEstadoCuenta = scanner.nextInt();

                   
                    Cuenta cuentaEstadoCuenta = obtenerCuentaPorNumero(banco, numeroCuentaEstadoCuenta);

                    if (cuentaEstadoCuenta != null) {
                        banco.generarEstadoCuenta(cuentaEstadoCuenta);
                    } else {
                        System.out.println("Cuenta no encontrada.");
                    }
                    break;

                case 0:
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static Cuenta obtenerCuentaPorNumero(Banco banco, int numeroCuenta) {
      
        return null;
    }
}