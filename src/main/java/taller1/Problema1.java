
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Carrera {

    public String nombre;
    public double costoCredito;

    public Carrera(String nombre, double costoCredito) {
        this.nombre = nombre;
        this.costoCredito = costoCredito;
    }
}


class Mecatronica extends Carrera {

    public Mecatronica() {
        super("Mecatronica", 20); 
    }
}

class IngenieriaDeSistemas extends Carrera {

    public IngenieriaDeSistemas() {
        super("Ingenieria de Sistemas", 20); 
    }
}

class Telemedicina extends Carrera {

    public Telemedicina() {
        super("Telemedicina", 30);
    }
}

class Contaduria extends Carrera {

    public Contaduria() {
        super("Contaduria", 30); 
    }
}


class Materia {

    public String nombre;
    public int creditos;

    public Materia(String nombre, int creditos) {
        this.nombre = nombre;
        this.creditos = creditos;
    }
}


class Estudiante {
    public String nombres;
    public String apellidos;
    public String documento;
    public String direccion;
    public String telefono;
    public boolean enLinea; // Indica si el estudiante realiza el curso en línea
    public List<Materia> materiasAplazadas;

    public Estudiante(String nombres, String apellidos, String documento, String direccion, String telefono) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.documento = documento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.materiasAplazadas = new ArrayList<>();
    }

    public void setEnLinea(boolean enLinea) {
        this.enLinea = enLinea;
    }

    public boolean isEnLinea() {
        return enLinea;
    }

    public void agregarMateriaAplazada(Materia materia) {
        materiasAplazadas.add(materia);
    }

    public List<Materia> getMateriasAplazadas() {
        return materiasAplazadas;
    }
}


class Recibo {
    private Estudiante estudiante;
    private Carrera carrera;
    private double costoTotal;

    public Recibo(Estudiante estudiante, Carrera carrera, double costoTotal) {
        this.estudiante = estudiante;
        this.carrera = carrera;
        this.costoTotal = costoTotal;
    }

    public void imprimirRecibo() {
        System.out.println("Recibo de Inscripción");
        System.out.println("Estudiante: " + estudiante.nombres + " " + estudiante.apellidos);
        System.out.println("Carrera: " + carrera.nombre);
        System.out.println("Costo Total: $" + costoTotal);
        
    }
}

public class Problema1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        System.out.println("Menú de Carreras:");
        System.out.println("1. Mecatronica");
        System.out.println("2. Ingenieria de Sistemas");
        System.out.println("3. Telemedicina");
        System.out.println("4. Contaduria");

        
        System.out.print("Elija una carrera (1-4): ");
        int opcionCarrera = sc.nextInt();
        sc.nextLine(); 

        
        Carrera carrera = null;
        switch (opcionCarrera) {
            case 1:
                carrera = new Mecatronica();
                break;
            case 2:
                carrera = new IngenieriaDeSistemas();
                break;
            case 3:
                carrera = new Telemedicina();
                break;
            case 4:
                carrera = new Contaduria();
                break;
            default:
                System.out.println("Opción no válida.");
                System.exit(1); 
        }

        
        System.out.print("Ingrese nombres: ");
        String nombres = sc.nextLine();

        System.out.print("Ingrese apellidos: ");
        String apellidos = sc.nextLine();

        System.out.print("Ingrese documento: ");
        String documento = sc.nextLine();

        System.out.print("Ingrese telefono: ");
        String telefono = sc.nextLine();

        sc.close();
    }
}
