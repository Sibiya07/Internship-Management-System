package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class adminHome_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Internship Management System - Admin Dashboard</title>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\"> <!-- Link to your CSS file -->\n");
      out.write("      <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css\">\n");
      out.write("    <style>\n");
      out.write("        /* Minimal CSS for professional look */\n");
      out.write("        body {\n");
      out.write("            font-family: 'Arial', sans-serif;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("            background-color: #f5f5f5;\n");
      out.write("        }\n");
      out.write("        .logout-icon {\n");
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
      out.write("        header {\n");
      out.write("            background-color:  #3b5998;\n");
      out.write("            color: white;\n");
      out.write("            padding: 15px 0;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("        header h1 {\n");
      out.write("            margin: 0;\n");
      out.write("            font-size: 2.5rem;\n");
      out.write("        }\n");
      out.write("        nav ul {\n");
      out.write("            list-style-type: none;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("        }\n");
      out.write("        nav ul li {\n");
      out.write("            display: inline;\n");
      out.write("            margin-right: 20px;\n");
      out.write("        }\n");
      out.write("        nav ul li a {\n");
      out.write("            color: white;\n");
      out.write("            text-decoration: none;\n");
      out.write("            font-size: 1rem;\n");
      out.write("            text-transform: uppercase;\n");
      out.write("        }\n");
      out.write("        nav ul li a:hover {\n");
      out.write("            text-decoration: underline;\n");
      out.write("        }\n");
      out.write("        .hero-section {\n");
      out.write("            background: url('images/dd.jpeg.jpg') no-repeat center center/cover;\n");
      out.write("            color: white;\n");
      out.write("            padding: 50px 0;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("        .hero-section h1 {\n");
      out.write("            font-size: 3rem;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("        }\n");
      out.write("        .hero-section p {\n");
      out.write("            font-size: 1.2rem;\n");
      out.write("            margin-bottom: 40px;\n");
      out.write("        }\n");
      out.write("        .btn-primary {\n");
      out.write("            background-color: #ff6600;\n");
      out.write("            color: white;\n");
      out.write("            padding: 15px 30px;\n");
      out.write("            font-size: 1rem;\n");
      out.write("            border: none;\n");
      out.write("            cursor: pointer;\n");
      out.write("            text-transform: uppercase;\n");
      out.write("            transition: background-color 0.3s ease;\n");
      out.write("        }\n");
      out.write("        .btn-primary:hover {\n");
      out.write("            background-color: #ff3300;\n");
      out.write("        }\n");
      out.write("        .container {\n");
      out.write("            padding: 50px 15px;\n");
      out.write("            text-align: center;\n");
      out.write("            background-color: white;\n");
      out.write("        }\n");
      out.write("        .container h2 {\n");
      out.write("            font-size: 2rem;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("        }\n");
      out.write("        .container p {\n");
      out.write("            font-size: 1.1rem;\n");
      out.write("            margin-bottom: 30px;\n");
      out.write("            line-height: 1.6;\n");
      out.write("        }\n");
      out.write("        footer {\n");
      out.write("            background-color: #333;\n");
      out.write("            color: white;\n");
      out.write("            padding: 20px 0;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("        footer p {\n");
      out.write("            margin: 0;\n");
      out.write("            font-size: 0.9rem;\n");
      out.write("        }\n");
      out.write("        .features ul {\n");
      out.write("            list-style-type: none;\n");
      out.write("            padding: 0;\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: space-around;\n");
      out.write("            flex-wrap: wrap;\n");
      out.write("        }\n");
      out.write("        .features ul li {\n");
      out.write("            width: 30%;\n");
      out.write("            margin: 20px 0;\n");
      out.write("        }\n");
      out.write("        .features ul li h3 {\n");
      out.write("            font-size: 1.5rem;\n");
      out.write("            margin-bottom: 10px;\n");
      out.write("        }\n");
      out.write("        .features ul li p {\n");
      out.write("            font-size: 1rem;\n");
      out.write("            line-height: 1.4;\n");
      out.write("        }\n");
      out.write("        .stats {\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: space-around;\n");
      out.write("            margin: 20px 0;\n");
      out.write("        }\n");
      out.write("        .stat-card {\n");
      out.write("            background-color: #e0e0e0;\n");
      out.write("            padding: 20px;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            width: 30%;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("        .stat-card h3 {\n");
      out.write("            margin: 0;\n");
      out.write("            font-size: 1.2rem;\n");
      out.write("        }\n");
      out.write("        .stat-card p {\n");
      out.write("            font-size: 1.5rem;\n");
      out.write("            font-weight: bold;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <!-- Header Navigation -->\n");
      out.write("    <header>\n");
      out.write("        <h1>Admin Dashboard</h1>\n");
      out.write("         <div class=\"logout-icon\">\n");
      out.write("            <a href=\"logout.jsp\"><i class=\"fas fa-sign-out-alt\" title=\"Logout\"></i></a>\n");
      out.write("        </div>\n");
      out.write("        <nav>\n");
      out.write("            <ul class=\"nav-list\">\n");
      out.write("                 <li><a href=\"adminDashboard.jsp\">Dashboard</a></li>\n");
      out.write("                <li><a href=\"addIntern.jsp\">Add Internship</a></li>\n");
      out.write("                       <li><a href=\"interndetails.jsp\">Added Internship</a></li>\n");
      out.write("                <li><a href=\"logout.jsp\">Logout</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("    </header>\n");
      out.write("\n");
      out.write("    <!-- Hero Section -->\n");
      out.write("    <div class=\"hero-section\">\n");
      out.write("        <h1>Welcome to the Admin Dashboard</h1>\n");
      out.write("        <p>Manage internships, users, and applications efficiently</p>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write(" \n");
      out.write("\n");
      out.write("    <!-- Features Section -->\n");
      out.write("    <section class=\"features\">\n");
      out.write("        <h2>Admin Dashboard Features</h2>\n");
      out.write("        <ul>\n");
      out.write("            <li>\n");
      out.write("                <h3>Total Internships Management</h3>\n");
      out.write("                <p>Admins can view and manage the total number of internships available, ensuring the listings are up-to-date and relevant.</p>\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                <h3>User Management</h3>\n");
      out.write("                <p>Easily manage user accounts, including adding, updating, and deactivating users to maintain an active and secure user base.</p>\n");
      out.write("            </li>\n");
      out.write("           \n");
      out.write("         \n");
      out.write("            <li>\n");
      out.write("                <h3>Real-Time Notifications</h3>\n");
      out.write("                <p>Receive updates on application statuses and user activities, enabling timely responses and effective management of the system.</p>\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                <h3>Intuitive Dashboard</h3>\n");
      out.write("                <p>Navigate through a user-friendly interface designed for quick access to all administrative functionalities and metrics.</p>\n");
      out.write("            </li>\n");
      out.write("        </ul>\n");
      out.write("    </section>\n");
      out.write("\n");
      out.write("    <!-- Footer -->\n");
      out.write("    <footer>\n");
      out.write("        <p>&copy; 2024 Internship Management System. All rights reserved.</p>\n");
      out.write("    </footer>\n");
      out.write("</body>\n");
      out.write("</html>");
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
