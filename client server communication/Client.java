
import java.util.Scanner;
import java.net.*;
import java.io.*;
class Client
{
	public static void main(String args[])throws Exception
	{
		Socket s=new Socket("localhost",1234);
		DataInputStream dis=new DataInputStream(s.getInputStream());
		DataOutputStream dos=new DataOutputStream(s.getOutputStream());
		Scanner S=new Scanner(System.in);
		
		
		while(true)
		{
			String in=dis.readUTF();
			if(in.equals("over"))
			{
				System.out.println("	server:"+in);
				break;
			}
			else
			{
				System.out.println("	server:"+in);
				System.out.println("\n");
			}
				
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
			
		}
		s.close();
		dis.close();
		dos.close();
		
	}
}
	
			