package Jugadores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * 
 * @author Daniel Sacor Barrios
 */
public class Repeticion {

    public Repeticion() {
    }

    private ArrayList array;
    private int [] ids = new int [100];
    ArrayList<Jugador>  jugadorArray= new ArrayList<>();

    public ArrayList ordenar() {
        Collections.sort(array, new Comparator<Jugador>() {
            @Override
            public int compare(Jugador p1, Jugador p2) {
                return new Integer(p1.getId()).compareTo(new Integer(p2.getId()));
            }
        });
        return array;
    }
    
    public void AgragarArray(Jugador jugar) {
        jugadorArray.add(jugar);
    }

    public void mostrarArray(JComboBox area) {
        jugadorArray.forEach(ju1 -> {
            System.out.println(ju1);
            area.addItem(ju1.getNombre());
        });
    }

    public void mostrar() {
        array.forEach(ob -> {
            System.out.println(ob);
        });
    }

    public boolean RecorrerEvaluar(int id, int contador){
       for (int i=0;i<ids.length;i++) {
           if (ids[i] == 0){
               break;
           }
           if (ids[i] == id){
               return false;
           }
    }
       ids[contador]= id;
       return true;
    }
    
    
    public boolean repetirdos(int id){
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).equals(id)) {
                System.out.println("El color " + id + " fue encontrado!");
                return false;
            }
        }
        return true;
    }
    public boolean countDuplicate(){
        try {
            Set<String> set = new HashSet<>(array);
            ArrayList<String> temp_array = new ArrayList<>();
            temp_array.clear();
            temp_array.addAll(set);
            System.out.println("Si es posible");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
