import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class BlockAUser extends JFrame 
{
    private static int clearancelevel;
    public static void main(String[] args) {
        BlockAUser frameTable = new BlockAUser(clearancelevel);
    }
    
    JLabel welcome = new JLabel("You can Block a User here:");
    JPanel panel = new JPanel();
    JTextField username = new JTextField(15);
    JLabel label1 = new JLabel("Username: ");
    JButton submit = new JButton("Submit");
    
    BlockAUser(int level)
    {
        super("Block A User");
        setSize(300,200);
        setLocation(500,280);
        panel.setLayout (null); 
      
        
        clearancelevel = level;
        
        username.setBounds(80, 30, 200, 20);
        label1.setBounds(10, 30, 200, 20);
        submit.setBounds(100, 150, 100, 20);
        
        panel.add(username);
        panel.add(label1);
        panel.add(submit);
        
        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        actionBlockUser();
    }
    public void actionBlockUser() 
        {
            submit.addActionListener(new ActionListener() 
            {
               public void actionPerformed(ActionEvent b) 
               {
                   
               DBConnect connect = new DBConnect();
               
               String User = username.getText();
               
               if (connect.BlockTheUser(User,clearancelevel) == true)
               {
                   OfficialBlockUser regFace =new OfficialBlockUser();
                   regFace.setVisible(true);
                   dispose();
               }
               else
               {
                   JOptionPane.showMessageDialog(null,"Wrong Username/Not High enough Clearance");
                   username.setText("");
               }
               
            }
            });
        }
}
