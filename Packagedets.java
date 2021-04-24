package javatours;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Packagedets extends JFrame implements ActionListener {
    JTable t1;
    JButton b1;
    String x[] = {"Username","Package","No of people","ID","ID Number","Phone","Price"};
    String y[][] = new String[30][9];
    int i = 0, j=0;

Packagedets(){
    super("Package Details");
     setBounds(400, 130, 750, 500);

    try{
        Conn c1 = new Conn();
        String s1 = "Select * from bookpackage;";
        ResultSet rs = c1.s.executeQuery(s1);
        while(rs.next()){
            y[i][j++] = rs.getString("username");
            y[i][j++] = rs.getString("package");
            y[i][j++] = rs.getString("persons");
            y[i][j++] = rs.getString("id");
            y[i][j++] = rs.getString("number");
            y[i][j++] = rs.getString("country");
            y[i][j++] = rs.getString("phone");
            y[i][j++] = rs.getString("price");
            i++;
            j=0;
             }
        t1 = new JTable(y,x);

    }catch(Exception e){}

  b1 = new JButton("Print");
  add(b1,"South");
  JScrollPane sp = new JScrollPane(t1);
  add(sp);
  b1.addActionListener(this);
}
public void  actionPerformed(ActionEvent ae){
    try{
        t1.print();
    }catch(Exception e){}
         }
public static void main(String[] args){
new Packagedets().setVisible(true);
}
}

