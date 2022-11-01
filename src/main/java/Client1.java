import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {
    public static void main(String[] args) {
        try (Socket clientSocket1 = new Socket("localhost", 8080);
             PrintWriter out1 = new PrintWriter(clientSocket1.getOutputStream(), true);
             Scanner scanner1 = new Scanner(System.in);
             BufferedReader in1 = new BufferedReader(new InputStreamReader(clientSocket1.getInputStream()))) {
            String actualCity = in1.readLine();
            System.out.println("Город, который озвучил игрок: " + actualCity);
            System.out.print("Введите название города: ");
            out1.println(scanner1.nextLine());
            String response = in1.readLine();
            System.out.println(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}