package Controlador;

public class TipoPuesto {
    private int id_tipo_puesto;
    private String nombre_puesto;
    private double salario;

    // Constructor vacío
    public TipoPuesto() {
    }

    // Constructor con ID
    public TipoPuesto(int id_tipo_puesto) {
        this.id_tipo_puesto = id_tipo_puesto;
    }

    // Constructor con nombre y salario
    public TipoPuesto(String nombre_puesto, double salario) {
        this.nombre_puesto = nombre_puesto;
        this.salario = salario;
    }

    // Getters y Setters
    public int getId_tipo_puesto() {
        return id_tipo_puesto;
    }

    public void setId_tipo_puesto(int id_tipo_puesto) {
        this.id_tipo_puesto = id_tipo_puesto;
    }

    public String getNombre_puesto() {
        return nombre_puesto;
    }

    public void setNombre_puesto(String nombre_puesto) {
        this.nombre_puesto = nombre_puesto;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
