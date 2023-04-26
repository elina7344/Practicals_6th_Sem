//Program to Implement client server communication (Socket Programming).

//simpleserver
package EXP_1;

import java.net.*;
import java.io.*;

public class simpleserver {
    public static void main(String args[]) throws IOException
    {
        //register service on port 1254
        ServerSocket s = new ServerSocket(1254);
        Socket s1 = s.accept();
        //get a communication stream associated with the socket
        OutputStream s1out = s1.getOutputStream();
        DataOutputStream dos = new DataOutputStream (s1out);
        //send a string
        dos.writeUTF("Welcome to the coding world");
        //Close the connection, but not the server socket
        dos.close();
        s1out.close();
        s1.close();

        }
    
}


//simpleclient

package EXP_1;

import java.net.*;
import java.io.*;

public class simpleclient {
    public static void main(String args[]) throws IOException
    {
        //Open your connection to a server, at port 1254
        Socket s1 = new Socket("localhost",1254);
        //get an input file handle from the socket and read the input
        InputStream s1In = s1.getInputStream();
        DataInputStream dis = new DataInputStream(s1In);
        String st = new String (dis.readUTF());
        System.out.println(st);
        //when done, just close the connection and exit
        dis.close();
        s1In.close();
        s1.close();

    }
}
