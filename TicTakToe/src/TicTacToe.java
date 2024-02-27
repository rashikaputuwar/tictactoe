import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {
    
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;
    
    TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        
        //setting bgcolor
        textfield.setBackground(new Color(25,25,25));
        //setting text color
        textfield.setForeground(Color.white);
        //setting font
        textfield.setFont(new Font("Int Free",Font.BOLD,75));
        //setting horizontal alignment
        textfield.setHorizontalAlignment(JLabel.CENTER);
        //setting txtfield
        textfield.setText("TicTacToe");
        textfield.setOpaque(true);
        
       title_panel.setLayout(new BorderLayout());
       //set bounds
       title_panel.setBounds(0,0,800,100);
       
       //add grid layout 
       button_panel.setLayout(new GridLayout(3,3));
       //bg color
       button_panel.setBackground(new Color(150,150,150));
       //adding buttons using for loop
       for(int i=0;i<9;i++){
           buttons[i] = new JButton();   //create button
           button_panel.add(buttons[i]);    // add button to our button panel
           buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));       //set font
           buttons[i].setFocusable(false);   //making button unfocusable
           buttons[i].addActionListener(this);  //add actionListener
       }
       
       //adding textfield into title panel 
       title_panel.add(textfield);
       // adding title panel to our frame 
       frame.add(title_panel,BorderLayout.NORTH);
        //add button panel to frame
       frame.add(button_panel);
       
       //calling firstTUrn
       firstTurn();
    }
    @Override
    public void actionPerformed(ActionEvent e){
        
        for(int i=0; i<9; i++){
            if(e.getSource()==buttons[i]){
            if(player1_turn){
                if(buttons[i].getText()==""){
                    buttons[i].setForeground(Color.red);
                    buttons[i].setText("X");
                    player1_turn=false;
                    textfield.setText("O Turn");
                    check();
                }
            }
            else{
                if(buttons[i].getText()==""){
                    buttons[i].setForeground(Color.blue);
                    buttons[i].setText("O");
                    player1_turn=true;
                    textfield.setText("X Turn");
                    check();
                }
            }
        }
    }
        
    }
    public void firstTurn(){
           //to show title for little bit or to delay before assigning turn
        try{
        Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        
        if(random.nextInt(2)==0){
            player1_turn=true;
            textfield.setText("X turn");
        }
        else{
             player1_turn=false;
            textfield.setText("O turn");
        }
        
        
    }
   
    public void check(){
        //  check x wins
        if(
                (buttons[0].getText()=="X") &&
                (buttons[1].getText()=="X")&&
                (buttons[2].getText()=="X")) {
            xWins(0,1,2);
            
        }
        
          if(
                (buttons[3].getText()=="X") &&
                (buttons[4].getText()=="X")&&
                (buttons[5].getText()=="X")) {
            xWins(3,4,5);
            
        }
        
            if(
                (buttons[6].getText()=="X") &&
                (buttons[7].getText()=="X")&&
                (buttons[8].getText()=="X")) {
            xWins(6,7,8);
            
        }
        
              if(
                (buttons[0].getText()=="X") &&
                (buttons[3].getText()=="X")&&
                (buttons[6].getText()=="X")) {
            xWins(0,3,6);
            
        }
        
                if(
                (buttons[1].getText()=="X") &&
                (buttons[4].getText()=="X")&&
                (buttons[7].getText()=="X")) {
            xWins(1,4,7);
            
        }
          if(
                (buttons[2].getText()=="X") &&
                (buttons[5].getText()=="X")&&
                (buttons[8].getText()=="X")) {
            xWins(2,5,8);
            
        }
            if(
                (buttons[0].getText()=="X") &&
                (buttons[4].getText()=="X")&&
                (buttons[8].getText()=="X")) {
            xWins(0,4,8);
            
        }
              if(
                (buttons[2].getText()=="X") &&
                (buttons[4].getText()=="X")&&
                (buttons[6].getText()=="X")) {
            xWins(2,4,6);
            
        }
        
        
        
        //check o wins
        if(
                (buttons[0].getText()=="O") &&
                (buttons[1].getText()=="O")&&
                (buttons[2].getText()=="O")) {
            oWins(0,1,2);
            
        }
        
          if(
                (buttons[3].getText()=="O") &&
                (buttons[4].getText()=="O")&&
                (buttons[5].getText()=="O")) {
            oWins(3,4,5);
            
        }
        
            if(
                (buttons[6].getText()=="O") &&
                (buttons[7].getText()=="O")&&
                (buttons[8].getText()=="O")) {
            oWins(6,7,8);
            
        }
        
              if(
                (buttons[0].getText()=="O") &&
                (buttons[3].getText()=="O")&&
                (buttons[6].getText()=="O")) {
            oWins(0,3,6);
            
        }
        
                if(
                (buttons[1].getText()=="O") &&
                (buttons[4].getText()=="O")&&
                (buttons[7].getText()=="O")) {
            oWins(1,4,7);
            
        }
          if(
                (buttons[2].getText()=="O") &&
                (buttons[5].getText()=="O")&&
                (buttons[8].getText()=="O")) {
            oWins(2,5,8);
            
        }
            if(
                (buttons[0].getText()=="O") &&
                (buttons[4].getText()=="O")&&
                (buttons[8].getText()=="O")) {
            oWins(0,4,8);
            
        }
              if(
                (buttons[2].getText()=="O") &&
                (buttons[4].getText()=="O")&&
                (buttons[6].getText()=="O")) {
            oWins(2,4,6);
            
        }
    }
    
    public void xWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
       // for all 9 buttons  
        for( int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("X Wins");
    }
    
     public void oWins(int a, int b, int c){
         buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
       // for all 9 buttons  
        for( int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("o Wins");
    }
}
