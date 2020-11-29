package root.lesson_11;

import java.io.*;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class Client {

    private static final String HOST = "localhost";
    private static final int PORT = 25555;

    public static void main(String[] args) {
        try (Socket clientSocket = new Socket(HOST, PORT);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
             BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             Scanner scanner = new Scanner(System.in)
        ) {

            System.out.println("Клиент подключен к серверу");
            System.out.println("Введите свое имя");

            String userName = scanner.nextLine();
            writer.write(userName);
            writer.newLine();
            writer.flush();

            new Thread(() -> {
                String message;
                while (true) {
                    try {
                        while (!(message = reader.readLine()).isEmpty()) {
                            System.out.println(message);
                        }
                    } catch (IOException e) {
                        System.out.println("Подключение прервано");
                        System.exit(0);
                    }
                }
            }).start();

            System.out.println("Привет " + userName + "!");

            message(scanner, writer);

        } catch (IOException e) {
            System.out.println("Cервер недоступен");
        } finally {
            System.exit(0);
        }
    }

    public static void message(Scanner scanner, BufferedWriter writer) throws IOException {
        String out;
        while (true) {
            out = scanner.nextLine();
            if ("quit".equals(out)) {
                System.exit(0);
            }
            if (!Objects.equals(out, null)
                    && !out.isEmpty()
                    && !Objects.equals("\n", out)) {
                writer.write(out);
                writer.newLine();
                writer.flush();
            }
        }
    }
}
