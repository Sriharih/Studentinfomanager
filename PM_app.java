package PJA;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;
class datas extends Frame implements ActionListener
{ 
	Label heading,year,dept,roll_no,name,sub,output;
	TextField years,Dept,Roll_no,Name,Sub;
	Button submit,clear,close;
	
	String qry="";
	Connection con=null;
	PreparedStatement st=null;
	ResultSet rs=null;
	Statement stmt=null;
	
	
	//CODE FOR CLEAR
	public void clear()
	{
		years.setText("");
		Dept.setText("");
		Roll_no.setText("");
		Name.setText("");
		Sub.setText("");
		years.requestFocus();
	}

	//DATABASE CONNECTION
	public void connect()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/project_mgnt_app?characterEncoding=utf8";
			String username="root";
			String password="T0ny5tark@123";
			con=DriverManager.getConnection(url,username,password);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	datas()
	{
		connect();
		Font titlefont = new Font("arial",Font.BOLD,25);
		//HEADING CODE
		heading=new Label("PROJECT MGNT SYSTEM");
		heading.setForeground(Color.RED);
		heading.setFont(titlefont);
	    heading.setBounds(250, 100, 350, 50);
		add(heading);
		
		//YEAR LABEL CODE
		year=new Label("YEAR");
		year.setBounds(250, 200, 150, 30);
		year.setFont(titlefont);
		add(year);
		
		//YEAR TEXT FIELD CODE
		years=new TextField("");
		years.setBounds(400, 200, 300, 30);
		years.setBackground(Color.YELLOW);
		add(years);
		
		//DEPT LABEL CODE
		dept=new Label("DEPT");
		dept.setBounds(250, 300, 150, 30);
		dept.setFont(titlefont);
		add(dept);
		
		//DEPT TEXT FIELD CODE
		Dept=new TextField("");
		Dept.setBounds(400, 300, 300, 30);
		Dept.setBackground(Color.YELLOW);
		add(Dept);
		
		//ROLL NO LABEL CODE
		roll_no=new Label("ROLL NO");
		roll_no.setBounds(250, 400, 150, 30);
		roll_no.setFont(titlefont);
		add(roll_no);
		
		//ROLL NO TEXT FIELD CODE
		Roll_no=new TextField("");
		Roll_no.setBounds(400, 400, 300, 30);
		Roll_no.setBackground(Color.YELLOW);
		add(Roll_no);
		
		//NAME LABEL CODE
		name=new Label("NAME");
	    name.setBounds(250, 500, 150, 30);
		name.setFont(titlefont);
		add(name);
		
		//NAME TEXT FIELD CODE
		Name=new TextField("");
		Name.setBounds(400, 500, 300, 30);
		Name.setBackground(Color.YELLOW);
		add(Name);
		
		//SUB LABEL CODE
		sub=new Label("SUB");
	    sub.setBounds(250, 600, 150, 30);
		sub.setFont(titlefont);
		add(sub);
		
		//SUB TEXTFIELD
        Sub=new TextField("");
        Sub.setBounds(400, 600, 300, 30);
        Sub.setBackground(Color.YELLOW);
		add(Sub);
		
		//BUTTON CODE
		submit=new Button("SUBMIT");
		submit.setBounds(420, 650, 150, 30);
		submit.setBackground(Color.lightGray);
		submit.addActionListener(this);
		add(submit);
		
		//CLEAR BUTTON
		clear=new Button("CLEAR");
		clear.setBounds(240, 650, 150, 30);
		clear.setBackground(Color.lightGray);
		clear.addActionListener(this);
		add(clear);
		
		//CLOSE BUTTON
		close=new Button("CLOSE");
		close.setBounds(600, 650, 150, 30);
		close.setBackground(Color.lightGray);
		close.addActionListener(this);
		add(close);
		
		//OUTPUT LABEL CODE
		output=new Label("____________");
		output.setBounds(520, 700, 350, 50);
		output.setForeground(Color.GREEN);
		output.setFont(titlefont);
		add(output);
		
		setLayout(null);
		setBackground(Color.CYAN);
		setVisible(true);
		setSize(800,800);
		//WINDOW CLOSING
		this.addWindowListener((WindowListener) new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String year=years.getText();
		String dept=Dept.getText();
		String roll_no=Roll_no.getText();
		String name=Name.getText();
		String sub=Sub.getText();
		try {
			if(e.getSource().equals(clear))
			{
				clear();
				output.setText("");
			}
			else if(e.getSource().equals(close))
			{
				System.exit(0);
			}
			else if(e.getSource().equals(submit))
			{
		
				//output.setText("RESPONSE NOTED");
				if(year.isEmpty()||year.equals(""))
				{
				
					output.setText("enter datas");
				
				}
			    else
			    {
			    	qry="insert into details(year,dept,roll_no,name,sub) values(?,?,?,?,?)";
				
			    	st=con.prepareStatement(qry);
			    	st.setString(1,year);
			    	st.setString(2,dept);
			    	st.setString(3,roll_no);
			    	st.setString(4,name);
			    	st.setString(5,sub);
					st.executeUpdate();
					clear();
			
					output.setText("RESPONSE NOTED");
			    }
			}
			else
			{
				output.setText("wrong datas");
			}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
	}
}
public class PM_app {

	public static void main(String[] args) {
		datas da=new datas();

	}

}
