package login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import signup.Database;
import signup.Events;

import mainmenu.Today;
import mainmenu.TodayEvents;
import login.LogIn;



public class LoginEvents  implements ActionListener
{
	LogIn lf;
	Today t;
	public String uname="", pswd="";
	public LoginEvents()
	{
		
	}
	public LoginEvents(LogIn lf)
	{
		this.lf=lf;
		
		lf.cancel.addActionListener(this);
		lf.login.addActionListener(this);
		
	}
	
	
	

	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == lf.cancel)
		{
			System.exit(0);
		}
		
		else if(e.getSource() == lf.login)
		{
			
			 
			try 
			{
				Connection con = (Connection) Database.dbconnect();  // connection done
				
				 uname = lf.username.getText();
				 pswd = lf.pswd.getText();
				 
				 System.out.print("\n in method of loginevents : "+uname);
				 
				
				Statement stmt = (Statement) con.createStatement();
				
				String query = "select Username, Password from signup where Username = '" + uname+ "' and Password = '"+pswd+"'";
				
				System.out.print("\n in method of loginevents : "+uname);
				
				ResultSet rs = stmt.executeQuery(query);
					
				
				// display menu for specified user
				
				if(rs.next())
				{
					lf.setVisible(false);
					
					// display menu for specified user
					
					try
					{
						Today tf = new Today("To Do List",uname);
						tf.setVisible(true);
						tf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
						tf.setLocation(200, 200);
						tf.setBounds(350,100,800,700);
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
					
				}
				
				
				else
				{
					System.out.print("--hello--");
					JOptionPane.showMessageDialog(null, "Incorrect Username and Password, Try again");
					
					
					
				}
				
			} 
			catch (SQLException e1) 
			{
				System.out.print("\n sql exception of login events  "+e1.getMessage());
				e1.printStackTrace();
			}
			
			
		}
		
		
		
	}
	
	
}
