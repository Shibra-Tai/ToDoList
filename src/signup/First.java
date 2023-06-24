package signup;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import signup.FirstLoginEvents;
import signup.FirstSignupEvents;
import signup.Events;

class FirstFrame extends JFrame
{
	JButton signup=null, login=null, img=null;
	Font btnf = new Font("Arial", Font.BOLD, 20);
	JPanel jp1=null,jp2=null;
	Container cont;
	
	
	
	public FirstFrame()
	{
		super("Hello");
		cont = getContentPane();
		
		cont.setLayout(new GridLayout(1,2));
		jp1 = new JPanel();
		jp2 = new JPanel();
		
		
		jp1.setBackground(Color.orange);
		jp2.setBackground(Color.black);
		
		
		img = new JButton(new ImageIcon("src\\img (3).jpg"));
		
		//img.setBounds(50,100,250,100);
		jp1.setLayout(new BorderLayout());
		
		jp1.add(img, BorderLayout.CENTER);
		
		cont.add(jp1);		cont.add(jp2);
		
		jp2.setLayout(null);
		signup = new JButton("Signup");
		login = new JButton("Login");
		
		signup.setFont(btnf);
		login.setFont(btnf);
		
		signup.setBackground(Color.orange);
		login.setBackground(Color.orange);
		signup.setBounds(70, 250, 200, 40);
		signup.setForeground(Color.black);
		login.setForeground(Color.black);
		login.setBounds(70, 400, 200, 40);
		signup.setBorder(null);			
		login.setBorder(null);
		jp2.add(signup);
		jp2.add(login);
		
		
		
		
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocation(200, 200);
		setBounds(350,100,800,700);	
		
		
		
	
		
		FirstLoginEvents fle = new FirstLoginEvents(this);
		FirstSignupEvents fse = new FirstSignupEvents(this);
	}
	
}

public class First 
{
	public static void main(String args[])
	{
		FirstFrame ff = new FirstFrame();
		
	}
}
