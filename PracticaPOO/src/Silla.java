
public abstract class Silla extends Mueble 
{
    private static final boolean respaldo = true;
    private double alturaTotal;   //La altura no solo hasta el asiento, incluyendo respaldo
    /**
     * Constructor de los objetos de la clase silla.
     */
    public Silla(double alto, double ancho, double profundidad, double alturaTotal)
    {
        super(alto, ancho, profundidad);
        this.setAlturaTotal(alturaTotal);
        int coste = 50;
        super.setPrecio(coste);
    }

    public static boolean isRespaldo() {
        return respaldo;
    }
    
    public double getAlturaTotal() {
        return alturaTotal;
    }

    public void setAlturaTotal(double alturaTotal) {
        this.alturaTotal = alturaTotal;
    }
   
    public String toString() {
        return  " Numero de articulo: " + getNumeroDeMuebleEnAlmacen()+ ". Altura: " +getAlto() + ", anchura " +getAncho() + ", profundidad: "+getProfundidad() +
        ", altura total: " + getAlturaTotal();
        
    }

}