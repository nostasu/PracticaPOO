import java.util.ArrayList;

/**
 * La clase GestorPrincipal es la encargada de inicializar todos los ArrayList y gestores.
 * Ademas, también inicia la clase datos iniciales simulando que de inicio en la fabrica tenemos pedidos y empleados.
 */

public class GestorPrincipal
{
    private Interfaz interfazPpal;
    private GestorUsuarios gestorUsuarios;
    private GestorPedidos gestorPedidos;
    private ArrayList <Persona> usuarios;
    private ArrayList <Pedido> pedidos;
    private DatosInicialesFabrica inicio;

    public GestorPrincipal()
    {
        interfazPpal = new Interfaz();
        inicio = new DatosInicialesFabrica();
        usuarios=inicio.iniciarDatosUsuarios();
        pedidos=inicio.pedidosIniciales();
        gestorUsuarios = new GestorUsuarios(usuarios);
        gestorPedidos = new GestorPedidos(usuarios, pedidos);
        bienvenida();

    }
    
    /**
     * Este metodo llama a la interfaz principal y segun el valor entero devuelto, inicia el gestor de usuarios, el de pedidos, o sale del sistema.
     * Se utiliza la recursión al método llamando dentro de cada case a bienvenida() para que al salir de cada gestor en concreto, vuelva al menu principal.
     * La variable local exit es un mero auxiliar para controlar que se introduce un numero que lleve a una opcion correcta.
     * La variable local int es el numero que obtenemos al llamar al metodo bienvenida de la interfaz principal para acceder al menu adecuado.
     */
    public void bienvenida() 
    {
        boolean exit=false;
        int menu = interfazPpal.bienvenida();
        do{ 
            if(menu==1) {
                gestorUsuarios.opcion();
                bienvenida();
                exit=false;
            } else if(menu==2) {
                gestorPedidos.opcion();
                bienvenida();
                exit=false;
            } else if(menu == 0) {
                System.out.println("Saliendo del sistema... Hasta pronto");
                System.exit(0);
                exit=false;
            } else {
                System.out.println("Debe imprimir un numero del 0 al 3");
                exit=true;
                bienvenida();
            }
        } while (exit);
    }
}