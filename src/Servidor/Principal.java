package Servidor;

public class Principal {

    Servidor servidor;

    public Principal() {
        try {

            servidor = new Servidor();
            servidor.iniciarServicioRMI();
            
        } catch (Exception e) {
            System.out.println("Excepcion al iniciar el servidor");
        }
    }

    public static void main(String[] args) {
        Principal programa = new Principal();

    }
}
