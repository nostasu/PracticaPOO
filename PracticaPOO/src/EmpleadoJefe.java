/**
 * Clase que representa a uno de los Jefes de la empresa.
 */
public class EmpleadoJefe extends Empleado
{
    /**
     * Los jefes tendran un incentivo de 500 euros por su cargo.
     */
    private static final double incentivoJefe = 500;
    
    /**
     * Constructor de la clase.
     * @Param Se espera un nombre (cadena), un entero que sera el id, un entero que sera el numero de telefono, una cadena que será la direccion, y un dato doble que indicara el sueldo.
     */
    public EmpleadoJefe(String nombre, int id, int telefono, String direccion, double sueldo)
    {
        super(nombre, id, telefono, direccion, sueldo+incentivoJefe);

    }
    
    /**
     * Método setter del único campo de la clase.
     */
    public double getIncentivoJefe() {
        return incentivoJefe;
    }

    /**
     * Método que sobrescribe al de Empleado y indica en el String el cargo del Empleado.
     */
    public String toString() {
        return "Empleado jefe: " +super.toString() + ". Incentivo: " +getIncentivoJefe() + ".";
    }

}

