
package javatours;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class BookHotel extends JFrame implements ActionListener{
    Choice c1, c2 , c3;
    JTextField t1,t2;
    JLabel l21 , l25;
    JButton b1, b2, b3;


    BookHotel(String username){
         setBounds(400, 180, 850, 400);
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
 
    JLabel l1 = new JLabel("BOOK HOTEL");
    l1.setBounds(300, 10, 200, 25);
    l1.setFont(new Font("Broadway", Font.BOLD, 25));
    l1.setForeground(new Color(230, 190, 250));
    add(l1);

    JLabel l2 = new JLabel("Username");
    l2.setBounds(30, 50, 200, 25);
    l2.setFont(new Font("Tahoma", Font.BOLD, 15));
    l2.setForeground(Color.BLACK);
    add(l2);

    l21 = new JLabel();
    l21.setBounds(260, 50, 200, 25);
    l21.setFont(new Font("Tahoma", Font.BOLD, 15));
    l21.setForeground(Color.BLUE);
    add(l21);

     JLabel l3 = new JLabel("Select Hotel");
    l3.setBounds(30, 80, 200, 25);
    l3.setFont(new Font("Tahoma", Font.BOLD, 15));
    l3.setForeground(Color.BLACK);
    add(l3);

    c1 = new Choice();
    try{
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("Select * from hotel");
        while(rs.next()){
            c1.add(rs.getString("name"));
        }

    }catch(Exception e){}
    c1.setBounds(260, 80, 200, 25);
    add(c1);

    JLabel l4 = new JLabel("Total Persons");
    l4.setBounds(30, 110, 200, 25);
    l4.setFont(new Font("Tahoma", Font.BOLD, 15));
    l4.setForeground(Color.BLACK);
    add(l4);

     t1 = new JTextField();
     t1.setBounds(260, 110, 200, 25);
     add(t1);

    JLabel l5 = new JLabel("Number of days");
    l5.setBounds(30, 140, 200, 25);
    l5.setFont(new Font("Tahoma", Font.BOLD, 15));
    l5.setForeground(Color.BLACK);
    add(l5);

     t2 = new JTextField();
     t2.setBounds(260, 140, 200, 25);
     add(t2);

      JLabel l6 = new JLabel("A/C or non A/C");
    l6.setBounds(30, 170, 200, 25);
    l6.setFont(new Font("Tahoma", Font.BOLD, 15));
    l6.setForeground(Color.BLACK);
    add(l6);

    c2 = new Choice();
    c2.add("YES");
    c2.add("NO");
    c2.setBounds(260, 170, 200, 25);
    add(c2);

    JLabel l7 = new JLabel("Include Food");
    l7.setBounds(30, 200, 200, 25);
    l7.setFont(new Font("Tahoma", Font.BOLD, 15));
    l7.setForeground(Color.BLACK);
    add(l7);

    c3 = new Choice();
    c3.add("YES");
    c3.add("NO");
    c3.setBounds(260, 200, 200, 25);
    add(c3);


    JLabel l11 = new JLabel("Total Price");
    l11.setBounds(30, 230, 200, 25);
    l11.setFont(new Font("Tahoma", Font.BOLD, 15));
    l11.setForeground(Color.BLACK);
    add(l11);

    l25 = new JLabel();
    l25.setBounds(260, 230, 200, 25);
    l25.setFont(new Font("Tahoma", Font.BOLD, 13));
    l25.setForeground(Color.BLUE);
    add(l25);

     try{
         Conn c = new Conn();
         ResultSet rs=c.s.executeQuery("Select * from customerdet where username = '"+username+"'");
         while(rs.next()){
          l21.setText(rs.getString("username"));
         }
     }catch(Exception e){}

    b1 = new JButton("CHECK PRICE");
    b1.setBounds(140, 310, 150, 30);
    b1.setBackground(new Color(230, 190, 250));
    b1.setFont(new Font("Tahoma", Font.BOLD, 15));
    b1.setForeground(Color.WHITE);
    b1.addActionListener(this);
    add(b1);
    
    b2 = new JButton("BOOK HOTEL");
    b2.setBounds(340, 310, 150, 30);
    b2.setBackground(new Color(230, 190, 250));
    b2.setFont(new Font("Tahoma", Font.BOLD, 15));
    b2.setForeground(Color.WHITE);
    b2.addActionListener(this);
    add(b2);

    b3 = new JButton("BACK");
    b3.setBounds(540, 310, 150, 30);
    b3.setBackground(new Color(230, 190, 250));
    b3.setFont(new Font("Tahoma", Font.BOLD, 15));
    b3.setForeground(Color.WHITE);
    b3.addActionListener(this);
    add(b3);

ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("javatours/icons/book.jpg"));
Image i2 = i1.getImage().getScaledInstance(330, 230, Image.SCALE_DEFAULT);
ImageIcon i3 = new ImageIcon(i2);
JLabel l12 = new JLabel(i3);
l12.setBounds(480, 50, 330, 230);
add(l12);
 }

    public void  actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
try{
    Conn c = new Conn();
    ResultSet rs =c.s.executeQuery("Select * from hotel where name ='"+c1.getSelectedItem()+"'");
    while(rs.next()){
        int cost=Integer.parseInt(rs.getString("cost_per_day"));
        int food=Integer.parseInt(rs.getString("food_charges"));
        int ac=Integer.parseInt(rs.getString("ac_charges"));

        int persons = Integer.parseInt(t1.getText());
         int days = Integer.parseInt(t2.getText());

         String acprice=c2.getSelectedItem();
         String foodprice = c3.getSelectedItem();

         if(persons*days>0){
             int total = 0;
             total += acprice.equals("YES")?ac:0;
             total += foodprice.equals("YES")?food:0;
             total += cost;

             total = total * persons * days;
             l25.setText(""+total);
            }
         else{
             l25.setText("please enter a valid number");} }
             }catch(Exception e){}
        }else if(ae.getSource() == b2){
            try{
             Conn c = new Conn();
           c.s.executeUpdate("insert into bookHotel values('"+l21.getText()+"', '"+c1.getSelectedItem()+"' , '"+t1.getText()+"', '"+t2.getText()+"', '"+c2.getSelectedItem()+"', '"+c3.getSelectedItem()+"','"+l25.getText()+"')");
           JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
           this.setVisible(false);
            }catch(Exception e){}
        }else if(ae.getSource() == b3){
            this.setVisible(false);
        }
    }
public static void main(String[] args){
new BookHotel("").setVisible(true);
}
}
