package javatours;
import javax.swing.*;
import java.awt.*;

public class CheckPackage extends JFrame {
    CheckPackage(){
        setBounds(500,200,700,400);

        String[] package1 ={"GOLD PACKAGE" ,  "~ 6 Days and & 6 Nights ~","~ Airport Assistance ~","~ Half Day City Tour ~","~ Daily Buffet ~","~ Welcome drinks on arrival ~" , "~ Full Day 3 Island Cruise ~" ," ~ English Speaking Guide ~", "BOOK NOW" , "SUMMER SPECIAL " , " Rs 12000/- ", "package1.jpg"};
        String[] package2 ={"SILVER PACKAGE" ,  "~ 5 Days and &  6 Nights ~","~ Toll And Entrance Free Tickets ~","~ Meet And Greet at Airport ~","~ Night Safari ~","~ Welcome drinks on arrival ~" , "~ Full Day 3 Island Cruise ~" ," ~ Cruise with dinner ~", "BOOK NOW" , "AUTUMN SPECIAL " , " Rs 24000/- ", "package2.jpg"};
        String[] package3 ={"BRONZE PACKAGE" ,  "~ 6 Days and & 5 Nights ~","~ Return Airfare ~","~ Free Clubbing ~","~ Horse Riding ~","~ Welcome drinks on arrival ~" , "~ Full Day 1 Island Cruise ~" ," ~ BBQ sepcial ~", "BOOK NOW" , "WINTER SPECIAL " , " Rs 32000/- ", "package3.jpg"};

        JTabbedPane pane = new JTabbedPane();             //for tabs
        JPanel p1 = createPackage(package1);
        pane.addTab("Package 1",null,p1);       //addtab is a method to add tabs on the frame

        JPanel p2 = createPackage(package2);
        pane.addTab("Package 2",null,p2);

         JPanel p3 = createPackage(package3);
        pane.addTab("Package 3",null,p3);
        add(pane, BorderLayout.CENTER);
    }
    public JPanel createPackage(String[] pack){
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);

        JLabel l1 = new JLabel(pack[0]);
        l1.setBounds(250, 7, 300, 25);
        l1.setFont(new Font("Broadway", Font.PLAIN, 20));
        p1.add(l1);

        JLabel l2 = new JLabel(pack[1]);
        l2.setBounds(30, 35, 300, 25);
        l2.setForeground(new Color(230, 190, 250));
        l2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        p1.add(l2);

        JLabel l3 = new JLabel(pack[2]);
        l3.setBounds(30, 65, 300, 25);
        l3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        p1.add(l3);

         JLabel l4 = new JLabel( pack[3]);
        l4.setBounds(30, 95, 300, 25);
        l4.setForeground(new Color(230, 190, 250));
        l4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        p1.add(l4);


         JLabel l5 = new JLabel(pack[4]);
        l5.setBounds(30, 125, 300, 25);
        l5.setFont(new Font("Tahoma", Font.PLAIN, 15));
        p1.add(l5);

         JLabel l6 = new JLabel(pack[5]);
        l6.setBounds(30,155, 300, 25);
        l6.setForeground(new Color(230, 190, 250));
        l6.setFont(new Font("Tahoma", Font.PLAIN, 15));
        p1.add(l6);


         JLabel l7 = new JLabel(pack[6]);
        l7.setBounds(30, 185, 300, 25);
        l7.setFont(new Font("Tahoma", Font.PLAIN, 15));
        p1.add(l7);

         JLabel l8 = new JLabel(pack[7]);
        l8.setBounds(30, 215, 300, 25);
        l8.setForeground(new Color(230, 190, 250));
        l8.setFont(new Font("Tahoma", Font.PLAIN, 15));
        p1.add(l8);

         JLabel l9 = new JLabel(pack[8]);
        l9.setBounds(30, 275, 150, 25);
        l9.setFont(new Font("Broadway", Font.PLAIN, 20));
        p1.add(l9);

         JLabel l10 = new JLabel(pack[9]);
        l10.setBounds(230, 275, 200, 25);
        l10.setFont(new Font("Broadway", Font.PLAIN, 20));
        p1.add(l10);

         JLabel l11 = new JLabel(pack[10]);
        l11.setBounds(510, 275, 300, 25);
        l11.setFont(new Font("Broadway", Font.PLAIN, 20));
        p1.add(l11);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("javatours/icons/"+pack[11]));
        Image i2 = i1.getImage().getScaledInstance(400, 220, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(240, 0, 400, 300);
        p1.add(l12);
        return p1;
    }
 public static void main(String[] args)
 {
     new CheckPackage().setVisible(true);
 }
}
