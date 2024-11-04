package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class dashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>Available Admin-Added Internships</title>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\n");
      out.write("    <style>\n");
      out.write("        .internship-card {\n");
      out.write("            border: 1px solid #ddd;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            padding: 15px;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("        .internship-card h4 {\n");
      out.write("            margin: 0;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("    <script>\n");
      out.write("        // Function to display internship details in a modal\n");
      out.write("        function showModal(title, company, duration, role, description, lastDate, applyLink) {\n");
      out.write("            document.getElementById(\"modalTitle\").innerText = title;\n");
      out.write("            document.getElementById(\"modalCompany\").innerText = company;\n");
      out.write("            document.getElementById(\"modalDuration\").innerText = duration;\n");
      out.write("            document.getElementById(\"modalRole\").innerText = role;\n");
      out.write("            document.getElementById(\"modalDescription\").innerText = description;\n");
      out.write("            document.getElementById(\"modalLastDate\").innerText = lastDate;\n");
      out.write("            document.getElementById(\"modalApplyLink\").href = applyLink;\n");
      out.write("            $('#internshipModal').modal('show');\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <header>\n");
      out.write("        <h1>Student Dashboard</h1>\n");
      out.write("        <nav>\n");
      out.write("            <ul class=\"nav-list\">\n");
      out.write("                <li><a href=\"home.jsp\">Home</a></li>\n");
      out.write("                <li><a href=\"viewInternships.jsp\">View Internships</a></li>\n");
      out.write("                <li><a href=\"addInternship.jsp\">Add Internship</a></li>\n");
      out.write("                <li><a href=\"profile.jsp\">Profile</a></li>\n");
      out.write("                <li><a href=\"dashboard.jsp\">Dashboard</a></li>\n");
      out.write("                <li><a href=\"logout.jsp\">Logout</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("    </header>\n");
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <h2>Available Admin-Added Internships</h2>\n");
      out.write("\n");
      out.write("        <!-- Filter Section -->\n");
      out.write("        <div class=\"row mb-4\">\n");
      out.write("            <div class=\"col-md-12\">\n");
      out.write("                <form method=\"post\" action=\"dashboard.jsp\" class=\"form-inline\"> \n");
      out.write("                    <label for=\"filterOption\" class=\"mr-2\">Filter by:</label>\n");
      out.write("                    <select name=\"filterOption\" id=\"filterOption\" class=\"form-control mr-2\">\n");
      out.write("                        <option value=\"\">Select an Option</option>\n");
      out.write("                        <option value=\"company_name\">Company Name</option>\n");
      out.write("                        <option value=\"role\">Role</option>\n");
      out.write("                    </select>\n");
      out.write("                    <input type=\"text\" id=\"filterValue\" name=\"filterValue\" class=\"form-control mr-2\" placeholder=\"Enter value for filter\" required>\n");
      out.write("                    <input type=\"submit\" value=\"Search\" class=\"btn btn-primary\">\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        ");

            // Declare the database connection variables globally
            String url = "jdbc:derby://localhost:1527/intern";  // Database URL
            String dbUsername = "intern";                      // Database username
            String dbPassword = "intern123";                   // Database password

            Connection con = null;
            Statement stmt = null;
            ResultSet rs = null;

            String filterOption = request.getParameter("filterOption");
            String filterValue = request.getParameter("filterValue");

            // Start building the SQL query
            StringBuilder queryBuilder = new StringBuilder("SELECT title, company_name, duration, role, description, last_date, apply_link FROM intern WHERE added_by_admin = true");

            // Apply filters based on user input
            if (filterOption != null && !filterOption.isEmpty() && filterValue != null && !filterValue.isEmpty()) {
                queryBuilder.append(" AND ").append(filterOption).append(" LIKE '%").append(filterValue).append("%'");
            }

            try {
                // Database connection
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                con = DriverManager.getConnection(url, dbUsername, dbPassword);  // Use the global variables

                // Query to get all admin-added internships
                String query = queryBuilder.toString();
                stmt = con.createStatement();
                rs = stmt.executeQuery(query);

                // Display the internships in card format
                while (rs.next()) {
                    String title = rs.getString("title");
                    String companyName = rs.getString("company_name");
                    String duration = rs.getString("duration");
                    String role = rs.getString("role");
                    String description = rs.getString("description");
                    String lastDate = rs.getString("last_date");
                    String applyLink = rs.getString("apply_link");

                    // Escape single quotes to prevent JS issues
                    String safeTitle = title.replace("'", "\\'"); 
                    String safeCompanyName = companyName.replace("'", "\\'"); 
                    String safeDescription = description.replace("'", "\\'"); 

                    out.println("<div class='internship-card' onclick=\"showModal('" + safeTitle + "', '" + safeCompanyName + "', '" + duration + "', '" + role + "', '" + safeDescription + "', '" + lastDate + "', '" + applyLink + "')\">");
                    out.println("<h4>" + title + "</h4>");
                    out.println("<p><strong>Company:</strong> " + companyName + "</p>");
                    out.println("<p><strong>Duration:</strong> " + duration + "</p>");
                    out.println("<p><strong>Role:</strong> " + role + "</p>");
                    out.println("</div>");
                }

            } catch (Exception e) {
                e.printStackTrace();
                out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
            } finally {
                try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
                try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
                try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        
      out.write("\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- Internship Modal -->\n");
      out.write("    <div class=\"modal fade\" id=\"internshipModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"internshipModalLabel\" aria-hidden=\"true\">\n");
      out.write("        <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <h5 class=\"modal-title\" id=\"modalTitle\"></h5>\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                        <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                    </button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                    <p><strong>Company:</strong> <span id=\"modalCompany\"></span></p>\n");
      out.write("                    <p><strong>Duration:</strong> <span id=\"modalDuration\"></span></p>\n");
      out.write("                    <p><strong>Role:</strong> <span id=\"modalRole\"></span></p>\n");
      out.write("                    <p><strong>Description:</strong> <span id=\"modalDescription\"></span></p>\n");
      out.write("                    <p><strong>Last Date to Apply:</strong> <span id=\"modalLastDate\"></span></p>\n");
      out.write("                    <p><a id=\"modalApplyLink\" href=\"#\" target=\"_blank\" class=\"btn btn-primary\">Apply Now</a></p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- Include Bootstrap JS for the modal functionality -->\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js\"></script>\n");
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
