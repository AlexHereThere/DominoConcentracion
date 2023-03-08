import java.util.Scanner;
/**
 * Esta clase es para controlar todos los aspectos del juego
 *
 * @author (ACR)
 * @version (1)
 */
public class JuegoConcentracion
{
    private Jugador[] jugadores;
    private Tablero tabla;
    private Domino domino;
    private int numeroDeJugadores;
    public static void main(String args[])
    {
        JuegoConcentracion juego=new JuegoConcentracion(2);
        juego.jugar();
    }
    //constructor
    public JuegoConcentracion(int numeroDeJugadores)
    {
        jugadores=new Jugador[numeroDeJugadores];
        //inicializar todos los jugadores
        for(int i=0;i<numeroDeJugadores;i++)
        {
        jugadores[i]=new Jugador();
        }
        domino=new Domino();
        tabla=new Tablero(domino);
        this.numeroDeJugadores=numeroDeJugadores;
    }
    public void jugar()
    {
       int fichaElegido1;
       int fichaElegido2;
       int sumaDePuntos;
       System.out.println("Saludos.. Jugaremos Concetracion de Domino");
       //inicio
       domino.setValorAleatorio();
       tabla.voltearDomino();
       tabla.mostrarDomino();
       mostrarPuntosDeJugadores();
            do{
              for(int i=0;i<numeroDeJugadores;i++)
              {
                  //jugador elige sus fichas
                  do{
                      fichaElegido1=seleccionDeFichaParaJuagdor(i);
                      if(tabla.estaFicha(fichaElegido1)==false) System.out.println("ERROR: NO ESTA FICHA");
                  }while(tabla.estaFicha(fichaElegido1)==false);//verificar que este en la tabla
                  domino.voltearFicha(fichaElegido1);
                  tabla.mostrarDomino();// ver ficha volteada y elegida
                  mostrarPuntosDeJugadores();
                  do{
                        fichaElegido2=seleccionDeFichaParaJuagdor(i);
                      if(tabla.estaFicha(fichaElegido2)==false) System.out.println("ERROR: NO ESTA FICHA");
                      if(fichaElegido1==fichaElegido2) System.out.println("ERROR: YA ELEGISTE ESA");
                      // esto es para que no eliga la misma ficha 2 veces -^
                  }while(tabla.estaFicha(fichaElegido2)==false || fichaElegido1==fichaElegido2);
                  domino.voltearFicha(fichaElegido2);
                  sumaDePuntos=domino.getMaxPuntosDeFicha(fichaElegido1)+domino.getMaxPuntosDeFicha(fichaElegido2);
                  tabla.mostrarDomino();// ver ficha volteada y elegida
                  System.out.println(domino.mostrarFicha(fichaElegido1)+" + "+domino.mostrarFicha(fichaElegido2)+" = "+sumaDePuntos);
                  if(sumaDePuntos>=12)
                  {
                      jugadores[i].ganaPuntos(12);
                      jugadores[i].gano();
                      tabla.sacarFicha(fichaElegido1);
                      tabla.sacarFicha(fichaElegido2);
                      i--;
                  }
                  else
                  {
                      jugadores[i].pierdePuntos(2);
                      jugadores[i].perdio();
                      domino.voltearFicha(fichaElegido1);
                      domino.voltearFicha(fichaElegido2);
                  }
                  tabla.mostrarDomino();// ver cambios debido a los resultados
                  mostrarPuntosDeJugadores();
                  if(esPosibleAcumular12()==false) break; //para que se detenga en cuanto no es posible
              }
            }while(esPosibleAcumular12()==true);
       tabla.voltearDomino();
       tabla.mostrarDomino();
       System.out.println("Mira... ya no es posible lograr los 12...");
       resultado();
            }
   //otros metodos...
   /**
    * mostrar los puntajes de los jugadores
    */
   public void mostrarPuntosDeJugadores()
   {
       for(int i=0;i<numeroDeJugadores;i++)
       {
           System.out.print("Jugador "+(i+1)+" tiene:");
           jugadores[i].mostrarPuntos();
       }
    }
    /**
     * para la seleccion de la ficha a revelar segun las
     * cordenadas que da el juagdor
     */
    public int seleccionDeFichaParaJuagdor(int NumeroDeJugador)
    {  
        Scanner teclado=new Scanner(System.in);
        int i=NumeroDeJugador;
        System.out.println("Jugador "+(i+1)+", introduce las cordenadas de la ficha que quieres ver:");
        jugadores[i].setSeleccionColumna(teclado.nextInt());
        jugadores[i].setSeleccionRenglon(teclado.nextInt());
        int UbicacionY=(jugadores[i].getSeleccionRenglon()-1)*7;
        int UbicacionX=jugadores[i].getSeleccionColumna()-1;
        int fichaElegido=UbicacionY+UbicacionX;
        return fichaElegido;
    }
    /**
     * metodo para saber si es posible sacar la suma de 12 con 2 fichas
     */
   public boolean esPosibleAcumular12()
   {
       boolean esPosible=false;
       for(int i=0;i<27;i++)
       {
           for(int j=i+1;j<28;j++)
           {
               if(tabla.estaFicha(i)==true && tabla.estaFicha(j))    
               {
                   if(domino.getMaxPuntosDeFicha(i)+domino.getMaxPuntosDeFicha(j)>=12)esPosible=true;
               }
           }
       }
       return esPosible;
   }
   /**
    * determinar cual jugador tiene el puntaje mas alto
    */
   private int valorMaxDePuntos()
   {
       int numeroDeJugadorConMax=0;
       int puntosMax=0;
       for(int i=0;i<numeroDeJugadores;i++)
       {
           if(i==0)
           {
               numeroDeJugadorConMax=i;
               puntosMax=jugadores[i].getPuntos();
           }
           if(jugadores[i].getPuntos()>puntosMax)
           {
               numeroDeJugadorConMax=i;
               puntosMax=jugadores[i].getPuntos(); 
           }
       }
       return puntosMax;
   }
   /**
    * resutados del juego.
    */
   public void resultado()
   {
       System.out.println("-----RESULTADOS-----");
       for(int i=0;i<numeroDeJugadores;i++)
       {
           System.out.println("--------------------");    
           System.out.println("Jugador "+(i+1));
           System.out.println("Acumulo: "+jugadores[i].getPuntos());
           System.out.println("Cuantas veces gano: "+jugadores[i].getCuantasGano());
           System.out.println("Cuantas veces perdio: "+jugadores[i].getCuantasPerdio());
           System.out.println("--------------------");
       }
       int puntosMax=valorMaxDePuntos();
       for(int i=0;i<numeroDeJugadores;i++)
       {
           if(jugadores[i].getPuntos()==puntosMax)
           {
           System.out.println("FELICIDADES JUGADOR "+(i+1)+" GANASTE CON: "+jugadores[i].getPuntos());
           }
       }
    }
}
