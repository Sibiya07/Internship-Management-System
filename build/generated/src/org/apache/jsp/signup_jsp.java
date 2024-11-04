package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class signup_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Sign Up - Internship Management System</title>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <style>\r\n");
      out.write("        /* Global Styles */\r\n");
      out.write("        body {\r\n");
      out.write("            font-family: 'Arial', sans-serif;\r\n");
      out.write("            background-color: #F3F4F6; /* Soft background */\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            padding: 0;\r\n");
      out.write("            color: #333; /* Standard text color */\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        /* Container Styles */\r\n");
      out.write("        .container {\r\n");
      out.write("            max-width: 700px; /* Increased width */\r\n");
      out.write("            margin: 30px auto; /* Reduced margin */\r\n");
      out.write("            padding: 15px 20px; /* Reduced padding to decrease overall height */\r\n");
      out.write("            background-color: #fff;\r\n");
      out.write("            border-radius: 10px;\r\n");
      out.write("            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Subtle shadow */\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .container h2 {\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            margin-bottom: 20px;\r\n");
      out.write("            font-size: 1.8rem;\r\n");
      out.write("            color: #0D3B66; /* Dark navy text */\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        /* Form Styles */\r\n");
      out.write("        form {\r\n");
      out.write("            display: flex;\r\n");
      out.write("            flex-direction: column;\r\n");
      out.write("            gap: 10px; /* Reduce gap between form elements */\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        label {\r\n");
      out.write("            font-size: 0.9rem;\r\n");
      out.write("            color: #555; /* Softer label color */\r\n");
      out.write("            margin-bottom: 5px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        input[type=\"text\"],\r\n");
      out.write("        input[type=\"email\"],\r\n");
      out.write("        input[type=\"password\"] {\r\n");
      out.write("            padding: 8px; /* Reduced padding inside inputs */\r\n");
      out.write("            margin-bottom: 10px; /* Reduced margin between inputs */\r\n");
      out.write("            border: 1px solid #ccc; /* Light border */\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("            font-size: 1rem;\r\n");
      out.write("            width: 100%; /* Full width inputs */\r\n");
      out.write("            box-sizing: border-box;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        input[type=\"submit\"] {\r\n");
      out.write("            background-color: navy;\r\n");
      out.write("            color: white;\r\n");
      out.write("            border: none;\r\n");
      out.write("            padding: 10px 0; /* Reduce button padding to make it shorter */\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("            font-size: 1rem;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("            transition: background-color 0.3s ease;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        input[type=\"submit\"]:hover {\r\n");
      out.write("            background-color: blue; /* Darker hover effect */\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        p {\r\n");
      out.write("            font-size: 0.9rem;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        /* Error & Success Message Styles */\r\n");
      out.write("        .message {\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            margin-top: 20px;\r\n");
      out.write("            font-size: 0.9rem;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .message.error {\r\n");
      out.write("            color: red;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .message.success {\r\n");
      out.write("            color: green;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("    <h2>Sign Up</h2>\r\n");
      out.write("    <form method=\"post\" action=\"signup.jsp\">\r\n");
      out.write("        <label for=\"username\">Username:</label>\r\n");
      out.write("        <input type=\"text\" id=\"username\" name=\"username\" required>\r\n");
      out.write("        \r\n");
      out.write("        <label for=\"email\">Email:</label>\r\n");
      out.write("        <input type=\"email\" id=\"email\" name=\"email\" required>\r\n");
      out.write("        \r\n");
      out.write("        <label for=\"password\">Password:</label>\r\n");
      out.write("        <input type=\"password\" id=\"password\" name=\"password\" required>\r\n");
      out.write("        \r\n");
      out.write("        <label for=\"confirmPassword\">Confirm Password:</label>\r\n");
      out.write("        <input type=\"password\" id=\"confirmPassword\" name=\"confirmPassword\" required>\r\n");
      out.write("        \r\n");
      out.write("        <input type=\"submit\" value=\"Sign Up\">\r\n");
      out.write("    </form>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"form-link\">\r\n");
      out.write("        <p>Already have an account? <a href=\"login.jsp\">Log in here</a>.</p>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    ");

        if ("POST".equalsIgnoreCase(request.getMethod())) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String confirmPassword = request.getParameter("confirmPassword");
            String email = request.getParameter("email");

            if (!password.equals(confirmPassword)) {
                out.println("<p class='error-message'>Passwords do not match. Please try again.</p>");
            } else {
                Connection con = null;
                PreparedStatement ps = null;

                try {
                    // Database connection
                    String url = "jdbc:derby://localhost:1527/intern";
                    String dbUsername = "intern";
                    String dbPassword = "intern123";

                    Class.forName("org.apache.derby.jdbc.ClientDriver");
                    con = DriverManager.getConnection(url, dbUsername, dbPassword);
                    
                    // Insert new user
                    ps = con.prepareStatement("INSERT INTO Users (username, password, email) VALUES (?, ?, ?)");
                    ps.setString(1, username);
                    ps.setString(2, password); // Plain text password - not secure for production!
                    ps.setString(3, email);

                    int result = ps.executeUpdate();
                    if (result > 0) {
                        out.println("<p class='success-message'>Registration successful! <a href='login.jsp'>Log in here</a>.</p>");
                    } else {
                        out.println("<p class='error-message'>Registration failed. Please try again.</p>");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    out.println("<p class='error-message'>Error: " + e.getMessage() + "</p>");
                } finally {
                    try { if (ps != null) ps.close(); } catch (SQLException e) { e.printStackTrace(); }
                    try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
                }
            }
        }
    
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
