package in.myproject.model;


import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSet;
//import java.sql.Statement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import in.myproject.beans.MovieInfo;

public class FunctionalDBconnection {
	public static Connection con;
	public static boolean addMovieData(MovieInfo info)
	{
		PreparedStatement ps=null;
		con=DBconnection.connect();
		try
		{
			ps=con.prepareStatement("INSERT INTO MovieData (name,lead_actor,other_actor,details,genre,rating,language) VALUES(?,?,?,?,?,?,?)");
			ps.setString(1,info.getName().toLowerCase());
			ps.setString(2,info.getLead());
			ps.setString(3,info.getAct());
			ps.setString(4,info.getDetails());
			ps.setString(5,info.getGenre());
			ps.setString(6,info.getRating());			
			ps.setString(7,info.getLang());
			ps.executeUpdate();
			con.commit();
			con.close();
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}		
	}
	
	
	public static boolean addMovieImg(HttpServletRequest request,String name)
	{
		byte[] dataBytes;
		String saveFile="";
		con=DBconnection.connect();
		String contentType = request.getContentType();
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
					ps = con.prepareStatement("INSERT INTO MovieImage(name,image) VALUES(?,?)");
					fis = new FileInputStream(f2);
					ps.setBinaryStream(2, (InputStream)fis, (int)(f2.length()));
					ps.setString(1,name.toLowerCase());
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
	
	
	/*public static boolean addMoviePath(String movie_path,String movie_name)
	{
		PreparedStatement ps=null;
		con=DBconnection.connect();
		String path=movie_path.replace("\\","/");
		try
		{
			ps=con.prepareStatement("INSERT INTO MoviePath (name,path) VALUES(?,?)");
			ps.setString(1,movie_name);
			ps.setString(2,path);
			ps.executeUpdate();
			con.commit();
			con.close();
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}	
	}*/
	
	
	public static boolean delMovie(String movie_name)
	{
		PreparedStatement ps=null;
		ResultSet rs=null;
		con=DBconnection.connect();
		try
		{
			ps=con.prepareStatement("SELECT name FROM MovieData WHERE name=(?)");
			ps.setString(1,movie_name.toLowerCase());
			rs=ps.executeQuery();
			if(rs.next())
			{
				ps=con.prepareStatement("DELETE FROM MovieImage WHERE name=(?)");
				ps.setString(1,movie_name.toLowerCase());
				ps.execute();
				ps=con.prepareStatement("DELETE FROM MovieData WHERE name=(?)");
				ps.setString(1,movie_name.toLowerCase());
				ps.execute();
				con.commit();
				con.close();
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	
	
	public static boolean checkMovie(String movie_name)
	{
		PreparedStatement ps=null;
		ResultSet rs=null;
		con=DBconnection.connect();
		try
		{
			ps=con.prepareStatement("SELECT name FROM MovieData WHERE name=(?)");
			ps.setString(1,movie_name.toLowerCase());
			rs=ps.executeQuery();
			if(rs.next())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	
	public static boolean rateMovie(String movie_name,String rating)
	{
		PreparedStatement ps=null;
		con=DBconnection.connect();
		try
		{
				ps=con.prepareStatement("UPDATE MovieData SET rating=(?) WHERE name=(?)");
				ps.setString(1,rating);
				ps.setString(2,movie_name.toLowerCase());
				ps.execute();
				con.commit();
				con.close();
				return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	
	
	public static boolean updateMovie(MovieInfo info)
	{
		PreparedStatement ps=null;
		con=DBconnection.connect();
		try
		{
			ps=con.prepareStatement("UPDATE MovieData SET lead_actor=(?),other_actor=(?),details=(?),genre=(?),language=(?) WHERE name=(?)");
			ps.setString(1,info.getLead());
			ps.setString(2,info.getAct());
			ps.setString(3,info.getDetails());
			ps.setString(4,info.getGenre());
			ps.setString(5,info.getLang());
			ps.setString(6,info.getName().toLowerCase());
			ps.execute();
			ps=con.prepareStatement("UPDATE MoviePath SET path=(?) WHERE name=(?)");
			ps.setString(1,info.getMovie_path());
			ps.setString(2,info.getName().toLowerCase());
			ps.execute();
			con.commit();
			con.close();
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	
	
	public static boolean updateMovieCover(HttpServletRequest request,String movie_name) 
	{
		byte[] dataBytes;
		String saveFile="";
		Connection con=DBconnection.connect();
		String contentType = request.getContentType();
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
					ps = con.prepareStatement("UPDATE MovieImage SET image=? WHERE name=?");
					fis = new FileInputStream(f2);
					ps.setBinaryStream(1, (InputStream)fis, (int)(f2.length()));
					ps.setString(2,movie_name.toLowerCase());
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
	
	
	public static boolean delUser(String user)
	{
		PreparedStatement ps=null;
		ResultSet rs=null;
		String userStr,idStr;
		con=DBconnection.connect();
		userStr=user.replaceAll("[0-9]","").trim().toLowerCase();			
		idStr=user.replaceAll("[a-zA-z]","").trim();
		try
		{
			ps=con.prepareStatement("SELECT username FROM UserData WHERE id=(?) AND username=(?)");
			ps.setInt(1,Integer.parseInt(idStr));
			ps.setString(2,userStr);
			rs=ps.executeQuery();
			if(rs.next())
			{
				ps=con.prepareStatement("DELETE FROM UserData WHERE id=(?) AND username=(?)");
				ps.setInt(1,Integer.parseInt(idStr));
				ps.setString(2,userStr);
				ps.execute();
	
				ps=con.prepareStatement("DELETE FROM UserImage WHERE id=(?)");
				ps.setInt(1,Integer.parseInt(idStr));
				ps.execute();
				con.commit();
				con.close();
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		} 
	}
	

}
