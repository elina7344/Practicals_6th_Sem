//Simulating RARP using UDP
/*
ALGORITHM:

Client

1.Start the program
2. using datagram sockets UDP function is established.
2.Get the MAC address to be converted into IP address.
3.Send this MAC address to server.
4.Server returns the IP address to client.

Server

Start the program.
Server maintains the table in which IP and corresponding MAC addresses are stored.
Read the MAC address which is send by the client.
Map the IP address with its MAC address and return the IP address to client.
*/

//server

package EXP_8;
import java.net.*; 
public class server {
    public static void main(String args[])
{
try
{
DatagramSocket server=new DatagramSocket(1309); while(true)
{
byte[] sendbyte=new byte[1024];
byte[] receivebyte=new byte[1024];
DatagramPacket receiver=new DatagramPacket(receivebyte,receivebyte.length);
server.receive(receiver);
String str=new String(receiver.getData()); String s=str.trim();
InetAddress addr=receiver.getAddress();
int port=receiver.getPort();
String ip[]={"165.165.80.80","165.165.79.1"}; String mac[]={"6A:08:AA:C2","8A:BC:E3:FA"}; for(int i=0;i<ip.length;i++)
{
if(s.equals(mac[i]))
{
sendbyte=ip[i].getBytes();
DatagramPacket sender=new DatagramPacket(sendbyte,sendbyte.length,addr,port);
server.send(sender);
break;
}
}
break;
}
}
catch(Exception e)
{
System.out.println(e);
}
}
}


//client
package EXP_8;
import java.io.*; 
import java.net.*; 
public class client {
    public static void main(String args[])
{
try
{
DatagramSocket client=new DatagramSocket();
InetAddress addr=InetAddress.getByName("127.0.0.1"); byte[] sendbyte=new byte[1024];
byte[] receivebyte=new byte[1024];
BufferedReader in=new BufferedReader(new InputStreamReader(System.in)); System.out.println("Enter the Physical address (MAC):");
String str=in.readLine(); 
sendbyte=str.getBytes();
DatagramPacket sender=new DatagramPacket(sendbyte,sendbyte.length,addr,1309);
client.send(sender);
DatagramPacket receiver=new DatagramPacket(receivebyte,receivebyte.length); client.receive(receiver);
String s=new String(receiver.getData()); System.out.println("The Logical Address is(IP): "+s.trim()); client.close();
}
catch(Exception e)
{
System.out.println(e);
}
}
}

/*
OUTPUT:
Enter the Physical address (MAC):
6A:08:AA:C2
The Logical Address is(IP): 165.165.80.80
*/
