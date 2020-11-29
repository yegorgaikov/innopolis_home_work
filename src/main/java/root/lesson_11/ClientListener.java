package root.lesson_11;

import java.io.*;
import java.net.Socket;
import java.util.Objects;
import java.util.UUID;

public class ClientListener extends Thread {

    private final Socket clientSocket;
    private final Server server;
    private String userName;
    private final String uuid;
    private BufferedReader reader;
    private BufferedWriter writer;

    public ClientListener(Socket clientSocket, Server server) {
        this.clientSocket = clientSocket;
        this.server = server;
        this.uuid = UUID.randomUUID().toString();
    }

    @Override
    public void run() {
        server.addClients(this);

        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(getClientSocket().getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(
                     new OutputStreamWriter(getClientSocket().getOutputStream()))) {

            setReader(bufferedReader);
            setWriter(bufferedWriter);
            userName = getMessage();
            String message = userName + " вошел в чат";
            server.broadcast(message, getUUID());

            while (true) {
                try {
                    message = getMessage();
                    if (message.startsWith("@")) {
                        server.unicast(userName + ": " + message, getUUID());
                    } else {
                        server.broadcast(userName + ": " + message, getUUID());
                    }
                } catch (IOException exception) {
                    message = userName + " покинул чат";
                    server.broadcast(message, getUUID());
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка");
        } finally {
            server.removeClients(this);
            closeResources();
        }
    }

    private String getMessage() throws IOException {

        String message;
        while (!(message = reader.readLine()).isEmpty()) {
            return message;
        }
        return null;
    }

    public void closeResources() {
        try {
            if (!Objects.equals(reader, null)) {
                reader.close();
            }
            if (!Objects.equals(writer, null)) {
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getUUID() {
        return uuid;
    }

    public BufferedWriter getWriter() {
        return writer;
    }

    public String getUserName() {
        return userName;
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    public void setWriter(BufferedWriter writer) {
        this.writer = writer;
    }
}
