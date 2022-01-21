
public class SillaOficinaSinRuedas extends SillaOficina
{
    private final boolean ruedas = false;

    public SillaOficinaSinRuedas()
    {
        super(67.8,55,70,108);
        int coste = 15;
        super.setPrecio(coste);
    }

    public boolean isRuedas() {
        return ruedas;
    }

    public String toString() {
    	return "Silla de oficina sin ruedas." + super.toString() + ", precio: " + getPrecio() + ".";
    }

}
