
package Tablero;

import javax.swing.JButton;

/**
 * 
 * @author Daniel Sacor Barrios
 */
public class Nodo extends JButton{

        String dato;
    Nodo arr;
    Nodo abj;
    Nodo sig;
    Nodo ant;

    public Nodo(String dato){
        this.dato = dato;
    }

    public Nodo getArr() {
        return arr;
    }

    public void setArr(Nodo arr) {
        this.arr = arr;
    }

    public Nodo getAbj() {
        return abj;
    }

    public void setAbj(Nodo abj) {
        this.abj = abj;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }

    public Nodo getAnt() {
        return ant;
    }

    public void setAnt(Nodo ant) {
        this.ant = ant;
    }

    @Override
    public String toString() {
        return "Nodo{" +
                "dato='" + dato + '\'' +
                '}';
    }
}
