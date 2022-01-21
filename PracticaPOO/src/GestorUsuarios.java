import java.util.ArrayList;
import java.util.Iterator;
/**
 * Clase gestor usuarios que se encarga de realizar altas, bajas, modificaciones de empleados y clientes.
 * Pedira los datos necesarios a la interfaz que es la encargada de solicitar por consola todos los datos al usuario de la aplicación.
 */
public class GestorUsuarios
{
    private ArrayList <Persona> usuarios;
    private InterfazUsuarios menu;
    private Persona persona;

    /**
     * Constructor de gestor usuarios.
     * @param un arraylist de Usuarios que le da el gestor principal para almacenar todos los usuarios del almacen, tanto clientes como empleados.
     */
    public GestorUsuarios(ArrayList <Persona> usuarios)
    {
        this.usuarios=usuarios;
        menu = new InterfazUsuarios();
    }

    public void opcion() {
        int opcion = menu.bienvenida();
        boolean exit=false;
        do{
            switch (opcion) {
                case 1: 
                    insertarUsuario();
                    opcion();
                    exit=false;
                    break;
                case 2:
                    modificarUsuario();
                    opcion();
                    exit=false;
                    break;
                case 3: 
                    borrarUsuario();
                    opcion();
                    exit=false;
                    break;
                case 4: 
                    listaUsuarios();
                    opcion();
                    exit=false;
                    break;
                case 5:
                    exit=false;
                    break;
                case 0:
                    System.out.println("Saliendo del sistema... Hasta pronto");
                    exit=false;
                    System.exit(0);
                default:
                    System.out.println("Debe imprimir un numero del 0 al 5");
                    exit=true;
                    opcion=menu.bienvenida();
            }
        }while(exit);
    }

    /**
     * Método valido tanto como para insertar en el arrayList clientes como personal,
     * ya que ambos según la estructura de la practica están incluidos en Personal.
     */
    public void insertarUsuario() {
        //Pedir datos del usuario, me debe devolver un dato
        boolean encontrado=false;
        persona=null;

        String nombre= menu.pideNombre();
        int id= menu.pideId();
        int telefono = menu.pideTelefono();
        String direccion = menu.pideDireccion();

        String claseEmpleado = menu.pideClaseUsuario();
        if(claseEmpleado.equalsIgnoreCase("ClientePersona")) {
            persona=new ClientePersona(nombre, id, telefono, direccion);
        } else if(claseEmpleado.equalsIgnoreCase("ClienteEmpresa")){
            String nombreEmpresa=menu.pideNombreEmpresa();
            persona = new ClienteEmpresa(nombre, id, telefono, direccion , nombreEmpresa);
        } else if(claseEmpleado.equalsIgnoreCase("EmpleadoJefe")) {
            Double sueldo = menu.pideSueldo();
            persona = new EmpleadoJefe(nombre, id, telefono, direccion, sueldo);
        } else if(claseEmpleado.equalsIgnoreCase("EmpleadoComercial")) {
            Double sueldo = menu.pideSueldo();
            persona = new EmpleadoComercial(nombre, id, telefono, direccion, sueldo);
        } else if(claseEmpleado.equalsIgnoreCase("ArtesanoHora")) {
            Double sueldo = menu.pideSueldo();
            persona = new ArtesanoPorHora(nombre, id, telefono, direccion, sueldo);
        } else if(claseEmpleado.equalsIgnoreCase("ArtesanoPlantilla")) {
            Double sueldo = menu.pideSueldo();
            persona = new ArtesanoPlantilla(nombre, id, telefono, direccion, sueldo);
        } else {
            persona=null;
        }

        //Esto ya cuando tenemos creada a la persona para añadirla al ArrayList;
        if(persona!=null) {    
            for(Persona listaPersonas: usuarios) {
                if(listaPersonas.getId() == id) {
                    encontrado=true;
                }
            } 
            if(encontrado) {
                System.out.println("El id ya existe en el sistema, no se puede crear al usuario");
            } else {
                usuarios.add(persona);
                System.out.println("Se ha añadido al usuario: " + persona.getNombre() + " con dni: " + persona.getId());
            }
        } else { 
            System.out.println("Hubo algún fallo y no se puede introducir al usuario");
        }
    }

    /**
     * Método que nos muestra una lista de empleados y clientes del almacen.
     */

    public void listaUsuarios() {
        if(usuarios.size()==0) {
            System.out.println("Todavia no se ha registrado ningun usuario en el sistema");
        } else {
            System.out.println("CLIENTES:");
            for(Persona persona : usuarios) {
                if(persona instanceof Cliente) {
                    System.out.println(persona.toString());
                }
            }
            System.out.println(" ");
            System.out.println("EMPLEADOS");
            for(Persona p : usuarios) {
                if(p instanceof Empleado) {
                    System.out.println(p.toString());
                }
            }
        }
    }

    /**
     * Método que por el id (dato que consideramos unico), nos devuelve un empleado
     * @return persona: la persona con el nombre especificado 
     */
    private Persona buscadorUsuario() {
        int id = menu.pideId();
        Persona p = null;
        
        Iterator <Persona> it = usuarios.iterator();
        while(it.hasNext()) {
            Persona empleado = it.next();
            if (empleado.getId()==id) {
                p=empleado;
            }
        }
        return p;  //Me devuelve el empleado que tiene el id que ha indicado el usuario.
    }
    
    /**
     * Método que nos permite modificar los datos de un usuario que pedimos al metodo buscador usuario.
     * Se comunica con la interfaz de usuarios para pedir los datos que queremos modificar.
     */
    public void modificarUsuario() {
        listaUsuarios();
        System.out.println(" ");
        Persona p = buscadorUsuario();

        if(p==null) {
            System.out.println("No se ha encontrado usuario y no se puede efectuar la modificación");
        } else {
            int dato = menu.pideDatosModificar();
            switch(dato) {
                case 1:
                    String direccion = menu.pideDireccion();
                    p.setDireccion(direccion);
                    System.out.println("Se ha modificado la direccion del usuario: " +p.getNombre());
                    break;
                case 2:
                    int telefono = menu.pideTelefono();
                    p.setTelefono(telefono);
                    System.out.println("Se ha modificado el telefono del usuario: " +p.getNombre());
                    break;
                case 3:
                    double sueldo = menu.pideSueldo();
                    if(p instanceof Empleado) {
                        ((Empleado) p).setSueldo(sueldo);
                        System.out.println("Se ha modificado el sueldo del empleado: " +p.getNombre());
                    } else {
                        System.out.println("No es un empleado y no se le puede subir el sueldo");
                    }
                    break;
                case 4:
                    String nombreEmpresa=menu.pideNombreEmpresa();
                    if(p instanceof ClienteEmpresa) {
                        ((ClienteEmpresa) p).setNombreEmpresa(nombreEmpresa);
                        System.out.println("Se ha modificado el nombre de la empresa del cliente: " +p.getNombre());
                    } else {
                        System.out.println("No es cliente empresa y no puede realizar la asignación");
                    }
                    break;
            }   
        } 
    }
    /**
     * Método para borrar un usuario del ArrayList.
     */
    public void borrarUsuario() {
        listaUsuarios();
        System.out.println(" ");
        int id = menu.pideId();
        boolean borrar = menu.eliminarPersonal();
        boolean eliminado = false;
        if(borrar) {
            Iterator <Persona> it = usuarios.iterator();
            while(it.hasNext()) {

                Persona empleado = it.next();

                if (empleado.getId()==id) {
                    it.remove();
                    eliminado=true;
                } 
            }
        }
        if(eliminado) {
            System.out.println("El usuario con id " + id + " se ha eliminado");
        } else { 
            System.out.println("No se ha podido encontrar ni borrar un usuario con ese id");
        }
    }
}