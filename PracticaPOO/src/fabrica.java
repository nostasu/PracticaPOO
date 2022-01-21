
/**
 * Clase fabrica. Es la encargada de iniciar la fabrica que es lo que se hace en el metodo main.
 * Al iniciarse fabrica se nos incia tambien la clase GestorPrincipal.
 * 
 * @author Noelia Osta Supervia
 * @version 24.05.2020
 */

public class fabrica
{
    private GestorPrincipal inicio;

    public fabrica() {
        inicio = new GestorPrincipal();
    }

    public static void main(String [] args){
        new fabrica();
    }
}
