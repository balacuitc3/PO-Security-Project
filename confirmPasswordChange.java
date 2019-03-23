import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class confirmPasswordChange extends JFrame 
{

   public static void main(String[] args) 
   {
      confirmPasswordChange frameTabel = new confirmPasswordChange();
   }

   JLabel welcome = new JLabel("You have successfully changed your password!");
   JPanel panel = new JPanel();
   
   confirmPasswordChange()
   {
      super("You are Logged Out");
      setSize(500,200);
      setLocation(500,280);
      panel.setLayout (null); 
      
      welcome.setBounds(70,50,300,60);
      
      panel.add(welcome);
      
      getContentPane().add(panel);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }

    void setVisibile(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
