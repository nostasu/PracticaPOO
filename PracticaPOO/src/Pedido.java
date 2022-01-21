import java.util.ArrayList;
/**
 * La clase pedido es la que se encarga de incializar los pedidos correctamente, con su cliente y los muebles que corresponden a cada pedido.
 * Estos muebles de pedido se almacenan en el ArrayList muebles pedido.
 * Tenemos dos variables id Inicial e id, que se usan para llevar la cuenta de los pedidos realizados hasta el momento en el almacen, además id sirve de identificador
 * para las búsquedas.
 * La clase pedido precisa tambien de un campo cliente ya que cada pedido tiene asignado el cliente que ha efectuado el pedido.
 */

public class Pedido
{
    private ArrayList <Mueble> mueblesPedido;
    private static int idInicial=1;
    private int id;
    private EstadoPedido estado;
    private Cliente cliente;

    /**
     * Constructor de la clase.
     * @param El cliente que esta haciendo el pedido y un ArrayList de la lista de los muebles que estan incluidos en el pedido.
     */
    public Pedido(Cliente cliente, ArrayList<Mueble> mueblesPedido)
    {
        this.cliente=cliente;
        id=idInicial;
        idInicial++;
        estado = EstadoPedido.PORINICIAR;
        this.mueblesPedido=mueblesPedido;
    }

    public void setNumeroMuebles(int numero)
    {
        mueblesPedido.size();
    }

    public int getNumeroPedido() {
        return id;
    }

    public int getNumeroMuebles()
    {
        return mueblesPedido.size();
    }

    /**
     * Método para insertar un mueble dentro de la lista de muebles del pedido.
     * @param el mueble que deseamos insertar.
     */
    public void insertarMuebleArray(Mueble mueble) {
        mueblesPedido.add(mueble);
    }

    /**
     * Método para devolver el ArrayList de los muebles del pedido.
     * @ return una lista correspondiente a todos los muebles del pedido.
     */
    public ArrayList<Mueble> getArrayMuebles(){
        return mueblesPedido;
    }

    /**
     * Método para devolver la lista de muebles con un formato para que el usuario que utiliza el ordenador pueda identificar mas fácilmente los muebles que incluye el pedido.
     */
    public String listaMuebles() {
        String lista = " "; 
        for(Mueble m : mueblesPedido) {
            lista = (lista + m.toString() + "\n ");
        }
        return lista;
    }

    public EstadoPedido getEstadoPedido() {
        return estado;
    }

    /**
     * Método para establecer el estado del pedido.
     * @param un String que sea: iniciado/finalizado/faltanpiezas/error.
     */
    public void setEstadoPedido(String estadoPedido) {
        if(estadoPedido.equalsIgnoreCase("iniciado")) {
            estado=EstadoPedido.INICIADO;
        } else if(estadoPedido.equalsIgnoreCase("finalizado")) {
            estado=EstadoPedido.FINALIZADO;
        } else if(estadoPedido.trim().equalsIgnoreCase("faltanpiezas")) {
            estado=EstadoPedido.FALTANPIEZAS;
        } else if (estadoPedido.trim().equalsIgnoreCase("esperandoartesanolibre")){
            estado=EstadoPedido.ESPERANDOARTESANOLIBRE;
        } else {
            estado=EstadoPedido.ERROR;
        }
    }

    public void setCliente(Cliente cliente) {
        this.cliente=cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    /**
    * El método toString de la clase Pedido para devolver el pedido en forma de String.
    */
    public String toString() {
        return "El pedido: " + getNumeroPedido() + " que incluye " + getNumeroMuebles() + 
            " muebles y el estado del pedido es: " + getEstadoPedido();
    }
}