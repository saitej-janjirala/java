import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fourqueen{

    public static void main(String[] args){
        new Code();
    }
}
class Code implements ActionListener
{
    JFrame frame;
    JPanel panel;
    JButton button[][],playagian;
    JTextField text;
    private int i,j,m,n,o;
    private int howmany;
    private int queens[][];
    private boolean select[][];
    private Font myfont;
    private boolean checked;
    Code()
    {
        o=0;
        checked=false;
        frame=new JFrame("FOUR QUEEN");
        panel=new JPanel();
        frame.setSize(800,800);
        panel.setLayout(new GridLayout(4,4,1,1));
        i=0;j=0;
        select=new boolean[4][4];
        howmany=0;
        queens=new int[4][2];
        button= new JButton[4][4];
        playagian=new JButton("PLAY AGAIN");
        myfont=new Font("",Font.BOLD,20);
        text=new JTextField("");
        playagian.setBackground(Color.CYAN);
        for(i=0;i<4;i++)
        {

                queens[i][0]=30;
                queens[i][1]=40;
        }
        for(i=0;i<4;i++)
        {
            for(j=0;j<4;j++)
            {

                select[i][j]=false;
                button[i][j]=new JButton("");
                button[i][j].setFont(myfont);
                button[i][j].setBackground(Color.CYAN);
                button[i][j].addActionListener(this);
                panel.add(button[i][j]);

            }
        }

        playagian.addActionListener(this);
        text.setBounds(200,10,200,50);
        panel.setBounds(100,70,500,500);
        playagian.setBounds(150,600,170,70);
        frame.add(text);
        frame.add(panel);
        frame.add(playagian);
        panel.setVisible(true);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(i=0;i<4;i++){
            for(j=0;j<4;j++){
                if(e.getSource()==button[i][j]) {
                    if (!select[i][j]) {
                        if (howmany < 4) {
                            if (check(i,j)) {
                                restore();
                                queens[howmany][0] = i;
                                queens[howmany][1] = j;
                                howmany++;
                                button[i][j].setText("Q" + howmany);
                                select[i][j]=true;
                            } else {

                                text.setText("check the sides and diagonals");
                                button[i][j].setBackground(Color.RED);
                            }
                        }

                    }
                }
            }
        }
        if(e.getSource()==playagian){
            new Code();
        }

    }
    void restore(){
        text.setText("");
        for(int i1=0;i1<4;i1++)
        {
            for(int j1=0;j1<4;j1++)
            {

                button[i1][j1].setBackground(Color.CYAN);


            }
        }
    }
    private boolean check(int a1, int a2) {

        for (m = 0; m < 4; m++) {
         if(queens[m][0] == a1 || queens[m][1] == a2 || (queens[m][0]+queens[m][1]==a1+a2)||(queens[m][1]+a1==queens[m][0]+a2))
         {
             System.out.println(queens[m][0]+" "+ queens[m][1]);
             System.out.println(a1+""+a2);
             checked = false;
             break;
         }

         else
         {
                o++;
                System.out.println(queens[m][0]+" else "+queens[m][1]);
                if(o==4){

                    checked = true;
                    o=0;
                }
         }
        }
        o=0;
        return checked;
    }
}
