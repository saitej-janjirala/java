package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main2{
    public static void main(String[] args) {
        new Code();
    }
}
class Code implements ActionListener {
    boolean select[][],x[][],o[][];
    int i,j,n,undotop;
    JButton playagain,button[][],undo;
    JFrame frame;
    JLabel text;
    int undoarray[][];
    boolean first,second,undo1,undo2;
    JPanel panel;
    Font myfont;
    Code(){
        n=0;
        i=0;
        j=0;
        undo1=false;
        undo2=false;
        undotop=-1;
        undoarray=new int[9][2];
        first=true;
        second=false;
        myfont=new Font("",Font.BOLD,20);
        select=new boolean[3][3];
        x=new boolean[3][3];
        o=new boolean[3][3];
        playagain=new JButton("play again");
        undo=new JButton("UNDO");
        undo.setFont(myfont);
        undo.setBackground(Color.CYAN);
        playagain.setFont(myfont);
        button=new JButton[3][3];
        frame=new JFrame("TIC TAC TOE");
        text=new JLabel("FIRST PLAYERS CHOICE");
        text.setFont(myfont);
        panel=new JPanel();
        panel.setLayout(new GridLayout(3,3,0,0));
        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                x[i][j]=false;
                o[i][j]=false;
                select[i][j]=false;
                button[i][j]=new JButton("");
                button[i][j].setFont(new Font("",Font.BOLD,40));
                panel.add(button[i][j]);
                button[i][j].setBackground(Color.CYAN);
                button[i][j].addActionListener(this);
            }
        }
        for(i=0;i<9;i++){
            undoarray[i][0]=30;
            undoarray[i][1]=40;
        }
        undo.addActionListener(this);
        playagain.setBackground(Color.CYAN);
        playagain.addActionListener(this);
        frame.setSize(600,600);
        frame.setLayout(null);
        text.setBounds(50,50,300,50);
        panel.setBounds(50,120,300,300);
        undo.setBounds(400,150,150,70);
        playagain.setBounds(400,250,150,70);
        playagain.setVisible(false);
        frame.setVisible(true);
        frame.add(text);
        frame.add(undo);
        frame.add(playagain);
        frame.add(panel);
        panel.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                if(e.getSource()==button[i][j]){
                    if(!select[i][j]){
                            if(first){
                                button[i][j].setText("X");
                                select[i][j]=true;
                                x[i][j]=true;
                                n++;
                                first=false;
                                second=true;
                                undotop++;
                                undoarray[undotop][0]=i;
                                undoarray[undotop][1]=j;
                                text.setText("SECOND PLAYERS CHOICE");
                                break;
                            }
                            if(second){
                                button[i][j].setText("O");
                                select[i][j]=true;
                                o[i][j]=true;
                                n++;
                                undotop++;
                                undoarray[undotop][0]=i;
                                undoarray[undotop][1]=j;
                                second=false;
                                first=true;
                                text.setText("FIRST PLAYERS CHOICE");
                                break;
                            }
                    }
                }
            }
        }
        if(n>4){
                for(i=0;i<3;i++){
                    if(n!=9) {
                        if ((x[i][0] & x[i][1] & x[i][2]) || (x[0][i] & x[1][i] & x[2][i]) || (x[0][0] & x[1][1] & x[2][2]) || (x[0][2] & x[1][1] & x[2][0])) {
			    undo.setVisible(false);
                            text.setText("###FIRST PLAYER WON###");
                            reset();
                            playagain.setVisible(true);
                        } else if ((o[i][0] & o[i][1] & o[i][2]) || (o[0][i] & o[1][i] & o[2][i]) || (o[0][0] & o[1][1] & o[2][2]) || (o[0][2] & o[1][1] & o[2][0])) {
				undo.setVisible(false);
                            text.setText("###SECOND PLAYER WON###");
                            reset();
                            playagain.setVisible(true);
                        }
                    }
                    else{
                        if((x[i][0]&x[i][1]&x[i][2])||(x[0][i]&x[1][i]&x[2][i])||(x[0][0]&x[1][1]&x[2][2])||(x[0][2]&x[1][1]&x[2][0])){
				undo.setVisible(false);
                            text.setText("###FIRST PLAYER WON###");
                            playagain.setVisible(true);
                        }
                       else if((o[i][0]&o[i][1]&o[i][2])||(o[0][i]&o[1][i]&o[2][i])||(o[0][0]&o[1][1]&o[2][2])||(o[0][2]&o[1][1]&o[2][0])){
                            text.setText("###SECOND PLAYER OWN###");
				undo.setVisible(false);
                            playagain.setVisible(true);
                        }
                       else{
				undo.setVisible(false);
                           text.setText("###THE MATCH IS DRAW###");
                            playagain.setVisible(true);
                        }
                    }
                }
        }
        if(e.getSource()==playagain){
           for(i=0;i<3;i++) {
               for (j = 0; j < 3; j++) {

                   button[i][j].setText("");
                   select[i][j] = false;
                   x[i][j] = false;
                   o[i][j] = false;
               }
           }   
           n=0;
           first=true;
           second=false;
           text.setVisible(true);
           text.setText("FIRST PLAYERS CHOICE");
           panel.setVisible(true);
           undo.setVisible(true);
           for(i=0;i<9;i++){
               undoarray[i][0]=30;
               undoarray[i][1]=40;
           }
           undotop=-1;
        }
        if(e.getSource()==undo){
            if(undotop>=0) {
                if(second){
                    first=true;
                    second=false;
                    text.setText("FIRST PLAYERS CHOICE");
                }
                else if(first){
                    first=false;
                    second=true;
                    text.setText("SECOND PLAYERS CHOICE");
                }
                button[undoarray[undotop][0]][undoarray[undotop][1]].setText("");
                select[undoarray[undotop][0]][undoarray[undotop][1]]=false;
                n--;
                undotop--;
            }
        }
    }
    void reset(){
        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                select[i][j]=true;
            }
        }
    }
}

