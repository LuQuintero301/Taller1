
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Problema2 {
    public static void main(String[] args) throws ParseException {
        
        Cliente cliente1 = new Cliente("Luisa");
        Barco barco1 = new Barco("BAC423", 10.5, 2020);

        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaInicio = dateFormat.parse("2023-11-20");
        Date fechaFin = dateFormat.parse("2023-11-25"); 

       
        cliente1.agregarAlquiler(barco1, fechaInicio, fechaFin, "A1");

     
        Alquiler alquiler = cliente1.getAlquileres().get(0);
        System.out.println("Información del Cliente:");
        System.out.println("Nombre: " + cliente1.getNombre());
        System.out.println("Alquiler:");
        System.out.println("  " + alquiler.getBarco().obtenerInformacion());
        System.out.println("  Fecha de inicio: " + dateFormat.format(alquiler.getFechaInicio())); 
        System.out.println("  Fecha de fin: " + dateFormat.format(alquiler.getFechaFin())); 
        System.out.println("  Posición de amarre: " + alquiler.getPosicionAmarre());
        System.out.println("  Costo del alquiler: $" + alquiler.calcularAlquiler());
    }
}
class Cliente {
  private String nombre;
  private int cantidadClientes;
  private List<Alquiler> alquileres;
  
    public List<Alquiler> getAlquileres() {
    return alquileres;
  }
  
   public String getNombre() {
    return nombre;
  }

  public Cliente(String nombre) {
    this.nombre = nombre;
    this.cantidadClientes = 0;
    this.alquileres = new ArrayList<>();
  }

  public void agregarAlquiler(Barco barco, Date fechaInicio, Date fechaFin, String posicionAmarre) {
    Alquiler alquiler = new Alquiler(this, barco, fechaInicio, fechaFin, posicionAmarre);
    alquileres.add(alquiler);
    cantidadClientes++;
  }
}

class Barco {
  private String matricula;
  private double eslora;
  private int anioFabricacion;

  public Barco(String matricula, double eslora, int anioFabricacion) {
    this.matricula = matricula;
    this.eslora = eslora;
    this.anioFabricacion = anioFabricacion;
  }

  public String obtenerInformacion() {
    return "Matrícula: " + matricula + ", Eslora: " + eslora + " metros, Año de fabricación: " + anioFabricacion;
  }
}

class Alquiler {
  private Cliente cliente;
  private Barco barco;
  private Date fechaInicio;
  private Date fechaFin;
  private String posicionAmarre;
  
   public Barco getBarco() {
        return barco;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public String getPosicionAmarre() {
        return posicionAmarre;
    }


  public Alquiler(Cliente cliente, Barco barco, Date fechaInicio, Date fechaFin, String posicionAmarre) {
    this.cliente = cliente;
    this.barco = barco;
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
    this.posicionAmarre = posicionAmarre;
  }

  public double calcularAlquiler() {
   
    long diasOcupacion = calcularDiasOcupacion();
    double costoDiario = 25000;
    double impuestos = 0.1; // 10% de impuestos
    return diasOcupacion * (costoDiario + (costoDiario * impuestos));
  }

  private long calcularDiasOcupacion() {
    long diferenciaEnMilis = fechaFin.getTime() - fechaInicio.getTime();
    return TimeUnit.DAYS.convert(diferenciaEnMilis, TimeUnit.MILLISECONDS);
}

  public void imprimirRecibo() {
    System.out.println("Recibo del alquiler:");
    System.out.println("Cliente: " + cliente.getNombre());
    System.out.println("Barco: " + barco.obtenerInformacion());
    System.out.println("Fecha de inicio: " + fechaInicio);
    System.out.println("Fecha de fin: " + fechaFin);
    System.out.println("Posición de amarre: " + posicionAmarre);
    System.out.println("Costo del alquiler: $" + calcularAlquiler());
  }
  
}


    
