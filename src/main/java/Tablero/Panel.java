package Tablero;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Panel extends JPanel implements ActionListener {
    private int pos_x, pos_y;
//-------- Constructor con parametros para posicionar a los botones ------//
    public Panel( int pos_x, int pos_y, int ancho, int alto ){ 

        //Se coloca el boton en un lugar y se le da un tamanio
        setBounds(pos_x, pos_y, ancho, alto);
        setBackground(Color.red);
        //Se agrega el action listener en este caso la misma clase

    }
     public Panel( int pos_x, int pos_y, int ancho, int alto , String a){ 

        //Se coloca el boton en un lugar y se le da un tamanio
        setBounds(pos_x, pos_y, ancho, alto);
        setBackground(Color.PINK);
        //Se agrega el action listener en este caso la misma clase

    }
    //------------------------------------------------------------------------//
    
    //---------------------- Se asigna una el nombre del boton ---------------//
    public void setNombre( int f ){
                this.pos_x = f;
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
