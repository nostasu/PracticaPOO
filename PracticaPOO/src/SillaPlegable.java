
public class SillaPlegable extends Silla
{
    private boolean plegable = true;

    public SillaPlegable ()
    {
        super(45, 45.2, 47.5, 87);
        int coste = -15;
        super.setPrecio(coste);

    }

    public boolean isPlegable() {
        return plegable;
    }

    public String toString() {
        return "Silla de plegable." + super.toString() + ", precio: " + getPrecio() + ".";
    }

}
