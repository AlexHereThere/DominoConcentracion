
/**
 * clase para modelar un marcador.
 *
 * @author (ACR)
 * @version (1)
 */
public class Marcador
{
    private int valorDeMarcador;
    //constructor
    public Marcador()
    {
        valorDeMarcador=0;    
    }
    //constructor parametrizado
    public Marcador(int ValorDeMarcadorInicial)
    {
        valorDeMarcador=ValorDeMarcadorInicial;    
    }
    
    //getter
    public int getValorDeMarcador()
    {
        return valorDeMarcador;    
    }
    // otros metodos
    /**
     * incrementar marcador segun el numero dado
     */
    public void incrementarMarcador(int cuanto)
    {
        valorDeMarcador+=cuanto;    
    }
    /**
     * decrementar marcador segun el numero dado
     */
    public void decrementarMarcador(int cuanto)
    {
        valorDeMarcador-=cuanto;    
    }
    public String toString()
    {
        return " "+valorDeMarcador;    
    }
}
