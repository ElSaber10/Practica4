
package Tablero;


import Jugadores.FrameInicio;
import Jugadores.Jugador;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class Matriz extends JFrame /*implements ActionListener */{
private JPanel panel;
	JButton btnCrear;
	JButton btnUnir;
	JTextField txtColumnas;
	JTextField txtFilas;
        private int filas;
        private int columnas;
        private int FilaInicialEscale;
        private int ColumnaInicialEscale;
        private int FilaFinalEscale;
        private int ColumnaFinalEscale;

    public Matriz(int FilaInicialEscale, int ColumnaInicialEscale, int FilaFinalEscale, int ColumnaFinalEscale) {
        this.FilaInicialEscale = FilaInicialEscale;
        this.ColumnaInicialEscale = ColumnaInicialEscale;
        this.FilaFinalEscale = FilaFinalEscale;
        this.ColumnaFinalEscale = ColumnaFinalEscale;
    }
        
        private int FilanicialSerpi;
        private int ColumnaInicialSerpi;
        private int FilaFinalSerpi;
        private int ColumnaFinalSerpi;
        private String a;       

    public Matriz(int FilanicialSerpi, int ColumnaInicialSerpi, int FilaFinalSerpi, int ColumnaFinalSerpi, String a) {
        this.FilanicialSerpi = FilanicialSerpi;
        this.ColumnaInicialSerpi = ColumnaInicialSerpi;
        this.FilaFinalSerpi = FilaFinalSerpi;
        this.ColumnaFinalSerpi = ColumnaFinalSerpi;
        this.a = a;
    }
        
    private int FilaRetroceder;
    private int ColumnaRetroceder;
        public void pan (JPanel panel){
            this.panel= panel;
        }
        
    public Matriz(JPanel panel, int fila, int columna) {
        this.panel = panel;
        this.filas = filas;
        this.columnas = columna;
        JToolBar barraHerramientas = new JToolBar();
        panel = new JPanel(null);
        //Para que el JFrame cierre la aplicacion
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Se agrega el panel a boton
        this.add(panel, BorderLayout.CENTER);

        this.setSize(710, 530);
        //Permite que la ventana se coloque al centro de la pantalla
        this.setLocationRelativeTo(null);
        
this.jajaja();
    }

    public Matriz(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
    }

    ArrayList<JPanel> paneles = new ArrayList<>();

   /* public void actionPerformed(ActionEvent evt) {*/
        //Se obtiene la cantidad de filas a crear como una cadena de caracter
    public void jajaja (){   

        //Se obtiene la cantidad de columnas a crear como una cadena de caracter

        //Se cambia de cadena de caracteres a numeros
    int filas = 5;//Integer.parseInt(f);
    int columnas = 5;//Integer.parseInt(c);
     Panel[][] botones = new Panel[filas][columnas];
        //Eliminamos los anteriores botones
        panel.removeAll();

        //Se crea una matriz de botones segun las filas y columnas entrantes
 
                  //Panel[] fichas = new Panel[2];
          int contador = 1;
        //Se recorren las filas
        for (int fila = 0; fila < filas; fila++) {
            //Estando en la fila se recorrer las columnas
            for (int columna = 0; columna < columnas; columna++) {
                //Se crea el boton y se agrega a las celda de la matriz
                botones[fila][columna] = new Panel(110 * columna, 90 * fila, 100, 75);
                
                  //fichas[fila]= new Panel(110 * columna, 90 * fila, 100, 75);
                //Se da el nombre en forma de coordenada enviando la fila y columna
                 botones[fila][columna].setNombre(contador);
                 contador++;
                //Se agrega el boton al panel
                panel.add(botones[fila][columna]);
                
            }
            
        }
        FrameInicio g = new FrameInicio();
        g.paneles(panel);
        //Se actualiza el panel para que se vean los botones
        panel.updateUI();
    }
    
public void mostrarFichas(){
    
}



}

    
