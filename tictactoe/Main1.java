
import java.awt.*;
import java.awt.event.*;
class Tic extends Frame implements ActionListener
{
	Button b[];
	Button bclose,bstart;
	Font myfont;
	TextField t1,t2,t3;
	Panel P=new Panel();
	int a[]=new int[9];
	int x[]=new int[9];
	int o[]=new int[9];
	int n=0;
	boolean first=true,second=false;
	
	Tic()
	{
		
		super("TICTACTOE");
		 myfont=new Font("kjwf",Font.BOLD,35);
		b=new Button[9];
		for(int i=0;i<9;i++)
		{
				a[i]=0;
		}
		for(int j=0;j<9;j++)
		{
			b[j]=new Button("");
			P.add(b[j]);
			b[j].setBackground(Color.red);
			b[j].addActionListener(this);
		}
		
		bclose=new Button("close");
		bstart=new Button("play again");
		t1=new TextField("1st player");
		t2=new TextField("");
		t3=new TextField("");
		t3.setBounds(100,430,200,70);t1.setBounds(60,60,100,30);t2.setBounds(280,60,100,30);
		bstart.setBounds(370,430,70,50);
		bclose.setBounds(320,430,50,50);
		add(t1);
		add(t2);
		P.setLayout(new GridLayout(3,3,1,1));
		P.setBounds(100,100,300,300);
		add(P);
		P.setVisible(true);
		add(t3);
		add(bclose);
		add(bstart);
		setLayout(null);
		setSize(600,600);
		setVisible(true);
		setBackground(Color.cyan);
		bclose.addActionListener(this);
		bstart.addActionListener(this);
		
		
	}
	public void actionPerformed(ActionEvent e)
	{
		for(int i=0;i<9;i++)
		{
			if(e.getSource()==b[i])
			{	
			
			if(first==true)
			{
				if(a[i]==0)
				{
					
					t1.setText("");
					t2.setText("2nd player");
					x[i]=1;
					b[i].setFont(myfont);
					b[i].setLabel("X");
					first=false;
					second=true;
					a[i]=a[i]+1;
					n=n+1;
				}
			}
			if(second==true)
			{
				if(a[i]==0)
				{
					t2.setText("");
					t1.setText("1st player");
					o[i]=1;
					b[i].setFont(myfont);
					b[i].setLabel("O");
					second=false;
					first=true;
					a[i]=a[i]+1;
					n=n+1;
				}
			}
			}
		}	
		if(e.getSource()==bclose)
		{
			System.exit(0);
		}
		if(e.getSource()==bstart)
		{
			for(int i=0;i<9;i++)
			{
				a[i]=0;
				x[i]=0;
				o[i]=0;
			}
			n=0;
			b[0].setLabel("");b[1].setLabel("");b[2].setLabel("");b[3].setLabel("");b[4].setLabel("");
			b[5].setLabel("");b[6].setLabel("");b[7].setLabel("");b[8].setLabel("");
			first=true;second=false;
			t1.setText("1st player");
			t2.setText("");
			t3.setText("");
		
		}
		if(n>4)
		{
			

			if(((x[0]&x[1]&x[2])==1||(x[3]&x[4]&x[5])==1||(x[6]&x[7]&x[8])==1||(x[0]&x[3]&x[6])==1||(x[1]&x[4]&x[7])==1||(x[2]&x[5]&x[8])==1||(x[0]&x[4]&x[8])==1||(x[2]&x[4]&x[6])==1))
			{
				t3.setText("player 1 won the game");
				t1.setText("");
				t2.setText("");n=0;
				for(int i=0;i<9;i++)
				{
					a[i]=2;
				}	
			}
			else if(((o[0]&o[1]&o[2])==1||(o[3]&o[4]&o[5])==1||(o[6]&o[7]&o[8])==1||(o[0]&o[3]&o[6])==1||(o[1]&o[4]&o[7])==1||(o[2]&o[5]&o[8])==1||(o[0]&o[4]&o[8])==1||(o[2]&o[4]&o[6])==1))
			{
				t3.setText("player 2 won the game");
				t1.setText("");
				t2.setText("");n=0;
				for(int i=0;i<9;i++)
				{
					a[i]=2;
				}
			}
			if(n==9)
			{
				if(((x[0]&x[1]&x[2])==1||(x[3]&x[4]&x[5])==1||(x[6]&x[7]&x[8])==1||(x[0]&x[3]&x[6])==1||(x[1]&x[4]&x[7])==1||(x[2]&x[5]&x[8])==1||(x[0]&x[4]&x[8])==1||(x[2]&x[4]&x[6])==1))
				{
					t3.setText("player 1 won the game");
					t1.setText("");
					t2.setText("");n=0;
					for(int i=0;i<9;i++)
					{
						a[i]=2;
					}				
				}
				else if(((o[0]&o[1]&o[2])==1||(o[3]&o[4]&o[5])==1||(o[6]&o[7]&o[8])==1||(o[0]&o[3]&o[6])==1||(o[1]&o[4]&o[7])==1||(o[2]&o[5]&o[8])==1||(o[0]&o[4]&o[8])==1||(o[2]&o[4]&o[6])==1))
				{
					t3.setText("player 2 won the game");
					t1.setText("");
					t2.setText("");n=0;
						for(int i=0;i<9;i++)
						{
							a[i]=2;
						}	
				}
				else
				{
					t1.setText("");
					t2.setText("");n=0;
					t3.setText("the match is draw");
						for(int i=0;i<9;i++)
						{
							a[i]=2;
						}
				}
			}
		}	
	}	
}
class Main1
{
	public static void main(String args[])
	{
		new Tic();
	}
}

		
		