import java.util.Scanner;
/**
 * Interfaz que pretende simular el menu principal y lo imprime en pantalla. Nos da acceso a dos menus:
 * El menu de usuarios que se encarga de la gestion de empleados y de los clientes, es decir, de todo el personal.
 * El gestor de pedidos que se encarga de la visualizacion y cracion de pedidos.
 * 
 * @Author Noelia Osta
 */

public class Interfaz
{
    /*
     * El menu principal de la fabrica. Este es llamado por el gestor principal.
     * Se espera por teclado un numero comprendido entre 0 y 2.
     * @Post: Devuelve un int que es la opcion correspondiente al menu al que deseamos acceder.
     */
    public int bienvenida(){

        Scanner entrada=new Scanner(System.in);
        System.out.println("============================================== ");
        System.out.println("Bienvenido al sistema de control de la fabrica ");
        System.out.println("1) Gestion de usuarios.");
        System.out.println("2) Gestion de pedidos.");
        System.out.println();
        System.out.println("Para salir pulse 0");
        System.out.println();
        System.out.println("Por favor, introduzca el numero sobre el cual desea realizar la consulta ");
        
        int menu=entrada.nextInt();
        return menu;
    }
}