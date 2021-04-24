package javatours;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewHotel extends JFrame implements ActionListener {
JButton b1;
    public ViewHotel(String username){
         setBounds(400, 180, 850, 400);
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);

     ImageIcon  i1 = new ImageIcon(ClassLoader.getSystemResource("javatours/icons/book.jpg"));
    Image i2 = i1.getImage().getScaledInstance(330, 300, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel l10 = new JLabel(i3);
    l10.setBounds(470, 40, 330, 300);
    add(l10);

    JLabel heading = new JLabel("-- BOOKED HOTEL RECEIPT --");
    heading.setBounds(220, 5, 450, 25);
    heading.setFont(new Font("Broadway", Font.BOLD, 25));
    heading.setForeground(new Color(230, 190, 250));
    add(heading);

     JLabel l1 = new JLabel("Username");
    l1.setBounds(30, 30, 200, 25);
    l1.setFont(new Font("Tahoma", Font.BOLD, 15));
    l1.setForeground(Color.BLACK);
    add(l1);

     JLabel l11 = new JLabel();
    l11.setBounds(160, 30, 200, 25);
    l11.setFont(new Font("Tahoma", Font.BOLD, 15));
    l11.setForeground(Color.BLUE);
    add(l11);

     JLabel l2 = new JLabel("Hotel");
    l2.setBounds(30, 60, 200, 25);
    l2.setFont(new Font("Tahoma", Font.BOLD, 15));
    l2.setForeground(Color.BLACK);
    add(l2);

     JLabel l12 = new JLabel();
    l12.setBounds(160, 60, 200, 25);
    l12.setFont(new Font("Tahoma", Font.BOLD, 15));
    l12.setForeground(Color.BLUE);
    add(l12);

    JLabel l3 = new JLabel("Total Persons");
    l3.setBounds(30, 90, 200, 25);
    l3.setFont(new Font("Tahoma", Font.BOLD, 15));
    l3.setForeground(Color.BLACK);
    add(l3);

     JLabel l13 = new JLabel();
    l13.setBounds(160, 90, 200, 25);
    l13.setFont(new Font("Tahoma", Font.BOLD, 15));
    l13.setForeground(Color.BLUE);
    add(l13);

     JLabel l4 = new JLabel("Total Days");
    l4.setBounds(30, 120, 200, 25);
    l4.setFont(new Font("Tahoma", Font.BOLD, 15));
    l4.setForeground(Color.BLACK);
    add(l4);


     JLabel l14 = new JLabel();
    l14.setBounds(160, 120, 200, 25);
    l14.setFont(new Font("Tahoma", Font.BOLD, 15));
    l14.setForeground(Color.BLUE);
    add(l14);

     JLabel l5 = new JLabel("A/C Included");
    l5.setBounds(30, 150, 200, 25);
    l5.setFont(new Font("Tahoma", Font.BOLD, 15));
    l5.setForeground(Color.BLACK);
    add(l5);


     JLabel l15 = new JLabel();
    l15.setBounds(160, 150, 200, 25);
    l15.setFont(new Font("Tahoma", Font.BOLD, 15));
    l15.setForeground(Color.BLUE);
    add(l15);

     JLabel l6 = new JLabel("Food");
    l6.setBounds(30, 180, 200, 25);
    l6.setFont(new Font("Tahoma", Font.BOLD, 15));
    l6.setForeground(Color.BLACK);
    add(l6);


     JLabel l16 = new JLabel();
    l16.setBounds(160, 180, 200, 25);
    l16.setFont(new Font("Tahoma", Font.BOLD, 15));
    l16.setForeground(Color.BLUE);
    add(l16);

     JLabel l7 = new JLabel("Total Amount");
    l7.setBounds(30, 210, 200, 25);
    l7.setFont(new Font("Tahoma", Font.BOLD, 15));
    l7.setForeground(Color.BLACK);
    add(l7);

    JLabel l17 = new JLabel();
    l17.setBounds(160, 210, 200, 25);
    l17.setFont(new Font("Tahoma", Font.BOLD, 15));
    l17.setForeground(Color.BLUE);
    add(l17);
    try{
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("Select * from bookHotel where username = '"+username+"'");
         while(rs.next()){
         l11.setText(rs.getString(1));                        //1 is count of column from table whose value i want to set
         l12.setText(rs.getString(2));
         l13.setText(rs.getString(3));
         l14.setText(rs.getString(4));
         l15.setText(rs.getString(5));
         l16.setText(rs.getString(6));
         l17.setText(rs.getString(7));
         }
    }catch(Exception e){}
    b1 = new JButton("BACK");
    b1.setBounds(130, 270, 190, 25);
    b1.setFont(new Font("Tahoma", Font.BOLD, 15));
    b1.setBackground(new Color(230, 190, 250));
    b1.setForeground(Color.WHITE);
    b1.addActionListener(this);
    add(b1);
    }
     public void actionPerformed(ActionEvent ae){
         this.setVisible(false);  }
 public static void main(String[] args){
     new ViewHotel("").setVisible(true);
 }
}




