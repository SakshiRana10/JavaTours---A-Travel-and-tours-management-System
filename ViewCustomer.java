package javatours;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewCustomer  extends JFrame implements ActionListener{
  
    JButton  b2;
ViewCustomer(String username){
    setBounds(400, 170, 900, 500);
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);

    JLabel head = new JLabel("---- VIEW CUSTOMER DETAILS ---");
    head.setBounds(300, 0, 360, 25);
    head.setFont(new Font("Broadway", Font.BOLD, 15));
    head.setForeground(new Color(230, 190, 250));
    add(head);

       JLabel l1 = new JLabel("Username :");
        l1.setBounds(20, 30, 200, 25);
        l1.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l1);

      JLabel l11 = new JLabel("");
        l11.setBounds(240, 30, 200, 25);
        l11.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l11);

        JLabel l2 = new JLabel("ID :");
        l2.setBounds(20, 90, 200, 25);
        l2.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l2);

      JLabel l12 = new JLabel("");
        l12.setBounds(240, 90, 200, 25);
        l12.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l12);

        JLabel l3 = new JLabel("Number :");
        l3.setBounds(20, 150, 200, 25);
        l3.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l3);

      JLabel l13 = new JLabel("");
        l13.setBounds(240, 150, 200, 25);
        l13.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l13);

        JLabel l4 = new JLabel("Name :");
        l4.setBounds(20, 210, 200, 25);
        l4.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l4);

      JLabel l14 = new JLabel("");
        l14.setBounds(240, 210, 200, 25);
        l14.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l14);

        JLabel l5 = new JLabel("Gender :");
        l5.setBounds(20, 270, 200, 25);
        l5.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l5);

       JLabel l15 = new JLabel("");
        l15.setBounds(240, 270, 200, 25);
        l15.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l15);

        JLabel l6 = new JLabel("Country :");
        l6.setBounds(460, 30, 200, 25);
        l6.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l6);

      JLabel l16 = new JLabel("");
        l16.setBounds(680, 30, 200, 25);
        l16.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l16);

         JLabel l7 = new JLabel("Address :");
        l7.setBounds(460, 90, 200, 25);
        l7.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l7);

       JLabel l17 = new JLabel("");
        l17.setBounds(680, 90, 200, 25);
        l17.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l17);

       JLabel l8 = new JLabel("Phone :");
        l8.setBounds(460, 150, 200, 25);
        l8.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l8);

       JLabel l18 = new JLabel("");
        l18.setBounds(680, 150, 200, 25);
        l18.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l18);

       JLabel l9 = new JLabel("Email :");
        l9.setBounds(460, 210, 200, 25);
        l9.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l9);

      JLabel l19 = new JLabel("");
        l19.setBounds(680, 210, 200, 25);
        l19.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l19);


         b2 = new JButton("Back");
       b2.setBackground(new Color(230, 190, 250));
        b2.setForeground(Color.WHITE);
        b2.setBounds(385, 270, 100, 30);
        b2.addActionListener(this);
        add(b2);

       ImageIcon  i1 = new ImageIcon(ClassLoader.getSystemResource("javatours/icons/viewall.jpg"));
       Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l10 = new JLabel(i3);
        l10.setBounds(130, 280, 600, 200);
        add(l10);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from Customerdet where username = '"+username+"'");
            while(rs.next()){
                l11.setText(rs.getString("username"));
                l12.setText(rs.getString("id"));
                l13.setText(rs.getString("number"));
                l14.setText(rs.getString("name"));
                l15.setText(rs.getString("gender"));
                l16.setText(rs.getString("Country"));
                l17.setText(rs.getString("Address"));
                l18.setText(rs.getString("Phone"));
                l19.setText(rs.getString("email"));

            }
        }catch(Exception e){}

}
public void actionPerformed(ActionEvent ae){
     if(ae.getSource() == b2);{
    this.setVisible(false);
}
}


public static void main(String[] args){
    new ViewCustomer("").setVisible(true);
}

}
