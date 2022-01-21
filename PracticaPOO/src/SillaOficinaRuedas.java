
public class SillaOficinaRuedas extends SillaOficina
{
    // instance variables - replace the example below with your own
    private final boolean ruedas = true;

    public SillaOficinaRuedas()
    {
        super(77.2,50,70.5,118);
        int coste = 25;
        super.setPrecio(coste);
    }

    public String toString() {
        return "Silla de oficina con ruedas." + super.toString() + ", precio: " + getPrecio() + ".";
    }

    public boolean isRuedas() {
        return ruedas;
    }
}