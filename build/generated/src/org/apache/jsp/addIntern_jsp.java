package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

public final class addIntern_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>Add Internship</title>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css\">\n");
      out.write("    <style>\n");
      out.write("        /* Basic reset */\n");
      out.write("        * {\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("            box-sizing: border-box;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        body {\n");
      out.write("            font-family: 'Arial', sans-serif;\n");
      out.write("            background-color: #f0f2f5;\n");
      out.write("            color: #333;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        header {\n");
      out.write("            background-color: navy;\n");
      out.write("            padding: 20px;\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: space-between;\n");
      out.write("            align-items: center;\n");
      out.write("            color: white;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        header h1 {\n");
      out.write("            font-size: 28px;\n");
      out.write("            margin-left: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        nav ul {\n");
      out.write("            list-style-type: none;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        nav ul li {\n");
      out.write("            display: inline;\n");
      out.write("            margin-right: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        nav ul li a {\n");
      out.write("            color: white;\n");
      out.write("            text-decoration: none;\n");
      out.write("            font-size: 18px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        nav ul li a:hover {\n");
      out.write("            text-decoration: underline;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .logout-icon {\n");
      out.write("            position: absolute;\n");
      out.write("            right: 20px;\n");
      out.write("            top: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .logout-icon i {\n");
      out.write("            font-size: 24px;\n");
      out.write("            color: white;\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .container {\n");
      out.write("            max-width: 800px;\n");
      out.write("            margin: 50px auto;\n");
      out.write("            background-color: white;\n");
      out.write("            padding: 20px;\n");
      out.write("            border-radius: 8px;\n");
      out.write("            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        h2 {\n");
      out.write("            font-size: 24px;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("            color: black;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        form {\n");
      out.write("            display: flex;\n");
      out.write("            flex-direction: column;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        form label {\n");
      out.write("            margin: 10px 0 5px;\n");
      out.write("            font-size: 16px;\n");
      out.write("            font-weight: bold;\n");
      out.write("            color: black;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        form input[type=\"text\"],\n");
      out.write("        form input[type=\"date\"],\n");
      out.write("        form input[type=\"url\"],\n");
      out.write("        form textarea {\n");
      out.write("            padding: 10px;\n");
      out.write("            border: 1px solid #ccc;\n");
      out.write("            border-radius: 4px;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("            width: 100%;\n");
      out.write("            font-size: 16px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        form textarea {\n");
      out.write("            resize: vertical;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        form input[type=\"submit\"] {\n");
      out.write("            padding: 12px 20px;\n");
      out.write("            background-color: navy;\n");
      out.write("            color: white;\n");
      out.write("            border: none;\n");
      out.write("            border-radius: 4px;\n");
      out.write("            cursor: pointer;\n");
      out.write("            font-size: 18px;\n");
      out.write("            transition: background-color 0.3s ease;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        form input[type=\"submit\"]:hover {\n");
      out.write("            background-color: #45a049;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        p {\n");
      out.write("            margin-top: 20px;\n");
      out.write("            font-size: 16px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Media query for responsiveness */\n");
      out.write("        @media (max-width: 600px) {\n");
      out.write("            header h1 {\n");
      out.write("                font-size: 22px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            nav ul li {\n");
      out.write("                display: block;\n");
      out.write("                margin-bottom: 10px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .container {\n");
      out.write("                padding: 10px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            form input[type=\"submit\"] {\n");
      out.write("                font-size: 16px;\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <header>\n");
      out.write("        <h1>Admin Internship</h1>\n");
      out.write("        <nav>\n");
      out.write("            <ul class=\"nav-list\">\n");
      out.write("                <li><a href=\"adminHome.jsp\">Home</a></li>\n");
      out.write("                <li><a href=\"adminDashboard.jsp\">Dashboard</a></li>\n");
      out.write("                <li><a href=\"addIntern.jsp\">Add Internship</a></li>\n");
      out.write("                <li><a href=\"interndetails.jsp\">Added Internship</a></li>\n");
      out.write("                <li><a href=\"logout.jsp\">Logout</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("        <div class=\"logout-icon\">\n");
      out.write("            <a href=\"logout.jsp\"><i class=\"fas fa-sign-out-alt\" title=\"Logout\"></i></a>\n");
      out.write("        </div>\n");
      out.write("    </header>\n");
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <h2>New Internship Details</h2>\n");
      out.write("        <form method=\"post\" action=\"addIntern.jsp\">\n");
      out.write("            <label for=\"title\">Internship Title:</label>\n");
      out.write("            <input type=\"text\" id=\"title\" name=\"title\" required>\n");
      out.write("\n");
      out.write("            <label for=\"companyName\">Company Name:</label>\n");
      out.write("            <input type=\"text\" id=\"companyName\" name=\"companyName\" required>\n");
      out.write("\n");
      out.write("            <label for=\"duration\">Duration:</label>\n");
      out.write("            <input type=\"text\" id=\"duration\" name=\"duration\" required>\n");
      out.write("\n");
      out.write("            <label for=\"role\">Role:</label>\n");
      out.write("            <input type=\"text\" id=\"role\" name=\"role\" required>\n");
      out.write("\n");
      out.write("            <label for=\"description\">Description:</label>\n");
      out.write("            <textarea id=\"description\" name=\"description\" required></textarea>\n");
      out.write("\n");
      out.write("            <label for=\"lastDate\">Last Date to Apply:</label>\n");
      out.write("            <input type=\"date\" id=\"lastDate\" name=\"lastDate\" required>\n");
      out.write("\n");
      out.write("            <label for=\"applyLink\">Apply Link:</label>\n");
      out.write("            <input type=\"url\" id=\"applyLink\" name=\"applyLink\" required>\n");
      out.write("            <br>\n");
      out.write("\n");
      out.write("            <input type=\"submit\" value=\"Add Internship\">\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        ");

            LocalDate currentDate = LocalDate.now(); // Move the currentDate declaration outside the POST block

            if ("POST".equalsIgnoreCase(request.getMethod())) {
                String title = request.getParameter("title");
                String companyName = request.getParameter("companyName");
                String duration = request.getParameter("duration");
                String role = request.getParameter("role");
                String description = request.getParameter("description");
                String lastDateStr = request.getParameter("lastDate");
                String applyLink = request.getParameter("applyLink");

                // Parse last date string to LocalDate
                LocalDate lastDate = LocalDate.parse(lastDateStr); 

                // Check if the last date has passed
                if (currentDate.isAfter(lastDate)) {
                    out.println("<p style='color:red;'>Error: Cannot add internship because the last date has already passed.</p>");
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

                        // Insert the internship into the intern table
                        String query = "INSERT INTO intern (title, company_name, duration, role, description, last_date, apply_link, added_by_admin) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                        ps = con.prepareStatement(query);
                        ps.setString(1, title);
                        ps.setString(2, companyName);
                        ps.setString(3, duration);
                        ps.setString(4, role);
                        ps.setString(5, description);
                        ps.setDate(6, java.sql.Date.valueOf(lastDate)); // Convert LocalDate to java.sql.Date
                        ps.setString(7, applyLink);
                        ps.setBoolean(8, true);
                        int rowsInserted = ps.executeUpdate();

                        if (rowsInserted > 0) {
                            out.println("<p>Internship added successfully!</p>");
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                        out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
                    } finally {
                        try { if (ps != null) ps.close(); } catch (SQLException e) { e.printStackTrace(); }
                        try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
                    }
                }
            }

            // Display internships
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;

            try {
                // Database connection
                String url = "jdbc:derby://localhost:1527/intern";
                String dbUsername = "intern";
                String dbPassword = "intern123";
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                con = DriverManager.getConnection(url, dbUsername, dbPassword);


            } catch (Exception e) {
                e.printStackTrace();
                out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
            } finally {
                try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
                try { if (ps != null) ps.close(); } catch (SQLException e) { e.printStackTrace(); }
                try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
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
