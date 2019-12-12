package com.mydomain.max;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

@WebServlet(name = "com.mydomain.max.MyServlet")
@MultipartConfig
public class MyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Properties properties = new Properties();
        InputStream input = getClass().getClassLoader().getResourceAsStream("settings.properties");
        properties.load(input);

        String url = "";

        String action = request.getParameter("fromPage");

        if (action.equals("page1")) {

            // Get first and last name from textboxes
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");

            // Get uploaded file
            Part file = request.getPart("fileUp");

            // Get name of uploaded file
            String fileName = file.getSubmittedFileName();

            // Create string of path to where you want to upload pic.
            //String uploadPath = "C:\\Pics";
            String uploadPath = properties.getProperty("pictureUploadPath").toString();

            System.out.println(uploadPath);

            // Create a file object for where you want to store uploaded picture.
            File uploadDir = new File(uploadPath);

            // Check if the file (folder) exists at specified path.
            if (!uploadDir.exists()) {
                // If doesn't exist, create directory.
                uploadDir.mkdir();
            }

            // Write uploaded file to specified file path with specified file name.
            file.write(uploadPath + "\\" + fileName);

            request.setAttribute("Message", "File uploaded " + fileName);

            User user = new User(firstName, lastName);

            HttpSession mySession = request.getSession(true);
            mySession.setAttribute("userSession", user);

            Cookie myCookie = new Cookie("userCookie", user.getFirstName());
            myCookie.setMaxAge(60 * 60);
            response.addCookie(myCookie);

            url = "/page2.jsp";
        }

        if (action.equals("page2")) {
            Cookie[] cookies =  request.getCookies();
            for(Cookie cookie : cookies) {
                System.out.println(cookie.getName() + " " + cookie.getValue());
            }

            url = "/index.jsp";
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
