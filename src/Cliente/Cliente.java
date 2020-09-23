package Cliente;

import Servidor.InterfazServicios;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class Cliente {

    private String nomServicio = "localhost";
    private int puerto = 8002;

    public Cliente() {

        try {
            System.out.println("====== Cliente RMI ======");
            System.out.println("nombre del Servicio=" + nomServicio + " Puerto=" + puerto);
            System.out.println("Conectando con el servidor...");
            Registry registro = LocateRegistry.getRegistry(puerto);
            InterfazServicios interfazServicios = (InterfazServicios) registro.lookup(nomServicio);
            System.out.println("Ingresa el tamaño de la matriz m x m: ");
            Scanner entradaEscaner = new Scanner(System.in);
            int tamano = Integer.parseInt(entradaEscaner.nextLine());
            float[][] matriz = new float[tamano][tamano];
            for (int i = 0; i < tamano; i++) {
                for (int j = 0; j < tamano; j++) {
                    System.out.print("\nIngresa el valor de la matriz en la posicion " + (i + 1) + " " + (j + 1) + ": ");
                    matriz[i][j] = Integer.parseInt(entradaEscaner.nextLine());
                }
            }
            if (interfazServicios.esSimetrica(matriz)) {
                System.out.println("La matriz es simetrica");
                mostrarMatriz(matriz);
            } else {
                System.out.println("La matriz no es simetrica");
                mostrarMatriz(matriz);
            }
        } catch (Exception e) {
        }
    }

    public void mostrarMatriz(float[][] matriz) {
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz.length; columna++) {
                System.out.print(" "+matriz[fila][columna]);
            }
            System.out.println("");
        }
    }
}
