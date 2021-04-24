package javatours;
import javax.swing.*;
import java.awt.*;
public class SplashScreen {
public static void main(String[] args){
   SplashFrame Frame = new SplashFrame();
   Frame.setVisible(true);
   int x = 1;
   for(int i = 1; i<= 600; i+=5, x+=3){
    Frame.setLocation(680 - (x + i)/2, 370 - (i/2));
    Frame.setSize(x + i, i);
    try{
        Thread.sleep(10);
        }catch(Exception e){}


    Frame.setVisible(true);
}
}
}
class SplashFrame extends JFrame implements Runnable{
    Thread t1;    //thread class object declared
    SplashFrame(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("javatours/icons/splash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        add(l1);           //function of Jframe class to put image components on the frame


        setUndecorated(true);      //to remove the cross bar on splashscreen
        t1 = new Thread(this);     //thread class object created
        t1.start();
    }

public void run(){                 //overriden abstract method of runnable interface
    try{
        Thread.sleep(7000);
        this.setVisible(false);

        new Whoareyou().setVisible(true);
        }catch(Exception e){}

 }

}