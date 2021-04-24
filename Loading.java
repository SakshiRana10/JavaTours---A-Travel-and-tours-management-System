package javatours;

import javax.swing.*;
import java.awt.*;                    //color class

public class Loading extends JFrame implements Runnable{                       //runnable is used for multithreading in Jprogress bar increment
    JProgressBar p;                  //class for progress bar in java
    Thread t;                          //object of runnable interface
    String username;
    public void run(){                               //run is a method of runnable interface to be overridden in order to implement it
        try{
           for(int i = 1; i <= 101; i++){
           int m = p.getMaximum();                       //maximum value of progress bar's object p
           int n = p.getValue();                         // cuurent value of object p
          if(n < m){
              p.setValue(p.getValue() + 1);                //if current value is less than max value then set p's value by adding one in current value
          }else{
               i = 101;
               setVisible(false);
               new Dashboard(username).setVisible(true);
          }
           Thread.sleep(50);                                         //to make the speed of progress bar slow
           }
        }catch(Exception e){}
    }
    Loading(String user){                      //username from login class is catched here
    username = user;
    t = new Thread(this);                          //thread obj declared
    setBounds(400, 200, 600, 400);
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);

    JLabel l1 = new JLabel("JAVATOURS WELCOMES YOU");
    l1.setBounds(75,40,500,40);
    l1.setFont(new Font("Broadway", Font.BOLD, 25));
    l1.setForeground(new Color(230, 190, 250));
    add(l1);


    p = new JProgressBar();
    p.setStringPainted(true);                       //by default iys false, have to make it true to get percentage on progress bar
    p.setBounds(130, 100, 300, 30);
    add(p);

     JLabel l2 = new JLabel("Please wait a minute...");
    l2.setBounds(160,130,500,40);
    l2.setFont(new Font("Broadway", Font.ITALIC, 18));
    l2.setForeground(Color.LIGHT_GRAY);
    add(l2);

     JLabel l3 = new JLabel("---- Welcome " + username + " ---- ");
    l3.setBounds(30,310,500,40);
    l3.setFont(new Font("Broadway", Font.BOLD, 18));
    l3.setForeground(new Color(230, 190, 250));
    add(l3);

    t.start();                                            //thread object started

  }
public static void main(String[] args){
new Loading("").setVisible(true);
}
}
