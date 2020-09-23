package Servidor;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JTextPane;

public class Servidor extends UnicastRemoteObject implements InterfazServicios {

    public Servidor() throws RemoteException {
    }

    private String ip = "localhost";
    private int puerto = 8002;

    public void iniciarServicioRMI() {
        try {
            Registry registro = LocateRegistry.createRegistry(puerto);
            registro.rebind(ip, this);
            System.out.println("Servidor iniciado...");
        } catch (RemoteException ex) {
            System.out.println(ex);
        }
    }

    private void finalizarServicioRMI() {
        try {
            Registry registro = LocateRegistry.getRegistry(this.puerto);
            registro.unbind(ip);
        } catch (RemoteException | NotBoundException ex) {
            System.out.println(ex);
        }
    }

    public boolean esSimetrica(float[][] matriz) {
        for (int fila = 1; fila < matriz.length; fila++) {
            for (int columna = 0; columna < fila; columna++) {
                if (matriz[fila][columna] != matriz[columna][fila]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String mostrarMatriz(float[][] matriz) {
        System.out.println("aquie");
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz.length; columna++) {
                System.out.println(matriz[fila][columna]);
                return String.valueOf(matriz[fila][columna]);
            }
            System.out.println("");
        }
        return "";
    }
}
