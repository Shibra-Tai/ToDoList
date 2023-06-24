package login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import login.LoginEvents;

public class LogIn extends JFrame
{
	JTextField username=null;
	JPasswordField pswd = null;
	Container cont=null;
	JPanel p1=null,p2=null;
	Font f = new Font("Courier", Font.PLAIN, 20);
	Font btnf = new Font("Arial", Font.BOLD, 20);
	JLabel uname=null,pass=null;
	JButton cancel=null, login=null, picbtn=null;
	
	public LogIn(String title)
	{
		super(title);
		cont = getContentPane();
		cont.setLayout(new GridLayout(1,2));
		p1 = new JPanel();
		p2 = new JPanel();
		p1.setBackground(Color.orange);
		p2.setBackground(Color.BLACK);
		
		
		
		picbtn = new JButton(new ImageIcon("src\\img (3).jpg"));
		p1.setLayout(new BorderLayout());
		p1.add(picbtn, BorderLayout.CENTER);
		p1.add(picbtn);
		
		cont.add(p1);
		cont.add(p2);
		
		p2.setLayout(null);
		
		
		/* username */
		uname = new JLabel("Username");
		uname.setBounds(50,150,100,30);
		uname.setFont(f);		uname.setForeground(Color.white);
		username = new JTextField();
		username.setBounds(50, 200, 300, 30);
		p2.add(uname);		p2.add(username);
		username.setBorder(null);
		username.setFont(f);
		
		
		/* password  */
		pass = new JLabel("Password");
		pass.setBounds(50,250,100,30);
		pass.setFont(f);		pass.setForeground(Color.white);
		pswd = new JPasswordField();
		pswd.setBounds(50, 300, 300, 30);
		p2.add(pass);			p2.add(pswd);
		pswd.setBorder(null);
		pswd.setFont(f);
		
		
		
		
		/*  Buttons  */
		
		cancel = new JButton("Cancel");
		cancel.setBorder(null);
		cancel.setForeground(Color.black);
		cancel.setBackground(Color.orange);
		cancel.setBounds(50, 400, 100, 40);
		cancel.setFont(btnf);
		p2.add(cancel);
		
		login = new JButton("Log In");
		login.setBorder(null);
		login.setForeground(Color.black);
		login.setBackground(Color.orange);
		login.setBounds(250, 400, 100, 40);
		login.setFont(btnf);
		p2.add(login);
		
		
		
		
		LoginEvents le = new LoginEvents(this);
		
		
		
		
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocation(200, 200);
		setBounds(350,100,800,700);
	}
}


