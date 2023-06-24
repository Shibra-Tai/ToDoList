package signup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import login.LogIn;
import signup.FirstFrame;
public class FirstLoginEvents implements ActionListener 
{
	
	FirstFrame ff;
	FirstLoginEvents(FirstFrame ff)
	{
		this.ff=ff;
		
		ff.login.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ff.login)
		{
			ff.setVisible(false);
			
			LogIn lf = new LogIn("Log In Your Account");
			
		}
		
	}
}
