
package Tablero;

import Jugadores.Jugador;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class Jugar extends Jugador{

    private JTextArea area;
    private int x;
    private int y;
    private int aleat;
    private Panel [][] panel;
    
    public Jugar(Panel [][] panel) {
        this.panel = panel;
    }
    public Jugar() {
    }
    
    
    public void PosicionActual(Jugador jugar, int x, int y){
//        Panel[][] botones = new Panel[filas][columnas];
//          int contador = 1;
//        //Se recorren las filas
//        for (int fila = 0; fila < filas; fila++) {
//            //Estando en la fila se recorrer las columnas
//            for (int columna = 0; columna < columnas; columna++) {
//                //Se crea el boton y se agrega a las celda de la matriz
//                botones[fila][columna] = new Panel(110 * columna, 90 * fila, 100, 75);
//
//                //Se da el nombre en forma de coordenada enviando la fila y columna
//                 botones[fila][columna].setNombre(contador);
//                 
//                 contador++;
//                //Se agrega el boton al panel
//                panel.add(botones[fila][columna]);
//            }
//        }
    }
    
    public void MoverPosicion(){
        
    }
    public void jugadores(String nombre, JTextArea agregar){
        agregar.append(nombre + "\n");
    }
    
    
    public void Iniciar(int jugadores, JPanel  panel){
          Panel[] botones = new Panel[jugadores];
          for (int columna = 0; columna < 2; columna++) {
                //Se crea el boton y se agrega a las celda de la matriz
                botones[columna] = new Panel(columna, 4,200, 175, " ");

                //Se da el nombre en forma de coordenada enviando la fila y columna
                //Se agrega el boton al panel
               panel.add(botones[columna]);
            }
          
    }
    
}
