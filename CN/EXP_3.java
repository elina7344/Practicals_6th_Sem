//HTTP Socket for Webpage upload and download

//ALGORITHM
/*
1.Start the program.

2.Get the frame size from the user

3.To create the frame based on the user request.

4.To send frames to server from the client side.

5.If your frames reach the server it will send ACK signal to client otherwise it will send NACK signal to client.

6.Stop the program
*/

//CLIENT
package EXP_3;

import java.net.*;
import java.io.*;
import java.awt.image.BufferedImage; 
import java.io.ByteArrayOutputStream; 
import java.io.File;
import javax.imageio.ImageIO;
public class client {
    public static void main(String args[]) throws Exception{ Socket soc;
        BufferedImage img = null;
        soc=new Socket("localhost",4000);
        System.out.println("Client is running. ");
        try {
        System.out.println("Reading image from disk. ");
        img = ImageIO.read(new File("Peacock_father.jpeg")); 
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(img, "jpeg", baos);
        baos.flush();
        byte[]  bytes = baos.toByteArray(); baos.close();
        System.out.println("Sending image to server. ");
        OutputStream out = soc.getOutputStream();
        DataOutputStream dos = new DataOutputStream(out);
        dos.writeInt(bytes.length);
        dos.write(bytes, 0, bytes.length);
        System.out.println("Image sent to server. ");
        dos.close();
        out.close();
        }catch (Exception e) { System.out.println("Exception: " + e.getMessage());
        soc.close();
        }
        soc.close();
        }
        }


//SERVER
package EXP_3;
import java.net.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;
public class server {
    public static void main(String args[]) throws Exception{
        ServerSocket server=null;
        Socket socket;
        server=new ServerSocket(4000);
        System.out.println("Server Waiting for image");
        socket=server.accept(); System.out.println("Client connected.");
        InputStream in =    socket.getInputStream();
        DataInputStream dis = new DataInputStream(in);
        int len = dis.readInt();
        System.out.println("Image Size: " + len/1024 + "KB"); 
        byte[] data = new byte[len];
        dis.readFully(data);
        dis.close();
        in.close();
        InputStream ian = new ByteArrayInputStream(data);
        BufferedImage bImage = ImageIO.read(ian);
        JFrame f = new JFrame("Server");
        ImageIcon icon = new ImageIcon(bImage);
        JLabel l = new JLabel();
        l.setIcon(icon);
        f.add(l);
        f.pack();
        f.setVisible(true);
        server.close();
      }
      }
      
       

