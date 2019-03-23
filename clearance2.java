import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class clearance2 extends JFrame 
{

   public static void main(String[] args) 
   {
      clearance2 frameTabel = new clearance2();
   }

   JLabel welcome = new JLabel("Welcome to PSecurity!");
   JPanel panel = new JPanel();
   JButton viewAllUser = new JButton("View Users");
   JButton logOut = new JButton ("Log Out");
   JButton viewBlockUser = new JButton("View Block Users");
   JButton changePassword = new JButton("Change Your Password");
   JButton BlockUser = new JButton("Block A User");
   
   clearance2()
   {
      super("Welcome To Clearance 2");
      setSize(300,300);
      setLocation(500,280);
      panel.setLayout (null); 
      
      welcome.setBounds(70,50,150,60);
      viewAllUser.setBounds(70,100,200,20);
      logOut.setBounds(70,140,200,20);
      
      panel.add(welcome);
      panel.add(viewAllUser);
      panel.add(logOut);
      
      viewBlockUser.setBounds(70, 120, 200, 20);
      panel.add(viewBlockUser);
      
      changePassword.setBounds(70, 160, 200, 20);
      panel.add(changePassword);
      
      BlockUser.setBounds(70, 180, 200, 20);
      panel.add(BlockUser);
      
      getContentPane().add(panel);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      
      actionlogin();
   }
   
    public void actionlogin()
   {
      viewAllUser.addActionListener(new ActionListener() 
      {
         public void actionPerformed(ActionEvent ae) 
         {
             DBConnect connect = new DBConnect();
             int level = 2;
             
             connect.viewUserInfo(level);
             dispose();
             
         }
      });
      viewBlockUser.addActionListener(new ActionListener() 
      {
         public void actionPerformed(ActionEvent ae) 
         {
             DBConnect connect = new DBConnect();
             connect.viewAllBlock();
             dispose();
             
         }
      });
      logOut.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent ae)
         {
             DBConnect connect = new DBConnect();
             connect.logOut();
         }
      });
      changePassword.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent ae)
         {
             DBConnect connect = new DBConnect();
             connect.changePassConnect();
             dispose();
         }
      });
      viewAllUser.addActionListener(new ActionListener() 
      {
         public void actionPerformed(ActionEvent ae) 
         {
             DBConnect connect = new DBConnect();
             int level = 2;
             
             connect.viewUserInfo(level);
             dispose();
             
         }
      });
   }
}
