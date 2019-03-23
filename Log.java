import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Log extends JFrame 
{

   public static void main(String[] args) 
   {
      Log frameTabel = new Log();
   }

   JButton buttonlogin = new JButton("Login");
   JPanel panel = new JPanel();
   JTextField textuser = new JTextField(15);
   JPasswordField password = new JPasswordField(15);
   
   JLabel label1 = new JLabel("Username: ");
   JLabel label2 = new JLabel("Password: ");
   
   ImageIcon image;
   JLabel piclabel;

   Log()
   {
      super("Login Autentification");
      setSize(500,350);
      setLocation(500,280);
      panel.setLayout (null); 
      
      image = new ImageIcon(getClass().getResource("logo.png"));
      piclabel = new JLabel(image);
      
      textuser.setBounds(80,30,150,20);
      label1.setBounds(10,30, 150, 20);
      password.setBounds(80,65,150,20);
      label2.setBounds(10,65, 150, 20);
      buttonlogin.setBounds(110,100,80,20);
      piclabel.setBounds(250, 50, 200, 200);
      
      panel.add(buttonlogin);
      panel.add(textuser);
      panel.add(label1);
      panel.add(label2);
      panel.add(password);
      panel.add(piclabel);
      
      getContentPane().add(panel);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      actionlogin();
   }

   public void actionlogin()
   {
      buttonlogin.addActionListener(new ActionListener() 
      {
         public void actionPerformed(ActionEvent ae) 
         {
             DBConnect connect = new DBConnect();
             String pusername = textuser.getText();
             String ppassword = password.getText();
             if (connect.checkAccount(pusername, ppassword) == true)
             {
                connect.confirmUserInfo(pusername,ppassword);
                dispose();
             }
            else 
            {
               JOptionPane.showMessageDialog(null,"Wrong Password / Username");
               textuser.setText("");
               password.setText("");
               textuser.requestFocus();
            }
             
         }
      });
   }
}