package Servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfazServicios extends Remote {
    
    public boolean esSimetrica(float[][] matriz) throws RemoteException;

    public String mostrarMatriz(float[][] matriz) throws RemoteException;
}
