package mainmenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

import mainmenu.Today;
import login.LoginEvents;
import signup.Database;
import signup.First;

public class TodayEvents implements ActionListener, FocusListener, WindowListener
{
	Today t;
	Connection con;
	public JTable jt = null,jtdone=null;
	public DefaultTableModel model=null,m=null;
	ResultSet rs;
	ResultSetMetaData rsmd;
	
	
	static FileWriter fw=null;
	
	
	Font f = new Font("Courier",Font.BOLD, 20);
	
	public String uname="";
	public TodayEvents() {}
	public TodayEvents(Today t) throws IOException
	{
		this.t = t;
		
		t.addbtn.addActionListener(this);
		t.delbtn.addActionListener(this);
		t.donebtn.addActionListener(this);
		t.editbtn.addActionListener(this);
		t.completedtasksbtn.addActionListener(this);
		t.logoutbtn.addActionListener(this);
		t.addWindowListener(this);
		
		
		
		fw = new FileWriter("C:\\AJT\\RecordsOfTodo.txt");
	}
	
	
	
	
	public void actionPerformed(ActionEvent e) 
	{

		if(e.getSource() == t.donebtn)
		{
			int selcol = jt.getSelectedRow();
			
			if(selcol != -1)
			{
				
				
				try 
				{
					String desc = (String) jt.getValueAt(selcol, 0);
					jt.getSelectedRow();
					con = Database.dbconnect();
					Statement stmt = (Statement) con.createStatement();
					
					
					String query = "update todo set status = 'T' where username = '"+t.uname+"' and description = '"+desc+"'";
					stmt.executeUpdate(query);
					model.removeRow(jt.getSelectedRow());
					//m.addRow();
					JOptionPane.showMessageDialog(null,"You have completed your task!!!");
					con.close();
					
					
					fw.write(""+t.uname+" : "+desc+" : Status = done");
					
					
				} 
				
				catch (SQLException e1) 
				{
					
					e1.printStackTrace();
				}
				
				catch(IOException ie)
				{
					ie.printStackTrace();
				}
				
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				
				
			}
			
			else
			{
				JOptionPane.showMessageDialog(null, "First select the task that you have completed");
			}
		}
		
		else if(e.getSource() == t.addbtn)
		{
			
			String new_task = t.newtask.getText();
			
			if(new_task.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please enter your task first");
			}
			
			else
			{
				 
				 System.out.println("    Add btn clicked by : "+t.uname);
				 
				 
				 try 
				 {
					 con=Database.dbconnect();
					Statement stmt = (Statement) con.createStatement();
					String insert_query = "insert into todo(username,description,status) values ('"+t.uname+"' , '"+new_task+"' , 'F')";
					stmt.executeUpdate(insert_query);
					
					
					JOptionPane.showMessageDialog(null, "Data inserted");
					
					String[] row = {new_task};
					
					model.addRow(row);
					t.newtask.setText("Enter your new task here");
					stmt.close();
					con.close();
					
					
					fw.write(""+t.uname+" : "+new_task+" : Status = undone");
					
				}
				 catch (SQLException e1) 
				 {
					
					 System.out.println("\n In TodayEvents class : "+e1.getMessage());
					
				 }
				 
				 catch(IOException ie)
				{
					ie.printStackTrace();
				}
					
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				 
				 
			}
			
		}
		
		
		else if(e.getSource() == t.editbtn)
		{
			try 
			{
				
				
				int selcol = jt.getSelectedRow();
				
				if(selcol!=-1)
				{
					String olddesc = ""+jt.getValueAt(selcol, 0);
					String desc = JOptionPane.showInputDialog("Enter your task here ");
					if(desc == null)
					{
						JOptionPane.showMessageDialog(null, "First enter your task in the prompt box");
					}
					
					else
					{
						con = Database.dbconnect();
						Statement stmt = (Statement) con.createStatement();
						
						String query = "update todo set description = '"+desc+"' where description = '"+olddesc+"' and username = '"+t.uname+"'";
						
						stmt.executeUpdate(query);
						jt.setValueAt(desc, selcol, 0);
						
						
						JOptionPane.showMessageDialog(null, "Edited successfully");
					}
					
					
					
					fw.write(""+t.uname+" : "+olddesc+" modified to :"+desc+"  Status = modified and undone");
					
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "First select the task from your todo list");
				}
				
				
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
			
			
		}
		
		else if(e.getSource() == t.delbtn)
		{
			int selcol = jt.getSelectedRow();
			
			if(selcol != -1)
			{
				
				
				try 
				{
					String desc = (String) jt.getValueAt(selcol, 0);
					jt.getSelectedRow();
					con = Database.dbconnect();
					Statement stmt = (Statement) con.createStatement();
					
					
					String query = "delete from todo where username = '"+t.uname+"' and description = '"+desc+"'";
					stmt.executeUpdate(query);
					model.removeRow(jt.getSelectedRow());
					JOptionPane.showMessageDialog(null,"Deleted successfully");
					
					
					fw.write(""+t.uname+" : "+desc+" : Status = deleted");
					
				} 
				
				catch (SQLException e1) 
				{
					
					e1.printStackTrace();
				}
				catch(IOException ie)
				{
					ie.printStackTrace();
				}
				
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				
				
			}
			
			else
			{
				JOptionPane.showMessageDialog(null, "First select the task from your todo list");
			}
			
		}
		
		else if(e.getSource() == t.completedtasksbtn)
		{
			
			if(t.completedtasksbtn.getLabel() == "Show Completed tasks")
			{
				jt.setVisible(false);	
				try 
				{
					
					con = Database.dbconnect();
					Statement stmt = (Statement) con.createStatement();
					String query = "select id,username,description from todo where username = '"+t.uname+"' and status = 'T' ";
					
					ResultSet rsn = stmt.executeQuery(query);
					ResultSetMetaData rsmdn = (ResultSetMetaData) rsn.getMetaData();
					
					m = new DefaultTableModel();
					jtdone = new JTable(m);
					
					System.out.print("done till jtdone");
					
					if(rsn.next())
					{
						
						int cols = rsmdn.getColumnCount();		// indexing starts from 1
						String[] colName = new String[cols];		
						
						for(int i=0;i<cols;i++)
						{
							colName[i] = rsmdn.getColumnName(i+1);
								
						}
						
						String[] c = new String[1];
						c[0]=colName[2];
						System.out.print("\n\n   "+colName[2]);
						
						m.setColumnIdentifiers(c);
						System.out.print("\n m done");
						jtdone.setFont(f);
						jtdone.setBackground(Color.orange);
						
						jtdone.setAutoResizeMode(jt.AUTO_RESIZE_OFF);
						jtdone.getColumnModel().getColumn(0).setPreferredWidth(500);
						
						jtdone.setRowHeight(30);
						
						stmt.close();
						rs.close();
						
						stmt = (Statement) con.createStatement();
						query = "select id,username,description from todo where username = '"+t.uname+"' and status = 'T' ";
						
						rsn = stmt.executeQuery(query);
						
						while(rsn.next())
						{
							System.out.print("\ninside loop ");
							String description = rsn.getString(3);
							
							
							String[] row = {description};
							
							
							m.addRow(row);
							t.jp2.add(jtdone);
						}
						
						t.jp2.add(jtdone);
						t.completedtasksbtn.setLabel("Back");
						
						
						
						
						
						
					}
					
					else
					{
						jt.setVisible(true);
						JOptionPane.showMessageDialog(null, "Your list is empty!");
					}
				} 
				
				catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
			
			
			else
			{
				jtdone.setVisible(false);
				jt.setVisible(true);
				t.completedtasksbtn.setLabel("Show Completed tasks");
			}
			
		}
		
		else if(e.getSource() == t.logoutbtn)
		{
			t.setVisible(false);
			
		}
		
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
		try
		{
			
			System.out.print("  "+t.uname);
			/* code to retrieve from database and display in table format	*/
			
			con = Database.dbconnect();	// connected 
			System.out.print("connected\n");
			Statement stmt = (Statement) con.createStatement();
			System.out.print("\n stmt created \n");
			String query = "select id,username,description from todo where username = '"+t.uname+"' and status = 'F'";
			System.out.print(" query created :  "+t.uname);
			
			rs = stmt.executeQuery(query);
			System.out.print("rs done\n");
			rsmd = (ResultSetMetaData) rs.getMetaData();
			System.out.print("rsmd done\n");
			model = new DefaultTableModel();
			jt = new JTable(model);
			//model = (DefaultTableModel) jt.getModel();
			
			System.out.print("model done");
			/*********************** ************************************/
			if(rs.next())
			{
				
				System.out.print("\n entered if ..............");
				int cols = rsmd.getColumnCount();		// indexing starts from 1
				String[] colName = new String[cols];		
				
				for(int i=0;i<cols;i++)
				{
					colName[i] = rsmd.getColumnName(i+1);
					System.out.print("\n entered for loop ..\n");
				}
				
				String[] c = new String[1];
				c[0]=colName[2];
				model.setColumnIdentifiers(c);
				
				String id="",username="",description="";
				/***************///////
				stmt.close();
				rs.close();
				
				stmt = (Statement) con.createStatement();
				
				 query = "select id,username,description from todo where username = '"+t.uname+"' and status = 'F'";
				System.out.print(" query created :  "+t.uname);
				rs = stmt.executeQuery(query);
				
				
//				rsmd = (ResultSetMetaData) rs.getMetaData();
				
				
				/**************///////
				while(rs.next())
				{
					
					
					System.out.print("\n entered while again ''''\n");
					id = rs.getString(1);
					username = rs.getString(2);
					description = rs.getString(3);
					
					System.out.print("\n "+id);
					System.out.print("  "+username);
					
					String[] row = {description};
					
					model.addRow(row);
					jt.setFont(f);
					jt.setBackground(Color.orange);
					
					jt.setAutoResizeMode(jt.AUTO_RESIZE_OFF);
					jt.getColumnModel().getColumn(0).setPreferredWidth(500);
					
					jt.setRowHeight(30);
					
					
					t.jp2.add(jt);
					System.out.print("\n leaving while ..............");
					
				}
			}
			
			else
			{
//				int cols = rsmd.getColumnCount();		// indexing starts from 1
//				String[] colName = new String[cols];		
//				
//				for(int i=0;i<cols;i++)
//				{
//					colName[i] = rsmd.getColumnName(i+1);
//						
//				}
//				
				System.out.print("\n entered else.. ..............");
				String[] c = new String[1];
				c[0]="description";
				model.setColumnIdentifiers(c);
				
				jt.setFont(f);
				jt.setBackground(Color.orange);
				
				jt.setAutoResizeMode(jt.AUTO_RESIZE_OFF);
				jt.getColumnModel().getColumn(0).setPreferredWidth(500);
				
				jt.setRowHeight(30);
				
				
				t.jp2.add(jt);
				JOptionPane.showMessageDialog(null, "Your list is empty!");
			}
		} 
		catch (SQLException e1) 
		{
			// TODO Auto-generated catch block
			System.out.print("in exception of today events : ");
			e1.printStackTrace();
		}
		
		
		
		
		
	}
	
	
	
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

}
