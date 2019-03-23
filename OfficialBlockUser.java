import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class OfficialBlockUser extends JFrame 
{

   public static void main(String[] args) 
   {
      OfficialBlockUser frameTabel = new OfficialBlockUser();
   }

   JLabel welcome = new JLabel("You Block The User!");
   JPanel panel = new JPanel();
   
   OfficialBlockUser()
   {
      super("Logged Out");
      setSize(300,200);
      setLocation(500,280);
      panel.setLayout (null); 
      
      welcome.setBounds(70,50,150,60);
      
      panel.add(welcome);
      
      getContentPane().add(panel);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }
}
