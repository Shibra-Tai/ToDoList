package signup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import signup.SignUp;
import signup.FirstFrame;
public class FirstSignupEvents implements ActionListener
{

	FirstFrame ff=null;
	public FirstSignupEvents(FirstFrame ff)
	{
		this.ff=ff;
		ff.signup.addActionListener(this);
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ff.signup)
		{
			ff.setVisible(false);
			
			SignUp sf = new SignUp("Create New Account");
		}
		
	}
}
