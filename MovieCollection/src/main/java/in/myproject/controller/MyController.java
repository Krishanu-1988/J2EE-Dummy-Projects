package in.myproject.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.myproject.beans.MovieInfo;
import in.myproject.beans.UserInfo;
import in.myproject.model.DBconnection;
import in.myproject.model.FunctionalDBconnection;
/**
 * Servlet implementation class MyController
 */
public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MyController() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession userSession=request.getSession(true);
		
		if(request.getQueryString().equals("C1"))
		{
			userSession.setAttribute("admin",request.getParameter("admin").toLowerCase().trim());
			if(request.getParameter("admin").toLowerCase().trim().equals("admin") && request.getParameter("pswd").equals("@dmin@123"))
			{
				userSession.setAttribute("timeLog",DBconnection.timeLog("admin"));
				response.sendRedirect("AdminHome.jsp?Log in = successful !!");
			}
			else
			{
				userSession.setAttribute("admin", null);
				response.sendRedirect("NackAdminLogIn.jsp?Invalid adminID or password !!");
			}
		}
		
		
		if(request.getQueryString().equals("C2"))
		{
			boolean loginStatus,imgStatus;
			userSession.setAttribute("user",request.getParameter("user").toLowerCase().trim());
			loginStatus=DBconnection.authenticateUser(request.getParameter("user").toLowerCase().trim(), request.getParameter("pswd"));//Method call from model package that will connect to database and authenticate and return boolean
			if(loginStatus==true)
			{				
				UserInfo info=DBconnection.getUserInfo(userSession.getAttribute("user").toString());//Method call from model package to get values of user from the table of database
				userSession.setAttribute("f_name", info.getF_name());
				userSession.setAttribute("l_name",info.getL_name());
				userSession.setAttribute("email", info.getEmail());
				userSession.setAttribute("sex", info.getSex());
				userSession.setAttribute("dob", info.getDob());
				userSession.setAttribute("timeLog",DBconnection.timeLog(userSession.getAttribute("user").toString()));
				imgStatus=DBconnection.checkIfImage(userSession.getAttribute("user").toString());
				userSession.setAttribute("imgStatus",imgStatus);
				if(imgStatus)
				{
				userSession.setAttribute("id",userSession.getAttribute("user").toString().replaceAll("[a-zA-z]","").trim() );
				DBconnection.downLoadImg(userSession.getAttribute("user").toString()); 
				}
				response.sendRedirect("UserHome.jsp?Log in = Successful !!");
			}
			else
			{
				userSession.setAttribute("user", null);
				response.sendRedirect("NackUserLogIn.jsp?Invalid userID or password !!");
			}
		}
		
		
		if(request.getQueryString().equals("C3"))
		{
			boolean updateStatus;
			UserInfo info=new UserInfo();
			info.setF_name(request.getParameter("f_name").toString().trim());
			info.setL_name(request.getParameter("l_name").toString().trim());
			info.setEmail(request.getParameter("email").toString().trim());
			info.setPassword(request.getParameter("conpswd").toString().trim());			
			info.setDob(request.getParameter("dob").toString().trim());
			info.setSex(request.getParameter("sex").toString().trim());
			updateStatus=DBconnection.insertNewUser(info);//Method call from model package to insert values in the table of database
			userSession.setAttribute("userID",info.getUserid());
			if(updateStatus)
			{
				response.sendRedirect("AckUserRegister.jsp?Registration = Successful !!");
			}
			else
			{
				response.sendRedirect("NackUserRegister.jsp?Database Not available !!");
			}
		}
		
		
		if(request.getQueryString().equals("C4"))
		{
			boolean uploadStatus,checkImg;
			checkImg=DBconnection.checkIfImage(userSession.getAttribute("user").toString());
			if(checkImg==false)
			{
				uploadStatus=DBconnection.UploadImg(request,userSession.getAttribute("user").toString());
				userSession.setAttribute("status", uploadStatus);
				if(uploadStatus==true)
				{
					userSession.setAttribute("id",userSession.getAttribute("user").toString().replaceAll("[a-zA-z]","").trim() );
					DBconnection.downLoadImg(userSession.getAttribute("user").toString()); 
					userSession.setAttribute("imgStatus","true");
					response.sendRedirect("AckChangePhoto.jsp?Image upload successful !!");
				}
				else
				{
					response.sendRedirect("NackChangePhoto.jsp?Error in image uploading !!");
				}
			}
			else
			{
				uploadStatus=DBconnection.updateImg(request, userSession.getAttribute("user").toString());
				if(uploadStatus==true)
				{
					userSession.setAttribute("id",userSession.getAttribute("user").toString().replaceAll("[a-zA-z]","").trim() );
					DBconnection.downLoadImg(userSession.getAttribute("user").toString()); 
					userSession.setAttribute("imgStatus","true");
					response.sendRedirect("AckChangePhoto.jsp?Image upload successful !!");
				}
				else
				{
					response.sendRedirect("NackChangePhoto.jsp?Error in image uploading !!");
				}
			}
		}
		
		
		if(request.getQueryString().equals("C5"))
		{
			boolean checkImg,delStatus;
			checkImg=DBconnection.checkIfImage(userSession.getAttribute("user").toString());
			if(checkImg)
			{
				delStatus=DBconnection.delImg(userSession.getAttribute("user").toString());
				if(delStatus)
				{
					userSession.setAttribute("imgStatus","false");
					response.sendRedirect("AckDelPhoto.jsp?Successfully deleted !!");
				}
				else
				{
					response.sendRedirect("NacDelPhoto.jsp?Fail to delete !!");
				}
			}
			else
			{
				response.sendRedirect("NoPhoto.jsp?No image uploaded !!");
			}
		}
		
		

		if(request.getQueryString().equals("C6"))
		{
			boolean updateStatus;
			if(request.getParameter("newEmail")!=null)
			{
				if(request.getParameter("newEmail").equals(""))
				{
					response.sendRedirect("NackEmail.jsp?Fail to update email !!");
				}
				else
				{
					updateStatus=DBconnection.updateEmail(userSession.getAttribute("user").toString(),request.getParameter("newEmail").toLowerCase());//Method call from DBconnection for update
					if(updateStatus)
					{
						UserInfo info=DBconnection.getUserInfo(userSession.getAttribute("user").toString());
						userSession.setAttribute("email", info.getEmail());
						response.sendRedirect("AckEmail.jsp?Email update successful !!");
					}
					else
					{
						response.sendRedirect("NackEmail.jsp?Fail to update email !!");
					}
				}
			}
			else
			{
				updateStatus=DBconnection.updatePswd(userSession.getAttribute("user").toString(),request.getParameter("oldpswd"),request.getParameter("connewpswd"));//Method call from DBconnection for update
				if(updateStatus)
				{
					response.sendRedirect("AckPassword.jsp?Password update successful !!");
				}
				else
				{
					response.sendRedirect("NackPassword.jsp?Password not matched!!");
				}
			}
		}
		
		
		
		if(request.getQueryString().equals("C7"))
		{
			boolean updateStatus;
			MovieInfo info=new MovieInfo();
			if(request.getParameter("movie_name").equals(""))
			{
				response.sendRedirect("AddMovie.jsp?No movie details entered !!");				
			}
			else
			{
				info.setName(request.getParameter("movie_name").toLowerCase());
				info.setLead(request.getParameter("actor").toLowerCase());
				info.setAct(request.getParameter("other_actor").toLowerCase());
				info.setDetails(request.getParameter("details").toLowerCase());
				info.setLang(request.getParameter("lang").toLowerCase());
				info.setGenre(request.getParameter("genre").toLowerCase());
				info.setRating(request.getParameter("rating").toLowerCase());
				userSession.setAttribute("movie_name",info.getName());
				updateStatus=FunctionalDBconnection.addMovieData(info);  //Method calling from DBControl class
				if(updateStatus)
				{
					response.sendRedirect("AddMovieImage.jsp?Movie details added successfully !!");
				}
				else
				{
					response.sendRedirect("AddMovie.jsp?Database error or movie already exists !!");
				}
			}
		}
		
		
		if(request.getQueryString().equals("C8"))
		{
			boolean uploadStatus;
				uploadStatus=FunctionalDBconnection.addMovieImg(request,userSession.getAttribute("movie_name").toString());
				if(uploadStatus)
				{
					response.sendRedirect("AdminHome.jsp?Image added successfully !!");
				}
				else
				{
					response.sendRedirect("AddMovieImage.jsp?Error in image uploading!!");
				}
		}
		
		
		if(request.getQueryString().equals("C9"))				//For checking the movie is available or not for rating
		{
			boolean availableStatus;
			if(request.getParameter("movie_name").toString().equals(""))
			{
				response.sendRedirect("AdminHome.jsp?No movie typed !!");				
			}
			else
			{
				userSession.setAttribute("temp_movie_name",request.getParameter("movie_name"));
				availableStatus=FunctionalDBconnection.checkMovie(request.getParameter("movie_name"));
				if(availableStatus)
				{
					response.sendRedirect("RateMovie-2.jsp?Movie selected successfully !!");
				}
				else
				{
					response.sendRedirect("AdminHome.jsp?Movie not present or Database error !!");
				}
			}
		}
		
		
		if(request.getQueryString().equals("C10"))				
		{
			boolean ratingStatus;
			
			ratingStatus=FunctionalDBconnection.rateMovie(userSession.getAttribute("temp_movie_name").toString(),request.getParameter("rating"));
			if(ratingStatus)
			{
				response.sendRedirect("AdminHome.jsp?Movie rating successful !!");
			}
			else
			{
				response.sendRedirect("AdminHome.jsp?Database error !!");
			}
		}
		
		

		if(request.getQueryString().equals("C11"))				//For checking the movie is available or not for update
		{
			boolean availableStatus;
			if(request.getParameter("movie_name").toString().equals(""))
			{
				response.sendRedirect("AdminHome.jsp?No movie typed !!");				
			}
			else
			{
				userSession.setAttribute("temp_movie_name",request.getParameter("movie_name"));
				availableStatus=FunctionalDBconnection.checkMovie(request.getParameter("movie_name"));
				if(availableStatus)
				{
					response.sendRedirect("UpdateMovie-2.jsp?Movie selected successfully !!");
				}
				else
				{
					response.sendRedirect("AdminHome.jsp?Movie not present or Database error !!");
				}
			}
		}
		
		
		if(request.getQueryString().equals("C12"))		//Javascript validation needed for empty text box in the corresponding JSP		
		{
			boolean updateStatus;
			MovieInfo info=new MovieInfo();
			info.setName(userSession.getAttribute("temp_movie_name").toString().toLowerCase());
			info.setLead(request.getParameter("actor").toLowerCase());
			info.setAct(request.getParameter("other_actor").toLowerCase());
			info.setDetails(request.getParameter("details").toLowerCase());
			info.setLang(request.getParameter("lang").toLowerCase());
			info.setGenre(request.getParameter("genre").toLowerCase());
			info.setMovie_path(request.getParameter("file").toLowerCase());
			updateStatus=FunctionalDBconnection.updateMovie(info);
			if(updateStatus)
			{
				response.sendRedirect("AdminHome.jsp?Movie updated successfully !!");
			}
			else
			{
				response.sendRedirect("AdminHome.jsp?Database error !!");
			}
		}
		
		
		if(request.getQueryString().equals("C13"))
		{
			boolean updateStatus;
			updateStatus=FunctionalDBconnection.updateMovieCover(request,userSession.getAttribute("temp_movie_name").toString().toLowerCase());
			if(updateStatus)
			{
				response.sendRedirect("AdminHome.jsp?Movie cover updated successfully !!");
			}
			else
			{
				response.sendRedirect("AdminHome.jsp?No movie cover selected or Database error !!");
			}
			
		}
		
		
		if(request.getQueryString().equals("C14"))
		{
			boolean delStatus;
			if(request.getParameter("movie_name").toString().equals(""))
			{
				response.sendRedirect("AdminHome.jsp?No movie typed !!");				
			}
			else
			{
				delStatus=FunctionalDBconnection.delMovie(request.getParameter("movie_name"));
				if(delStatus)
				{
					response.sendRedirect("AdminHome.jsp?Movie deleted successfully !!");
				}
				else
				{
					response.sendRedirect("AdminHome.jsp?Movie not present or Database error !!");
				}
			}
		}
		
		
		if(request.getQueryString().equals("C15"))
		{
			boolean delStatus;
			if(request.getParameter("user").toString().equals(""))
			{
				response.sendRedirect("AdminUserControl.jsp?No user typed !!");				
			}
			else
			{
				delStatus=FunctionalDBconnection.delUser(request.getParameter("user"));
				if(delStatus)
				{
					response.sendRedirect("AdminUserControl.jsp?User deleted successfully !!");
				}
				else
				{
					response.sendRedirect("AdminUserControl.jsp?User not present or Database error !!");
				}
			}
		}
	}
}
