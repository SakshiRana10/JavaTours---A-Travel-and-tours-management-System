package javatours;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener{
String s;
JButton b1;
    About(){
    setBounds(400, 180, 850, 400);
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);

    JLabel l1 = new JLabel("--- JAVATOURS - Travel and tours management system ---");
    l1.setBounds(100, 5, 800, 35);
    l1.setFont(new Font("Broadway", Font.PLAIN, 20));
    l1.setForeground(new Color(230, 190, 250));
    add(l1);
     s = " ~~ The objective of the travel and tourism management system project is to develop" +
             " a system that automates" +
         " the processes and activities of a travel and tourism agency.\n\n" +
         "~~ The purpose is to design a system using" +
         " which all operations related to travelling are done.\n\n " +
         "~~ Users can decide about places they want to visit and make" +
         " bookings online for travel and accommodation.\n\n"+
        " ~~ Javatours is a desktop based application that allows"+
        " users to check various locations & hotels and then book the desired hotel using various options.\n\n"+
       "~~ Nearly Everyone goes on a vacation for this ‘a Tourism management system’ would play a vital"+
       "role in planning the perfect trip.\n\n"+
       "~~ The tourism management system allows the user of the system"+
       "access all the details such as location, events, etc.\n \n"+
       "~~ The main purpose is to help tourism companies to manage customer and hotels etc.\n\n "+
      "_______________________________________________________________________________________________________\n\n\n"+
      "ABOUT THE CREATOR:-\n\n" +
      "My name is Sakshi Rana and i am a First Year Student of MCA in BCIIT(GGSIPU)\n\n" +
      " i Want to learn as much as Possible and work for the society in best possible ways ever.\n\n";
     TextArea t1 =new TextArea(s,10,40,Scrollbar.VERTICAL);
     t1.setEditable(false);
     t1.setBounds(40, 80, 750,200);
     add(t1);
     
     b1 = new JButton("BACK");
     b1.setBounds(350, 300, 100, 30);
      b1.setFont(new Font("Tahoma", Font.BOLD, 15));
     b1.setBackground(new Color(230, 190, 250));
     b1.setForeground(Color.white);
     b1.addActionListener(this);
     add(b1);
    }
     public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == b1){
   this.setVisible(false);
    }}
    
public static void main(String[] args){
    new About().setVisible(true);
}
}
