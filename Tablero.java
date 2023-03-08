
/**
 * tablero se dedicara a demostrar las fichas para el juego y ayudar para modificar el domino.
 * Es exclusivo para doble 6...
 * @author (ACR)
 * @version (1)
 */
public class Tablero
{
  private boolean[] estaFicha;
  private Domino domino;
  /**
   * Constructor de Tablero
   */
  public Tablero()
  { 
   estaFicha=new boolean[28];
       for(int i=0;i<28;i++)
       {
           estaFicha[i]=true; 
       }
    domino=new Domino();
   }
  /**
   * Constructor parametrizado para Tablero
   */
  public Tablero(Domino domino)
  {
    estaFicha=new boolean[28];
       for(int i=0;i<28;i++)
       {
           estaFicha[i]=true; 
       }  
    this.domino=domino;
  }
  /**
   * metodo para mostrar el campo de juego (para doble 6)
   */
  public void mostrarDomino()
  {
        int x=0;
        System.out.println("     1     2     3     4     5     6     7");  
    for(int i=0;i<4;i++)
    {
        System.out.print((i+1)+" ");
     for(int j=0;j<7;j++)
     {
      if(j==6)
      {   
          if(estaFicha[x]==true)
          {
              System.out.println(" "+domino.mostrarFicha(x));   
              x++;  
          }
          else
          {
              System.out.println("   X  ");    
              x++;
          }
      }
      else
      {   
          if(estaFicha[x]==true)
          {
              System.out.print(" "+domino.mostrarFicha(x));
              x++;
          }
          else
          {
              System.out.print("   X  ");
              x++;
          }
      }
     }
    }
  }
  /**
   * Metodo para voltear domino
   */
  public void voltearDomino()
  {
      domino.voltearFichas();    
  }
  /**
   * Para sacar la ficha establecida
   */
  public void sacarFicha(int numeroDeFicha)
  {
      estaFicha[numeroDeFicha]=false;    
  }
  /**
   * Para determinar si una ficha sigue en el juego
   */
  public boolean estaFicha(int numeroDeFicha)
  {
      return estaFicha[numeroDeFicha];    
  }
}
