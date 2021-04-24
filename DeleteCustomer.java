
package javatours;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class DeleteCustomer extends JFrame implements ActionListener{
    JButton b1,b2;
    String username;
   DeleteCustomer(String user){
       this.username = user;
    setBounds(400, 150, 750, 510);
    setLayout(null);
    getContentPane().setBackground(Color.WHITE);

    JLabel heading = new JLabel(" --- DELETE CUSTOMER DETAILS --- ");
    heading.setBounds(200, 5, 390, 25);
    heading.setFont(new Font("Broadway", Font.BOLD, 18));
    heading.setForeground(new Color(230, 190, 250));
    add(heading);
      JLabel l1 = new JLabel("Username :");
        l1.setBounds(20, 30, 200, 25);
        l1.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l1);

       JLabel l11 = new JLabel();
        l11.setBounds(240, 30, 200, 25);
        l11.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l11);

        JLabel l2 = new JLabel("ID :");
        l2.setBounds(20, 70, 200, 25);
        l2.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l2);

       JLabel l12 = new JLabel();
        l12.setBounds(240, 70, 200, 25);
        l12.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l12);


        JLabel l3 = new JLabel("Number :");
        l3.setBounds(20, 110, 200, 25);
        l3.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l3);

       JLabel l13 = new JLabel();
        l13.setBounds(240, 110, 200, 25);
        l13.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l13);

        JLabel l4 = new JLabel("Name :");
        l4.setBounds(20, 150, 200, 25);
        l4.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l4);

       JLabel l14 = new JLabel();
        l14.setBounds(240, 150, 200, 25);
        l14.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l14);

        JLabel l5 = new JLabel("Gender :");
        l5.setBounds(20, 190, 200, 25);
        l5.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l5);

       JLabel l15 = new JLabel();
        l15.setBounds(240, 190, 200, 25);
        l15.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l15);

        JLabel l6 = new JLabel("Country :");
        l6.setBounds(20, 230, 200, 25);
        l6.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l6);

      JLabel l16 = new JLabel();
        l16.setBounds(240, 230, 200, 25);
        l16.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l16);

        JLabel l7 = new JLabel("Address :");
        l7.setBounds(20, 270, 200, 25);
        l7.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l7);

       JLabel l17 = new JLabel();
        l17.setBounds(240, 270, 200, 25);
        l17.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l17);

        JLabel l8 = new JLabel("Phone :");
        l8.setBounds(20, 310, 200, 25);
        l8.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l8);

       JLabel l18 = new JLabel();
        l18.setBounds(240, 310, 200, 25);
        l18.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l18);

       JLabel l9 = new JLabel("Email :");
        l9.setBounds(20, 350, 200, 25);
        l9.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l9);

       JLabel l19 = new JLabel();
        l19.setBounds(240, 350, 200, 25);
        l19.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l19);


         b1 = new JButton("Delete");
        b1.setBackground(new Color(230, 190, 250));
        b1.setForeground(Color.WHITE);
        b1.setBounds(235, 410, 100, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBackground(new Color(230, 190, 250));
        b2.setForeground(Color.WHITE);
        b2.setBounds(405, 410, 100, 30);
        b2.addActionListener(this);
        add(b2);

       ImageIcon  i1 = new ImageIcon(ClassLoader.getSystemResource("javatours/icons/delete.png"));
       Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel l10 = new JLabel(i3);
       l10.setBounds(380, 80, 300, 300);
       add(l10);



       try{
         Conn c = new Conn();
         ResultSet rs = c.s.executeQuery("Select * from customerdet where username = '"+username+"'");
         while(rs.next()){
             l11.setText(rs.getString("username"));
             l12.setText(rs.getString("id"));
             l13.setText(rs.getString("number"));
             l14.setText(rs.getString("name"));
             l15.setText(rs.getString("gender"));
             l16.setText(rs.getString("country"));
             l17.setText(rs.getString("address"));
             l18.setText(rs.getString("phone"));
             l19.setText(rs.getString("email"));
         }
       }catch(Exception e){}

   }
public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == b1){
     try{
         Conn c = new Conn();
         c.s.executeUpdate("delete from account where username = '"+username+"'");
         c.s.executeUpdate("delete from bookhotel where username = '"+username+"' ");
         c.s.executeUpdate("delete from bookpackage where username = '"+username+"'");
         c.s.executeUpdate("delete from customerdet where username = '"+username+"'");

         JOptionPane.showMessageDialog(null, "Customer details Deleted Succesfully");
         System.exit(0);
     }catch(Exception e){}
    }
    else if(ae.getSource() == b2);{
    this.setVisible(false);
}
}

public static void main(String[] args){
    new DeleteCustomer("").setVisible(true);
}
}
