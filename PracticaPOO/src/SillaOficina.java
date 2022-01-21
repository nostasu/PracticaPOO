
public abstract class SillaOficina extends Silla
{
    
    public SillaOficina(double alto, double ancho, double profundidad, double alturaTotal)
    {
         super(alto, ancho, profundidad, alturaTotal);
         int coste = 75;
         super.setPrecio(coste);
    }

    public String toString() {
        return super.toString();
    }
}
