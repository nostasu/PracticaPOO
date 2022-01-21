
public class MesaComedor extends Mesa
{
    
    public MesaComedor()
    {
    	super(80, 80, 150);
    	int coste = 75;
        super.setPrecio(coste);
    }
    
    public String toString()
    {
    	return "Mesa de comedor." + super.toString() + ", precio: " + getPrecio() + ".";
    }
}
