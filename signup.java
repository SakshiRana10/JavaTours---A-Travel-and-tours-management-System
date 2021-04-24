package javatours;
import javax.swing.*;                    //JFrame class is in swing package
import java.awt.*;                      //color class is in awt package
import java.awt.event.*;
public class signup extends JFrame implements ActionListener{        //setvisible is in Jframe class
 
    JButton b1, b2;
    JTextField t1, t2, t3, t4,t6,t7;
    Choice c1, c2;

    signup(){
    setBounds(300, 200, 800, 450);       //frame created
    getContentPane().setBackground(Color.WHITE);     //getcontentpane targets the frame to set bg color white
    setLayout(null);
    
    JPanel p1 = new JPanel();         //left lavender division created
    p1.setBackground(new Color(230, 190, 250));
    p1.setBounds(0, 0, 500, 450);
    p1.setLayout(null);
    add(p1);            //adding it on the frame

    JLabel l1 = new JLabel("USERNAME");
    l1.setFont(new Font("Tahoma", Font.BOLD, 12));
    l1.setBounds(50, 20, 125, 25);
    p1.add(l1);
    
    t1 = new JTextField();
    t1.setBounds(230, 20, 200, 25);
    t1.setBorder(BorderFactory.createEmptyBorder());      //removing default border of the textfield
    p1.add(t1);



     JLabel l2 = new JLabel("NAME");
    l2.setFont(new Font("Tahoma", Font.BOLD, 12));
    l2.setBounds(50, 60, 125, 25);
    p1.add(l2);

    t2 = new JTextField();
    t2.setBounds(230, 60, 200, 25);
    t2.setBorder(BorderFactory.createEmptyBorder());     
    p1.add(t2);


     JLabel l3 = new JLabel("PASSWORD");
    l3.setFont(new Font("Tahoma", Font.BOLD, 12));
    l3.setBounds(50, 100, 125, 25);
    p1.add(l3);

    t3 = new JPasswordField();
    t3.setBounds(230, 100, 200, 25);
    t3.setBorder(BorderFactory.createEmptyBorder());
    p1.add(t3);

     JLabel l4 = new JLabel("SECURITY QUESTION");
    l4.setFont(new Font("Tahoma", Font.BOLD, 12));
    l4.setBounds(50, 140, 125, 25);
    p1.add(l4);

    c1 = new Choice();        //checkBox created
    c1.add("YOUR FAVOURITE COLOR");
    c1.add("YOUR SCHOOL NAME");
    c1.add("YOUR HOMESTATE");
    c1.add("YOUR LUCKY NUMBER");
    c1.add("YOUR CITY NAME");
    c1.setBounds(230, 140, 200, 25);
    p1.add(c1);


    JLabel l5 = new JLabel("ANSWER");
    l5.setFont(new Font("Tahoma", Font.BOLD, 12));
    l5.setBounds(50, 180, 125, 25);
    p1.add(l5);

    t4 = new JTextField();
    t4.setBounds(230, 180, 200, 25);
    t4.setBorder(BorderFactory.createEmptyBorder());
    p1.add(t4);

         JLabel l7 = new JLabel("Email");
        l7.setBounds(50 ,220 , 150, 25);
        l7.setFont(new Font("Tahoma", Font.BOLD, 12));
        p1.add(l7);

        t6 = new JTextField();
        t6.setBounds(230,220, 200, 25);
        t6.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t6);
      
     ImageIcon  i1 = new ImageIcon(ClassLoader.getSystemResource("javatours/icons/signup.png"));
     JLabel l6 = new JLabel(i1);
     l6.setBounds(550, 70, 200, 200);     //setting bounds of the image
     add(l6);                             //adding image on the panel

        b1 = new JButton ("CREATE");
        b1.setBounds(120, 350, 100, 30);
        b1.setFont(new Font("Tahoma", Font.BOLD, 15));
        b1.setBackground(Color.WHITE);
        b1.setForeground(new Color(230, 190, 250));
        b1.addActionListener(this);
        b1.setBorder(BorderFactory.createEmptyBorder());
        p1.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(240, 350, 100, 30);
        b2.setFont(new Font("Tahoma", Font.BOLD, 15));
        b2.setForeground(new Color(230, 190, 250));
        b2.setBackground(Color.WHITE);
        b2.addActionListener(this);
        b2.setBorder(BorderFactory.createEmptyBorder());
        p1.add(b2);

}
     public void actionPerformed(ActionEvent ae){      //method overriden for using interface action listener
      if(ae.getSource() == b1){
          String username = t1.getText();            //on clicking create button these values will be taken to db
          String name = t2.getText();
          String password = t3.getText();
          String security = c1.getSelectedItem();
          String answer = t4.getText();
          String email = t6.getText();
          try{
              Conn c = new Conn();
               String query = null;
            query = "INSERT INTO account VALUES('"+username+"' , '"+name+"', '"+password+"', '"+security+"', '"+answer+"','"+email+"');";
              c.s.executeUpdate(query);         //step4 in jdbc connection
              JOptionPane.showMessageDialog(null, "Account created");  //popup created
              this.setVisible(false);    //on OK this popup closes
              new login().setVisible(true);    //returned to login page
              }
          catch(Exception e){
          e.printStackTrace();
          }
      }else if(ae.getSource() == b2){
          new login().setVisible(true);
          this.setVisible(false);        //after going back to login signupS disappears

      }
    }
    
    public static void main(String[] args){
    new signup().setVisible(true);


}
}
