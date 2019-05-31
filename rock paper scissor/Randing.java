import java.util.*;
class Randing 
{
	String a="rock",b="paper",c="scissor";
	Random x=new Random();
	Scanner S=new Scanner(System.in);
	int d,n=x.nextInt(3)+1;
	
	Randing(String start)
	{
		System.out.println(start);
		System.out.println("choose your option");
		System.out.println("1.rock 2.paper 3.scissor 4.exit");
		d=S.nextInt();
		switch(d)
		{
			case 1: System.out.println("you: rock");
				break;
			case 2: System.out.println("you: paper");
				break;
			case 3: System.out.println("you: scissor");
				break;
		}
	}
		
	public static void main(String args[])
	{
		
		Randing r=new Randing("start the game");
		r.gamestart();	
		
	}
	int gamestart()
	{
		while(d==n)
		{
			System.out.println(" cpu:" +this.setname());
			System.out.println("the match is draw ");
			break;
		}
	
		while(d!=n)
		{
		if(((d==1)&(n==3))||((d==2)&(n==1))||((d==3)&(n==2)))
		{
			System.out.println(" cpu:" +this.setname());
			System.out.println("you have won the game ");
			break;
		}
		else
		{
			System.out.println(" cpu:" +this.setname());
			System.out.println("you have lost the game");
			break;
		}
		}
		return 0;
		
	}
	String setname()
	{
			String rps="";
			if(n==1)
			{
				rps=a;
			}
			else if(n==2)
			{
				rps=b;
			}
			else if(n==3)
			{
				
				rps=c;
			}
			return rps;
	}
}
		
		
		
		