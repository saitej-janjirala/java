import java.util.Scanner;
import java.net.*;
import java.io.*;
class Server
{
	public static void main(String args[])throws Exception
	{
		ServerSocket server=new ServerSocket(1234);
		Socket s=server.accept();
		System.out.println("connection established");
		DataInputStream dis=new DataInputStream(s.getInputStream());
		DataOutputStream dos=new DataOutputStream(s.getOutputStream());
		Scanner S=new Scanner(System.in);
		
		while(true)
		{
			String out=S.nextLine();
			
			if(out.equals("over"))
			{
				dos.writeUTF(out);
				break;
			}
			else
			{
				dos.writeUTF(out);
			}
			String in=dis.readUTF();
			
			if(in.equals("over"))
			{
				System.out.println(" 	client:"+in);
				break;
			}
			else
			{
				System.out.println("\n	client:"+in);
			
			}
		}
		
		
		
		
		
		dis.close();
		dos.close();
		s.close();
		server.close();
	}
}