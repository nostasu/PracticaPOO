
/**
 * La superclase mueble define las caracteristicas comunes a todos los muebles.
 * Se incluyen también setters y getters para obtener los valores correspondientes.
 * Ademas, gracias a los campos muebleSiguiente y numeroDeMueble se lleva la cuenta de los muebles creados hasta el momento.
 * 
 * @autor Noelia Osta Supervia
 * @version 1.0
 */
public abstract class Mueble
{
    private static final int patas=4;
    private double alto;
    private double ancho;
    private double profundidad;
    private static int muebleSiguiente =1; //Auxiliar
    private final int numeroDeMuebleEnAlmacen;
    private double precio;

    /**
     * Constructor de la clase mueble. Aunque sea una clase abstracta lo usamos para incializar los campos.
     */
    public Mueble(double alto, double ancho, double profundidad)
    {
       setAlto(alto);
       setAncho(ancho);
       setProfundidad(profundidad);
       numeroDeMuebleEnAlmacen=muebleSiguiente;
       muebleSiguiente++;
    }

    /**
     * Metodos getter y setter para atributos
     */
    public int getPatas(){
        return patas;
    }
    
    /**
     * Para establecer la altura del mueble en centimetros
     */
    public void setAlto(double alto){
        this.alto=alto;
    }
    
    /**
     * Para establecer la anchura del mueble en centimetros
     */
    public void setAncho(double ancho){
        this.ancho=ancho;
    }

    /**
     * Para establecer la largura del mueble en centimetros
     */
    public void setProfundidad(double profundidad){
        this.profundidad=profundidad;
    }

    public double getAlto(){
        return alto;
    }
        
    public double getAncho(){
        return ancho;
    }
    
    public double getProfundidad(){
        return profundidad;
    }
    
    public int getNumeroDeMuebleEnAlmacen() {
            return numeroDeMuebleEnAlmacen;
	}
    
    public void setIncremento(int incremento) {
    	precio += incremento;
    }
    
    public void setPrecio(int precio) {
    	this.precio += precio;
    }
    
    public double getPrecio() {
    	return precio;
    }
    
    /**
     * Metodo abstracto que  renombraremos en las subclases para que nos devuelva los datos del mueble.
     * @return Una cadena de texto con las caracteristicas de cada mueble.
     */
    
    abstract public String toString();
}