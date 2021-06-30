/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Archivos;


import Tablero.Matriz;
import java.awt.geom.Area;
import javax.swing.*;
//import javax.swing.vuelosfilechooser.FileNameExtensionFilter;
import java.io.*;
        
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class LeerArchivo {
    static String[][] tirados = new String[20][];
    static String[][] tablero = new String[20][];
    static String[][] retrocede = new String[20][];
    static String[][] avanza = new String[20][];
    static String[][] subidas = new String[20][];
    static String[][] pierdeturno = new String[20][];
    static String[][] bajada = new String[20][];
    static String reservas[][] = new String[20][];
    static int cantidadTirados = 0;
    static int cantidadTableros = 0;
    static int cantidadRetroceder = 0;
    static int cantidadavanza = 0;
    static int cantidadSubidas = 0;
    static int cantidadPierdeturno = 0;
    static int cantidadBajadas = 0;
    static int cantidadReservas = 0;
    //public static void main(String[] args) {
   
   static JTextArea area;

    public LeerArchivo(JTextArea area) {
        this.area = area;
    }

    //}

    public static void LeerArchivos(){
        
        JFileChooser cargar = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Carga de datos","txt");
        cargar.setFileFilter(filtro);

        cargar.showOpenDialog(null);
        cargar.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        //
        File archivo = cargar.getSelectedFile();
        
        //File archivo = new File("/home/daniel/Escritorio/doc.txt");
        int contador = 0;
        try{
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
           String lectura = entrada.readLine();

            while(lectura != null){
                contador++;
                System.out.println("----");
                String objeto[] = probar(lectura, contador+"");
                switch (objeto[0]){
                    case "tablero":
                        tablero[cantidadTableros] = objeto;
                        cantidadTableros++;
                        break;
                    case "retrocede":
                        retrocede[cantidadRetroceder] = objeto;
                        cantidadRetroceder++;
                        break;
                    case "tirados":
                        tirados[cantidadTirados] = objeto;
                        cantidadTirados++;
                        break;
                    case "subida":
                        subidas[cantidadSubidas] = objeto;
                        cantidadSubidas++;
                        break;
                
                    case "avanza":
                        avanza[cantidadavanza] = objeto;
                        cantidadavanza++;
                        break;
                
                    case "pierdeturno":
                        pierdeturno[cantidadPierdeturno] = objeto;
                        cantidadPierdeturno++;
                        break;
                                                
                    case "bajada":
                        bajada[cantidadBajadas] = objeto;
                        cantidadBajadas++;
                        break;
                        
                    case "RESERVACION":
                        reservas[cantidadReservas] = objeto;
                        cantidadReservas++;
                        break;
                                                
                }
                lectura = entrada.readLine();
            }
            entrada.close();
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Error al cargar el archivo");
            System.out.println(ex);
        }

        //validar(tablero, retrocede, distancia, tirados, avanza);
        /**
         * Aeropuertos tambien se puede hacer funcion para poder ingresar nuevos aeropuertos desde el programa
         */
        for (int i = 0; i < cantidadTableros; i++) {
            int t = tablero[i].length - 2;
            if(t != 2){
                System.out.println("Error cantidad elementos línea:" + tablero[i][t+1]);
            }else if((esNumero(tablero[i][1]) || esNumero(tablero[i][2]) || esNumero(tablero[i][3])) && !EsAeropuertoRepetido(tablero[i][1],tablero,i)){
                System.out.println("Error número requerido línea:" + tablero[i][t+1]);
            }
            else{
           // Matriz  ma = new Matriz();
                //System.out.println(" "+(tablero[i][1]+ " "+  tablero[i][2]+" "+ tablero[i][3] + i));
            //Aeropuerto aer= new Aeropuerto(tablero[i][1], tablero[i][2], tablero[i][3],1);
//            Aeropuerto.Aeropuerto(tablero[i][1], i);
            }
        }
        /**
         * Aerolineas 
         */
        for (int i = 0; i < cantidadRetroceder; i++) {
            int t = retrocede[i].length - 2;
            if (t != 2) {
                System.out.println("Error cantidad elementos línea:" + retrocede[i][t + 1]);
            } else if (!esNumero(retrocede[i][1]) || !esNumero(retrocede[i][2]) || (!esAerolinearepetida(retrocede[i][1],retrocede[i][2], retrocede, i)) || (ExisteElAeropuerto(retrocede[i][1], tablero, cantidadTableros))) {
                System.out.println("Error número requerido línea:" + retrocede[i][t + 1]);
            } else {
                //Aerolinea av = new Aerolinea(retrocede[i][1], retrocede[i][2], i);
            }
        }
        /**
         * Aviones
         */
        for (int i = 0; i < cantidadTirados; i++) {
            int t = tirados[i].length - 2;
            if(t != 6){
                System.out.println("Error cantidad elementos línea:" + tirados[i][t+1]);
            }else if(!esNumero(tirados[i][4]) || !esNumero(tirados[i][5]) || !esNumero(tirados[i][6]) || (ExisteElAerolinea(tirados[i][1], retrocede, cantidadRetroceder))){
                System.out.println("Error número requerido línea:" + tirados[i][t+1]);
            }
            else{
                //Avion av = new Avion(tirados[i][1], tirados[i][2], tirados[i][3], Integer.parseInt(tirados[i][4]), Integer.parseInt(tirados[i][5]), Float.parseFloat(tirados[i][6]),i);
            }
        }
        /**
         * Distancia
         */
        for (int i = 0; i < cantidadSubidas; i++) {
            int t = subidas[i].length - 2;
            if(t != 3){
                System.out.println("Error cantidad elementos línea:" + subidas[i][t+1]);
            }else if(!esNumero(subidas[i][3])||(ExisteElAeropuerto(subidas[i][1], tablero, cantidadTableros)) || (ExisteElAeropuerto(subidas[i][2], tablero, cantidadTableros))){
                System.out.println("Error número requerido línea:" + subidas[i][t+1]);
            }
            else{
                //Distancia av = new Distancia(subidas[i][1], subidas[i][2], Integer.parseInt(subidas[i][3]),i);
            }
        }/**
         * Vuelos /**
         * Vuelos /**
         * Vuelos /**
         * Vuelos /**
         * Vuelos /**
         * Vuelos /**
         * Vuelos /**
         * Vuelos 
         */
        for (int i = 0; i < cantidadPierdeturno; i++) {
            int t = pierdeturno[i].length - 2;
            if(t != 6){
                System.out.println("Error cantidad elementos  VUELOS línea:" + pierdeturno[i][t+1]);
            }else if(!esNumero(pierdeturno[i][1]) || !esNumero(pierdeturno[i][5])){
                System.out.println("Error número requerido línea:" + pierdeturno[i][t+1]);
            }
            else{
                //Vuelo av = new Vuelo(Integer.parseInt(pierdeturno[i][1]), pierdeturno[i][2], pierdeturno[i][3],pierdeturno[i][4], Integer.parseInt(pierdeturno[i][5]), pierdeturno[i][6], i);
            }
        }
        /**
         * Pasaportes
         */
        for (int i = 0; i < cantidadavanza; i++) {
            int t = avanza[i].length - 2;
            if (t != 12) {
                System.out.println("Error cantidad elementos línea:" + avanza[i][t + 1]);
            } else if (!esNumero(avanza[i][1]) || !esNumero(avanza[i][5])) {
                System.out.println("Error número requerido línea:" + avanza[i][t + 1]);
            } else {
               // Pasaporte av = new Pasaporte(avanza[i][1], avanza[i][2], avanza[i][3], avanza[i][4], avanza[i][5], avanza[i][6], avanza[i][7], avanza[i][8], avanza[i][9], avanza[i][10], avanza[i][11], avanza[i][12], i);
            }
        }
        /**
         * Tarjetas
         */
        for (int i = 0; i < cantidadBajadas; i++) {
            int t = bajada[i].length - 2;
            if (t != 4) {
                System.out.println("Error cantidad elementos línea:" + bajada[i][t + 1]);
            } else if (!esNumero(bajada[i][1]) || !esNumero(bajada[i][2]) || !esNumero(bajada[i][3]) || !esNumero(bajada[i][4])) {
                System.out.println("Error número requerido línea:" + bajada[i][t + 1]);
            } else {
//                Tarjeta at = new Tarjeta(bajada[i][1], bajada[i][2], bajada[i][3], bajada[i][4], i);
            }
        }
        /**
         * Reservas
         */
        for (int i = 0; i < cantidadReservas; i++) {
            int t = reservas[i].length - 2;
            if (t != 4) {
                System.out.println("Error cantidad elementos línea:" + reservas[i][t + 1]);
            } else if (!esNumero(reservas[i][1]) || !esNumero(reservas[i][2]) || !esNumero(reservas[i][3]) || !esNumero(reservas[i][4])) {
                System.out.println("Error número requerido línea:" + reservas[i][t + 1]);
            } else {
               // Reserva at = new Reserva(reservas[i][1], reservas[i][2], reservas[i][3], reservas[i][4], i);
            }
        }
        area.append(tablero + "\n");
               // agregar.append(nombre + "\n");
    }
    
    public static boolean esNumero(String valor){
        try{
            var n =Float.parseFloat(valor);
            return true;
        }
        catch(Exception ex){
            return true;
        }
    }
    public static boolean EsAeropuertoRepetido(String valor,String arreglo[][], int ff){

            for (int i = 0; i < ff; i++) {
                if (valor.equals(arreglo[i][1])){
                    System.out.println("Esta respetido " + arreglo[i][1]);
                    return false;
                }
            }
       return true;
    }
    public static boolean ExisteElAeropuerto(String valor, String arreglo[][], int ff) {
        for (int i = 0; i < ff; i++) {
            if (valor.equals(arreglo[i][1])) {
                return false;
            }
        }
        return true;
    }
    public static boolean ExisteElAerolinea(String valor, String arreglo[][], int ff) {
        for (int i = 0; i < ff; i++) {
            if (valor.equals(arreglo[i][2])) {
                return false;
            }
        }
        return true;
    }

    public static boolean esAerolinearepetida(String valor, String valor2, String arreglo[][], int ff){
            for (int i = 0; i < ff; i++) {
                if (valor.equals(arreglo[i][1]) && valor2.equals(arreglo[i][2])) {
                        System.out.println("Esta respetido " + arreglo[i][1] + " y " + arreglo[i][2]);
                        return false;
                    }
                
            }
       return true;
    }

    public static String[] probar(String a, String linea ){
        a = a+linea;
        a = a.replaceAll("\\(", ",");
        a = a.replaceAll("\\)", ",");
        String b[] = a.split(",");


        for (int i = 0; i <b.length ; i++) {
            b[i] = b[i].trim().toUpperCase();
            //toLowerCase();
            System.out.println(b[i]);
        }
        return b;
    }
    
}