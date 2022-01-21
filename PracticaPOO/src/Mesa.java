
/**
 * La clase Mesa crea una clase abstracta ya que no nos interesa que se pueda instanciar.
 * Tablero se define como final y de clase ya que todas las mesas tendran tablero.
 * 
 * @autor Noelia Osta
 */
public abstract class Mesa extends Mueble
{
    private static final boolean tablero = true;
    /**
     * Constructor de los objetos de la clase mesa.
     * La mesa toma de inicio un valor que se va incrementando según la clase de mesa.
     * @param la altura, anchura y profundidad de la mesa indicadas en dato de tipo double.
     */
    public Mesa(double alto, double ancho, double profundidad)
    {
        super(alto,ancho,profundidad);     //Tomaran valor en cada clase correspondiente
        int coste = 150;
        super.setPrecio(coste);
    }

    /**
     * Método que sobreescribiran las otras mesas y que nos devuelve las caracteristicas en forma de cadena de caracteres.
     */
    public String toString() {
        return  " Numero de articulo: " + getNumeroDeMuebleEnAlmacen()+ ". Altura: " +getAlto() + ", anchura " +getAncho() + ", profundidad: "+getProfundidad();
    }
}
