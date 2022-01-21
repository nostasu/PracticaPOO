

public class MesaDormitorio extends Mesa
{
    /**
     * Constructor de la clase mesa dormitorio. 
     */
    public MesaDormitorio()
    {
        super(45, 38, 34);
        int coste = 25;
        super.setPrecio(coste);
    }

    public String toString()
    {
        return "Mesilla de dormitorio." + super.toString() + ", precio: " + getPrecio() + ".";
    }
}
