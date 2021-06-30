/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablero;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Prueva {

    public static void main(String[] args) {
        Ventana miVentana =new Ventana();
        miVentana.iniciarMovimiento();
    }

}
class Ventana extends JFrame implements Runnable{

    private JPanel jPanel1;
    private JLabel jLabel1;
    private Thread hilo;

    public Ventana() {
        setTitle("JLabel en movimiento");
        setBounds(300, 200, 400, 400);
        jPanel1 =new JPanel(null);
        jLabel1 =new JLabel("Texto de JLabel");
        jLabel1.setLocation(10, 10);
        jLabel1.setSize(90, 20);//ancho 90, altura 20
        jPanel1.add(jLabel1);
        add(jPanel1);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //instanciamos el hilo pasándole un Runneable, o sea esta clase Ventana
        this.hilo = new Thread(this);      
    }

    public void iniciarMovimiento(){
        //se ejecuta el método run()
        hilo.start();
    }

    @Override
    public void run() {

        int x = 1;
        int y = 100;
        int dx = 1;
        int limit = jPanel1.getSize().width;

        Thread ct = Thread.currentThread();
        while(ct == hilo)
        {
            System.out.println("1");
            jLabel1.setLocation(x, y);
            x = x+dx;
            System.out.println(x);

            //si x se hace igual a limite menos el ancho del JLabel invertir sentido
            if(x == limit-jLabel1.getWidth()) {
                dx = -dx;
                System.out.println("2");
            }
            //si x se hace igual a cero invertir sentido
            if(x == 0) {
                dx = -dx;
                System.out.println("3");
            }

            try {
                Thread.sleep(10);//lo hice un poco más rápido
                System.out.println("4");
            } catch (InterruptedException ex) {
                System.out.println("Error");
            }
        }
    }
}
