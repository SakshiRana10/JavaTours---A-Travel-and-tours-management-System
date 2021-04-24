package javatours;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Hoteldets extends JFrame implements ActionListener {
    JTable t1;
    JButton b1;
    String x[] = {"Username","Hotel","No of People","Days","AC","Food","Cost"};
    String y[][] = new String[30][7];
    int i = 0, j=0;

Hoteldets(){
    super("Hotel Details");
     setBounds(400, 130, 750, 500);

    try{
        Conn c1 = new Conn();
        String s1 = "Select * from bookhotel;";
        ResultSet rs = c1.s.executeQuery(s1);
        while(rs.next()){
            y[i][j++] = rs.getString("username");
            y[i][j++] = rs.getString("hotel");
            y[i][j++] = rs.getString("persons");
            y[i][j++] = rs.getString("days");
            y[i][j++] = rs.getString("ac");
            y[i][j++] = rs.getString("food");
            y[i][j++] = rs.getString("cost");
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
new Hoteldets().setVisible(true);
}
}

