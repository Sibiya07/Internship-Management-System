package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class adminLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Admin Login</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css\">\n");
      out.write("    <style>\n");
      out.write("       body {\n");
      out.write("    font-family: 'Roboto', sans-serif; /* Use a clean, modern font */\n");
      out.write("    background-image: url('images/dd.jpeg.jpg'); /* Your background image */\n");
      out.write("    background-size: cover; /* Ensures the image covers the entire background */\n");
      out.write("    background-position: center; /* Centers the image */\n");
      out.write("    background-repeat: no-repeat; /* Prevents the image from repeating */\n");
      out.write("    margin: 0;\n");
      out.write("    padding: 0;\n");
      out.write("    display: flex;\n");
      out.write("    justify-content: center;\n");
      out.write("    align-items: center;\n");
      out.write("    height: 100vh; /* Ensures full screen height */\n");
      out.write("    filter: brightness(0.85); /* Slightly darkens the image for better contrast with text */\n");
      out.write("}\n");
      out.write("\n");
      out.write(".container {\n");
      out.write("    max-width: 400px; /* Set a max width for the login form */\n");
      out.write("    background-color: rgba(255, 255, 255, 0.9); /* Semi-transparent background for the form */\n");
      out.write("    padding: 40px; /* Padding around the form */\n");
      out.write("    border-radius: 15px; /* Increased rounded corners for a modern look */\n");
      out.write("    box-shadow: 0 10px 30px rgba(0, 0, 0, 0.3); /* Larger shadow for depth */\n");
      out.write("    backdrop-filter: blur(10px); /* Optional: Adds a subtle blur for a glass effect */\n");
      out.write("    border: 1px solid rgba(255, 255, 255, 0.2); /* Light border for definition */\n");
      out.write("}\n");
      out.write("\n");
      out.write("h1 {\n");
      out.write("    color: #124E66; /* Heading color */\n");
      out.write("    text-align: center; /* Center the heading */\n");
      out.write("    margin-bottom: 30px; /* More space below the heading */\n");
      out.write("    font-size: 28px; /* Larger font size */\n");
      out.write("    font-weight: bold; /* Bold heading */\n");
      out.write("    text-transform: uppercase; /* Uppercase for emphasis */\n");
      out.write("    letter-spacing: 1px; /* Slightly spaced out letters */\n");
      out.write("}\n");
      out.write("\n");
      out.write(".form-group label {\n");
      out.write("    color: #333; /* Darker label color for contrast */\n");
      out.write("    font-weight: 600; /* Semi-bold labels */\n");
      out.write("}\n");
      out.write("\n");
      out.write(".form-group input {\n");
      out.write("    height: 45px; /* Increased height for input fields */\n");
      out.write("    font-size: 16px; /* Larger font size for inputs */\n");
      out.write("    padding: 10px; /* Padding inside the input */\n");
      out.write("    border-radius: 8px; /* Rounded corners for inputs */\n");
      out.write("    border: 1px solid #ddd; /* Light border */\n");
      out.write("    transition: border-color 0.3s ease; /* Smooth transition effect */\n");
      out.write("}\n");
      out.write("\n");
      out.write(".form-group input:focus {\n");
      out.write("    border-color: #007BFF; /* Blue border on focus */\n");
      out.write("    box-shadow: 0 0 8px rgba(0, 123, 255, 0.3); /* Subtle shadow effect on focus */\n");
      out.write("    outline: none; /* Remove default outline */\n");
      out.write("}\n");
      out.write("\n");
      out.write("button[type=\"submit\"] {\n");
      out.write("    height: 50px; /* Taller button */\n");
      out.write("    font-size: 18px; /* Larger button text */\n");
      out.write("    font-weight: bold; /* Bold button text */\n");
      out.write("    background-color: #2E3944; /* Button background color */\n");
      out.write("    color: #fff; /* White text */\n");
      out.write("    border: none; /* Remove default border */\n");
      out.write("    border-radius: 8px; /* Rounded corners */\n");
      out.write("    transition: background-color 0.3s ease, box-shadow 0.3s ease; /* Smooth transition */\n");
      out.write("}\n");
      out.write("\n");
      out.write("button[type=\"submit\"]:hover {\n");
      out.write("    background-color: #0056b3; /* Darker blue on hover */\n");
      out.write("    box-shadow: 0 5px 15px rgba(0, 91, 187, 0.5); /* Shadow on hover */\n");
      out.write("}\n");
      out.write("\n");
      out.write(".error-message {\n");
      out.write("    color: red; /* Error message color */\n");
      out.write("    text-align: center; /* Center error message */\n");
      out.write("    margin-top: 20px; /* Increased space above error message */\n");
      out.write("    font-size: 16px; /* Larger error message font */\n");
      out.write("    font-weight: bold; /* Emphasize error */\n");
      out.write("}\n");
      out.write("\n");
      out.write(".home-icon {\n");
      out.write("    position: absolute;\n");
      out.write("    left: 20px;\n");
      out.write("    top: 20px; /* Adjusted value to move the icon higher */\n");
      out.write("    font-size: 24px; /* Slightly larger icon */\n");
      out.write("    color: #ffffff; /* White text for better contrast */\n");
      out.write("    text-decoration: none;\n");
      out.write("    padding: 10px 20px; /* Larger padding for better touch target */\n");
      out.write("    background-color: #124E66; /* A blue color that matches well with white text */\n");
      out.write("    border-radius: 5px;\n");
      out.write("    transition: background-color 0.3s;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".home-icon:hover {\n");
      out.write("    background-color: #748D92; /* A darker blue for hover effect */\n");
      out.write("}\n");
      out.write("\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    \n");
      out.write("<a href=\"index.html\" class=\"home-icon\">\n");
      out.write("        <i class=\"fas fa-home\"></i>\n");
      out.write("    </a>\n");
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <h1>Admin Login</h1>\n");
      out.write("        <form method=\"post\" action=\"adminLogin.jsp\">\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label for=\"username\">Username:</label>\n");
      out.write("                <input type=\"text\" id=\"username\" name=\"username\" class=\"form-control\" required>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label for=\"password\">Password:</label>\n");
      out.write("                <input type=\"password\" id=\"password\" name=\"password\" class=\"form-control\" required>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <button type=\"submit\" class=\"btn btn-primary btn-block\">Login</button>\n");
      out.write("\n");
      out.write("            ");

                if ("POST".equalsIgnoreCase(request.getMethod())) {
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");

                    Connection con = null;
                    PreparedStatement ps = null;
                    ResultSet rs = null;

                    try {
                        // Connect to the database
                        String url = "jdbc:derby://localhost:1527/admindb";
                        String dbUsername = "admine";
                        String dbPassword = "admin123";
                        Class.forName("org.apache.derby.jdbc.ClientDriver");
                        con = DriverManager.getConnection(url, dbUsername, dbPassword);

                        // Query to check if admin credentials are valid
                        String query = "SELECT * FROM admin WHERE username = ? AND password = ?";
                        ps = con.prepareStatement(query);
                        ps.setString(1, username);
                        ps.setString(2, password);
                        rs = ps.executeQuery();

                        if (rs.next()) {
                            // Admin login successful
                            session.setAttribute("admin", username);
                            response.sendRedirect("adminDashboard.jsp");
                        } else {
                            out.println("<p class='error-message'>Invalid username or password!</p>");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        out.println("<p class='error-message'>Error: " + e.getMessage() + "</p>");
                    } finally {
                        try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
                        try { if (ps != null) ps.close(); } catch (SQLException e) { e.printStackTrace(); }
                        try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
                    }
                }
            
      out.write("\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- Include Bootstrap JS and dependencies -->\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js\"></script>\n");
      out.write("    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
