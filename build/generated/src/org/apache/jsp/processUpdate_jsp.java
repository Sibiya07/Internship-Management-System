package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.io.*;

public final class processUpdate_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Process Update</title>\n");
      out.write("</head>\n");
      out.write("<style>  .back-button {\n");
      out.write("            text-align: center;\n");
      out.write("            margin-top: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .back-button a {\n");
      out.write("            display: inline-block;\n");
      out.write("            padding: 10px 20px;\n");
      out.write("            background-color: #007bff;\n");
      out.write("            color: white;\n");
      out.write("            text-decoration: none;\n");
      out.write("            border-radius: 4px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .back-button a:hover {\n");
      out.write("            background-color: #0056b3;\n");
      out.write("        }</style>\n");
      out.write("<body>\n");
      out.write("    ");

        Connection con = null;
        PreparedStatement ps = null;

        try {
            String url = "jdbc:derby://localhost:1527/Intern";
            String dbUsername = "intern";
            String dbPassword = "intern123";

            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection(url, dbUsername, dbPassword);

            String id = request.getParameter("id");
            String status = request.getParameter("status");
            String certificationLink = request.getParameter("certificationLink");

            // Update the internship
            String query = "UPDATE intern SET status = ?, certification_link = ? WHERE id = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, status);
            if ("Completed".equals(status) && (certificationLink != null && !certificationLink.isEmpty())) {
                ps.setString(2, certificationLink);
            } else {
                ps.setNull(2, Types.VARCHAR);
            }
            ps.setInt(3, Integer.parseInt(id));

            int result = ps.executeUpdate();
            if (result > 0) {
                response.sendRedirect("viewInternships.jsp?message=Internship updated successfully!");
            } else {
                out.println("<p style='color:red;'>Failed to update internship.</p>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
        } finally {
            try { if (ps != null) ps.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    
      out.write("\n");
      out.write("     <div class=\"back-button\">\n");
      out.write("            <a href=\"dashboard.jsp\">Back to Dashboard</a>\n");
      out.write("        </div>\n");
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
