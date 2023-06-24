package signup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

import signup.SignUp;
import signup.Database;
import signup.FirstFrame;
import login.LogIn;
public class Events implements ActionListener{

	SignUp su;
	
	
	Events(){}
	Events(SignUp su)
	{
		this.su = su;
		
		su.create.addActionListener(this);
		su.cancel.addActionListener(this);
		Connection con = Database.dbconnect();   // connected to database
		System.out.print("**********Entered in constructor************");
	}
	
	
	public void actionPerformed(ActionEvent e) 
	{
		
		
		try
		{
			
			if(e.getSource() == su.create)
			{
				
				String usr = su.username.getText();
				String pass = su.pswd.getText();
				Connection conn=Database.dbconnect();
				PreparedStatement pst =  conn.prepareStatement("insert into signup(Username,Password) values(?,?)");  
				
				pst.setString(1, usr);   // insert usr into 1st column of signup relation
				pst.setString(2,pass);	 // insert pass into 2nd column of signup relation
				
				String check_str = "select Username, Password from signup where Username='"+usr+"'";
				
				Statement st = null;
				st = (Statement) conn.createStatement();
				ResultSet rs = st.executeQuery(check_str);
				
				
				if(rs.next())
				{
					su.username.setText("");
					su.pswd.setText("");
					JOptionPane.showMessageDialog(null,"Username or Password already exists, Try again");
				}
				
				else
				{
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Now you are a registered user");
					LogIn lf = new LogIn("Log In Your Account");
					
				}
				
				conn.close();
			}
			
			
			
			
		}
		
		catch(Exception exp)
		{
			System.out.print("\n In Events class of signup pkg : "+exp.getMessage());
		}
		
	}

}
