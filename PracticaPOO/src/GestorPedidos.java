import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase Gestor Pedidos.
 * Esta es la clase encargada de gestionar todo lo relacionado con la creación de un nuevo pedido.
 * Necesita la lista de usuarios para saber a que artesano debe asignar cada pedido, listas de pedidos, mueblesPedido que son los muebles que estan como campo en cada pedido particular.
 * También pedidos usuario que son los pedidos que tiene un artesano en concreto.
 * Esta clase es la encargada de crear los muebles, ya que en principio asumimos que los muebles se crean por encargo de pedido. En principio los muebles tienen unos valores
 * predeterminados de ancho, alto, profundidad pero el cliente puede solicitar modificarlos con un sobrecoste del precio de 50€.
 * Tiene como campo la interfaz de menu ya que es la encargadada de solicitar y guardar los datos que introduce el usuario por consola.
 * 
 * @author Noelia Osta
 */
public class GestorPedidos
{
    private ArrayList <Persona> usuarios;
    private ArrayList <Pedido> pedidos;    //Lista de pedidos de la fabrica, sin asignar a ningun empleado
    private ArrayList <Mueble> mueblesPedido;  
    private ArrayList <Pedido> pedidosUsuario;
    private Mueble mueble;
    private Pedido pedido;
    private Cliente cliente;
    private EmpleadoArtesano empleado;
    private InterfazPedido menu;

    /**
     * Constructor de la clase gestorPedidos.
     * Este constructor necesita los arraylist de usuarios y de pedidos que estan de manera inicial en la fabrica. 
     */
    public GestorPedidos(ArrayList <Persona> usuarios,ArrayList <Pedido> pedidos)
    {
        this.usuarios=usuarios;
        this.pedidos=pedidos;
        mueblesPedido=new ArrayList<Mueble>();
        pedidosUsuario=new ArrayList<Pedido>();
        menu = new InterfazPedido();
    }
    
    /**
     * Este método llama a la interfaz de pedidos y obtiene de ella un entero con la opcion que desea hacer el usuario.
     */
    public void opcion() {
        int opcion = menu.bienvenidaPedidos();

        switch (opcion) {
            case 1: 
            recepcionPedido();
            opcion();
            break;
            case 2:
            asignarPedido();
            opcion();
            break;
            case 3: 
            listaPedidos();
            opcion();
            break;
            case 4: 
            modificarMueble();
            opcion();
            break;
            case 5:
            cambiarEstadoPedido();
            opcion();
            break;
            case 6:
            break;
            case 0:
            System.out.println("Saliendo del sistema... Hasta pronto");
            System.exit(0);
            default:
            System.out.println("Debe imprimir un numero del 0 al 5");
            opcion();
        }
    }
    
    /**
     * Funcion que inserta los muebles del pedido al arrayList cuando se esta recepcionando un nuevo pedido.
     * Este metodo es llamado por la siguiente.
     */
    private void insertarMueble() {
        int numeroMuebles=menu.pideNumeroDeMuebles();
        boolean muebleCorrecto=true;
        for(int i=0; i<numeroMuebles; i++) { 
            System.out.println("============================================== ");
            System.out.println("Inserción del mueble: " + (i+1));   
            String dato=menu.nuevoPedidoMueble();
            switch(dato) {
                case "dormitorio" :
                    mueble=new MesaDormitorio();
                    break;
                case "comedor":
                    mueble = new MesaComedor();
                    break;
                case "mesacafemadera":
                    mueble=new MesaCafeMadera();
                    break;
                case "mesacafecristal": 
                    mueble=new MesaCafeCristal();
                    break;
                case "sillacocina":
                    mueble=new SillaCocina();
                    break;
                case "sillaoficinaruedas":
                    mueble=new SillaOficinaRuedas();
                    break;
                case "sillaoficinasinruedas":
                    mueble= new SillaOficinaSinRuedas();
                    break;
                case "sillaplegable":
                    mueble= new SillaPlegable();
                    break;
                case " ":
                    insertarMueble();
            } 
            if(muebleCorrecto) {
                System.out.println("Se ha añadido el mueble: " + mueble);
            }
            mueblesPedido.add(mueble);
        }
    }
    
    /**
     * Metodo que nos permite crear un nuevo pedido. Llama al método anterior para crear nuevos muebles y añadirlos al arraylist correspondiente para cada pedido.
     * Para la creación del pedido necesitamos un cliente, y una lista de pedidos. Nos servimos tambien de la interfaz de pedidos para obtener los datos del cliente 
     * y lo buscamos entre las listas para asignarselo al pedido.
     */
    private void recepcionPedido() {
        System.out.println("Se le van a mostrar los clientes que figuran en sistema ");
        System.out.println("Si el cliente no existe debe volver al menu anterior e introducir al cliente ");
        System.out.println();
        mostrarClientes();
        System.out.println("");
        System.out.println("El cliente ya existe en sistema? Introduzca si/no");

        boolean cierto = menu.siONo();
        if(cierto){
            System.out.println("Introduzca el id del cliente");
            int id=menu.pideIdCliente();
            cliente = (Cliente) obtenerCliente(id);
            insertarMueble();
            pedido = new Pedido(cliente, mueblesPedido);
            pedidos.add(pedido);
            System.out.println("Se ha añadido el pedido: " + pedido.getNumeroPedido() + " con cliente: " + cliente.getNombre() + " y numero de muebles: " + pedido.getNumeroMuebles());
        } else {
            System.out.println("Por favor, vaya al menu de usuarios e introduzca un nuevo cliente");
        }
    }

    /**
     * Método que muestra los artesanos de la fabrica, usada como auxiliar.
     */
    private void mostrarArtesanos(){
        for(Persona persona: usuarios) {
            if(persona instanceof EmpleadoArtesano) {
                System.out.println(persona.toString());
            }
        }
    }
    
    /**
     * Método que nos indica si el artesano esta ocupado.
     * @return un valor booleano que será verdadero si el artesano esta ocupado. En caso contratio, el valor de retorno sera false.
     */
    private boolean artesanoOcupado() {
        boolean ocupado=false;
        for(Persona persona: usuarios) {
            if(persona instanceof EmpleadoArtesano) {
                EstadoArtesano estado=((EmpleadoArtesano) persona).getEstado();
                if(estado==EstadoArtesano.OCUPADO) {
                    System.out.println("Empleado: " +persona.getNombre() +". Id: " + persona.getId());
                    ocupado=true;
                }
            }
        }
        return ocupado;
    }

    /**
     * Método que nos sirve para escoger un artesano a través de su id. 
     * @pre: un id(dni) valido, esto quiere decir, que exista algun usuario en el ArrayList con ese id.
     * @return el empleado del id correspondiente.
     */
    private EmpleadoArtesano escogerArtesano(int id) {
        Iterator <Persona> it = usuarios.iterator();
        while(it.hasNext()) {
            Persona persona=it.next();
            if(persona instanceof EmpleadoArtesano) {
                if(persona.getId() == id) {
                    empleado=(EmpleadoArtesano)persona;
                }
            }
        }
        return empleado;
    }

    /**
     * Método que lo usaremos en la asginar pedido. Nos busca los pedidos que estén todavia con el estado por iniciar para poder asignarselo a un artesano.
     */
    private void buscadorPedidosPorIniciar() {
        Iterator <Pedido> it= pedidos.iterator();
        while(it.hasNext()) {
            Pedido p=it.next();
            EstadoPedido estadoPedido = p.getEstadoPedido();
            if(estadoPedido==EstadoPedido.PORINICIAR) {
                System.out.println(p.toString());
            }
        } 
    }

    /**
     * Método que nos permite asignar un pedido a un artesano que gracias a la interfaz nos indicara el usuario.
     * Para facilitar la decisión, se muestran las listas de artesanos y la de pedidos pendientes de asignar.
     * Si el artesano estaba libre, se le asigna el pedido y lo inicia.
     * En caso de que el artesano estuviera ocupado, se le asigna y se pone a la espera de que este el artesano libre.
     */
    private void asignarPedido() {
        System.out.println("Se va a mostrar la lista de artesanos");
        System.out.println("============================================== ");
        mostrarArtesanos();
        int idArtesano= menu.pideIdArtesano();
        empleado=escogerArtesano(idArtesano);
        System.out.println("Se van a mostrar los pedidos pendientes de asignar");
        System.out.println("============================================== ");
        buscadorPedidosPorIniciar();
        pedido=iteratorPedidos();
        empleado.setInsertarPedidoLista(pedido);
        if(empleado.getEstado()==EstadoArtesano.OCUPADO) {
            pedido.setEstadoPedido("ESPERANDOARTESANOLIBRE");
        } else if(empleado.getEstado()==EstadoArtesano.LIBRE){
            pedido.setEstadoPedido("INICIADO");
            empleado.setOcupado();
        }
        System.out.println("Se ha asignado el pedido: " + pedido.getNumeroPedido() + " al artesano: " + empleado.getNombre());
    }
    
    /**
     * Método que nos muestra los clientes. 
     */
    private void mostrarClientes() {
        for(Persona persona: usuarios) {
            if(persona instanceof Cliente) {
                System.out.println("Nombre cliente: " + persona.getNombre() + " e id cliente :" + persona.getId());
            }
        }
    }
    
    /**
     * Método que, a travez de el id que se pasa por parámetro, nos devuelve el Cliente correspondiente.
     * @pre un id valido que este en el arraylist de personas y sea instancia de cliente.
     * @post devuelve el cliente asociado al id pasado por parametro.
     */
    private Cliente obtenerCliente(int id) 
    {
        boolean encontrado=false;
        Iterator <Persona> it = usuarios.iterator();
        while(it.hasNext()) 
        {
            Persona persona=it.next();
            if(persona instanceof Cliente) {
                if(persona.getId() == id) {
                    cliente=(Cliente) persona;
                    encontrado = true;
                }
            }
        }
            
        if(encontrado==true) {
            System.out.println("El cliente es: " + cliente.getNombre() + " con id: " + cliente.getId());
        }else{
            System.out.println("No se ha podudo encontrar cliente con ese id, vuelva a introducir un id");
            int idCliente = menu.pideIdCliente();
            obtenerCliente(idCliente);
        }
       return cliente;
    }

    /**
     * Nos muestra los pedidos tanto sin asignar, como los asignados.
     */
    private void listaPedidos() 
    {
        System.out.println("============================================== ");
        System.out.println("Listado de pedidos sin asignar todavía a artesano");
        if(pedidos.size()==0) { 
            System.out.println("No existen pedidos sin asignar");
        }else {
            for(Pedido p: pedidos) {
                EstadoPedido estadoPedido = p.getEstadoPedido();
                if(estadoPedido == EstadoPedido.PORINICIAR) {
                    System.out.println(p.toString());
                }
            }
        }

        System.out.println("============================================== ");
        System.out.println("Se van a mostrar los artesanos ocupados y despues de indicar su id su lista de pedidos");
        boolean ocupado=artesanoOcupado();
        if(ocupado) {
            int id=menu.pideIdArtesano();
            for(Persona p: usuarios) {
                if(p instanceof EmpleadoArtesano) {
                    if(p.getId()==id) {
                        System.out.println("El artesano con id: " + p.getId() + " tiene en asignados los pedidos: " + ((EmpleadoArtesano) p).getPedidoLista()); 

                    }
                }
            }
        } else {
            System.out.println("No hay artesanos ocupados en este momento");
        }

    }
    
    /**
     * Método que nos sirve para cambiar el estado de pedido al que quiera introducir el usuario.
     * Se presupone que a esta aplicacion accedera el usuario indicando su numero de id y asi dejando constancia del
     * pedido y su estado correspondiente.
     */
    private void cambiarEstadoPedido() {
        int idPedido=0;
        mostrarArtesanos();
        int idArtesano=menu.pideIdArtesano();
        empleado=escogerArtesano(idArtesano);
        pedidosUsuario=empleado.getPedidoLista();  
        if(pedidosUsuario.size()==0) {
            System.out.println("Todavia no tiene pedidos asignados, disfrute de su tiempo libre!");
        } else {
            for(Pedido p : pedidosUsuario) {
                if(p.getEstadoPedido()==EstadoPedido.INICIADO) {
                    idPedido=p.getNumeroPedido();
                }
            }

            System.out.println("Actualmente esta trabajando en el pedido numero: " + idPedido);
            pedido=pedidosUsuario.get(0);//ya que el pedido iniciado siempre estara en la posicion 0

            boolean exit=false;
            do{
                int numero=menu.cambiaEstado();
                if(numero==1) {
                    pedido.setEstadoPedido("finalizado");
                    exit=true;
                } else if(numero==2) {
                    pedido.setEstadoPedido("faltan piezas");
                    exit=true;
                } else if(numero==3) {
                    pedido.setEstadoPedido("error");
                    exit=true;
                } 
            }while (!exit);
            System.out.println("El pedido: " + idPedido + " cambia estado a " +pedido.getEstadoPedido());
            pedidosUsuario.remove(0);
            System.out.println("Se le asignara automaticamente el siguiente pedido de su lista si existe alguno");
            if(pedidosUsuario.size() != 0){
                pedidosUsuario.get(0).setEstadoPedido("INICIADO");
                System.out.println("Iniciando: " + pedidosUsuario.get(0));
            } else {
                System.out.println("Todavia no tiene pedidos pendientes de realizar, puede tomarse un descanso.");
                empleado.setLibre();
            }
        }
    }
    
    /**
     * Método para listar (imprimir por pantalla) los muenles de los pedidos.
     */
    private void listaMueblesPedidos(){
        System.out.println("============================================== ");
        for(Pedido p: pedidos) {
            System.out.println("El pedido: " +(p.getNumeroPedido()) + " esta en estado: " + p.getEstadoPedido() + " y contiene la siguiente lista de muebles: ");
            System.out.println(p.listaMuebles());
        }
    }
    
    /**
     * Método que que recorre la lista de pedidos, aprovechandose de el método pide id para pedir el id de un pedido, 
     * y mediante ese numero nos devuelve el pedido correspondiente.
     * @return: El pedido encontrado.
     */

    private Pedido iteratorPedidos() {
        int id=menu.pideIdPedido();
        boolean encontrado=false;;

        for(Pedido p: pedidos) {
            if(p.getNumeroPedido()==id) {
                pedido=p;
                encontrado=true;
            } 
        } 
        if(!encontrado) {
            System.out.println("No existe pedido con ese numero de id");
            pedido=null;
        }
        return pedido;
    }

    /**
     * Funcion que, para un pedido obtenido en la función anterior, nos devuelve el mueble correspondiente.
     * @return el mueble del pedido.
     */

    private Mueble obtenerMueblePedido(Pedido pedido) {
        boolean encontrado=false;

        mueblesPedido = pedido.getArrayMuebles();
        int numeroMueble=menu.pideMueble();

        Iterator <Mueble> it = mueblesPedido.iterator();
        while(it.hasNext()) {

            Mueble m=it.next();
            if(m.getNumeroDeMuebleEnAlmacen() == numeroMueble) {
                mueble=m;
                encontrado=true;
            }   //Asi conseguimos que nos devuelva el mueble con ese id.
        } 
        
        if(!encontrado) {
            System.out.println("No se pudo encontrar ningún mueble con ese numero en el pedido seleccionado");
            mueble=null;
        }

        return mueble;
    }

    /**
     * Método que nos sirve para modificar las caracteristicas de un mueble. Para ello, pedimos un numero de pedido
     * y nos ayudamos del método anterior para obtener el mueble correspondiente.
     * Una vez obtenido el mueble, le pedimos a través de la interfaz al usuario los datos que desea modificar 
     * y llo modificamos con los setter. Además como los muebles son por encargo, por modificar las características base 
     * incrementamos el coste del producto.
     */
    private void modificarMueble() {
        System.out.println("A continuación, se va a mostrar todos los pedidos con sus correspondientes muebles");
        System.out.println("Por favor, indique el numero de pedido que contenga el mueble que desea modificar");
        listaMueblesPedidos(); 
        pedido = iteratorPedidos();
        EstadoPedido estado=pedido.getEstadoPedido();
        if(estado==EstadoPedido.PORINICIAR){
            if(pedido!=null) {
                mueble=obtenerMueblePedido(pedido);
                if(mueble!=null) {
                    int dato=menu.modificaMueble();
                    int sobreCoste = 50;
                    switch(dato) {
                        case 1:
                        double alto = menu.pideAlto();
                        mueble.setAlto(alto);
                        break;
                        case 2:
                        double ancho = menu.pideAncho();
                        mueble.setAncho(ancho);             
                        break;
                        case 3:
                        double profundidad = menu.pideAlturaTotal();
                        mueble.setProfundidad(profundidad);
                        break;
                        case 4:
                        double alturaTotal = menu.pideAlturaTotal();
                        if(mueble instanceof Silla) {
                            ((Silla) mueble).setAlturaTotal(alturaTotal);
                        }
                        break;
                    }
                    mueble.setIncremento(sobreCoste);
                    System.out.println("Se ha modificado el mueble : " + mueble.toString());
                } 
            }else {
                System.out.println("No se puede modificar pedido, por favor, vuelva al menu e inserte un id valido");
            }
        }else{
            System.out.println("No se pueden modificar pedidos que no esten en estado por iniciar");
        }
    }
}