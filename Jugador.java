
/**
 * clase para modelar un jugador de concetracion.
 *
 * @author (ACR)
 * @version (1)
 */
public class Jugador
{
  int seleccionColumna;
  int seleccionRenglon;
  int cuantasGano=0;
  int cuantasPerdio=0;
  Marcador marcador;
  //constructor
  public Jugador()
  {
      seleccionColumna=0;
      seleccionRenglon=0;
      marcador=new Marcador();
  }
  //setters
  public void setSeleccionColumna(int valor)
  {
      seleccionColumna=valor;    
  }
  public void setSeleccionRenglon(int valor)
  {
      seleccionRenglon=valor;
  }
  //getters
  public int getSeleccionColumna()
  {
      return seleccionColumna;    
  }
  public int getSeleccionRenglon()
  {
      return seleccionRenglon;    
  }
   public int getPuntos()
  {
      return marcador.getValorDeMarcador();    
  }
  public int getCuantasGano()
  {
      return cuantasGano;    
  }
  public int getCuantasPerdio()
  {
      return cuantasPerdio;    
  }
  //otros metodos...
  /**
   * modificar su marcador con cuantos perdio
   */
  public void pierdePuntos(int numeroDePuntos)
  {
      marcador.decrementarMarcador(numeroDePuntos);
  }
  /**
   * sumarle al contador de cuantas veces perdio
   */
  public void perdio()
  {
      cuantasPerdio+=1;    
  }
  /**
   * modificar su marcador con cuanto gano
   */
  public void ganaPuntos(int numeroDePuntos)
  {
      marcador.incrementarMarcador(numeroDePuntos);    
  }
   /**
   * sumarle al contador de cuantas veces gano
   */
  public void gano()
  {
      cuantasGano+=1;    
  }
  /**
   * mostrar sus puntos.
   */
  public void mostrarPuntos()
  {
      System.out.println(marcador);    
  }
}
