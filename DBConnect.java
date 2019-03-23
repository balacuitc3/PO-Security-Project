import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DBConnect
{
   private Connection con;
   private Statement st;
   private ResultSet rs;
   
   public DBConnect() {
      try{
         Class.forName("com.mysql.jdbc.Driver");
         
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PSecurityDB","root","");
         st = con.createStatement();
         
      } catch(Exception ex) {
         System.out.println("Error: "+ ex);
      }
      
   }
   public void getData() {
      try{
         String query = "select * from users";
         rs = st.executeQuery(query);
         System.out.println("Records from Database"); 
         
         while(rs.next())
         {
            String FirstName = rs.getString("FirstName");
            String LastName = rs.getString("LastName");
            System.out.println("Name: " + FirstName + " " + LastName);
         }
      } catch(Exception ex) {
         System.out.println("Error: "+ ex);
      }
     
   }   
   public void viewUserInfo(int level) {
      try{
         String query = "select * from users";
         rs = st.executeQuery(query);
         
         int SizeOfUsers = 0;
         while(rs.next())
         {
            int clearancelevel = rs.getInt("ClearanceLevel");
            if(clearancelevel <= level)
            {
                SizeOfUsers++;
            }
         }
         String[] UserArray = new String[SizeOfUsers];
         int count = 0;
         rs = st.executeQuery(query);
         while(rs.next())
         {
            int clearancelevel = rs.getInt("ClearanceLevel");
            if(clearancelevel <= level)
            {
                String FirstName = rs.getString("FirstName");
                String LastName = rs.getString("LastName");
                UserArray[count] = "Name: " + FirstName + " " + LastName;
                count++;
            }
         }
             viewusers regFace =new viewusers(UserArray);
             regFace.setVisible(true);
         
      } catch(Exception ex) {
         System.out.println("Error: "+ ex);
      }
     
   }
   public void checkBlockUser(int level) {
      try{
         String query = "select * from users";
         rs = st.executeQuery(query);
         int thelevel = level;
         
         BlockAUser regFace =new BlockAUser(thelevel);
         regFace.setVisible(true);
         
      } catch(Exception ex) {
         System.out.println("Error: "+ ex);
      }
     
   }
   public void checkAddUser(int level) {
      try{
         int thelevel = level;
         
         AddAUser regFace =new AddAUser(thelevel);
         regFace.setVisible(true);
         
      } catch(Exception ex) {
         System.out.println("Error: "+ ex);
      }
     
   }
      public void addTheNewUser(String FirstName, String LastName, String Email, String Username, String Password, String nPassword, int level, int block, int Clearancelevel) {
        boolean Info = true;
          try{
         
         String fn = FirstName;
         String ln = LastName;
         String em = Email;
         String user = Username;
         String Pass = Password;
         String nPass = nPassword;
         int lvl = level; 
         int Blocked = block;
         int clearLevel = Clearancelevel;
         
           String query = "INSERT INTO users(FirstName,LastName,Email,Username,Password,ClearanceLevel,Blocked) VALUES(?,?,?,?,?,?,?)";
           PreparedStatement preparedStmt = con.prepareStatement(query);
           preparedStmt.setString(1, fn);
           preparedStmt.setString(2, ln);
           preparedStmt.setString(3, em);
           preparedStmt.setString(4, user);
           preparedStmt.setString(5, Pass);
           preparedStmt.setInt(6, lvl);
           preparedStmt.setInt(7, Blocked);

           preparedStmt.executeUpdate();
           con.close();

           confirmUser regFace =new confirmUser();
           regFace.setVisible(true);
         
      } catch(Exception ex) {
         System.out.println("Error: "+ ex);
      }
   }
   public boolean BlockTheUser(String User, int level) {
boolean Info = true;
          try{
         String sql = "SELECT * from users";
         rs = st.executeQuery(sql);
         
         int count = 0;
         while(rs.next())
         {
            count++;
         }
         String query = "SELECT * from users";
         rs = st.executeQuery(query);
         
         String[] TheUsername = new String[count];
         int[] TheLevel = new int[count];
         int[] BlockedArray = new int[count];
         int recount = 0;
         
         while(rs.next())
         {
            String UN = rs.getString("Username");
            int Level = rs.getInt("ClearanceLevel");
            int Blocked = rs.getInt("Blocked");
            
            TheUsername[recount] = UN;
            TheLevel[recount] = Level;
            BlockedArray[recount] = Blocked;
            recount++;
            
         }
         
         for(int i = 0; i < recount; i++)
         {
            if (User.equals(TheUsername[i]) && (level > TheLevel[i] || level == 4))
            {
                Info = true;
                query = "UPDATE users set Blocked = 1 where Username = ?";
                PreparedStatement preparedStmt = con.prepareStatement(query);
                preparedStmt.setString(1, User);

                preparedStmt.executeUpdate();
                con.close();

                break;
            }
            else
            {
                Info = false;
            }
         }
      } catch(Exception ex) {
         System.out.println("Error: "+ ex);
      }
      return Info;
   }
      public void viewAllBlock() {
      try{
         String query = "select * from users";
         rs = st.executeQuery(query);
         
         int SizeOfUsers = 0;
         int BlockLevel = 1;
         while(rs.next())
         {
            int Blocked = rs.getInt("Blocked");
            if(Blocked == BlockLevel)
            {
                SizeOfUsers++;
            }
         }
         String[] UserArray = new String[SizeOfUsers];
         int count = 0;
         rs = st.executeQuery(query);
         while(rs.next())
         {
            int Blocked = rs.getInt("Blocked");
            if(Blocked == BlockLevel)
            {
                String FirstName = rs.getString("FirstName");
                String LastName = rs.getString("LastName");
                UserArray[count] = "Name: " + FirstName + " " + LastName;
                count++;
            }
         }
             viewblockusers regFace =new viewblockusers(UserArray);
             regFace.setVisible(true);
         
      } catch(Exception ex) {
         System.out.println("Error: "+ ex);
      }
     
   }
   public void logOut() {
      try{
          LogOut regFace = new LogOut();
          regFace.setVisibile(true);
      } catch(Exception ex) {
         System.out.println("Error: "+ ex);
      }
     
   }
   public void changePassConnect() {
      try{
          ChangePassFrame regFace = new ChangePassFrame();
      } catch(Exception ex) {
         System.out.println("Error: "+ ex);
      }
     
   }
   public void changeOldPassword(String Username, String Password, String nPassword) {
        boolean Info = true;
          try{
         String sql = "SELECT * from users";
         rs = st.executeQuery(sql);
         
         int count = 0;
         while(rs.next())
         {
            count++;
         }
         String query = "SELECT * from users";
         rs = st.executeQuery(query);
         
         String nPass = nPassword;
         String oUsername;
         String oPassword;
         
         String[] TheUsername = new String[count];
         String[] ThePassword = new String[count];
         int[] TheLevel = new int[count];
         int[] BlockedArray = new int[count];
         int recount = 0;
         
         while(rs.next())
         {
            String UN = rs.getString("Username");
            String PW = rs.getString("Password");
            int Level = rs.getInt("ClearanceLevel");
            int Blocked = rs.getInt("Blocked");
            
            TheUsername[recount] = UN;
            ThePassword[recount] = PW;
            TheLevel[recount] = Level;
            BlockedArray[recount] = Blocked;
            recount++;
            
         }
         
         for(int i = 0; i < recount; i++)
         {
            if (Username.equals(TheUsername[i]) && Password.equals(ThePassword[i]))
            {
               if (BlockedArray[i] == 0)
               {
                    Info = true;
                    oUsername = TheUsername[i];
                    oPassword = ThePassword[i];
                    query = "UPDATE users set Password = ? where Username = ?";
                    PreparedStatement preparedStmt = con.prepareStatement(query);
                    preparedStmt.setString(1, nPass);
                    preparedStmt.setString(2, oUsername);
                    
                    preparedStmt.executeUpdate();
                    con.close();
                    
                    confirmPasswordChange regFace =new confirmPasswordChange();
                    regFace.setVisible(true);
                    
                    break;
               }
               else
               {
                   Info = false;
               }
            }
            else
            {
                Info = false;
            }
         }
         
      } catch(Exception ex) {
         System.out.println("Error: "+ ex);
      }
   }
   public boolean checkAccount(String Username, String Password) {
        boolean Info = true;
          try{
         String sql = "SELECT * from users";
         rs = st.executeQuery(sql);
         
         int count = 0;
         while(rs.next())
         {
            count++;
         }
         String query = "SELECT * from users";
         rs = st.executeQuery(query);
         
         String[] TheUsername = new String[count];
         String[] ThePassword = new String[count];
         int[] TheLevel = new int[count];
         int[] BlockedArray = new int[count];
         int recount = 0;
         
         while(rs.next())
         {
            String UN = rs.getString("Username");
            String PW = rs.getString("Password");
            int Level = rs.getInt("ClearanceLevel");
            int Blocked = rs.getInt("Blocked");
            
            TheUsername[recount] = UN;
            ThePassword[recount] = PW;
            TheLevel[recount] = Level;
            BlockedArray[recount] = Blocked;
            recount++;
            
         }
         
         for(int i = 0; i < recount; i++)
         {
            if (Username.equals(TheUsername[i]) && Password.equals(ThePassword[i]))
            {
               if (BlockedArray[i] == 0)
               {
                    Info = true;
                    break;
               }
               else
               {
                   Info = false;
               }
            }
            else
            {
                Info = false;
            }
         }
      } catch(Exception ex) {
         System.out.println("Error: "+ ex);
      }
      return Info;
   }
   public void confirmUserInfo(String Username, String Password) {
      try{
         String sql = "SELECT * from users";
         rs = st.executeQuery(sql);
         
         int count = 0;
         while(rs.next())
         {
            count++;
         }
         String query = "SELECT * from users";
         rs = st.executeQuery(query);
         
         String[] TheUsername = new String[count];
         String[] ThePassword = new String[count];
         int[] TheLevel = new int[count];
         int recount = 0;
         
         while(rs.next())
         {
            String UN = rs.getString("Username");
            String PW = rs.getString("Password");
            int Level = rs.getInt("ClearanceLevel");
            
            TheUsername[recount] = UN;
            ThePassword[recount] = PW;
            TheLevel[recount] = Level;
            recount++;
            
         }
         
         for(int i = 0; i < recount; i++)
         {
            if (Username.equals(TheUsername[i]) && Password.equals(ThePassword[i]))
            {
                switch (TheLevel[i]) {
                    case 4:
                        {
                            clearance4 regFace =new clearance4();
                            regFace.setVisible(true);
                            break;
                        }
                    case 3:
                        {
                            clearance3 regFace =new clearance3();
                            regFace.setVisible(true);
                            break;
                        }
                    case 2:
                        {
                            clearance2 regFace =new clearance2();
                            regFace.setVisible(true);
                            break;
                        }
                    case 1:
                        {
                            clearance1 regFace =new clearance1();
                            regFace.setVisible(true);
                            break;
                        }
                    default:
                        break;
                }
            }
         }
      } catch(Exception ex) {
         System.out.println("Error: "+ ex);
      }
     
   }
   
}
