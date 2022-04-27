package in.myproject.model;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import in.myproject.beans.UserInfo;

public class DBconnection { 
	
	public static Connection connect()
	{
		Connection con=null;
		try {
//			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//			String filename = "C:\\Users\\Krishanu\\Downloads\\Test.mdb";
//			String database = "jdbc:ucanaccess://" + filename;
//		    con = DriverManager.getConnection( database);
		    Class.forName("org.postgresql.Driver");
			String database = "jdbc:postgresql://localhost:5432/moviesdb";
		    con = DriverManager.getConnection( database, "moviesdbuser", "MyDB123");
		    con.setAutoCommit(false);
		    return con;
			}
		    catch (Exception e) {
		     System.out.println(e);
		      return null;
		    }
		    
	}
	
	public static boolean authenticateUser(String userid,String userpwd)
	{
			int id=0;
			Connection con=connect();
			Statement s;
			String userStr,idStr,password=null,user=null;
			userStr=userid.replaceAll("[0-9]","").trim().toLowerCase();			
			idStr=userid.replaceAll("[a-zA-z]","").trim();
			try {
				s = con.createStatement();
				s.executeQuery("SELECT username, id, password FROM UserData WHERE username='"+userStr+"' AND id="+Integer.parseInt(idStr)+""); 
			   
				ResultSet rs = s.getResultSet(); 
			    	while ( rs.next() ) 
			    	{
			    		user=rs.getString(1);
			    		id=rs.getInt(2);
			    		password=rs.getString(3);
			    	}
			    s.close(); 
			    con.close();
			    if(userid.equalsIgnoreCase((user+id).trim()) && userpwd.equals(password))
			    {
			    return true;
			    }
			    else
			    	return false;
			    
			} catch (Exception e){
				System.out.println(e);
				return false;
			} 
	}
	
	public static boolean insertNewUser(UserInfo info)
	{
		Connection con=connect();
		Statement s;
		String userid;
		int id =(int)(Math.random()*1000);
		String userStr=info.getF_name(),user;
		if(userStr.length()>5)
		{
			user=userStr.substring(0,5).toLowerCase().trim();
		}
		else
			user=userStr.toLowerCase().trim();
		try
		{
			s=con.createStatement();
			s.executeUpdate("INSERT INTO UserData (username,id,password,f_name,l_name,email_id,sex,dob) VALUES('"+user+"',"+id+",'"+info.getPassword()+"','"+info.getF_name()+"','"+info.getL_name()+"','"+info.getEmail()+"','"+info.getSex()+"','"+info.getDob()+"')");
			ResultSet rs=s.executeQuery("SELECT username,id FROM UserData WHERE id="+id+"");
			while(rs.next())
			{
				userid=rs.getString(1).toString().trim()+Integer.valueOf(rs.getInt(2)).toString().trim();
				info.setUserid(userid);
			}
			con.commit();
			s.close();
			con.close();
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}
	
	
	public static UserInfo getUserInfo(String userid)
	{
		Statement s=null;
		ResultSet rs=null;
		Connection con=connect();
		UserInfo info=new UserInfo();
		int id=Integer.parseInt(userid.replaceAll("[a-zA-z]","").trim());
		try
		{
			s=con.createStatement();
			s.executeQuery("SELECT f_name,l_name,email_id,sex,dob FROM UserData WHERE id="+id+"");
			rs=s.getResultSet();
			while(rs.next())
			{
				info.setF_name(rs.getString("f_name"));
				info.setL_name(rs.getString("l_name"));
				info.setEmail(rs.getString("email_id"));
				info.setSex(rs.getString("sex"));
				info.setDob(rs.getString("dob"));
			}
			con.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return info;
	}
	
	
	public static boolean updateEmail(String userid,String newEmail)
	{
		PreparedStatement ps=null;
		Connection con=connect();
		int id=Integer.parseInt(userid.replaceAll("[a-zA-z]","").trim());
		try
		{
			ps=con.prepareStatement("UPDATE UserData SET email_id=? WHERE id=?");
			ps.setString(1,newEmail);
			ps.setInt(2,id);
			ps.executeUpdate();
			con.commit();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	
	public static boolean updatePswd(String userid,String oldpswd,String newpswd)
	{
		PreparedStatement ps=null;
		ResultSet rs=null;
		String prevpswd=null;
		Connection con=connect();
		int id=Integer.parseInt(userid.replaceAll("[a-zA-z]","").trim());
		try
		{
			ps=con.prepareStatement("SELECT password FROM UserData WHERE id=?");
			ps.setInt(1,id);
			rs=ps.executeQuery();
			while(rs.next())
			{
				prevpswd=rs.getString("password");
			}
			if(prevpswd.equals(oldpswd))
			{
			ps=con.prepareStatement("UPDATE UserData SET password=? WHERE id=?");
			ps.setString(1,newpswd);
			ps.setInt(2,id);
			ps.executeUpdate();
			con.commit();
			con.close();
			return true;
			}
			else
			{
				con.commit();
				con.close();
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	
	
	public static boolean UploadImg( HttpServletRequest request,String userid) 
	{		
		byte[] dataBytes;
		String saveFile="";
		Connection con=connect();
		String contentType = request.getContentType();
		int id=Integer.parseInt(userid.replaceAll("[a-zA-z]","").trim());
		int status = 0,boundaryLocation=0,startPos=0,endPos=0,pos=0,lastIndex=0,formDataLength=0,byteRead=0, totalBytesRead=0;
				if ((contentType != null) && (contentType.indexOf("multipart/form-data") >= 0))
		{
			try{
					DataInputStream in = new DataInputStream(request.getInputStream());
					formDataLength = request.getContentLength();
					dataBytes = new byte[formDataLength];
					byteRead = 0;
					totalBytesRead = 0;
					while (totalBytesRead < formDataLength) 
					{
						byteRead = in.read(dataBytes, totalBytesRead,formDataLength);
						totalBytesRead += byteRead;
					}
					String file = new String(dataBytes);
					saveFile = file.substring(file.indexOf("filename=\"") + 10);
					saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
					saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1,saveFile.indexOf("\""));
					lastIndex = contentType.lastIndexOf("=");
					String boundary = contentType.substring(lastIndex + 1,contentType.length());
					pos = file.indexOf("filename=\"");
					pos = file.indexOf("\n", pos) + 1;
					pos = file.indexOf("\n", pos) + 1;
					pos = file.indexOf("\n", pos) + 1;
					boundaryLocation = file.indexOf(boundary, pos) - 4;
					startPos = ((file.substring(0, pos)).getBytes()).length;
					endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;
					File f1 = new File(saveFile);
					FileOutputStream fileOut = new FileOutputStream(f1);
					fileOut.write(dataBytes, startPos, (endPos - startPos));
					fileOut.flush();
					fileOut.close();
					FileInputStream fis = null;
					PreparedStatement ps;
					File f2 = new File(saveFile);
					ps = con.prepareStatement("INSERT INTO UserImage(id,image) VALUES(?,?)");
					fis = new FileInputStream(f2);
					ps.setBinaryStream(2, (InputStream)fis, (int)(f2.length()));
					ps.setInt(1,id);
					status = ps.executeUpdate();
					con.commit();
					con.close();
				}
				catch(Exception e)
				{
					System.out.println(e);
					e.printStackTrace();
					return false;
				}
			}
		if(status>0)
		   	{
		   		return true;
		   	}
		   	else
		   	{
		   		return false;
		   	}
	}
	
	
	public static void downLoadImg(String userid) 
	{
		int id=Integer.parseInt(userid.replaceAll("[a-zA-z]","").trim());
		Connection con=connect();
		PreparedStatement pst = null;
		ResultSet rs=null;
		FileOutputStream fileOut;
		InputStream is=null;
		try
		{
			pst=con.prepareStatement("SELECT image FROM UserImage WHERE id=?");
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(rs.next())
			{
				byte[] byteArray= new byte[1048576];
				is=rs.getBinaryStream(1);
				while((is.read(byteArray))!= -1 )
				{
					fileOut=new FileOutputStream("D:\\My Works\\Development\\Workspaces\\eclipse-workspace\\MovieCollection\\src\\main\\webapp\\Temp\\"+id+".jpg");
					fileOut.write(byteArray);
					fileOut.close();
				}
			}
			con.close();
			
		}catch(Exception e)
		{
			System.out.println("Here");
			System.out.println(e);
		}
	}
	
	
	
	public static boolean checkIfImage(String userid)
	{
		boolean bool = false;
		int id=Integer.parseInt(userid.replaceAll("[a-zA-z]","").trim());
		Connection con=connect();
		Statement s=null;
		ResultSet rs=null;
		try
		{
			s=con.createStatement();
			rs=s.executeQuery("SELECT id FROM UserImage WHERE id="+id+"");
			if(rs.next())
			{
				bool=true;
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
			bool=false;
		}
		return bool;
	}
	
	
	
	public static boolean updateImg(HttpServletRequest request,String userid) 
	{
		byte[] dataBytes;
		String saveFile="";
		Connection con=connect();
		String contentType = request.getContentType();
		int id=Integer.parseInt(userid.replaceAll("[a-zA-z]","").trim());
		int status = 0,boundaryLocation=0,startPos=0,endPos=0,pos=0,lastIndex=0,formDataLength=0,byteRead=0, totalBytesRead=0;
				if ((contentType != null) && (contentType.indexOf("multipart/form-data") >= 0))
		{
			try{
					DataInputStream in = new DataInputStream(request.getInputStream());
					formDataLength = request.getContentLength();
					dataBytes = new byte[formDataLength];
					byteRead = 0;
					totalBytesRead = 0;
					while (totalBytesRead < formDataLength) 
					{
						byteRead = in.read(dataBytes, totalBytesRead,formDataLength);
						totalBytesRead += byteRead;
					}
					String file = new String(dataBytes);
					saveFile = file.substring(file.indexOf("filename=\"") + 10);
					saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
					saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1,saveFile.indexOf("\""));
					lastIndex = contentType.lastIndexOf("=");
					String boundary = contentType.substring(lastIndex + 1,contentType.length());
					pos = file.indexOf("filename=\"");
					pos = file.indexOf("\n", pos) + 1;
					pos = file.indexOf("\n", pos) + 1;
					pos = file.indexOf("\n", pos) + 1;
					boundaryLocation = file.indexOf(boundary, pos) - 4;
					startPos = ((file.substring(0, pos)).getBytes()).length;
					endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;
					File f1 = new File(saveFile);
					FileOutputStream fileOut = new FileOutputStream(f1);
					fileOut.write(dataBytes, startPos, (endPos - startPos));
					fileOut.flush();
					fileOut.close();
					FileInputStream fis = null;
					PreparedStatement ps;
					File f2 = new File(saveFile);
					ps = con.prepareStatement("UPDATE UserImage SET image=? WHERE id=?");
					fis = new FileInputStream(f2);
					ps.setBinaryStream(1, (InputStream)fis, (int)(f2.length()));
					ps.setInt(2,id);
					status = ps.executeUpdate();
					con.commit();
					con.close();
				}
				catch(Exception e)
				{
					System.out.println(e);
					return false;
				}
			}
		if(status>0)
		   	{
		   		return true;
		   	}
		   	else
		   	{
		   		return false;
		   	}
	}
	
	
	public static boolean delImg(String userid)
	{
		boolean bool = false;
		int id=Integer.parseInt(userid.replaceAll("[a-zA-z]","").trim());
		Connection con=connect();
		Statement s=null;
		try
		{
			s=con.createStatement();
			s.execute("DELETE FROM UserImage WHERE id="+id+"");
			bool=true;
			con.commit();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
			bool=false;
		}
		return bool;
	}
	
	
	public static String timeLog(String userid)
	{
		String currentTime,previousTime=null,lastLogin=null;
		Calendar cal = Calendar.getInstance();
		currentTime=cal.getTime().toString(); 
		Connection con=connect();
		Statement s;
		ResultSet rs;
		try
		{
			s=con.createStatement();
			rs=s.executeQuery("SELECT lastlogin FROM TimeLog WHERE userid='"+userid+"'");
			while(rs.next())
			{
				lastLogin=rs.getString("lastlogin");
			}
			}catch(Exception e)
			{
				System.out.println(e);
			}
		previousTime=currentTime;
		try
		{
			if(lastLogin==null)
			{
			s=con.createStatement();
			s.executeUpdate("INSERT INTO TimeLog VALUES ('"+userid+"','"+currentTime+"')");
			lastLogin="!! First Time Login !!";
			con.commit();
			s.close();
			con.close();
			}
			else
			{
				s=con.createStatement();
				s.executeUpdate("UPDATE TimeLog SET lastLogin = '"+previousTime+"' WHERE userid = '"+userid+"'");
				con.commit();
				s.close();
				con.close();
			}
			
			return lastLogin;
		}
	catch(Exception e)
		{
		System.out.println(e);
			return null;
		}
	}
	
	
	//public static void main(String[] args)
	//{
		
	//}
}

