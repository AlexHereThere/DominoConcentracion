import java.util.Random;
/**
 * Clase para resguardar y manejar las fichas de domino
 *
 * @author (ACR)
 * @version (1)
 */
public class Domino
{
    // instance variables - replace the example below with your own
    private Ficha[] fichas;//arreglo para guardar todos los valores
    private int numeroDeFichas;//guarda el numero de fichas del domino creado
    private int maxPuntosPorLado;//guarda el numero de puntos que puede tener un lado dependiendo del tipo de domino
    /**
     * Constructor para domino simple (6 doble).
     */
    public Domino()
    {
        numeroDeFichas=28;
        fichas = new Ficha[28]; 
    
        for(int i=0;i<numeroDeFichas;i++)
        {
            fichas[i]=new Ficha();    
        }
    
        maxPuntosPorLado=6;
    }
    /**
     * Constructor para los atributos de Domino
     * establece que tipo de domino sera.
     * Medidas Disponibles: "doble 6","doble 9","doble 12".
     * Si no se introduce medida valida, sera doble 6.
     */
     public Domino(String tipoDeDomino)
     {
       if(tipoDeDomino=="doble 9")
       {
           numeroDeFichas=55;
           fichas = new Ficha[55];
           maxPuntosPorLado=9;
       }
       else if(tipoDeDomino=="doble 12")
       {
           numeroDeFichas=91;
           fichas = new Ficha[91];
           maxPuntosPorLado=12;
       }
       else
       {
           numeroDeFichas=28;
           fichas = new Ficha[28]; 
           maxPuntosPorLado=6;
       }
       
      for(int i=0;i<numeroDeFichas;i++)
      {
          fichas[i]=new Ficha();    
      }
    
     }
     /**
      * Metodo para vaciar los valores de las fichas
      */
     private void vaciarValorDeFichas()
     {
      for(int i=0;i<numeroDeFichas;i++)
      {
          fichas[i].setLado1(0);
          fichas[i].setLado2(0);
      }
     }
    /**
     * Metodo para asignar los valores de las fichas de manera acomodada
     * ([0/0],[0/1],[1/1],[0/2],[1/2],etc.)
     */
    public void setValorAcomodado()
    {
        vaciarValorDeFichas();
        int x=0;
        for(int l2=0;l2<=maxPuntosPorLado;l2++)
        {   
          for(int l1=0;l1<=l2;l1++)
          {
                       fichas[x].setLado1(l1);
                       fichas[x].setLado2(l2);
                       x++;
          }
        }
    }
    /**
     * Metodo para asignar los valores de las fichas de manera aleatoria
     * ([3/4],[2,2],[5/6],[0/1],[0/6],etc.)
     */
    public void setValorAleatorio()
    {
        vaciarValorDeFichas();
        Random rnd = new Random();
        int l1,l2;
        boolean repetido;   
        //al principio asigno la ficha que tendra 0/0 
        int fichaCon0_0=rnd.nextInt(numeroDeFichas);
        fichas[fichaCon0_0].setLado1(0);
        fichas[fichaCon0_0].setLado2(0);
       for(int x=0;x<numeroDeFichas;x++)
       {
           repetido=false;
             //para que se respete la ficha que se selecciono como 0/0
             if(x==fichaCon0_0) {
                 continue;
             }
             //lado 1 no puede ser mayor que lado 2
             do{
                 l1=rnd.nextInt(maxPuntosPorLado+1);
                 l2=rnd.nextInt(maxPuntosPorLado+1);
             }while(l1>l2);
             //para ver si no hay repetido
           for(int y=0;y<numeroDeFichas;y++)
           {
            if(l1==fichas[y].getLado1() && l2==fichas[y].getLado2())
            {
                repetido=true;
            }
           }
            //si se repite, volver a asignar nuevos.
            if(repetido==true)
            {
                x--;   
            }
            else
            {
                fichas[x].setLado1(l1);
                fichas[x].setLado2(l2);
            }
       }
    }
    /**
     * mostrar todas las fichas
     */
    public void mostrarFichas()
    {
    for(int i=0;i<numeroDeFichas;i++)
    {
          System.out.println("("+i+") "+fichas[i]);   
    }
    }
    /**
    * para mostrar una ficha en especifico
    */
    public String mostrarFicha(int NumeroDeFicha)
    {
          return fichas[NumeroDeFicha].toString();   
    }
    /**
     * para voltear todas las fichas
     */
     public void voltearFichas()
    {
    for(int i=0;i<numeroDeFichas;i++)
    {
         fichas[i].voltear();  
    }
    }
    /**
     * para sacar la suma de puntos de los dos lados de una ficha
     */
    public int getMaxPuntosDeFicha(int numeroDeFicha)
    {
        return fichas[numeroDeFicha].getLado1() + fichas[numeroDeFicha].getLado2();    
    }
    /**
     * para voltear una ficha especifica en el domino
     */
    public void voltearFicha(int NumeroDeFicha)
    {
        fichas[NumeroDeFicha].voltear();        
    }
}