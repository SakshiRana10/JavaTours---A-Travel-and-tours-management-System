
package javatours;
import javax.swing.*;        //contains Jframe class
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;            //contains action listener interface
import java.sql.*;

public class login extends JFrame implements ActionListener{  //action listener interface is used to connect signup frame with login on the click of button
    JButton b1, b2, b3;
    JTextField t1;
    JPasswordField t2;
     
    login(){
        setSize(800,400);
        setLocation(300,200);

        setLayout(null);    //border layout is default hence null
        getContentPane().setBackground(Color.white);     //to set color white
        JPanel p1 = new JPanel();   //a left divison created
        p1.setBackground(new Color(230, 190, 250));    //setting bgcolor of the panel
        p1.setBounds(0, 0, 400, 400);   //location for division panel
        p1.setLayout(null);
        add(p1);   //adding panel on the frame

        ImageIcon  i1 = new ImageIcon(ClassLoader.getSystemResource("javatours/icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT); //scaling full image on the frame
        ImageIcon i3 = new ImageIcon(i2); //Jlabel doesnt take image class object hence imageicon object created
        JLabel l1 = new JLabel(i3);
        l1.setSize(300, 300);     //setting bounds of the image
        l1.setLocation(50, 50);
        p1.add(l1);   //adding image on the panel

        JPanel p2 = new JPanel();   //right division panel created
        p2.setLayout(null);
        p2.setBounds(400, 30, 350, 300);  //right panel bounds
        add(p2);    //adding panel on the frame
       
        JLabel l2 = new JLabel("Username"); //username label created
        l2.setBounds(20, 20, 120, 25);
        l2.setFont(new Font("SAN_SERIF", Font.BOLD, 15));   //changing labels font,style and size
        p2.add(l2);     //adding label on the right panel


        t1 = new JTextField();   //adding textfield for name
        t1.setBounds(20, 50, 250, 25);
        t1.setBorder(BorderFactory.createEmptyBorder());    //removing border of textfield
        p2.add(t1);

         JLabel l3 = new JLabel("Password"); //password label created
        l3.setBounds(20, 80, 120, 25);
        l3.setFont(new Font("SAN_SERIF", Font.BOLD, 15));   //changing labels font,style and size
        p2.add(l3);     //adding label on the right panel


        t2 = new JPasswordField();   //adding passwordfield for password
        t2.setBounds(20, 110, 250, 25);
        t2.setBorder(BorderFactory.createEmptyBorder());    //removing border of textfield
        p2.add(t2);

      

        b1 = new JButton("LOGIN");
        b1.setBounds(20, 200, 120, 30);
        b1.setBackground(new Color(230, 190, 250));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        p2.add(b1);


         b2 = new JButton("SIGNUP");
        b2.setBounds(150, 200, 120, 30);
        b2.setForeground(new Color(230, 190, 250));
        b2.setBackground(Color.WHITE);
        b2.addActionListener(this);            //go to signup frame when clicked
        p2.add(b2);


        b3 = new JButton("FORGET PASSWORD");
        b3.setBounds(80, 240, 150, 30);
        b3.setForeground(new Color(230, 190, 250));
        b3.setBackground(Color.WHITE);
        b3.setBorder(new LineBorder(new Color(230, 190, 250)));
        b3.addActionListener(this);
        p2.add(b3);

        JLabel l4 = new JLabel("Trouble logging in...");
        l4.setForeground(Color.RED);
        l4.setBounds(100, 280, 200, 20);
        p2.add(l4);


        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){      //method overriden for using interface action listener
      if(ae.getSource() == b1){
          try{
              String username = t1.getText();
              String password = t2.getText();
              String sql = "select * from account where username = '"+username+"' AND password = '"+password+"'";
              Conn c = new Conn();
              ResultSet rs = c.s.executeQuery(sql);
          if(rs.next()){                        //if for checking if entered values are there in DB
              this.setVisible(false);
              new Loading(username).setVisible(true);                    //loading frame if will and this frame will close when values are matched
          }else{
                JOptionPane.showMessageDialog(null,  "INVALID LOGIN");
                t1.setText("");
                t2.setText("");
               }
          }catch(Exception e){}

      }else if(ae.getSource() == b2){
          this.setVisible(false);        //after signup opens login disappears
          new signup().setVisible(true);
          
      }else if(ae.getSource() == b3){
           this.setVisible(false);
           new ForgotPassword().setVisible(true);
      }
    }
public static void main(String[] args){
    new login();
}
}
