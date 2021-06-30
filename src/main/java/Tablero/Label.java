/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Tablero;

import java.awt.Color;
import javax.swing.JLabel;

/**
 * 
 * @author Daniel Sacor Barrios
 */
public class Label extends JLabel{
    public Label( int pos_x, int pos_y, int ancho, int alto ){ 

        //Se coloca el boton en un lugar y se le da un tamanio
        setBounds(pos_x, pos_y, ancho, alto);
        setBackground(Color.red);
        //Se agrega el action listener en este caso la misma clase

    }
}
