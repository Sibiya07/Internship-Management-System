package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class addInternship_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Add Internship</title>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\"> <!-- Link to your CSS file -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\"> <!-- Font Awesome for icons -->\n");
      out.write("    \n");
      out.write("    <script>\n");
      out.write("        function toggleCertificationLink() {\n");
      out.write("            var statusCompleted = document.getElementById(\"statusCompleted\").checked;\n");
      out.write("            var certificationDiv = document.getElementById(\"certificationDiv\");\n");
      out.write("            certificationDiv.style.display = statusCompleted ? \"block\" : \"none\";\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("    <style>\n");
      out.write("        /* General container styling for radio button group */\n");
      out.write(".radio-label {\n");
      out.write("    display: inline-block;\n");
      out.write("    margin-right: 20px;\n");
      out.write("    font-family: Arial, sans-serif;\n");
      out.write("    font-size: 16px;\n");
      out.write("    cursor: pointer;\n");
      out.write("    position: relative;\n");
      out.write("    padding-left: 30px;\n");
      out.write("    margin-bottom: 10px;\n");
      out.write("    color: #333;\n");
      out.write("    line-height: 20px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".radio-label input[type=\"radio\"] {\n");
      out.write("    position: absolute;\n");
      out.write("    opacity: 0;\n");
      out.write("    cursor: pointer;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".radio-label input[type=\"radio\"] + label::before {\n");
      out.write("    content: \"\";\n");
      out.write("    position: absolute;\n");
      out.write("    left: 0;\n");
      out.write("    top: 50%;\n");
      out.write("    transform: translateY(-50%);\n");
      out.write("    width: 15px;\n");
      out.write("    height: 15px;\n");
      out.write("    border: 2px solid black; /* Border color for the radio */\n");
      out.write("    border-radius: 50%;\n");
      out.write("    background-color: #fff;\n");
      out.write("    transition: background-color 0.3s ease;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".radio-label input[type=\"radio\"]:checked + label::before {\n");
      out.write("    background-color: #007bff; /* Background color when checked */\n");
      out.write("}\n");
      out.write("\n");
      out.write(".radio-label input[type=\"radio\"] + label::after {\n");
      out.write("    content: \"\";\n");
      out.write("    position: absolute;\n");
      out.write("    top: 50%;\n");
      out.write("    left: 4px;\n");
      out.write("    transform: translateY(-50%);\n");
      out.write("    width: 12px;\n");
      out.write("    height: 12px;\n");
      out.write("    border-radius: 50%;\n");
      out.write("    background-color: white;\n");
      out.write("    opacity: 0;\n");
      out.write("    transition: opacity 0.3s ease;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".radio-label input[type=\"radio\"]:checked + label::after {\n");
      out.write("    opacity: 1;\n");
      out.write("    background-color: white; /* Inner circle color when checked */\n");
      out.write("}\n");
      out.write("\n");
      out.write(".radio-label label {\n");
      out.write("    margin-left: 8px; /* Space between label and radio */\n");
      out.write("    color: #333;\n");
      out.write("    font-size: 16px;\n");
      out.write("    vertical-align: middle;\n");
      out.write("}\n");
      out.write("        </style>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <header>\n");
      out.write("        <h1>Internship Management System</h1>\n");
      out.write("        <nav>\n");
      out.write("            <ul class=\"nav-list\">\n");
      out.write("                <li><a href=\"home.jsp\">Home</a></li>\n");
      out.write("                <li><a href=\"viewInternships.jsp\">View Internships</a></li>\n");
      out.write("                <li><a href=\"addInternship.jsp\">Add Internship</a></li>\n");
      out.write("             \n");
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
      out.write("    </header>\n");
      out.write("    \n");
      out.write("    <h2>Add New Internship</h2>\n");
      out.write("\n");
      out.write("    ");

        Connection con = null;
        PreparedStatement ps = null;

        if ("POST".equalsIgnoreCase(request.getMethod())) {
            String title = request.getParameter("title");
            String companyName = request.getParameter("companyName");
            String duration = request.getParameter("duration");
            String role = request.getParameter("role");
            String status = request.getParameter("status");
            String description = request.getParameter("description");
            String username = (String) session.getAttribute("username");
            String certificationLink = request.getParameter("certificationLink"); // Get the certification link

            try {
                String dbUrl = "jdbc:derby://localhost:1527/intern";
                String dbUser = "intern";
                String dbPassword = "intern123";
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

                // Insert internship with optional certification link
                String query = "INSERT INTO intern (title, company_name, duration, role, status, description, username, certification_link) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                ps = con.prepareStatement(query);
                ps.setString(1, title);
                ps.setString(2, companyName);
                ps.setString(3, duration);
                ps.setString(4, role);
                ps.setString(5, status);
                ps.setString(6, description);
                ps.setString(7, username);

                // If the status is "Completed," add the certification link
                if ("Completed".equals(status) && certificationLink != null && !certificationLink.isEmpty()) {
                    ps.setString(8, certificationLink);
                } else {
                    ps.setNull(8, Types.VARCHAR);
                }

                int result = ps.executeUpdate();
                if (result > 0) {
                    out.println("<p class='message success'>Internship added successfully!</p>");
                } else {
                    out.println("<p class='message error'>Failed to add internship. Please try again.</p>");
                }

            } catch (Exception e) {
                e.printStackTrace();
                out.println("<p class='message error'>Error: " + e.getMessage() + "</p>");
            } finally {
                try { if (ps != null) ps.close(); } catch (SQLException e) { e.printStackTrace(); }
                try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        }
    
      out.write("\n");
      out.write("\n");
      out.write("    <form method=\"post\" action=\"addInternship.jsp\">\n");
      out.write("        <label for=\"title\">Internship Title:</label>\n");
      out.write("        <input type=\"text\" id=\"title\" name=\"title\" required>\n");
      out.write("\n");
      out.write("        <label for=\"companyName\">Company Name:</label>\n");
      out.write("        <input type=\"text\" id=\"companyName\" name=\"companyName\" required>\n");
      out.write("\n");
      out.write("        <label for=\"duration\">Duration:</label>\n");
      out.write("        <input type=\"text\" id=\"duration\" name=\"duration\" required>\n");
      out.write("\n");
      out.write("        <label for=\"role\">Role:</label>\n");
      out.write("        <input type=\"text\" id=\"role\" name=\"role\" required>\n");
      out.write("\n");
      out.write("        <label>Status:</label>\n");
      out.write("        <span class=\"radio-label\">\n");
      out.write("            <input type=\"radio\" id=\"statusCompleted\" name=\"status\" value=\"Completed\" onclick=\"toggleCertificationLink()\" required>\n");
      out.write("            <label for=\"statusCompleted\">Completed</label>\n");
      out.write("        </span>\n");
      out.write("        <span class=\"radio-label\">\n");
      out.write("            <input type=\"radio\" id=\"statusOngoing\" name=\"status\" value=\"Ongoing\" onclick=\"toggleCertificationLink()\" required>\n");
      out.write("            <label for=\"statusOngoing\">Ongoing</label>\n");
      out.write("        </span>\n");
      out.write("\n");
      out.write("        <div id=\"certificationDiv\" style=\"display:none;\">\n");
      out.write("            <label for=\"certificationLink\">Certification Link:</label>\n");
      out.write("            <input type=\"text\" id=\"certificationLink\" name=\"certificationLink\" placeholder=\"Enter certification link (if any)\">\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <label for=\"description\">Description:</label>\n");
      out.write("        <textarea id=\"description\" name=\"description\" rows=\"4\" required></textarea>\n");
      out.write("\n");
      out.write("        <input type=\"submit\" value=\"Add Internship\">\n");
      out.write("    </form>\n");
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
