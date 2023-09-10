package client;
import java.net.Socket;
import java.io.PrintStream;
import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        // Dados do servidor | Para onde vão as informações
        try {
            Socket cliente = new Socket("127.0.0.1", 7000);
            
            System.out.println("Conectado ao servidor! Digite 'sair' para encerrar a conexão.");
            Scanner input = new Scanner(System.in);
            PrintStream output = new PrintStream(cliente.getOutputStream());
            // Fluxo de dados para envio
            while (true) {
                System.out.println("Digite uma mensagem: ");
                String mensagem = input.nextLine();
                output.println(mensagem);
                if (mensagem.equals("sair")) {
                    break;
                }
            }
            input.close();
            output.close();
            cliente.close();
            System.out.println("Conexão encerrada!");
        } catch(Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
