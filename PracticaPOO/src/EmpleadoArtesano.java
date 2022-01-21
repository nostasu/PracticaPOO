import java.util.ArrayList;
/**
 * Clase que simula en Empleado de la fabrica. Es abstracta y de ella heredaran artesano por horas y artesano en plantilla.
 * Necesitamos en esta clase un campo EstadoArtesano que hace referencia al enumerado y nos indicará si el empleado está o no ocupado.
 * Los artesanos también tienen un campo que almacena un ArrayList con los pedidos que tienen asignados.
 */
public abstract class EmpleadoArtesano extends Empleado
{
    private EstadoArtesano estado;
    private ArrayList <Pedido>listaPedidosArtesano;
    
    /**
     * Constructor.
     * @Pre: Se espera un nombre (cadena), un entero que sera el id, un entero que sera el numero de telefono, una cadena que será la direccion, y un dato doble que indicara el sueldo.
     */

    public EmpleadoArtesano(String nombre, int id, int telefono, String direccion, double sueldo)
    {
        super(nombre, id, telefono, direccion, sueldo);
        estado = EstadoArtesano.LIBRE;   //De Inicio establecemos que el artesano esta libre
        listaPedidosArtesano = new ArrayList<Pedido>();
    }

    public void setOcupado() {
        estado=EstadoArtesano.OCUPADO;
    }

    public void setLibre() {
        estado=EstadoArtesano.LIBRE;
    }

    public EstadoArtesano getEstado() {
        return estado;
    }

     /**
     * Método para insertar in pedido en el ArrayList.
     * @param: el pedido que deseamos insertar.
     */
    public void setInsertarPedidoLista(Pedido pedido) {
        listaPedidosArtesano.add(pedido);
    }

    /**
     * Método que devuelve el ArrayList de pedidos de un empleado artesano.
     * @return El ArrayList de este artesano.
     */
    public ArrayList<Pedido> getPedidoLista() {
        return listaPedidosArtesano;
    }

    /**
     * Método toString que sobrescribe al de empleado.
     */
    public String toString() {
        return super.toString() + ". Estado: " + getEstado() + ".";
    }
}
