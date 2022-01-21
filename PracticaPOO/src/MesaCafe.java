
/**
 * Una subclase de la clase mueble para identificar las mesas de cafe, de ella heredaran dos clases hijas en las que se estableceran las dimensiones.
 */
public abstract class MesaCafe extends Mesa
{

    /**
     * Constructor de mesa cafe.
     * Se aplica el coste adicional del mueble por ser una mesa de cafe.
     */
    public MesaCafe(double alto, double ancho, double profundidad)
    {
        super(alto,ancho,profundidad); 
        int coste = 50;
        super.setPrecio(coste);
    }
}

