//echo client and server using java

/*
ALGORITHM:
SERVER:
    STEP 1: Start
    STEP 2: Declare the variables for the socket
    STEP 3: Specify the family, protocol, IP address and port number
    STEP 4: Create a socket using socket() function
    STEP 5: Bind the IP address and Port number
    STEP 6: Listen and accept the client’s request for the connection
    STEP 7: Read the client’s message
    STEP 8: Display the client’s message
    STEP 9: Close the socket
    STEP 10: Stop
CLIENT:
    STEP 1: Start
    STEP 2: Declare the variables for the socket
    STEP 3:  Specify the family, protocol, IP address and port number
    STEP 4: Create a socket using socket() function
    STEP 5: Call the connect() function
    STEP 6: Read the input message
    STEP 7: Send the input message to the server
    STEP 8: Display the server’s echo
    STEP 9: Close the socket
    STEP 10: Stop
*/

//server
package EXP_9;
import java.io.*;
import java.net.*;
public class server {
    private final static int PORT = 8080;

    public static void main(String[] args) throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(PORT);

        System.out.println("Listening on port " + PORT);

        while (true) {
            try (Socket socket = serverSocket.accept();
                 InputStreamReader isr = new InputStreamReader(socket.getInputStream());
                 BufferedReader in = new BufferedReader(isr);
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
            ) {
                System.out.println("Connection accepted");

                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println("Server received: " + line + ". Sending to client");
                    out.println(line);

                    if (line.equals("Bye")) {
                        break;
                    }
                }
            }
        }
    }
}



//client
package EXP_9;
import java.io.*;
import java.net.*;
public class client {
    private final static String HOSTNAME = "localhost";
    private final static int PORT = 8080;

    public static void main(String[] args) throws IOException
    {
        try (Socket clientSocket = new Socket(HOSTNAME, PORT);
             InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
             BufferedReader in = new BufferedReader(isr);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            System.out.println("Connected to " + HOSTNAME + " on port " + PORT);

            String data = "Hello\nBye";

            System.out.println("Sending to server:\n" + data);
            out.println(data);

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("Client received: " + line);
            }
        }
    }
}

