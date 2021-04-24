
package javatours;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AdminDashboard extends JFrame implements ActionListener {
    JLabel l1;
    JButton b1, b2 , b3, b4;
AdminDashboard(){
     super("Admin DashBoard");
     setBounds(500, 200, 450, 360);
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
  

    l1 = new JLabel(" - HI SAKSHI ! -");
    l1.setBounds(130, 10, 250, 25);
    l1.setForeground(Color.BLUE);
    l1.setFont(new Font("Broadway", Font.BOLD, 20));
    add(l1);

     b1 = new JButton("See customer Details");
    b1.setBounds(90, 90, 250, 30);
    b1.setBackground(new Color(230, 190, 250));
    b1.setFont(new Font("Tahoma", Font.BOLD, 15));
    b1.setForeground(Color.WHITE);
    b1.addActionListener(this);
    add(b1);

     b3 = new JButton("See Hotels Booked");
    b3.setBounds(90, 140, 250, 30);
    b3.setBackground(Color.BLUE);
    b3.setFont(new Font("Tahoma", Font.BOLD, 15));
    b3.setForeground(Color.WHITE);
    b3.addActionListener(this);
    add(b3);

   b4 = new JButton("See Packages Booked");
    b4.setBounds(90, 190, 250, 30);
    b4.setBackground(new Color(230, 190, 250));
    b4.setFont(new Font("Tahoma", Font.BOLD, 15));
    b4.setForeground(Color.WHITE);
    b4.addActionListener(this);
    add(b4);

     b2 = new JButton("Go to User DashBoard");
    b2.setBounds(90, 240, 250, 30);
    b2.setBackground(Color.BLUE);
    b2.setFont(new Font("Tahoma", Font.BOLD, 15));
    b2.setForeground(Color.WHITE);
    b2.addActionListener(this);
    add(b2);

    }
 public void  actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
           new CustomerDets().setVisible(true);
        }
        if(ae.getSource() == b2){
            new Dashboard("").setVisible(true);
        }
        if(ae.getSource() == b3){
            new Hoteldets().setVisible(true);
         }
        if(ae.getSource() == b4){
            new Packagedets().setVisible(true);
        }

 }
public static void main(String[] args){
new AdminDashboard().setVisible(true);
}
}
