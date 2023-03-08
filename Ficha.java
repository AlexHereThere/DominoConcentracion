
/**
 * Para modelar cada ficha de domino
 *
 * @author (ACR)
 * @version (1)
 */
public class Ficha
{
    //atributos de ficha
    private int lado1; //es el valor del lado izquierdo
    private int lado2; //es el valor del lado derecho
    private boolean estaVolteado; //es para repesentar si esta volteado o no
    //Constructor de ficha.
  public Ficha()
  {
      lado1=0;
      lado2=0;
      estaVolteado=false;
  }
  //Constructor parametrisado de ficha.
  public Ficha(int lado1, int lado2)
  {
      this.lado1=lado1;
      this.lado2=lado2;
      estaVolteado=false;
  }
  //Para obtener valor lado1 de ficha.
  public int getLado1()
  {
      return lado1;
  }
  //Para cambiar valor lado1 de ficha.
  public void setLado1(int lado1)
  {
      this.lado1=lado1;
  }
  
  //Para obtener valor lado2 de ficha.
  public int getLado2()
  {
      return lado2;
  }
  //Para cambiar valor lado2 de ficha.
  public void setLado2(int lado2)
  {
      this.lado2=lado2;
  }
  //Para voltear la ficha.
  public void voltear()
  {
   if(estaVolteado==false)
   {
    estaVolteado=true;
   }
   else
   {
    estaVolteado=false;   
   }
  }
  // obtener el estado del la ficha
  public boolean getEstaVolteado()
  {
      return estaVolteado;
  }
  public String toString()
  {
      if(estaVolteado==true)
      {
          return "  -  ";
      }
      else
      {
          return "["+lado1+"/"+lado2+"]";
      }
  }
}
