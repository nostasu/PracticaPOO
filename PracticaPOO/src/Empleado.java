
/**
 * Clase Empleado. No hay mucho que decir, lo que nos pide el enunciado y un par de atributos.
 * Lo unico reseñable es que es una clase abstracta ya que no nos interesa crear instancias de ella.
 * @author Noelia Osta
 * @version 1
 */

public abstract class Empleado extends Persona
{
    private double sueldo;

    /**
     * Constructor de la clase Empleado. 
     * @Pre: Se espera un nombre (cadena), un entero que sera el id, un entero que sera el numero de telefono, una cadena que será la direccion, y un dato doble que indicara el sueldo.
     */
    public Empleado(String nom, int id, int telefono, String direccion, double sueldo)
    {
        super(nom, id , telefono, direccion);
        this.sueldo=sueldo;

    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    /**
     * Clase que sobrescribirán los empleados que usaremos para mostrar en un String los datos de un Empleado
     * @return Los datos del empleado.
     */
    public String toString(){
        return getNombre() + ". Dni: " + getId() + 
        ". Telefono: " + getTelefono() + ". Direccion: " 
        + getDireccion() + ". Sueldo de " + getSueldo();
    }
}