package root.lesson_11;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public static final int PORT = 25555;
    private final Set<ClientListener> clients = new HashSet<>();
    private ServerSocket serverSocket;

    public static void main(String[] args) {
        Server server = new Server();
        server.accept();
    }

    public void accept() {
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Сервер включен");

            while (true) {
                Socket socket = serverSocket.accept();
                ExecutorService executorService = Executors.newCachedThreadPool();
                ClientListener clientListener = new ClientListener(socket, this);
                executorService.submit(clientListener);
            }
        } catch (IOException exception) {
            try {
                serverSocket.close();
                for (ClientListener client : clients) {
                    client.closeResources();
                }
            } catch (IOException e) {
                System.out.println("Ошибка при закрытии ресурсов");
            } finally {
                System.exit(0);
            }
        }
    }

    public void broadcast(String message, String uuid) throws IOException {
        for (ClientListener client : clients) {
            if (!Objects.equals(client.getUUID(), uuid)) {
                BufferedWriter writer = client.getWriter();
                writer.write(message);
                writer.newLine();
                writer.flush();
            }
        }
    }

    public void unicast(String message, String uuid) throws IOException {
        String name = message.substring(message.indexOf("@") + 1, message.indexOf(","));
        message = message.replace("@" + name + ", ", "");

        for (ClientListener client : clients) {
            if (Objects.equals(client.getUserName(), name) && !Objects.equals(client.getUUID(), uuid)) {
                BufferedWriter writer = client.getWriter();
                writer.write(message);
                writer.newLine();
                writer.flush();
            }
        }
    }

    public void addClients(ClientListener clientListener) {
        clients.add(clientListener);
    }

    public void removeClients(ClientListener clientListener) {
        clients.remove(clientListener);
    }
}
