package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class interndetails_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>Available Admin-Added Internships</title>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\n");
      out.write("      <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("            background-color: #f4f4f4;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("        }\n");
      out.write("        header {\n");
      out.write("            background: #3b5998;\n");
      out.write("            color: white;\n");
      out.write("            padding: 10px 0;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("        .nav-list {\n");
      out.write("            list-style-type: none;\n");
      out.write("            padding: 0;\n");
      out.write("        }\n");
      out.write("        .nav-list li {\n");
      out.write("            display: inline;\n");
      out.write("            margin: 0 15px;\n");
      out.write("        }\n");
      out.write("         .logout-icon {\n");
      out.write("        position: absolute;\n");
      out.write("        right: 100px; /* Position it from the left */\n");
      out.write("        top: 25px; /* Position it from the top */\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .logout-icon i {\n");
      out.write("        font-size: 30px; /* Adjust the size as needed */\n");
      out.write("        color: white; /* Color of the icon */\n");
      out.write("        cursor: pointer; /* Change cursor to pointer */\n");
      out.write("    }\n");
      out.write("        .nav-list a {\n");
      out.write("            color: white;\n");
      out.write("            text-decoration: none;\n");
      out.write("            font-weight: bold;\n");
      out.write("        }\n");
      out.write("        .container {\n");
      out.write("            background: white;\n");
      out.write("            padding: 20px;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n");
      out.write("        }\n");
      out.write("        h2 {\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("        }\n");
      out.write("        .card {\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("        }\n");
      out.write("        .card-header {\n");
      out.write("            background-color: #007BFF;\n");
      out.write("            color: white;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js\"></script>\n");
      out.write("    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\n");
      out.write("    <script>\n");
      out.write("        $(document).ready(function() {\n");
      out.write("            $('#internModal').on('show.bs.modal', function (event) {\n");
      out.write("                var button = $(event.relatedTarget);\n");
      out.write("                var title = button.data('title');\n");
      out.write("                var company = button.data('company');\n");
      out.write("                var duration = button.data('duration');\n");
      out.write("                var role = button.data('role');\n");
      out.write("                var description = button.data('description');\n");
      out.write("                var lastDate = button.data('lastdate');\n");
      out.write("                var applyLink = button.data('applylink');\n");
      out.write("\n");
      out.write("                var modal = $(this);\n");
      out.write("                modal.find('.modal-title').text(title);\n");
      out.write("                modal.find('.modal-body').html(\n");
      out.write("                    \"<p><strong>Company:</strong> \" + company + \"</p>\" +\n");
      out.write("                    \"<p><strong>Duration:</strong> \" + duration + \"</p>\" +\n");
      out.write("                    \"<p><strong>Role:</strong> \" + role + \"</p>\" +\n");
      out.write("                    \"<p><strong>Description:</strong> \" + description + \"</p>\" +\n");
      out.write("                    \"<p><strong>Last Date to Apply:</strong> \" + lastDate + \"</p>\" +\n");
      out.write("                    \"<a href='\" + applyLink + \"' class='btn btn-primary'>Apply Now</a>\"\n");
      out.write("                );\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("    </script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <header>\n");
      out.write("         <div class=\"logout-icon\">\n");
      out.write("            <a href=\"logout.jsp\"><i class=\"fas fa-sign-out-alt\" title=\"Logout\"></i></a>\n");
      out.write("        </div>\n");
      out.write("        <h1>Admin Dashboard</h1>\n");
      out.write("        <nav>\n");
      out.write("            <ul class=\"nav-list\">\n");
      out.write("                <li><a href=\"adminHome.jsp\">Home</a></li>\n");
      out.write("                <li><a href=\"interndetails.jsp\">Added Internship</a></li>\n");
      out.write("                <li><a href=\"adminDashboard.jsp\">Dashboard</a></li>\n");
      out.write("                <li><a href=\"logout.jsp\">Logout</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("    </header>\n");
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <h2>Admin-Added Internships</h2>\n");
      out.write("        <div class=\"row\">\n");
      out.write("            ");

                Connection con = null;
                Statement stmt = null;
                ResultSet rs = null;

                try {
                    // Database connection
                    String url = "jdbc:derby://localhost:1527/intern";
                    String dbUsername = "intern";
                    String dbPassword = "intern123";
                    Class.forName("org.apache.derby.jdbc.ClientDriver");
                    con = DriverManager.getConnection(url, dbUsername, dbPassword);

                    // Query to get all admin-added internships
                    String query = "SELECT title, company_name, duration, role, description, last_date, apply_link FROM intern WHERE added_by_admin = true";
                    stmt = con.createStatement();
                    rs = stmt.executeQuery(query);

                    // Display the internships as cards
                    while (rs.next()) {
                        String title = rs.getString("title");
                        String companyName = rs.getString("company_name");
                        String duration = rs.getString("duration");
                        String role = rs.getString("role");
                        String description = rs.getString("description");
                        String lastDate = rs.getString("last_date");
                        String applyLink = rs.getString("apply_link");

                        out.println("<div class='col-md-4'>" +
                            "<div class='card' data-toggle='modal' data-target='#internModal' " +
                            "data-title='" + title + "' " +
                            "data-company='" + companyName + "' " +
                            "data-duration='" + duration + "' " +
                            "data-role='" + role + "' " +
                            "data-description='" + description + "' " +
                            "data-lastdate='" + lastDate + "' " +
                            "data-applylink='" + applyLink + "'>" +
                            "<div class='card-header'>" + title + "</div>" +
                            "<div class='card-body'>" +
                            "<h5 class='card-title'>" + companyName + "</h5>" +
                            "<p class='card-text'><strong>Duration:</strong> " + duration + "</p>" +
                            "<p class='card-text'><strong>Role:</strong> " + role + "</p>" +
                            "<p class='card-text'><strong>Description:</strong> " + description + "</p>" +
                            "<p class='card-text'><strong>Last Date to Apply:</strong> " + lastDate + "</p>" +
                            "<a href='" + applyLink + "' class='btn btn-success'>Apply</a>" +
                            "</div></div></div>");
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
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- Modal -->\n");
      out.write("    <div class=\"modal fade\" id=\"internModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"internModalLabel\" aria-hidden=\"true\">\n");
      out.write("        <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <h5 class=\"modal-title\" id=\"internModalLabel\">Internship Details</h5>\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                        <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                    </button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                    <!-- Dynamic content will be injected here -->\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-footer\">\n");
      out.write("                    <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
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
