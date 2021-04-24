package javatours;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;      //result set class is here


public class ForgotPassword extends JFrame implements ActionListener{
    JTextField t1, t2, t3, t4, t5;
    JButton b1, b2, b3;
    ForgotPassword(){
        setBounds(300, 180, 800, 380);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("javatours/icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l6 = new JLabel(i3);
        l6.setBounds(560, 60, 200, 200);
        add(l6);


        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBounds(30, 30, 500, 300);
        add(p);

        JLabel l1 = new JLabel("Username");
        l1.setBounds(30 ,20 , 150, 25);
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        p.add(l1);

        t1 = new JTextField();
        t1.setBounds(200,20, 150, 25);
        t1.setBorder(BorderFactory.createEmptyBorder());
        p.add(t1);



        b1= new JButton("Search");
        b1.setBackground(Color.GRAY);
        b1.setForeground(Color.WHITE);
        b1.setBounds(360, 20, 120, 25);
        b1.addActionListener(this);
        p.add(b1);

        JLabel l2 = new JLabel("Name");
        l2.setBounds(30 ,60 , 150, 25);
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        p.add(l2);

        t2 = new JTextField();
        t2.setBounds(200,60, 150, 25);
        t2.setBorder(BorderFactory.createEmptyBorder());
        p.add(t2);

         JLabel l3 = new JLabel("Security Question");
        l3.setBounds(30 ,100 , 150, 25);
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        p.add(l3);

        t3 = new JTextField();
        t3.setBounds(200,100, 250, 25);
        t3.setBorder(BorderFactory.createEmptyBorder());
        p.add(t3);
        
        JLabel l4 = new JLabel("Answer");
        l4.setBounds(30 ,140 , 150, 25);
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        p.add(l4);





        b2= new JButton("Retrieve");
        b2.setBackground(Color.GRAY);
        b2.setForeground(Color.WHITE);
        b2.setBounds(360, 140, 120, 25);
        b2.addActionListener(this);
        p.add(b2);


        t4 = new JTextField();
        t4.setBounds(200,140, 150, 25);
        t4.setBorder(BorderFactory.createEmptyBorder());
        p.add(t4);

        JLabel l5 = new JLabel("Password");
        l5.setBounds(30 ,180 , 150, 25);
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        p.add(l5);

        t5 = new JTextField();
        t5.setBounds(200,180, 150, 25);
        t5.setBorder(BorderFactory.createEmptyBorder());
        p.add(t5);


           b3= new JButton("Back");
        b3.setBackground(Color.GRAY);
        b3.setForeground(Color.WHITE);
        b3.setBounds(150, 230, 120, 25);
        b3.addActionListener(this);
        p.add(b3);

    }
    public void actionPerformed(ActionEvent ae){
        Conn c = new Conn();
        if(ae.getSource() == b1){
            try{
               String sql = "select * from account where username = '"+t1.getText()+"'";
               ResultSet rs =  c.s.executeQuery(sql);
               while(rs.next()){                          //for column to column jump in account table
                 t2.setText(rs.getString("name"));
                 t3.setText(rs.getString("security"));
               }
            }catch(Exception e){}
        }else if(ae.getSource() == b2){
           try{
               String sql = "select * from account where answer = '"+t4.getText()+"' AND username = '"+t1.getText()+"'" ;
               ResultSet rs =  c.s.executeQuery(sql);
               while(rs.next()){
                  t5.setText(rs.getString("password"));
               }
            }catch(Exception e){}
        }else if(ae.getSource() == b3){
            this.setVisible(false);
            new login().setVisible(true);
        }
    }
public static void main(String [] args){
    new ForgotPassword().setVisible(true);
}
}
