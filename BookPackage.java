package javatours;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class BookPackage extends JFrame implements ActionListener {
    Choice c1;
    JLabel l11, l12, l13, l14, l15;
    JTextField t1;
    JButton b1, b2, b3;
    BookPackage(String username){
    setBounds(400, 180, 850, 400);
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);


    ImageIcon  i1 = new ImageIcon(ClassLoader.getSystemResource("javatours/icons/bookpackage.jpg"));
    Image i2 = i1.getImage().getScaledInstance(350, 270, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel l16 = new JLabel(i3);
    l16.setBounds(470, 40, 350, 270);
    add(l16);

    JLabel l1 = new JLabel("BOOK PACKAGE");
    l1.setBounds(260, 5, 360, 25);
    l1.setFont(new Font("Broadway", Font.BOLD, 25));
    l1.setForeground(new Color(230, 190, 250));
    add(l1);

     JLabel l2 = new JLabel("Username");
    l2.setBounds(40, 40, 200, 25);
    l2.setFont(new Font("Tahoma", Font.BOLD, 15));
    l2.setForeground(Color.BLACK);
    add(l2);
    
    l11 = new JLabel();
    l11.setBounds(260, 40, 200, 25);
    l11.setFont(new Font("Tahoma", Font.BOLD, 15));
    l11.setForeground(Color.BLACK);
    add(l11);

     JLabel l3 = new JLabel("Select Package");
    l3.setBounds(40, 80, 200, 25);
    l3.setFont(new Font("Tahoma", Font.BOLD, 15));
    l3.setForeground(Color.BLACK);
    add(l3);

      c1 = new Choice();
     c1.add("GOLD PACKAGE");
     c1.add("SILVER PACKAGE");
     c1.add("BRONZE PACKAGE");
    c1.setBounds(260, 80, 200, 25);
    c1.setForeground(Color.BLACK);
    add(c1);


 JLabel l4 = new JLabel("Total Persons");
    l4.setBounds(40, 120, 200, 25);
    l4.setFont(new Font("Tahoma", Font.BOLD, 15));
    l4.setForeground(Color.BLACK);
    add(l4);

    t1 = new JTextField();
    t1.setBounds(260, 120, 200, 25);
    add(t1);

     JLabel l5 = new JLabel("ID ");
    l5.setBounds(40, 160, 200, 25);
    l5.setFont(new Font("Tahoma", Font.BOLD, 15));
    l5.setForeground(Color.BLACK);
    add(l5);

    l12 = new JLabel();
    l12.setBounds(260, 160, 200, 25);
    l12.setFont(new Font("Tahoma", Font.BOLD, 15));
    l12.setForeground(Color.BLACK);
    add(l12);
    
    JLabel l6 = new JLabel("ID number");
    l6.setBounds(40, 200, 200, 25);
    l6.setFont(new Font("Tahoma", Font.BOLD, 15));
    l6.setForeground(Color.BLACK);
    add(l6);

    l13 = new JLabel();
    l13.setBounds(260, 200, 200, 25);
    l13.setFont(new Font("Tahoma", Font.BOLD, 15));
    l13.setForeground(Color.BLACK);
    add(l13);

     JLabel l7 = new JLabel("Phone");
    l7.setBounds(40, 240, 200, 25);
    l7.setFont(new Font("Tahoma", Font.BOLD, 15));
    l7.setForeground(Color.BLACK);
    add(l7);

    l14 = new JLabel();
    l14.setBounds(260, 240, 200, 25);
    l14.setFont(new Font("Tahoma", Font.BOLD, 15));
    l14.setForeground(Color.BLACK);
    add(l14);

     JLabel l8 = new JLabel("Total Price");
    l8.setBounds(40, 280, 200, 25);
    l8.setFont(new Font("Tahoma", Font.BOLD, 15));
    l8.setForeground(Color.BLACK);
    add(l8);

    l15 = new JLabel();
    l15.setBounds(260, 280, 200, 25);
    l15.setFont(new Font("Tahoma", Font.BOLD, 15));
    l15.setForeground(Color.BLUE);
    add(l15);
    
    try{
       Conn c = new Conn();
       ResultSet rs = c.s.executeQuery("Select * from customerdet where username = '"+username+"'");
       while(rs.next()){
           l11.setText(rs.getString("username"));
           l12.setText(rs.getString("id"));
           l13.setText(rs.getString("number"));
           l14.setText(rs.getString("phone"));
           
           
           
       }
    }catch(Exception e){}

    b1 = new JButton("CHECK PRICE");
    b1.setBounds(70, 320, 150, 25);
   b1.setFont(new Font("Tahoma", Font.BOLD, 15));
    b1.setBackground(new Color(230, 190, 250));
    b1.setForeground(Color.WHITE);
    b1.addActionListener(this);
    add(b1);

     b2 = new JButton("BOOK PACKAGE");
    b2.setBounds(260, 320, 200, 25);
   b2.setFont(new Font("Tahoma", Font.BOLD, 15));
    b2.setBackground(new Color(230, 190, 250));
    b2.setForeground(Color.WHITE);
    b2.addActionListener(this);
    add(b2);
    
     b3 = new JButton("BACK");
    b3.setBounds(500, 320, 150, 25);
   b3.setFont(new Font("Tahoma", Font.BOLD, 15));
    b3.setBackground(new Color(230, 190, 250));
    b3.setForeground(Color.WHITE);
    b3.addActionListener(this);
    add(b3);
}
    public void actionPerformed(ActionEvent ae){
     if(ae.getSource() == b1){
      String p = c1.getSelectedItem();
      int cost = 0;
      if(p.equals("GOLD PACKAGE")){
          cost = cost+12000;
      }else if(p.equals("SILVER PACKAGE")){
          cost = cost+24000;
      }else if(p.equals("BRONZE PACKAGE")){
          cost = cost+32000;
      }
    int persons = Integer.parseInt(t1.getText());                        //parse int for converting string of GetText into int for calculations
    cost *= persons;
    l15.setText("Rs" +cost);
     }
     else if(ae.getSource() == b2){
    try{

    Conn c = new Conn();
    c.s.executeUpdate("insert into bookPackage values('"+l11.getText()+"','"+c1.getSelectedItem()+"','"+t1.getText()+"','"+l12.getText()+"','"+l13.getText()+"','"+l14.getText()+"','"+l15.getText()+"')");
    JOptionPane.showMessageDialog(null,"Package Booked Successfully");
    this.setVisible(false);
    
    }catch(Exception e){}
                                  }
else if(ae.getSource() == b3){
this.setVisible(false);

     }}
 public static void main(String[] args){
     new BookPackage("").setVisible(true);
 }
}
