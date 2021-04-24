
package javatours;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Adminlogin extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4;
    JTextField t1, t2;
    JButton b1, b2;

    Adminlogin(){
        super("Admin Login");
           setBounds(500, 240, 650, 300);
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);

    l1 = new JLabel(" - HI ADMIN ! -");
    l1.setBounds(230, 10, 250, 25);
    l1.setFont(new Font("Broadway", Font.BOLD, 20));
    add(l1);

   l2 = new JLabel("Login to access Your Data.");
    l2.setBounds(200, 50, 250, 25);
    l2.setFont(new Font("Botang", Font.BOLD, 17));
    l2.setForeground(Color.BLUE);
    add(l2);

   l3 = new JLabel("Admin name"); //username label created
        l3.setBounds(90, 100, 120, 25);
        l3.setFont(new Font("SAN_SERIF", Font.BOLD, 15));   //changing labels font,style and size
        add(l3);     //adding label on the right panel


        t1 = new JTextField();   //adding textfield for name
        t1.setBounds(250, 100, 250, 25);
        add(t1);

         l4 = new JLabel("Password"); //password label created
        l4.setBounds(90, 140, 120, 25);
        l4.setFont(new Font("SAN_SERIF", Font.BOLD, 15));   //changing labels font,style and size
        add(l4);     //adding label on the right panel


        t2 = new JPasswordField();   //adding passwordfield for password
        t2.setBounds(250, 140, 250, 25);
        add(t2);

         b1 = new JButton("LOGIN");
    b1.setBounds(180, 210, 100, 30);
    b1.setBackground(Color.BLUE);
    b1.setFont(new Font("Tahoma", Font.BOLD, 15));
    b1.setForeground(Color.WHITE);
   b1.addActionListener(this);
    add(b1);

   b2 = new JButton("BACK");
    b2.setBounds(330, 210, 100, 30);
    b2.setBackground(Color.BLUE);
    b2.setFont(new Font("Tahoma", Font.BOLD, 15));
    b2.setForeground(Color.WHITE);
    b2.addActionListener(this);
    add(b2);

    }

     public void  actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String s = t1.getText();
            String p = t2.getText();
            if(s.equals("Sakshi"))
            {
                if(p.equals("Hello")){
            this.setVisible(false);
           new AdminDashboard().setVisible(true);
        }
            } else{JOptionPane.showMessageDialog(null,  "INVALID LOGIN");
                t1.setText("");
                t2.setText("");}

        if(ae.getSource() == b2){
            this.setVisible(false);
            new Whoareyou().setVisible(true);
        }
        }
 }
public static void main(String[] args){
new Adminlogin().setVisible(true);
}
}
