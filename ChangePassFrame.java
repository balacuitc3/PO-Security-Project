import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;



public class ChangePassFrame extends JFrame 
{
    
    public static void main(String[] args) {
        ChangePassFrame frameTable = new ChangePassFrame();
    }
    
    JLabel welcome = new JLabel("Change Password");
    JPanel panel = new JPanel();
    JTextField username = new JTextField(15);
    JPasswordField oldPass = new JPasswordField(15);
    JPasswordField newPass = new JPasswordField(15);
    JPasswordField confirmPass = new JPasswordField(15);
    JButton submit = new JButton("Submit");
    
    JLabel label1 = new JLabel("Username: ");
    JLabel label2 = new JLabel("Password: ");
    JLabel label3 = new JLabel("New Pass: ");
    JLabel label4 = new JLabel("Confirm Pass: ");
    
    ChangePassFrame() 
    {
        super("Change Password");
        
        setSize(300,250);
        setLocation(500,280);
        panel.setLayout (null); 
        
        username.setBounds(80, 30, 200, 20);
        label1.setBounds(10, 30, 200, 20);
        oldPass.setBounds(80, 60, 200, 20);
        label2.setBounds(10, 60, 200, 20);
        newPass.setBounds(80, 90, 200, 20);
        label3.setBounds(10, 90, 200, 20);
        confirmPass.setBounds(80, 120, 200, 20);
        label4.setBounds(0, 120, 200, 20);
        submit.setBounds(100, 150, 100, 20);
        

        panel.add(username);
        panel.add(oldPass);
        panel.add(newPass);
        panel.add(confirmPass);
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(submit);

        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        actionchangePass();
    }
        public void actionchangePass() 
        {
            submit.addActionListener(new ActionListener() 
            {
               public void actionPerformed(ActionEvent b) 
               {
                   
               DBConnect connect = new DBConnect();
               
                   
               String User = username.getText();
               String oPass =  oldPass.getText();
               String nPass = newPass.getText();
               String cPass = confirmPass.getText();
               
               if(connect.checkAccount(User, oPass) == true) {
                   if (nPass.equals(cPass) == true) {
                       connect.changeOldPassword(User, oPass, nPass);
                       dispose();
                   }
                   else {
                       JOptionPane.showMessageDialog(null, "Make sure password is re-entered correctly");
                       oldPass.setText("");
                       newPass.setText("");
                       confirmPass.setText("");
                   }
               }
               else {
               JOptionPane.showMessageDialog(null,"Old password did not match current password");
               oldPass.setText("");
               newPass.setText("");
               confirmPass.setText("");
                   
               }
            }
            });
        }
}
