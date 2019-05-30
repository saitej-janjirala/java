import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main2{

    public static void main(String[] args){
        new Code();
    }
}
class Code implements ActionListener
{
    JFrame frame;
    JPanel panel;
    JButton button[][],playagian,undo;
    JTextField text;
    private int i,j,m,ok;
    private int howmany;
    private int queens[][];
    private int top,undoarray[][];
    private boolean select[][];
    private Font myfont;
    private boolean checked;
    Code()
    {
        ok=0;
        checked=false;
        frame=new JFrame("FOUR QUEEN");
        panel=new JPanel();
        frame.setSize(800,750);
        panel.setLayout(new GridLayout(8,8,1,1));
        i=0;j=0;
        select=new boolean[8][8];
        howmany=0;
        top=-1;
        queens=new int[8][2];
        undoarray=new int[8][2];
        button= new JButton[8][8];
        undo=new JButton("UNDO");
        playagian=new JButton("PLAY AGAIN");
        myfont=new Font("",Font.BOLD,20);
        text=new JTextField("");
        undo.setBackground(Color.CYAN);
        playagian.setBackground(Color.CYAN);
        for(i=0;i<8;i++)
        {

                queens[i][0]=30;
                queens[i][1]=40;
        }
        for(i=0;i<8;i++){
            undoarray[i][0]=89;
            undoarray[i][1]=67;
        }
        for(i=0;i<8;i++)
        {
            for(j=0;j<8;j++)
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
        panel.setBounds(20,70,600,600);
        undo.setBounds(650,200,100,100);
        playagian.setBounds(650,400,130,70);
        frame.add(text);
        frame.add(panel);
        undo.addActionListener(this);
        frame.add(undo);
        undo.setFont(myfont);
        frame.setBackground(Color.GRAY);
        frame.add(playagian);
        panel.setVisible(true);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(i=0;i<8;i++){
            for(j=0;j<8;j++){
                if(e.getSource()==button[i][j]) {
                    if (!select[i][j]) {
                        if (howmany < 8) {
                            if (check(i,j)) {
                                restore();
                                queens[howmany][0] = i;
                                queens[howmany][1] = j;
                                howmany++;
                                button[i][j].setText("Q" + howmany);
                                top++;
                                undoarray[top][0]=i;
                                undoarray[top][1]=j;
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
        if(e.getSource()==undo){
            if(top>=0) {
                button[undoarray[top][0]][undoarray[top][1]].setText("");
                queens[top][0] = 30;
                queens[top][1] = 40;
                undoarray[top][0] = 89;
                undoarray[top][1] = 67;
                top--;
                howmany--;
            }
        }
    }
    void restore(){
        text.setText("");
        for(int i1=0;i1<8;i1++)
        {
            for(int j1=0;j1<8;j1++)
            {

                button[i1][j1].setBackground(Color.CYAN);


            }
        }
    }
    private boolean check(int a1, int a2) {

        for (m = 0; m < 8; m++) {
         if(queens[m][0] == a1 || queens[m][1] == a2 || (queens[m][0]+queens[m][1]==a1+a2)||(queens[m][1]+a1==queens[m][0]+a2))
         {

             checked = false;
             break;
         }

         else
         {
                ok++;

                if(ok==8){

                    checked = true;
                    ok=0;
                }
         }
        }
        ok=0;
        return checked;
    }

}
