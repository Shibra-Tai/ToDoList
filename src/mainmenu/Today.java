package mainmenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import mainmenu.TodayEvents;



public class Today extends JFrame
{
	JTextField newtask=null;
	JButton addbtn=null, donebtn=null, delbtn=null, editbtn=null, completedtasksbtn=null,logoutbtn=null;
	JPanel jp1=null, jp2=null, jp3=null;
	Font btnf = new Font("Arial", Font.BOLD, 17), btnfs = new Font("Arial", Font.BOLD, 10);
	Font f = new Font("Courier", Font.BOLD, 20);
	Container cont=null;
	
	
	JRadioButton rb=null, rb2=null;
	
	JLabel l1=null, l2=null;
	Date d1=null;
	public String uname;
	public Today(String title, String uname) throws IOException, Exception
	{
		super(title);
		this.uname=uname;
		cont = getContentPane();
		cont.setLayout(new BorderLayout());
		
		
		/*		for top panel 		*/
		jp1 = new JPanel();
		cont.add(jp1, BorderLayout.NORTH);
		jp1.setBackground(Color.black);
		newtask = new JTextField("Enter your task here");
		
		newtask.setFont(f);
		addbtn = new JButton("Add");
		
		addbtn.setBorder(null);
		addbtn.setForeground(Color.black);
		addbtn.setBackground(Color.orange);
		addbtn.setFont(btnf);
		jp1.add(newtask);
		jp1.add(addbtn);
		
		
		
		/*  for displaying previously added tasks 	*/
		
		jp2 = new JPanel();
		jp2.setBackground(Color.orange);
		
		//jp2.setLayout(null);
		//jp2.setLayout(new FlowLayout());
		
		
		
		
	
		cont.add(jp2,BorderLayout.CENTER);
		
		//  end of panel2
		
		
		/*		for exit and back buttons 	*/
		
		jp3 = new JPanel();
		cont.add(jp3,BorderLayout.SOUTH);
		
		
		editbtn = new JButton("Edit");
		editbtn.setFont(btnf);
		editbtn.setBackground(Color.black);
		editbtn.setForeground(Color.white);
		
		delbtn = new JButton("Delete");
		delbtn.setFont(btnf);
		delbtn.setBackground(Color.black);
		delbtn.setForeground(Color.white);
		
		donebtn = new JButton("Done");
		donebtn.setFont(btnf);
		donebtn.setBackground(Color.black);
		donebtn.setForeground(Color.white);
		
		
		
		completedtasksbtn = new JButton("Show Completed tasks");
		completedtasksbtn.setFont(btnfs);
		completedtasksbtn.setBackground(Color.black);
		completedtasksbtn.setForeground(Color.white);
		
		logoutbtn = new JButton("Logout");
		logoutbtn.setFont(btnf);
		logoutbtn.setBackground(Color.black);
		logoutbtn.setForeground(Color.white);
		
		
		jp3.setLayout(new GridLayout(1,2));
		jp3.add(editbtn);	
		jp3.add(delbtn);	
		jp3.add(donebtn);	
		jp3.add(completedtasksbtn);
		jp3.add(logoutbtn);
		
		
		TodayEvents te = new TodayEvents(this);
	}
}
//public class Today 
//{
//	public static void main(String[] args)
//	{
//		TodayFrame tf = new TodayFrame("To Do List");
//		tf.setVisible(true);
//		tf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//		tf.setLocation(200, 200);
//		tf.setBounds(350,100,800,700);
//		
//	}
//	
//	
//}
