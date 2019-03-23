import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class viewusers extends JFrame 
{

    private static String[] listItems;
   JPanel panel = new JPanel();
   
   viewusers(String[] UserArray)
   {
      super("Here are the users");
      setSize(300,200);
      setLocation(500,280);
      panel.setLayout (null); 
      listItems = new String[UserArray.length];
      
      for (int x = 0; x <UserArray.length;x++)
      {
          String item = UserArray[x];
          listItems[x] = item;
      }
      
      JList numberList = new JList(listItems);
      JScrollPane scrollPane = new JScrollPane(numberList);
      
      scrollPane.setBounds(5,5,300,200);
      
      panel.add(scrollPane);
      
      
      getContentPane().add(panel);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }
   
   public static void main(String[] args) 
   {
      viewusers frameTabel = new viewusers(listItems);
   }
}
