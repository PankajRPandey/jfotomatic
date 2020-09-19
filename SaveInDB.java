import java.io.File;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.util.Enumeration;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class SaveInDB extends JFrame
{

JButton b,s,insert;
JTextField t;
JLabel lb;
Container c;
final JFileChooser fc = new JFileChooser("d:");//user's default directory
  String getPicture;
File dialog;
  	public SaveInDB(String titleText)
	{
		super(titleText);
		setLayout(null);
fc.setAccessory(new ImagePreview(fc));
		b=new JButton("Get Image");
		insert=new JButton("Insert In DB");
		s=new JButton("Browse An Image");
		t=new JTextField();
		t.setBounds(150,600,80,30);
		b.setBounds(240,600, 120, 30);
		insert.setBounds(370,600,120,30);
		s.setBounds(550,600, 150, 30);
		JLabel lbltxt=new JLabel("Image ID:");
		lbltxt.setBounds(90,600,80,30);

		lb=new JLabel();

		lb.setBounds(100,50,600,500);

		c=getContentPane();
		c.add(lb);
		c.add(s);
		c.add(lbltxt);
		c.add(t);
		c.add(b);
		c.add(insert);

		lb.setBorder(BorderFactory.createTitledBorder(""));
		b.addActionListener(new getset());
		insert.addActionListener(new insert());

		s.addActionListener(new ActionListener() {

            		public void actionPerformed(ActionEvent e)
            		{
               
              			openFile();
               			lb.removeAll();
            		}
        		});
		setVisible(true);
		int width=800;int height=665;
        		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
        		int x=(screen.width-width)/2;
        		int y=(screen.height-height)/2;
        		setBounds(x,y,width,height);

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

	}




	class getset implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
  			Connection con = null;
			ResultSet rs = null;
			PreparedStatement psmnt = null;
			FileInputStream fis;
			try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
				con = DriverManager.getConnection("jdbc:odbc:java","scott","tiger");

				PreparedStatement ps = con.prepareStatement("select * from images where id=?");
				ps.setString(1, t.getText());
				ResultSet rs1 = ps.executeQuery();


        				String imgLen="";
        				if(rs1.next())
        				{ String h=rs1.getString(1);
            					imgLen = rs1.getString(2);
        				}
 				ps = con.prepareStatement("select img from images where id=?");
				ps.setString(1, t.getText());
 				rs1 = ps.executeQuery();


       				 if(rs1.next())
        				{
            					int len = imgLen.length();
            					byte [] rb = new byte[len];
            					InputStream readImg = rs1.getBinaryStream(1);
            					int index=readImg.read(rb, 0, len);
            					ImageIcon i=new ImageIcon(rb, imgLen);
            					lb.setIcon(i);
            					ps.close();
            					lb.setIcon(i);
       				}

			}
			catch (Exception ex) {
				System.out.println("Found some error : "+ex);
			}

		}
	}

//----------------------------------BROWSE IMAGE-----------------------------------------
	private void openFile()
	{
      		int returnVal = fc.showOpenDialog(SaveInDB.this);
        		if (returnVal == JFileChooser.APPROVE_OPTION)
        		{
		 	dialog= fc.getSelectedFile();
			getPicture = dialog.getPath();
			lb.setIcon(new ImageIcon(getPicture));
        		}
	}
/*--------------------------------------------------------------------------------------------*/
	class insert implements ActionListener
	{
   		public void actionPerformed(ActionEvent e)
   		{
    			Connection connection = null;
			ResultSet rs = null;
			PreparedStatement psmnt = null;
			FileInputStream fis;
			try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
				connection = 				DriverManager.getConnection("jdbc:odbc:java","scott","tiger");
			psmnt = connection.prepareStatement("insert into images values(?,?)");
				psmnt.setString(1,t.getText());
				fis = new FileInputStream(dialog);
				psmnt.setBinaryStream(2, (InputStream)fis, (int)(dialog.length()));
				int s = psmnt.executeUpdate();
				if(s>0) {
    				JOptionPane.showMessageDialog(null,"Image Uploaded successfully !","Image Inserted" ,1);
				System.out.println("Uploaded successfully !");
				}
				else {
		JOptionPane.showMessageDialog(null,"Image Upload Failed","Error",JOptionPane.ERROR_MESSAGE);
				System.out.println("Failed to upload image.");
				}
			}
			catch (Exception ex) {
				System.out.println("Found some error : "+ex);
			}


   		}
	}

}

