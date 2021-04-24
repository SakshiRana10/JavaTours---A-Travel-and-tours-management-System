
package javatours;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateCustomer  extends JFrame implements ActionListener{
    JTextField t1, t2, t3 , t4, t5, t6, t7 , t8, t9;
    JComboBox c1;
    JRadioButton r1, r2;
    JButton b1, b2;
UpdateCustomer(String username){
    setBounds(500, 180, 750, 500);
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);

    JLabel l11 = new JLabel("---- UPDATE CUSTOMER DETAILS ---");
    l11.setBounds(200, 0, 360, 25);
    l11.setFont(new Font("Broadway", Font.BOLD, 15));
    l11.setForeground(new Color(230, 190, 250));
    add(l11);

       JLabel l1 = new JLabel("Username :");
        l1.setBounds(20, 30, 200, 25);
        l1.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l1);

       t1 = new JTextField();
       t1.setBounds(240, 30, 200, 25);
       add(t1);

        JLabel l2 = new JLabel("ID :");
        l2.setBounds(20, 70, 200, 25);
        l2.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l2);

       t9 = new JTextField();
       t9.setBounds(240, 70, 200, 25);
       add(t9);

        JLabel l3 = new JLabel("Number :");
        l3.setBounds(20, 110, 200, 25);
        l3.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l3);

       t2 = new JTextField();
       t2.setBounds(240, 110, 200, 25);
       add(t2);

        JLabel l4 = new JLabel("Name :");
        l4.setBounds(20, 150, 200, 25);
        l4.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l4);

       t3 = new JTextField();
       t3.setBounds(240, 150, 200, 25);
       add(t3);

        JLabel l5 = new JLabel("Gender :");
        l5.setBounds(20, 190, 200, 25);
        l5.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l5);

        t8 = new JTextField();
       t8.setBounds(240, 190, 200, 25);
       add(t8);

        JLabel l6 = new JLabel("Country :");
        l6.setBounds(20, 230, 200, 25);
        l6.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l6);

       t4 = new JTextField();
       t4.setBounds(240, 230, 200, 25);
       add(t4);

         JLabel l7 = new JLabel("Address :");
        l7.setBounds(20, 270, 200, 25);
        l7.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l7);

       t5 = new JTextField();
       t5.setBounds(240, 270, 200, 25);
       add(t5);

       JLabel l8 = new JLabel("Phone :");
        l8.setBounds(20, 310, 200, 25);
        l8.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l8);

       t6 = new JTextField();
       t6.setBounds(240, 310, 200, 25);
       add(t6);

       JLabel l9 = new JLabel("Email :");
        l9.setBounds(20, 350, 200, 25);
        l9.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
       add(l9);

       t7 = new JTextField();
       t7.setBounds(240, 350, 200, 25);
       add(t7);



       b1 = new JButton("Update");
       b1.setBackground(new Color(230, 190, 250));
        b1.setForeground(Color.WHITE);
        b1.setBounds(110, 400, 100, 30);
        b1.addActionListener(this);
        add(b1);

         b2 = new JButton("Back");
       b2.setBackground(new Color(230, 190, 250));
        b2.setForeground(Color.WHITE);
        b2.setBounds(260, 400, 100, 30);
        b2.addActionListener(this);
        add(b2);

       ImageIcon  i1 = new ImageIcon(ClassLoader.getSystemResource("javatours/icons/update.png"));
       Image i2 = i1.getImage().getScaledInstance(230, 360, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l10 = new JLabel(i3);
        l10.setBounds(500, 20, 200, 400);
        add(l10);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from Customerdet where username = '"+username+"'");
            while(rs.next()){
                t1.setText(rs.getString("username"));
                t2.setText(rs.getString("number"));
                t3.setText(rs.getString("name"));
                t4.setText(rs.getString("country"));
                t5.setText(rs.getString("address"));
                t6.setText(rs.getString("Phone"));
                t7.setText(rs.getString("email"));
                t8.setText(rs.getString("gender"));
                t9.setText(rs.getString("id"));

            }
        }catch(Exception e){}

}
public void actionPerformed(ActionEvent ae){
     if(ae.getSource() == b1){
    String username = t1.getText();
    String id = t9.getText();                        //c1 will give an object which needs to be typecasted into a string
    String number = t2.getText();
    String name = t3.getText();
    String radio = t8.getText();
    String country = t4.getText();
    String address = t5.getText();
    String phone = t6.getText();
    String email = t7.getText();

    String q = "update customerdet set username = '"+username+"', id = '"+id+"',number = '"+number+"',name = '"+name+"', gender = '"+radio+"',country = '"+country+"',address = '"+address+"',Phone = '"+phone+"',email = '"+email+"'";
    try{
        Conn c = new Conn();
        c.s.executeUpdate(q);

        JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
        this.setVisible(false);
    }catch(Exception e){}

}else if(ae.getSource() == b2);{
    this.setVisible(false);
}
}


public static void main(String[] args){
    new UpdateCustomer("").setVisible(true);
}

}
