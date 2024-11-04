package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class studentLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Student Login - Internship Management System</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css\">\n");
      out.write("\n");
      out.write("    <style>\n");
      out.write("        /* Body and Background */\n");
      out.write("        body {\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("            background-image: url('images/dd.jpeg.jpg'); /* Background image */\n");
      out.write("            background-size: cover; /* Cover entire screen */\n");
      out.write("            background-position: center; /* Center the image */\n");
      out.write("            background-repeat: no-repeat; /* Prevent repetition */\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("            height: 100vh;\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: center;\n");
      out.write("            align-items: center;\n");
      out.write("            filter: brightness(0.85); /* Darken the image for better text contrast */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Form Container */\n");
      out.write("        .container {\n");
      out.write("            max-width: 400px;\n");
      out.write("            background-color: rgba(255, 255, 255, 0.9); /* Semi-transparent form background */\n");
      out.write("            padding: 40px;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            box-shadow: 0 0 15px rgba(0, 0, 0, 0.3); /* Subtle shadow for depth */\n");
      out.write("            margin-top: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Page Heading */\n");
      out.write("        h1 {\n");
      out.write("            color: #007BFF;\n");
      out.write("            text-align: center;\n");
      out.write("            font-size: 32px;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Label and Input Styling */\n");
      out.write("        label {\n");
      out.write("            font-weight: bold;\n");
      out.write("            color: #333;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        input[type=\"text\"], \n");
      out.write("        input[type=\"password\"] {\n");
      out.write("            width: 100%;\n");
      out.write("            padding: 12px;\n");
      out.write("            margin: 10px 0 20px 0;\n");
      out.write("            display: inline-block;\n");
      out.write("            border: 1px solid #ccc;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            box-sizing: border-box;\n");
      out.write("            font-size: 16px;\n");
      out.write("            transition: border-color 0.3s ease;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        input[type=\"text\"]:focus,\n");
      out.write("        input[type=\"password\"]:focus {\n");
      out.write("            border-color: #007BFF;\n");
      out.write("            outline: none;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Button Styling */\n");
      out.write("        input[type=\"submit\"] {\n");
      out.write("            width: 100%;\n");
      out.write("            background-color: #007BFF;\n");
      out.write("            color: white;\n");
      out.write("            padding: 14px;\n");
      out.write("            margin: 8px 0;\n");
      out.write("            border: none;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            cursor: pointer;\n");
      out.write("            font-size: 18px;\n");
      out.write("            transition: background-color 0.3s ease, transform 0.2s;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        input[type=\"submit\"]:hover {\n");
      out.write("            background-color: #0056b3;\n");
      out.write("            transform: translateY(-2px); /* Lift effect */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Error Message */\n");
      out.write("        .error-message {\n");
      out.write("            color: red;\n");
      out.write("            text-align: center;\n");
      out.write("            margin-top: 10px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Link Styling */\n");
      out.write("        p {\n");
      out.write("            text-align: center;\n");
      out.write("            margin-top: 15px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        p a {\n");
      out.write("            color: #007BFF;\n");
      out.write("            text-decoration: none;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        p a:hover {\n");
      out.write("            text-decoration: underline;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Home Icon Button */\n");
      out.write("        .home-icon {\n");
      out.write("            position: absolute;\n");
      out.write("            left: 20px;\n");
      out.write("            top: 20px;\n");
      out.write("            font-size: 20px;\n");
      out.write("            color: #ffffff;\n");
      out.write("            text-decoration: none;\n");
      out.write("            padding: 10px 15px;\n");
      out.write("            background-color: #007BFF;\n");
      out.write("            border-radius: 50%;\n");
      out.write("            transition: background-color 0.3s ease, transform 0.3s ease;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .home-icon:hover {\n");
      out.write("            background-color: #0056b3;\n");
      out.write("            transform: scale(1.1); /* Hover scaling */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Mobile Optimizations */\n");
      out.write("        @media (max-width: 576px) {\n");
      out.write("            .container {\n");
      out.write("                padding: 20px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            h1 {\n");
      out.write("                font-size: 24px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            input[type=\"submit\"] {\n");
      out.write("                font-size: 16px;\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <!-- Home Icon with Font Awesome -->\n");
      out.write("    <a href=\"index.html\" class=\"home-icon\">\n");
      out.write("        <i class=\"fas fa-home\"></i>\n");
      out.write("    </a>\n");
      out.write("\n");
      out.write("    <!-- Login Form Container -->\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <h1>Student Login</h1>\n");
      out.write("        \n");
      out.write("        <form action=\"login.jsp\" method=\"post\">\n");
      out.write("            <label for=\"username\">Username:</label>\n");
      out.write("            <input type=\"text\" id=\"username\" name=\"username\" required>\n");
      out.write("\n");
      out.write("            <label for=\"password\">Password:</label>\n");
      out.write("            <input type=\"password\" id=\"password\" name=\"password\" required>\n");
      out.write("\n");
      out.write("            <input type=\"submit\" value=\"Login\">\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        <p>Don't have an account? <a href=\"signup.jsp\">Sign up here</a></p>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- Bootstrap JS and jQuery -->\n");
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
