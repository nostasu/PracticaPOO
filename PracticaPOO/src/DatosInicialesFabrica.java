import java.util.ArrayList;
/**
 * Clase encargada de cargar los datos de inicio de la fabrica.
 * Se cargan usuarios (empleados y clientes de la fabrica) y unos pedidos inciales.
 */
public class DatosInicialesFabrica {

    private ArrayList<Persona> usuarios;
    private ArrayList<Pedido> pedidos;

    public DatosInicialesFabrica() {
        usuarios=new ArrayList<Persona>();
        pedidos=new ArrayList <Pedido>();

    }

    /**
     * Iniciamos una lista de usuarios y pedidos en el almacen para pruebas
     */
    public ArrayList<Persona> iniciarDatosUsuarios() {

        ClientePersona cliente1 = new ClientePersona("Noelia", 17768378, 976298525, "Calle Pamplona, Zaragoza");
        ClienteEmpresa cliente2 = new ClienteEmpresa("Antonio", 74512395, 976569462, "Calle Almozara, Utebo", "Antonio SA");
        EmpleadoJefe empleado1 = new EmpleadoJefe("Mariano", 45512365, 644417668, "Calle Delicias, Zaragoza", 19520.75);
        EmpleadoComercial empleado2 = new EmpleadoComercial("Paco", 12563785, 620638157, "Calle Buenos Aires, Utebo", 1275.12);
        ArtesanoPlantilla empleado3 = new ArtesanoPlantilla("Lucia", 75123612, 639693020, "Avenida San Juan De La Pena, Zaragoza", 1325);
        ArtesanoPorHora empleado4 = new ArtesanoPorHora("Martin", 54231652, 644417455, "Calle Paco, Calatayud", 1450);

        usuarios.add(cliente1);
        usuarios.add(cliente2);
        usuarios.add(empleado1);
        usuarios.add(empleado2);
        usuarios.add(empleado3);
        usuarios.add(empleado4); 

        return usuarios;
    }

    public ArrayList <Pedido> pedidosIniciales() {

        ArrayList <Mueble> muebles = new ArrayList<Mueble>();
        Mueble mueble1 = new SillaCocina();
        muebles.add(mueble1);
        Pedido pedido1 = new Pedido((Cliente)usuarios.get(0), muebles);

        ArrayList <Mueble> muebles1 = new ArrayList<Mueble>();
        Mueble mueble2=new SillaOficinaRuedas();
        Mueble mueble3=new MesaDormitorio();
        muebles1.add(mueble2);
        muebles1.add(mueble3);
        Pedido pedido2 = new Pedido((Cliente)usuarios.get(0), muebles1);

        ArrayList <Mueble> muebles2 = new ArrayList<Mueble>();
        Mueble mueble4=new SillaOficinaSinRuedas();
        Mueble mueble5=new SillaPlegable();
        Mueble mueble6=new SillaOficinaRuedas();
        Mueble mueble7=new MesaCafeCristal();
        Mueble mueble8=new MesaComedor();
        muebles2.add(mueble4);
        muebles2.add(mueble5);
        muebles2.add(mueble6);
        muebles2.add(mueble7);
        muebles2.add(mueble8);
        Pedido pedido3 = new Pedido((Cliente)usuarios.get(0), muebles2);

        pedidos.add(pedido1);
        pedidos.add(pedido2);
        pedidos.add(pedido3);

        return pedidos;
    }
}
