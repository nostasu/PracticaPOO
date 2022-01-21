/**
 * Clase que extiende de Empleado e implementa un comercial de la empresa.
 */
public class EmpleadoComercial extends Empleado
{

    /**
     * Constructor de la clase.
     * @Param Se espera un nombre (cadena), un entero que sera el id, un entero que sera el numero de telefono, una cadena que será la direccion, y un dato doble que indicara el sueldo.
     */
    public EmpleadoComercial(String nombre, int id, int telefono, String direccion, double sueldo)
    {
        super(nombre, id, telefono, direccion, sueldo);
    }

    /**
     * Método que sobreescribe a Empleado e indica la clase de empleado.
     */
    public String toString() {
        return "Empleado comercial: " +super.toString();
    }

}
