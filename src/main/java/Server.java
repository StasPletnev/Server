import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static int count = 0;
    public static void main(String[] args) {
        String actualCity = "???";
        int port = 8080;
        try (ServerSocket serverSocket = new ServerSocket(port)
        ) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    count++;
                    out.println(actualCity);
                    String city = in.readLine();
                    if (city.equals("end")) {
                        out.println("Конец игры");
                        break;
                    }
                    if (count == 1) {
                        actualCity = city;
                        out.println("OK");
                    }
                    if (count > 1) {
                        if (city.charAt(0) == actualCity.charAt(actualCity.length() - 1)) {
                            actualCity = city;
                            out.println("OK");
                        } else {
                            out.println("NOT OK");
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }
}