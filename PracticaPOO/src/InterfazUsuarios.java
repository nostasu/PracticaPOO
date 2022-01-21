import java.util.Scanner;
/**
 * Clase interfaz usuarios, va a ser la encargada de gestionar el menu para la gestion de usuarios.
 * Además, es la encargada de pedir los datos por teclado. En usuarios se incluye tanto el 
 * personal de la fabrica como los clientes.
 */

public class InterfazUsuarios {
    private Scanner entrada;
    public InterfazUsuarios() {
        entrada=new Scanner(System.in);
    }
    
    /*
     * Este método es llamado por el gestor de usuarios para que le devuelva un int con la opcion deseada.
     * @return el numero de la opción.
     */
    public int bienvenida(){
        
        System.out.println("=====================================");
        System.out.println("Esta usted en el gestor de usuarios ");
        System.out.println("1) Alta usuario nuevo");
        System.out.println("2) Modificar usuario");
        System.out.println("3) Borrar usuario ");
        System.out.println("4) Mostrar lista usuarios (clientes y empleados) ");
        System.out.println("5) Menu principal");
        System.out.println("");
        System.out.println("Para salir pulse 0");
        System.out.println(" ");
        System.out.println("Por favor, introduzca el numero sobre el cual desea realizar la consulta"); 

        int opcion = entrada.nextInt();
        return opcion;
    }
    
    /*
     * Funcion que me pide los datos de los usuarios para que el gestor cree al usuario.
     * @Pre: se deve introducir por teclado valores numericos comprendidos entre 1 y 3.
     * @Post: devuelve un numero comprendido entre uno 1 y 3 para crear un cliente.
     */
    public String pideClaseUsuario() {  
        
        boolean correcto = false;
        int dato;
        String claseEmpleado = " ";
        
        do {
            System.out.println("=====================================");
            System.out.println("Por favor, introduzca el numero de la opcion deseada");
            System.out.println("Pulse 1 para añadir cliente persona, 2 para añadir cliente empresa y 3 para añadir empleado");  
            dato=entrada.nextInt();
            
            if(dato==1) {
                claseEmpleado = "ClientePersona";
                correcto=true;
            } else if(dato==2) {
                claseEmpleado = "ClienteEmpresa";
                correcto=true;
            }else if(dato==3) {
                System.out.println("Pulse 1 para jefe, 2 para comercial, 3 para artesano");
                dato=entrada.nextInt();
                if(dato==1) {
                    claseEmpleado = "EmpleadoJefe";
                    correcto=true;
                } else if(dato==2) {
                    claseEmpleado = "EmpleadoComercial";
                    correcto=true;
                } else if(dato==3) {
                    do {
                        System.out.println("Pulse 1 para artesano por hora o 2 para artesano en plantilla");
                        dato=entrada.nextInt();
                        if(dato==1) {
                            claseEmpleado="ArtesanoHora";
                            correcto=true;
                        } else if (dato==2){
                            claseEmpleado="ArtesanoPlantilla";
                            correcto=true;
                        } else {
                            System.out.println("Debe introducir: hora o plantilla");
                            correcto = false; 
                        } 
                    } while(!correcto);
                } else {
                correcto=false;
                }
            } else {
                correcto=false;
            }
        }while(!correcto);
        return claseEmpleado;
    }
    
    /*
     * A continuación una lista de métodos que solo sirven como getters para devolver el nombre/telefono/id.. que el usuario mete por teclado.
     * @return el dato pedido.
     */
    public String pideNombreEmpresa(){
        System.out.println("Nombre de la empresa? ");
        String nombreEmpresa = entrada.next();
        return nombreEmpresa;
    }
    
    public String pideNombre() {
        System.out.println( "Dime el nombre del usuario" );
        String nom=entrada.next();
        
        return nom;
    }    
    
    public int pideId() {
        System.out.println("Introduzca el DNI del usuario sin letra");
        int id=entrada.nextInt();
        return id;
    }
    
    public int pideTelefono() {
        System.out.println("Introduzca el telefono de contacto ");
        int telefono = entrada.nextInt();
        return telefono;
    }
    
    public String pideDireccion() {
        System.out.println("Introduzca la direccion");
        String direccion = entrada.next();
        return direccion;
    }

    public double pideSueldo() {
  
        System.out.println("Cual es el sueldo del empleado ");
        double sueldo = entrada.nextDouble();
        
        return sueldo;
        
    }

    /*
     * Este es un metodo que tambien es llamado por el gestor principal para seleccionar la opcion del dato que queremos modificar.
     * Se espera un numero por teclado comprendido ente 1 y 3.
     * @return int el numero de la opcion correspondiente.
     */   
    public int pideDatosModificar() {
        
       int entradaDato;
       boolean datoCorrecto=false;
       do {
            System.out.println("Que dato del usuario desea modificar?");
            System.out.println("Pulse 1 para direccion, 2 para telefono, 3 para sueldo o 4 para nombre empresa");
            entradaDato  = entrada.nextInt();
        
            if(entradaDato==1) {
                entradaDato=1;
                datoCorrecto=true;
            } else if(entradaDato ==2) {
                entradaDato=2;
                datoCorrecto=true;
            } else if (entradaDato==3) {
                entradaDato=3;
                datoCorrecto=true;
            } else if(entradaDato==4) {
                entradaDato=4;
                datoCorrecto=true;
            } else {
                System.out.println("Debe introducir 1/2/3");
            }
       } while (datoCorrecto==false);
       return entradaDato;
    }
    
    /*
     * Método llamado por el gestor principal para cerciorarnos de que se desea eliminar al empleado.
     * @return devuelve un boooleano que toma el valor de true si el usuario quiere borrar al empleado y false si se ha arrepentido.
     */
    public boolean eliminarPersonal() {
        
        boolean borrar = false;
        System.out.println("El personal que indique se borrara definitivamente, esta seguro?");
        System.out.println("Introduzca si/no");
        String entradaDato= entrada.next();
        
        if(entradaDato.equalsIgnoreCase("si")) {
            borrar = true;
        } else { 
            System.out.println("Volviendo al menu principal");
            borrar = false;
            bienvenida();
        }
        return borrar;
    } 
}