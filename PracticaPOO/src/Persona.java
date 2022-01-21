
/**
 * Crea la superclase persona de la cual heredaran todos los empleados y clientes tal y como se pide en la jerarquia de herencia de la practica.
 * Creaa unos campos comunes a todas las personas como son el nombre, id o dni, telefono y direccion.
 */

public abstract class Persona
{
    private final String nombre;
    private final int id;
    private int telefono;
    private String direccion;
    
    /**
     * Constructor de los objetos de la clase Persona
     * @param Una cadena que representa el nombre, un numero entero que sera el dni, un numero entero como telefono, y una cadena de texto con la direccion.
     */
    public Persona(String nom, int identificacion, int tlf, String dir)
    {
        nombre=nom;
        id= identificacion;
        telefono=tlf;
        direccion=dir;
    }

    public int getId()
    {
        return id;
        
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public void setTelefono(int telefono)
    {
        this.telefono = telefono;
        
    }
    
    public int getTelefono()
    {
        return telefono;
        
    }
    
    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
        
    }
    
    public String getDireccion() 
    {
    	return  direccion;
    }
    
    public abstract String toString();
}