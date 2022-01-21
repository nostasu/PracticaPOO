
public class MesaCafeMadera extends MesaCafe
{
    private boolean madera;

    /**
     * Constructor for objects of class MesaCafeMadera
     */
    public MesaCafeMadera()
    {
    	super(45, 100, 50);
        madera=true;
        int coste = 25;
        super.setPrecio(coste);
    }

    public boolean dimeMadera() {
    	return madera;
    }
    
    public String toString()
    {
    	return "Mesa de cafe madera." + super.toString() + ". Precio: " + getPrecio() + ".";
    }
}
