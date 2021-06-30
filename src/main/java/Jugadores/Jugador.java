package Jugadores;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Generar objetos tipo jugador el cual es para tener control.
 */
/**
 * 
 * @author Daniel Sacor Barrios
 */
public class Jugador {
private int Id;
private String nombre;
private String apellido;
protected int partidasJugadas;
protected int partidasGanadas;
protected int partidasPerdidas;


    public Jugador() {
    }



    public Jugador(int Id, String nombre, String apellido) {
        this.Id = Id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Jugador(int Id, String nombre, String apellido, int partidasJugadas, int partidasGanadas, int partidasPerdidas) {
        this.Id = Id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.partidasJugadas = partidasJugadas;
        this.partidasGanadas = partidasGanadas;
        this.partidasPerdidas = partidasPerdidas;

    }
   


    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    public void setPartidasJugadas(int partidasJugadas) {
        this.partidasJugadas = partidasJugadas;
    }

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    public int getPartidasPerdidas() {
        return partidasPerdidas;
    }

    public void setPartidasPerdidas(int partidasPerdidas) {
        this.partidasPerdidas = partidasPerdidas;
    }

    @Override
    public String toString() {
        return "Jugador{" + "Id=" + Id + ", nombre=" + nombre + ", apellido=" + apellido + ", partidasJugadas=" + partidasJugadas + ", partidasGanadas=" + partidasGanadas + ", partidasPerdidas=" + partidasPerdidas + '}';
    }

 


    
    
}
