    
public class MesaCafeCristal extends MesaCafe
{
    private final boolean cristal = true;

    /**
     * Constructor for objects of class MesaCafeCristal
     */
    public MesaCafeCristal( )
    {
        super(50, 55.5, 60);
        int coste = 150;
        super.setPrecio(coste);

    }
    
    public boolean dimeCristal() {
        return cristal;
    }
    
    public String toString()
    {
    	return "Mesa cafe cristal." + super.toString() + ", precio: " + getPrecio() + ".";
    }
}
