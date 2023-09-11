package client;

import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        try {
            Socket cliente = new Socket("127.0.0.1", 7000);

            System.out.println("Conectado ao servidor! Digite 'sair' para encerrar a conexão.");
            ObjectOutputStream output = new ObjectOutputStream(cliente.getOutputStream());
            Scanner inputCliente = new Scanner(System.in);

            // Recebendo a mensagem do servidor
            ObjectInputStream inputServer = new ObjectInputStream(cliente.getInputStream());

            // Cria um novo thread para receber mensagens do servidor
            Thread t = new Thread(new ServerHandler(inputServer));
            t.start();

            while (true) {
                System.out.println("Digite uma mensagem: ");
                String mensagem = inputCliente.nextLine();
                output.writeObject(mensagem);

                if (mensagem.equals("sair")) {
                    break;
                }
            }

            inputCliente.close();
            output.close();
            cliente.close();
            System.out.println("Conexão encerrada!");
        } catch (Exception e) {
            e.printStackTrace(); // Imprime a pilha de rastreamento da exceção
        }
    }
}

class ServerHandler implements Runnable {
    private ObjectInputStream inputServer;

    public ServerHandler(ObjectInputStream inputServer) {
        this.inputServer = inputServer;
    }

    public void run() {
        try {
            while (true) {
                String mensagemServer = inputServer.readObject().toString();
                if (mensagemServer != null) {
                    System.out.println("Mensagem recebida do Servidor: " + mensagemServer);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // Imprime a pilha de rastreamento da exceção
        }
    }
}