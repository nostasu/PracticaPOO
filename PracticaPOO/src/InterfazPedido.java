import java.util.Scanner;
/*
 * Clase que servirá para mostrar los datos en pantalla que necesitemos en gestor de pedidos.
 */
public class InterfazPedido
{
    private Scanner entrada;

    public InterfazPedido()
    {

        entrada=new Scanner (System.in);

    }

    /*
     * Como todos los menus principales de la fabrica, nos devuelve un entero que nos servirá para asignar la opcion correcta en el gestor de pedidos.
     */
    public int bienvenidaPedidos(){
        System.out.println("============================================== ");
        System.out.println("Bienvenido al menu de pedidos");
        System.out.println("1) Recepcion y alta del pedido");
        System.out.println("2) Asignar pedido a artesano");
        System.out.println("3) Lista pedidos");
        System.out.println("4) Modificar muebles de un pedido");
        System.out.println("5) Cambiar estado pedido");
        System.out.println("6) Volver al menu principal");
        System.out.println("");
        System.out.println("Para salir pulse 0");
        System.out.println("");
        System.out.println("Por favor, introduzca el numero sobre el cual desea realizar la consulta"); 

        int opcion = entrada.nextInt();
        return opcion;
    }

    /*
     * Función que sirve para pedir por pantalla el numero de muebles del pedido.
     * @return: el numero de muebles como dato entero.
     */
    public int pideNumeroDeMuebles() {
        System.out.println("Cuantos muebles desea insertar al pedido?");
        int dato=entrada.nextInt();
        return dato;
    }

     /*
     * Funcion que pedira todos los datos del mueble, no veia necesario estar poniendo todo el rato
     * el do, while ya que al ser numeros imagino que no dara lugar a error al introducir el dato.
     * @return un String que servira de auxiliar para crear en el gestor el mueble adecuado.
     */
    public String nuevoPedidoMueble()  {
        int dato;
        String tipoMueble = " ";
        boolean exit=false;

        do {

            System.out.println("Introduzca el numero del mueble que desea insertar:");
            System.out.println("1 para mesa, 2 para silla");
            dato = entrada.nextInt();

            switch(dato) {
                case 1:
                    System.out.println("1 para mesa de dormitorio, 2 para mesa de comedor, 3 para mesa de cafe");
                    dato=entrada.nextInt();
                    if(dato==1) {
                        tipoMueble = "dormitorio";
                        exit=true;
                    } else if(dato==2) {
                        tipoMueble = "comedor";
                        exit=true;
                    } else if (dato==3) {
                        System.out.println("1 para mesa de cafe madera y 2 para mesa de cafe cristal");
                        dato=entrada.nextInt();
                        if(dato==1) {
                            tipoMueble="mesacafemadera";
                            exit=true;
                        } else if(dato==2) {
                            tipoMueble="mesacafecristal";
                            exit=true;
                        } else {
                            exit=false;
                            System.out.println("Debe introducir 1 o 2");
                        }
                    }
                    break;

                case 2:  
                    System.out.println("Introduzca 1 para silla de cocina, 2 para silla de oficina, 3 para silla plegable");
                    dato=entrada.nextInt();
    
                    if(dato==1) {
                        tipoMueble="sillacocina";
                        exit=true;
                    }else if(dato==2) {
                        System.out.println("1 para silla de oficina con ruedas, 2 para silla de oficina sin ruedas");
                        dato=entrada.nextInt();
                        if(dato==1) {
                            tipoMueble="sillaoficinaruedas";
                            exit=true;
                        } else if(dato==2) {
                            tipoMueble = "sillaoficinasinruedas";
                            exit=true;
                        } else {
                            System.out.println("No se ha podido introducir por dato incorrecto");
                            exit=false;
                        }
                    }else if(dato==3) {
                        tipoMueble="sillaplegable";
                        exit=true;
                    }

                    exit=true;
                    break;
                default: 
                    System.out.println("No se ha podido a�adir el mueble por alg�n numero incorrecto");
                    System.out.println("Se va a volver al inicio");
                    exit=false;
                    break;
            }

        } while(!exit);
        return tipoMueble;
    }
    
     /* 
      * Método para pedir por pantalla el id del artesano y se asigna a la variable id que es la que se devolverá.
      * @return el id que ha introducido el usuario.
      */
    public int pideIdArtesano() {
        System.out.println("Introduzca el id del artesano");
        int id=entrada.nextInt();
        return id;

    }

    /*
     * Método para pedir el numero de pedido.
     * @return el id de pedido que ha introducido el usuario.
     */
    public int pideIdPedido() {
        System.out.println("Introduzca el numero del pedido: 1/2/3..");
        int id=entrada.nextInt();
        return id;

    }

    /*
     * Método para pedir el id al cliente
     * @return el idCliente que ha introducido el usuario.
     */
    public int pideIdCliente() {
        int idCliente=entrada.nextInt();
        return idCliente;
    }

    /*
     * Método para pedile al usuario una valor que sea si, o no, y nos lo devuelva en una variable booleana.
     * return el valor que ha introducido el usuario.
     */
    public boolean siONo() {
        boolean cierto = false;
        boolean salir=true;
        do {
            String dato=entrada.next();
            if(dato.equalsIgnoreCase("si")) {
                cierto=true;
                salir=true;
            } else if(dato.equalsIgnoreCase("no")) {
                cierto=false;
                salir=true;
            }
            else { 
                System.out.println("Debe introducir si/no");
                salir=false;
            }
        } while(!salir);
        return cierto;
    }

    /*
     * Método auxiliar que se usa en el gestor para cambiar el estado del pedido, asi el artesano indica por el ordenador el cambio que desea realizar.
     * @return un numero asociado a un cambio de estado de pedido.
     */
    public int cambiaEstado() {
        System.out.println("Pulse 1 para cambiar estado a Finalizado");
        System.out.println("Pulse 2 para cambiar estado a Faltan Piezas");
        System.out.println("Pulse 3 para cambiar estado a Error");
        int dato=entrada.nextInt();
        return dato;
    }

    /*
     * Método para introducir el numero de mueble a modificar.
     * @return: el correspondiente numero al mueble a modificar.
     */
    public int pideMueble() {
        System.out.println("Por favor, introduzca el numero de artículo del mueble que desea modificar");
        int dato=entrada.nextInt();
        return dato;
    }

    /*
     * Método para pedir modificaciones en el muebles. Además, informa al usuario que las modificaciones conllevan un sobrecoste de 50€ para que posteriormente
     * informe al cliente del precio nuevo.
     * @return el numero asociado a la modificacion.
     */
    public int modificaMueble() {

        int entradaDato;
        boolean correcto = false;
        System.out.println("Que operacion desea hacer con el mueble? ");
        System.out.println(" Aviso: modificar las caracteristicas de un mueble implicará un sobrecoste de 50 euros");
        System.out.println("Pulse 1 para alto, 2 para ancho, 3 para profundidad, 4 para altura total");
        do {
            entradaDato=entrada.nextInt();
            if(entradaDato==1) {
                entradaDato=1;
                correcto=true;
            } else if(entradaDato==2) {
                entradaDato=2;
                correcto=true;
            } else if (entradaDato==3) {
                entradaDato=3;
                correcto=true;
            } else if (entradaDato==4){
                entradaDato=4;
                correcto=true;
            } else {
                System.out.println("Debe introducir 1/2/3/4");
            }
        } while (correcto==false);
        return entradaDato;
    }

    /*
     * Método para pedir la nueva altura deseada del mueble.
     * @return el nuevo alto introducido por el comercial.
     */
    public double pideAlto() {
        System.out.println("Introduzca el nuevo alto ");
        double alto = entrada.nextDouble();
        return alto;
    }

     /*
     * Método para pedir el nuevo ancho deseado del mueble.
     * @return el nuevo ancho introducido por el comercial.
     */
    public double pideAncho() {
        System.out.println("Introduzca el nuevo ancho ");
        double ancho = entrada.nextDouble();
        return ancho;
    }
    
    /*
     * Método para pedir la nueva altura total deseada del mueble.
     * @return la nueva altura total introducida por el comercial.
     */
    public double pideAlturaTotal() {
        System.out.println("Introduzca la nueva altura total ");
        double altoTotal = entrada.nextDouble();
        return altoTotal;   
    }

     /*
     * Método para pedir la profundidad del mueble.
     * @return la nueva profundidad introducida por el comercial.
     */
    public double pideProfundidad() {
        System.out.println("Introduzca la nueva profundidad ");
        double profundidad = entrada.nextDouble();
        return profundidad; 
    }
}