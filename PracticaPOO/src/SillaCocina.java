
/**
 * Clase Silla Cocina que hereda de silla.
 */
public class SillaCocina extends Silla {

    /*
     * Se encarga de establecer los valores iniciales de la silla de cocina llamando al constructor de silla.
     * Además, se incrementa el coste del mueble.
     */
    public SillaCocina()
    {
         super(47,40,50,87);
         int coste = 25;
         super.setPrecio(coste);
    }

    public String toString() {
        return "Silla de cocina." + super.toString() + ", precio: " + getPrecio() + ".";
    }

}