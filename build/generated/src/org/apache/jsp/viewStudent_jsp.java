package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class viewStudent_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Student Details</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <h2>Student Details</h2>\n");
      out.write("        ");

            String username = request.getParameter("username");
            if (username != null) {
                Connection con = null;
                PreparedStatement ps = null;
                ResultSet rs = null;

                try {
                    // Database connection
                    String url = "jdbc:derby://localhost:1527/Intern";
                    String dbUsername = "intern";
                    String dbPassword = "intern123";
                    Class.forName("org.apache.derby.jdbc.ClientDriver");
                    con = DriverManager.getConnection(url, dbUsername, dbPassword);

                    // Query to fetch student details by username
                    String query = "SELECT u.username, u.email, u.phone_number, u.branch, u.course, u.college_name, " +
                                   "i.company_name, i.role FROM users u LEFT JOIN intern i ON u.username = i.username " +
                                   "WHERE u.username = ?";
                    ps = con.prepareStatement(query);
                    ps.setString(1, username);
                    rs = ps.executeQuery();

                    if (rs.next()) {
                        out.println("<p><strong>Username:</strong> " + rs.getString("username") + "</p>");
                        out.println("<p><strong>Email:</strong> " + rs.getString("email") + "</p>");
                        out.println("<p><strong>Phone Number:</strong> " + rs.getString("phone_number") + "</p>");
                        out.println("<p><strong>Branch:</strong> " + rs.getString("branch") + "</p>");
                        out.println("<p><strong>Course:</strong> " + rs.getString("course") + "</p>");
                        out.println("<p><strong>College Name:</strong> " + rs.getString("college_name") + "</p>");
                        out.println("<p><strong>Company Name:</strong> " + rs.getString("company_name") + "</p>");
                        out.println("<p><strong>Role:</strong> " + rs.getString("role") + "</p>");
                    } else {
                        out.println("<p>No details found for the student.</p>");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    out.println("<p>Error retrieving data: " + e.getMessage() + "</p>");
                } finally {
                    if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
                    if (ps != null) try { ps.close(); } catch (SQLException e) { e.printStackTrace(); }
                    if (con != null) try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
                }
            } else {
                out.println("<p>No student username provided.</p>");
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
