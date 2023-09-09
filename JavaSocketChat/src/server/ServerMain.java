package server;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class ServerMain {
    public static void main(String[] args){

        try{
            // Definindo a porta de comunicação
            ServerSocket servidor = new ServerSocket(7000);
            System.out.println("Servidor iniciado na porta 7000...");
            //Espera conexão
            while(true){
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
                InputStreamReader fluxoDados = new InputStreamReader(cliente.getInputStream());
                BufferedReader input = new BufferedReader(fluxoDados);
                System.out.println("Mensagem recebida: " + input.readLine());
            }
        }catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
