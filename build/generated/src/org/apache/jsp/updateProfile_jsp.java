package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public final class updateProfile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/footer.jsp");
  }

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
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Update Profile</title>\n");
      out.write("   <link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\n");
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
      out.write("                <li><a href=\"dashboard.jsp\">Dashboard</a></li>\n");
      out.write("                <li><a href=\"logout.jsp\">Logout</a></li>\n");
      out.write("            </ul>\n");
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
      out.write("\n");
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <h2>Update Profile</h2>\n");
      out.write("\n");
      out.write("        ");

            // Ensure the user is logged in
            String userIdStr = request.getParameter("userId");
            Integer userId = null;

            if (userIdStr != null) {
                try {
                    userId = Integer.parseInt(userIdStr);
                } catch (NumberFormatException e) {
                    out.println("<div class='alert alert-danger'>Invalid user ID format.</div>");
                    return;
                }
            }

            if (userId == null) {
                response.sendRedirect("login.jsp");
                return;
            }

            Connection con = null;
            PreparedStatement ps = null;

            try {
                String url = "jdbc:derby://localhost:1527/Intern";
                String dbUsername = "intern"; 
                String dbPassword = "intern123"; 

                Class.forName("org.apache.derby.jdbc.ClientDriver");
                con = DriverManager.getConnection(url, dbUsername, dbPassword);
                
                // Retrieve form data
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String course = request.getParameter("course");
                String branch = request.getParameter("branch");
                String phoneNumber = request.getParameter("phoneNumber");
                String collegeName = request.getParameter("collegeName");
                String academicPassoutYear = request.getParameter("academicPassoutYear");
                String cgpa = request.getParameter("cgpa");
                String currentYear = request.getParameter("currentYear");

                // Update user details in the database
                String updateQuery = "UPDATE Users SET Username=?, email=?, course=?, branch=?, phone_number=?, college_name=?, passout_year=?, cgpa=?, current_year=? WHERE id=?";
                ps = con.prepareStatement(updateQuery);
                ps.setString(1, name);
                ps.setString(2, email);
                ps.setString(3, course);
                ps.setString(4, branch);
                ps.setString(5, phoneNumber);
                ps.setString(6, collegeName);
                ps.setString(7, academicPassoutYear);
                ps.setString(8, cgpa);
                ps.setString(9, currentYear);
                ps.setInt(10, userId);

                int rowsUpdated = ps.executeUpdate();

                if (rowsUpdated > 0) {
                    out.println("<div class='alert alert-success'>Profile updated successfully!</div>");
                    out.println("<a href='profile.jsp'>Go back to Profile</a>");
                } else {
                    out.println("<div class='alert alert-danger'>No changes were made to the profile.</div>");
                    out.println("<a href='profile.jsp'>Go back to Profile</a>");
                }

            } catch (SQLException e) {
                e.printStackTrace();
                out.println("<div class='alert alert-danger'>Database Error: " + e.getMessage() + "</div>");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                out.println("<div class='alert alert-danger'>JDBC Driver not found.</div>");
            } catch (Exception e) {
                e.printStackTrace();
                out.println("<div class='alert alert-danger'>Error: " + e.getMessage() + "</div>");
            } finally {
                try { if (ps != null) ps.close(); } catch (SQLException e) { e.printStackTrace(); }
                try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        
      out.write("\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <footer>\n");
      out.write("        <p>&copy; 2024 Internship Management System</p>\n");
      out.write("    </footer>\n");
      out.write("\n");
      out.write("    ");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <link rel=\"stylesheet\" href=\"styles.css\"> \n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("   \n");
      out.write("    <footer>\n");
      out.write("        <p>&copy; 2024 Internship Management System. All rights reserved.</p>\n");
      out.write("    </footer>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
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
