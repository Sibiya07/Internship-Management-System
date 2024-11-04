package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public final class profile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>Edit Profile</title>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css\">\n");
      out.write("    \n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <header>\n");
      out.write("        <h1>Internship Management System</h1>\n");
      out.write("        <nav>\n");
      out.write("            <ul class=\"nav-list\">\n");
      out.write("                <li><a href=\"home.jsp\">Home</a></li>\n");
      out.write("                <li><a href=\"viewInternships.jsp\">View Internships</a></li>\n");
      out.write("                <li><a href=\"addInternship.jsp\">Add Internship</a></li>\n");
      out.write("                <li><a href=\"profile.jsp\">Profile</a></li>\n");
      out.write("                <li><a href=\"dashboard.jsp\">Dashboard</a></li>\n");
      out.write("             \n");
      out.write("        </nav>\n");
      out.write("        <div class=\"profile-icon\">\n");
      out.write("            <div class=\"dropdown\">\n");
      out.write("                <i class=\"fas fa-user-circle\"></i>\n");
      out.write("                <div class=\"dropdown-content\">\n");
      out.write("                    <a href=\"profile.jsp\"><i class=\"fas fa-user\"></i> My Profile</a>\n");
      out.write("                    <a href=\"viewInternships.jsp\"><i class=\"fas fa-briefcase\"></i> View Internships</a>\n");
      out.write("                    <a href=\"addInternship.jsp\"><i class=\"fas fa-plus\"></i> Add Internship</a>\n");
      out.write("                    <a href=\"logout.jsp\"><i class=\"fas fa-sign-out-alt\"></i> Logout</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </header>\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <h2>Edit Profile</h2>\n");
      out.write("\n");
      out.write("        ");

            // Ensure the user is logged in
            String userIdStr = (String) session.getAttribute("userId");
            Integer userId = null;

            if (userIdStr != null) {
                try {
                    userId = Integer.parseInt(userIdStr);
                } catch (NumberFormatException e) {
                    out.println("<p style='color:red;'>Invalid user ID format.</p>");
                    response.sendRedirect("login.jsp");
                    return;
                }
            } else {
                response.sendRedirect("login.jsp");
                return;
            }

            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;

            try {
                String url = "jdbc:derby://localhost:1527/Intern";
                String dbUsername = "intern"; 
                String dbPassword = "intern123"; 

                Class.forName("org.apache.derby.jdbc.ClientDriver");
                con = DriverManager.getConnection(url, dbUsername, dbPassword);
                
                // Fetch user details
                ps = con.prepareStatement("SELECT * FROM Users WHERE id=?");
                ps.setInt(1, userId);
                rs = ps.executeQuery();

                String name = "";
                String email = "";
                String course = "";
                String branch = "";
                String phoneNumber = "";
                String collegeName = "";
                String academicPassoutYear = "";
                String cgpa = ""; 
                String currentYear = ""; 

                if (rs.next()) {
                    name = rs.getString("name") != null ? rs.getString("name") : "";
                    email = rs.getString("email") != null ? rs.getString("email") : "";
                    course = rs.getString("course") != null ? rs.getString("course") : "";
                    branch = rs.getString("branch") != null ? rs.getString("branch") : "";
                    phoneNumber = rs.getString("phone_number") != null ? rs.getString("phone_number") : "";
                    collegeName = rs.getString("college_name") != null ? rs.getString("college_name") : "";
                    academicPassoutYear = rs.getString("passout_year") != null ? rs.getString("passout_year") : "";
                    cgpa = rs.getString("cgpa") != null ? rs.getString("cgpa") : "";
                    currentYear = rs.getString("current_year") != null ? rs.getString("current_year") : "";
                } else {
                    out.println("<p>User not found.</p>");
                }
        
      out.write("\n");
      out.write("\n");
      out.write("        <form method=\"post\" action=\"updateProfile.jsp\">\n");
      out.write("            <input type=\"hidden\" name=\"userId\" value=\"");
      out.print( userId );
      out.write("\">\n");
      out.write("\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label for=\"name\">Name:</label>\n");
      out.write("                <input type=\"text\" id=\"name\" name=\"name\" value=\"");
      out.print( name );
      out.write("\" required>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label for=\"email\">Email:</label>\n");
      out.write("                <input type=\"email\" id=\"email\" name=\"email\" value=\"");
      out.print( email );
      out.write("\" required>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label for=\"course\">Course:</label>\n");
      out.write("                <input type=\"text\" id=\"course\" name=\"course\" value=\"");
      out.print( course );
      out.write("\" required>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label for=\"branch\">Branch:</label>\n");
      out.write("                <input type=\"text\" id=\"branch\" name=\"branch\" value=\"");
      out.print( branch );
      out.write("\" required>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label for=\"phoneNumber\">Phone Number:</label>\n");
      out.write("                <input type=\"text\" id=\"phoneNumber\" name=\"phoneNumber\" value=\"");
      out.print( phoneNumber );
      out.write("\" required>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label for=\"collegeName\">College Name:</label>\n");
      out.write("                <input type=\"text\" id=\"collegeName\" name=\"collegeName\" value=\"");
      out.print( collegeName );
      out.write("\" required>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label for=\"academicPassoutYear\">Academic Passout Year:</label>\n");
      out.write("                <input type=\"text\" id=\"academicPassoutYear\" name=\"academicPassoutYear\" value=\"");
      out.print( academicPassoutYear );
      out.write("\" required>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label for=\"cgpa\">CGPA:</label>\n");
      out.write("                <input type=\"text\" id=\"cgpa\" name=\"cgpa\" value=\"");
      out.print( cgpa );
      out.write("\" required>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label for=\"currentYear\">Current Year:</label>\n");
      out.write("                <input type=\"text\" id=\"currentYear\" name=\"currentYear\" value=\"");
      out.print( currentYear );
      out.write("\" required>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <input type=\"submit\" value=\"Update Profile\" class=\"edit-profile-button\">\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        ");

            } catch (Exception e) {
                out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
            } finally {
                if (rs != null) try { rs.close(); } catch (SQLException ignored) {}
                if (ps != null) try { ps.close(); } catch (SQLException ignored) {}
                if (con != null) try { con.close(); } catch (SQLException ignored) {}
            }
        
      out.write("\n");
      out.write("    </div>\n");
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
