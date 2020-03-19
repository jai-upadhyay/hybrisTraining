package org.nagarro.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.hibernate.Session;
import org.nagarro.hibernate.entity.Images;
import org.nagarro.hibernate.service.DatabaseService;
import org.nagarro.hibernate.service.ProcessImage;

import antlr.collections.List;

/**
 * Servlet implementation class UploadImage
 */
@WebServlet(description = "Servlet to upload Image", urlPatterns = { "/UploadImage" })
@MultipartConfig
public class UploadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadImage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		InputStream inputStream = null;
		String name;
		long size;
		int userId = (int)request.getSession(true).getAttribute("LoggedInUser"); //toberefractored
		InputStream photo;
		DatabaseService db;
		Part filePart = null;
		try {
			filePart = request.getPart("image");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		
		 if (filePart != null) {
			 // prints out some information for debugging
			name = filePart.getName();
			size = filePart.getSize();
			photo = filePart.getInputStream();
			byte[] imageData = new byte[(int) size];
			photo.read(imageData);
		    System.out.println(name);
		    System.out.println(size);
		    db = new DatabaseService();
		    Images image = new Images(name, imageData, size, userId);
		    ProcessImage process = new ProcessImage();
		    boolean IsDone = process.InsertImage(image);
	        System.out.println("Transaction done");
	        if(IsDone) {
	        	response.sendRedirect("ImageUtility.jsp");
	        }
	      
	        }
		
	}

}
