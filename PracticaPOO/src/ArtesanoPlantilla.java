/**
 * Clase que hereda de EmpleadoArtesano y simula un artesano fijo en plantilla.
 */
public class ArtesanoPlantilla extends EmpleadoArtesano
{

    /**
     * Constructor.
     * @Pre: Se espera un nombre (cadena), un entero que sera el id, un entero que sera el numero de telefono, una cadena que será la direccion, y un dato doble que indicara el sueldo.
     */
    public ArtesanoPlantilla(String nombre, int id, int telefono, String direccion, double sueldo)
    {
        super(nombre, id, telefono, direccion, sueldo);
    }
    
    /**
     * Método que sobrescribimos de Empleado para indicar la clase de empleado.
     */
    public String toString() {
    	return "Artesano plantilla: " +super.toString();
    }
}
