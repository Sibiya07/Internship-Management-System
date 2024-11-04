package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class adminDashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>Admin Dashboard</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css\">\n");
      out.write("</head>\n");
      out.write("<style>\n");
      out.write("    /* General Styles */\n");
      out.write("    body {\n");
      out.write("        font-family: Arial, sans-serif;\n");
      out.write("        margin: 0;\n");
      out.write("        padding: 0;\n");
      out.write("        background-color: #f4f4f4;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    header {\n");
      out.write("        background-color: #3b5998;\n");
      out.write("        color: white;\n");
      out.write("        padding: 15px 0;\n");
      out.write("        text-align: center;\n");
      out.write("        position: relative;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    h1 {\n");
      out.write("        margin: 0;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    /* Navigation Styles */\n");
      out.write("    .nav-list {\n");
      out.write("        list-style-type: none;\n");
      out.write("        padding: 0;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .nav-list ul {\n");
      out.write("        padding: 0;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .nav-list li {\n");
      out.write("        display: inline;\n");
      out.write("        margin: 0 15px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .nav-list a {\n");
      out.write("        color: white;\n");
      out.write("        text-decoration: none;\n");
      out.write("        font-weight: bold;\n");
      out.write("        padding: 10px;\n");
      out.write("        border-radius: 4px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .nav-list a:hover {\n");
      out.write("        background-color: #0056b3;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    /* Logout icon styles */\n");
      out.write("    .logout-icon {\n");
      out.write("        position: absolute;\n");
      out.write("        right: 100px;\n");
      out.write("        top: 25px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .logout-icon i {\n");
      out.write("        font-size: 30px;\n");
      out.write("        color: white;\n");
      out.write("        cursor: pointer;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    /* Container for content */\n");
      out.write("    .container {\n");
      out.write("        max-width: 800px;\n");
      out.write("        margin: 20px auto;\n");
      out.write("        padding: 20px;\n");
      out.write("        background-color: #ffffff;\n");
      out.write("        border-radius: 8px;\n");
      out.write("        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    /* Form Styles */\n");
      out.write("    form {\n");
      out.write("        margin-bottom: 20px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    label {\n");
      out.write("        font-weight: bold;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    input[type=\"text\"], select {\n");
      out.write("        width: 100%;\n");
      out.write("        padding: 10px;\n");
      out.write("        margin-top: 5px;\n");
      out.write("        margin-bottom: 15px;\n");
      out.write("        border: 1px solid #ccc;\n");
      out.write("        border-radius: 4px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    input[type=\"submit\"] {\n");
      out.write("        background-color: #007bff;\n");
      out.write("        color: white;\n");
      out.write("        border: none;\n");
      out.write("        padding: 10px 15px;\n");
      out.write("        border-radius: 4px;\n");
      out.write("        cursor: pointer;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    input[type=\"submit\"]:hover {\n");
      out.write("        background-color: #0056b3;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    /* Table Styles */\n");
      out.write("    table {\n");
      out.write("        width: 100%;\n");
      out.write("        border-collapse: collapse;\n");
      out.write("        margin-top: 20px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    th, td {\n");
      out.write("        border: 1px solid #ddd;\n");
      out.write("        padding: 12px;\n");
      out.write("        text-align: left;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    th {\n");
      out.write("        background-color: #007bff;\n");
      out.write("        color: white;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    tr:nth-child(even) {\n");
      out.write("        background-color: #f2f2f2;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    tr:hover {\n");
      out.write("        background-color: #ddd;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    /* Message Styles */\n");
      out.write("    .message {\n");
      out.write("        text-align: center;\n");
      out.write("        font-size: 16px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .message.success {\n");
      out.write("        color: green;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .message.error {\n");
      out.write("        color: red;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    /* Responsive Styles */\n");
      out.write("    @media (max-width: 768px) {\n");
      out.write("        .nav-list li {\n");
      out.write("            display: block;\n");
      out.write("            margin: 5px 0;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        header h1 {\n");
      out.write("            font-size: 1.5em;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        table {\n");
      out.write("            font-size: 0.9em;\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <header>\n");
      out.write("        <div class=\"logout-icon\">\n");
      out.write("            <a href=\"logout.jsp\"><i class=\"fas fa-sign-out-alt\" title=\"Logout\"></i></a>\n");
      out.write("        </div>\n");
      out.write("        <h1>Admin Dashboard</h1>\n");
      out.write("        <nav class=\"nav-list\">\n");
      out.write("            <ul>\n");
      out.write("                <li><a href=\"adminHome.jsp\">Home</a></li>\n");
      out.write("                <li><a href=\"adminDashboard.jsp\">Dashboard</a></li>\n");
      out.write("                <li><a href=\"addIntern.jsp\">Add Internship</a></li>\n");
      out.write("                <li><a href=\"interndetails.jsp\">Added Internship</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("    </header>\n");
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <h2>Search Student Details</h2>\n");
      out.write("        <form method=\"post\" action=\"adminDashboard.jsp\">\n");
      out.write("            <label for=\"username\">Filter by:</label>\n");
      out.write("            <select name=\"filterOption\">\n");
      out.write("                <option value=\"username\">Username</option>\n");
      out.write("                <option value=\"company_name\">Company Name</option>\n");
      out.write("                <option value=\"role\">Role</option>\n");
      out.write("            </select>\n");
      out.write("\n");
      out.write("            <input type=\"text\" id=\"filterValue\" name=\"filterValue\" placeholder=\"Enter value for filter\" required>\n");
      out.write("            <input type=\"submit\" value=\"Search\">\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("      \n");
      out.write("\n");
      out.write("        ");

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

                // Check if the form is submitted to show all students and interns
                if ("true".equals(request.getParameter("showAll"))) {
                    // Query to get all students and interns
                    String query = "SELECT u.username AS user_username, u.email, u.phone_number, u.branch, u.course, u.college_name, " +
                                   "i.company_name, i.role FROM users u " +
                                   "LEFT JOIN intern i ON u.username = i.username";

                    ps = con.prepareStatement(query);
                } else if ("POST".equalsIgnoreCase(request.getMethod()) && request.getParameter("filterValue") != null) {
                    String filterOption = request.getParameter("filterOption");
                    String filterValue = request.getParameter("filterValue");

                    // Query to filter based on username, company name, or role
                    String query = "SELECT u.username AS user_username, u.email, u.phone_number, u.branch, u.course, u.college_name, " +
                                   "i.company_name, i.role FROM users u " +
                                   "LEFT JOIN intern i ON u.username = i.username " +
                                   "WHERE LOWER(" + (filterOption.equals("username") ? "u." : "i.") + filterOption + ") = LOWER(?)";

                    // Preparing the statement
                    ps = con.prepareStatement(query);
                    ps.setString(1, filterValue.toLowerCase()); // Convert filter value to lowercase
                }

                if (ps != null) {
                    rs = ps.executeQuery();

                    if (rs.next()) {
                        // Display the filtered student list or all students in a table with clickable names
                        out.println("<h3>Student and Intern List</h3>");
                        out.println("<table border='1'>");
                        out.println("<tr><th>Username</th><th>Email</th><th>Phone Number</th><th>Branch</th><th>Company</th><th>Role</th></tr>");

                        do {
                            String studentUsername = rs.getString("user_username");
                            out.println("<tr>");
                            out.println("<td><a href='viewStudent.jsp?username=" + studentUsername + "'>" + studentUsername + "</a></td>");
                            out.println("<td>" + rs.getString("email") + "</td>");
                            out.println("<td>" + rs.getString("phone_number") + "</td>");
                            out.println("<td>" + rs.getString("branch") + "</td>");
                            out.println("<td>" + rs.getString("company_name") + "</td>");
                            out.println("<td>" + rs.getString("role") + "</td>");
                            out.println("</tr>");
                        } while (rs.next());

                        out.println("</table>");
                    } else {
                        out.println("<p class='message error'>No students found for the selected filter.</p>");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                out.println("<p class='message error'>Error retrieving data: " + e.getMessage() + "</p>");
            } finally {
                if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
                if (ps != null) try { ps.close(); } catch (SQLException e) { e.printStackTrace(); }
                if (con != null) try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        
      out.write(" \n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write(" ");
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
