
/**
 * Crea la clase cliente persona
 */
public class ClientePersona extends Cliente
{
    /**
     * Constructor de los objetos de Cliente Persona.
     * Pre: Se espera un nombre (cadena), un entero que sera el id, un entero que sera el numero de telefono, una cadena que será la direccion.
     */
    public ClientePersona(String nombreCliente, int id, int telefono, String direccion )
    {
    	super(nombreCliente, id, telefono, direccion);
    }
    
    /**
     * Método toString que sobrescibe al toString de Cliente.
     */
    public String toString() {
    	return super.toString() + ".";
    }
}

