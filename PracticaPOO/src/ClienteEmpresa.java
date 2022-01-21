
/**
 * Crea la clase Cliente empresa.
 * Los campos son muy similares al resto de clases y con sus getter y su setter ademas del método to String usado en todas las clases que marca el enunciado.
 * 
 * @author Noelia Osta 
 */
public class ClienteEmpresa extends Cliente
{
    private String nombreEmpresa;

    /**
     * Constructor de la clase.
     * @Pre: Se espera un nombre (cadena), un entero que sera el id, un entero que sera el numero de telefono, una cadena que será la direccion.
     */
    public ClienteEmpresa(String nombreCliente, int id, int telefono, String direccion , String nombreEmpresa )
    {
        super(nombreCliente, id, telefono, direccion);
        this.nombreEmpresa=nombreEmpresa;

    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa=nombreEmpresa;
    }
    
    /**
     * Método toString que sobrescibe al toString de Cliente.
     */
    public String toString(){
        return super.toString() + ". Nombre empresa: " + getNombreEmpresa() +".";
    }
}

