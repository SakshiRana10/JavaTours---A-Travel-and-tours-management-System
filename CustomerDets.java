
package javatours;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class CustomerDets extends JFrame implements ActionListener {
    JTable t1;
    JButton b1;
    String x[] = {"Username","ID","Number","Name","Gender","Country","Address","Phone","Email"};
    String y[][] = new String[30][9];
    int i = 0, j=0;

CustomerDets(){
    super("Customer Details");
     setBounds(400, 130, 750, 500);
    
    try{
        Conn c1 = new Conn();
        String s1 = "Select * from customerdet;";
        ResultSet rs = c1.s.executeQuery(s1);
        while(rs.next()){
            y[i][j++] = rs.getString("username");
            y[i][j++] = rs.getString("id");
            y[i][j++] = rs.getString("number");
            y[i][j++] = rs.getString("name");
            y[i][j++] = rs.getString("gender");
            y[i][j++] = rs.getString("country");
            y[i][j++] = rs.getString("address");
            y[i][j++] = rs.getString("phone");
            y[i][j++] = rs.getString("email");
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
new CustomerDets().setVisible(true);
}
}
