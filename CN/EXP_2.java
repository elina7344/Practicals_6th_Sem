//Ping is a simple command that can test the reachability of a device on the network.

//Traceroute is a command you use to 'trace' the 
/*route that a packet takes when traveling to its destination. 
    It's useful for tracing network problems, 
    discovering where connections fail, and tracking down latency problems.*/

/*PING ALGORITHM

Step 1:	Start the program. 

Step 2:	Import net and packages. 

Step 3:	Get the IP address 

Step 4:	Ping the remote server using Ping Command 

Step 5:	The Packet statistics of the pinged server is displayed */




//Ping
package EXP_2;
import java.io.*;
public class ping {
    public static void runSystemCommand(String Command)
{
try{
Process p=Runtime.getRuntime().exec(Command);
BufferedReader InputStream=new BufferedReader(new InputStreamReader(p.getInputStream()));
String s=" ";
while((s=InputStream.readLine())!=null)
{
System.out.println(s);
}
}
catch(Exception e)
{
e.printStackTrace();
}
}
public static void main(String[]args)
{
String Ip="localhost";

runSystemCommand("ping " +Ip);
java.util.Date date=new java.util.Date();
System.out.println(date);
}
}

/*TRACEROUTE ALGO

Step 1:	Start the program. 

Step 2:	Import net and packages. 

Step 3:	Get the IP address 

Step 4:	Traceroute the remote server using traceroute Command 

Step 5:	The number of max hopes and byte packets are displayed.*/

//traceroute
package EXP_2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class traceroute {

    public static void runSystemCommand(String Command)
    {
    try{
    Process p=Runtime.getRuntime().exec(Command);
    BufferedReader InputStream=new BufferedReader(new InputStreamReader(p.getInputStream()));
    String s=" ";
    while((s=InputStream.readLine())!=null)
    {
    System.out.println(s);
    }
    }
    catch(Exception e)
    {
    e.printStackTrace();
    }
    }
    public static void main(String[]args)
    {
    String Ip=" 67.195.160.76";
    
    runSystemCommand("tracert" +Ip);
    java.util.Date date=new java.util.Date();
    System.out.println(date);
    }
    }  

