package javatours;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class paytm extends JFrame implements ActionListener {
    JButton b1, b2;
  paytm(){
   setBounds(400, 180, 750, 500);
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);

     ImageIcon  i1 = new ImageIcon(ClassLoader.getSystemResource("javatours/icons/paytm.jpeg"));
    Image i2 = i1.getImage().getScaledInstance(730, 480, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel l1 = new JLabel(i3);
    l1.setBounds(0, 0, 730, 480);
    add(l1);


  b1 = new JButton("PAY");
    b1.setBounds(190, 10, 150, 30);
    b1.setBackground(Color.BLUE);
    b1.setFont(new Font("Tahoma", Font.BOLD, 15));
    b1.setForeground(Color.WHITE);
   b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paytm2.openURL("https://paytm.com/");
			}
		});
   l1.add(b1);


   b2 = new JButton("BACK");
    b2.setBounds(390, 10, 150, 30);
    b2.setBackground(Color.BLUE);
    b2.setFont(new Font("Tahoma", Font.BOLD, 15));
    b2.setForeground(Color.WHITE);
    b2.addActionListener(this);
    l1.add(b2);
  }
public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == b1){
        this.setVisible(false);
        new paytm().setVisible(true);
   }else if(ae.getSource() == b2){
        this.setVisible(false);
    }
}



    public static void main(String[] args){
        new paytm().setVisible(true);
    }

}