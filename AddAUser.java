import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;



public class AddAUser extends JFrame 
{
    private static int clearancelevel;
    public static void main(String[] args) {
        AddAUser frameTable = new AddAUser(clearancelevel);
    }
    
    JLabel welcome = new JLabel("Add A New User");
    JPanel panel = new JPanel();
    JTextField firstname = new JTextField(15);
    JTextField lastname = new JTextField(15);
    JTextField email = new JTextField(15);
    JTextField username = new JTextField(15);
    JPasswordField newPass = new JPasswordField(15);
    JPasswordField confirmPass = new JPasswordField(15);    
    JTextField UserLevel = new JTextField(15);
    JTextField Blocked = new JTextField(15);
    JButton submit = new JButton("Submit");
   
    
    JLabel label1 = new JLabel("First Name: ");
    JLabel label2 = new JLabel("Last Name: ");
    JLabel label3 = new JLabel("Email: ");
    JLabel label4 = new JLabel("Username: ");
    JLabel label5 = new JLabel("Password: ");
    JLabel label6 = new JLabel("Confirm Pass: ");
    JLabel label7 = new JLabel("Level: ");
    JLabel label8 = new JLabel("Blocked: ");
    
    AddAUser(int level) 
    {
        super("Add A User");
        
        setSize(300,350);
        setLocation(500,280);
        panel.setLayout (null); 
        
        clearancelevel = level;
        
        firstname.setBounds(80, 30, 200, 20);
        label1.setBounds(10, 30, 200, 20);
        
        lastname.setBounds(80, 60, 200, 20);
        label2.setBounds(10, 60, 200, 20);
        
        email.setBounds(80, 90, 200, 20);
        label3.setBounds(10, 90, 200, 20);
        
        username.setBounds(80, 120, 200, 20);
        label4.setBounds(10, 120, 200, 20);
        
        newPass.setBounds(80, 150, 200, 20);
        label5.setBounds(10, 150, 200, 20);
        
        confirmPass.setBounds(80, 180, 200, 20);
        label6.setBounds(10, 180, 200, 20);
        
        UserLevel.setBounds(80, 210, 200, 20);
        label7.setBounds(10, 210, 200, 20);
        
        Blocked.setBounds(80, 240, 200, 20);
        label8.setBounds(10, 240, 200, 20);
        
        submit.setBounds(100, 270, 100, 20);
        
        panel.add(firstname);
        panel.add(lastname);
        panel.add(email);
        panel.add(username);
        panel.add(newPass);
        panel.add(confirmPass);
        panel.add(UserLevel);
        panel.add(Blocked);
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        panel.add(label6);
        panel.add(label7);
        panel.add(label8);
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
               
               String first = firstname.getText();
               String last = lastname.getText();
               String emailuser = email.getText();
               String User = username.getText();
               String nPass = newPass.getText();
               String cPass = confirmPass.getText();
               String templvl = UserLevel.getText();
               String tempblock = Blocked.getText();
               
               int lvl = Integer.parseInt(templvl);
               int block = Integer.parseInt(tempblock);
               
               
                if (nPass.equals(cPass) == true) {
                    connect.addTheNewUser(first, last, emailuser, User, nPass, cPass, lvl, block, clearancelevel);
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Make sure password is re-entered correctly");
                    newPass.setText("");
                    confirmPass.setText("");
                }
            }
            });
        }
}
