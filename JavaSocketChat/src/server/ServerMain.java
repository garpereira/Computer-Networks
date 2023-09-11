package server;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class ServerMain {
    public static void main(String[] args) {

        try {
            // Definindo a porta de comunicação
            ServerSocket servidor = new ServerSocket(7000);
            System.out.println("Servidor iniciado na porta 7000...");
            
            Scanner mensagemInput = new Scanner(System.in);
            //Espera conexão
            while (true) {
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
                
                try{
                    ObjectInputStream inputCliente = new ObjectInputStream(cliente.getInputStream());
                    ObjectOutputStream outputServer = new ObjectOutputStream(cliente.getOutputStream());
                    while (true) {
                        // Recebendo a mensagem do cliente
                        String mensagem = inputCliente.readObject().toString();
                        System.out.println("Mensagem recebida do Cliente: " + mensagem);
                        if (mensagem.equals("sair")) {
                            inputCliente.close();
                            break;
                        }
                        // Enviando a mensagem para o cliente
                        System.out.println("Digite uma mensagem: ");
                        String mensagemServer = mensagemInput.nextLine();
                        if (mensagemServer != null){
                            outputServer.writeObject(mensagemServer);
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Erro de E/S: " + e.getMessage());
                    }
                cliente.close();
            }
            
        } catch (Exception e){
        System.out.println("Erro: " + e.getMessage());
        }
    }
}
