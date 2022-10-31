import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(4004)) {
            try (Socket clientSocket = server.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {
                System.out.println("Сервер запущен!");
                String word = in.readLine();
                System.out.println(word);
                out.write("Привет, это Сервер! Подтверждаю, вы написали : " + word + "\n");
                out.flush();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}