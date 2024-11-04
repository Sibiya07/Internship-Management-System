package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class updateInternship_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>Update Internship</title>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\n");
      out.write("    <script>\n");
      out.write("        function toggleCertificationLink() {\n");
      out.write("            var statusSelect = document.getElementById(\"statusSelect\");\n");
      out.write("            var certificationDiv = document.getElementById(\"certificationDiv\");\n");
      out.write("            certificationDiv.style.display = statusSelect.value === \"Completed\" ? \"block\" : \"none\";\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("</head>\n");
      out.write("<style>.back-button {\n");
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
      out.write("    <h2>Update Internship Status</h2>\n");
      out.write("\n");
      out.write("    ");

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        // Check if the user is logged in
        String username = (String) session.getAttribute("username");
        if (username == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String id = request.getParameter("id");

        try {
            String url = "jdbc:derby://localhost:1527/Intern";
            String dbUsername = "intern";
            String dbPassword = "intern123";

            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection(url, dbUsername, dbPassword);

            // Fetch current internship details
            ps = con.prepareStatement("SELECT title, company_name, duration, role, status, description, certification_link FROM intern WHERE id = ?");
            ps.setInt(1, Integer.parseInt(id));
            rs = ps.executeQuery();

            if (rs.next()) {
    
      out.write("\n");
      out.write("        <form action=\"processUpdate.jsp\" method=\"post\">\n");
      out.write("            <input type=\"hidden\" name=\"id\" value=\"");
      out.print( id );
      out.write("\">\n");
      out.write("            <label>Title: ");
      out.print( rs.getString("title") );
      out.write("</label><br>\n");
      out.write("            <label>Company: ");
      out.print( rs.getString("company_name") );
      out.write("</label><br>\n");
      out.write("            <label>Duration: ");
      out.print( rs.getString("duration") );
      out.write("</label><br>\n");
      out.write("            <label>Role: ");
      out.print( rs.getString("role") );
      out.write("</label><br>\n");
      out.write("            <label>Status: \n");
      out.write("                <select name=\"status\" id=\"statusSelect\" onchange=\"toggleCertificationLink()\">\n");
      out.write("                    <option value=\"Ongoing\" ");
      out.print( rs.getString("status").equals("Ongoing") ? "selected" : "" );
      out.write(">Ongoing</option>\n");
      out.write("                    <option value=\"Completed\" ");
      out.print( rs.getString("status").equals("Completed") ? "selected" : "" );
      out.write(">Completed</option>\n");
      out.write("                </select>\n");
      out.write("            </label><br>\n");
      out.write("\n");
      out.write("            <div id=\"certificationDiv\" style=\"display: ");
      out.print( rs.getString("status").equals("Completed") ? "block" : "none" );
      out.write(";\">\n");
      out.write("                <label for=\"certificationLink\">Certification Link:</label>\n");
      out.write("                <input type=\"text\" id=\"certificationLink\" name=\"certificationLink\" placeholder=\"Enter certification link (if any)\" value=\"");
      out.print( rs.getString("certification_link") );
      out.write("\">\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <input type=\"submit\" value=\"Update\">\n");
      out.write("        </form>\n");
      out.write("           \n");
      out.write("    ");

            } else {
                out.println("<p style='color:red;'>Internship not found.</p>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (ps != null) ps.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    
      out.write("\n");
      out.write("</body>\n");
      out.write("  <div class=\"back-button\">\n");
      out.write("            <a href=\"dashboard.jsp\">Back to Dashboard</a>\n");
      out.write("        </div>\n");
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
