package client;
import java.net.Socket;
import java.io.PrintStream;

public class ClientMain {
    public static void main(String[] args){
        // Dados do servidor | Para onde vão as informações
        try{
            Socket cliente = new Socket("127.0.0.1", 7000);
            
            System.out.println("Conectado ao servidor!");
            // Fluxo de dados para envio
            PrintStream output = new PrintStream(cliente.getOutputStream());
            output.println("Olá, servidor!");
            cliente.close();
            System.out.println("Conexão encerrada!");
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
