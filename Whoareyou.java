
package javatours;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Whoareyou extends JFrame implements ActionListener{
    JButton b1,b2;
Whoareyou(){
    super("Who is this");
    setBounds(580, 240, 450, 250);
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    
     JLabel l1 = new JLabel(" - JAVA TOURS ASKS -");
    l1.setBounds(80, 10, 250, 25);
    l1.setFont(new Font("Broadway", Font.BOLD, 20));
    l1.setForeground(new Color(230, 190, 250));
    add(l1);

    JLabel l2 = new JLabel("Who are you ?");
    l2.setBounds(130, 50, 250, 25);
    l2.setFont(new Font("Broadway", Font.BOLD, 17));
    add(l2);

    b1 = new JButton("USER");
    b1.setBounds(80, 120, 100, 30);
    b1.setBackground(new Color(230, 190, 250));
    b1.setFont(new Font("Tahoma", Font.BOLD, 15));
    b1.setForeground(Color.WHITE);
    b1.addActionListener(this);
    add(b1);

   b2 = new JButton("ADMIN");
    b2.setBounds(260, 120, 100, 30);
    b2.setBackground(new Color(230, 190, 250));
    b2.setFont(new Font("Tahoma", Font.BOLD, 15));
    b2.setForeground(Color.WHITE);
   b2.addActionListener(this);
    add(b2);

}
 public void  actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
          this.setVisible(false);
           new login().setVisible(true);
        }
        if(ae.getSource() == b2){
           this.setVisible(false);
            new Adminlogin().setVisible(true);
        }

 }
public static void main(String[] args){
new Whoareyou().setVisible(true);
}
}
