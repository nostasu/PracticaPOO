
/**
 * Clase Cliente. 
 * Clase abstracta ya que no nos interesa crear instancias de ella y no lo queremos permitir, y de la cual heredaran Cliente Persona y Cliente Empresa. 
 * Noelia Osta.
 */
public abstract class Cliente extends Persona
{
    private static int ClienteSiguiente =1; //Auxiliar para guardar la cuenta de los clientes.
    private final int numeroDeCliente;

    /**
     * Constructor de los objetos de la clase Cliente
     * @Pre: Se espera un nombre (cadena), un entero que sera el id, un entero que sera el numero de telefono, una cadena que será la direccion.
     */
    public Cliente(String nombreCliente, int id , int telefono, String direccion)
    {
        super(nombreCliente, id , telefono, direccion);
        numeroDeCliente=ClienteSiguiente;
        ClienteSiguiente++;
    }

    /**
     * Método getter de numero de cliente
     */
    public int getNumeroDeCliente()
    {
        return numeroDeCliente;
    }
    
    /**
     * Método toString para imprimir los detalles del objeto Cliente.
     * Lo sobrescribirán las clases que hereden de cliente.
     */
    public String toString(){
        return "Cliente: " + getNombre() + ". Dni: " + getId() + 
        ". Telefono: " + getTelefono() + ". Direccion: " 
        + getDireccion() + " Numero de cliente: " + getNumeroDeCliente();
    }
}