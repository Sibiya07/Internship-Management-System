<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Available Admin-Added Internships</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        header {
            background: #3b5998;
            color: white;
            padding: 10px 0;
            text-align: center;
        }
        .nav-list {
            list-style-type: none;
            padding: 0;
        }
        .nav-list li {
            display: inline;
            margin: 0 15px;
        }
         .logout-icon {
        position: absolute;
        right: 100px; /* Position it from the left */
        top: 25px; /* Position it from the top */
    }

    .logout-icon i {
        font-size: 30px; /* Adjust the size as needed */
        color: white; /* Color of the icon */
        cursor: pointer; /* Change cursor to pointer */
    }
        .nav-list a {
            color: white;
            text-decoration: none;
            font-weight: bold;
        }
        .container {
            background: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            margin-bottom: 20px;
        }
        .card {
            margin-bottom: 20px;
        }
        .card-header {
            background-color: #007BFF;
            color: white;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
        $(document).ready(function() {
            $('#internModal').on('show.bs.modal', function (event) {
                var button = $(event.relatedTarget);
                var title = button.data('title');
                var company = button.data('company');
                var duration = button.data('duration');
                var role = button.data('role');
                var description = button.data('description');
                var lastDate = button.data('lastdate');
                var applyLink = button.data('applylink');

                var modal = $(this);
                modal.find('.modal-title').text(title);
                modal.find('.modal-body').html(
                    "<p><strong>Company:</strong> " + company + "</p>" +
                    "<p><strong>Duration:</strong> " + duration + "</p>" +
                    "<p><strong>Role:</strong> " + role + "</p>" +
                    "<p><strong>Description:</strong> " + description + "</p>" +
                    "<p><strong>Last Date to Apply:</strong> " + lastDate + "</p>" +
                    "<a href='" + applyLink + "' class='btn btn-primary'>Apply Now</a>"
                );
            });
        });
    </script>
</head>
<body>
    <header>
         <div class="logout-icon">
            <a href="logout.jsp"><i class="fas fa-sign-out-alt" title="Logout"></i></a>
        </div>
        <h1>Admin Dashboard</h1>
        <nav>
            <ul class="nav-list">
                <li><a href="adminHome.jsp">Home</a></li>
                <li><a href="interndetails.jsp">Added Internship</a></li>
                <li><a href="adminDashboard.jsp">Dashboard</a></li>
                <li><a href="logout.jsp">Logout</a></li>
            </ul>
        </nav>
    </header>

    <div class="container">
        <h2>Admin-Added Internships</h2>
        <div class="row">
            <%
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
            %>
        </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="internModal" tabindex="-1" role="dialog" aria-labelledby="internModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="internModalLabel">Internship Details</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <!-- Dynamic content will be injected here -->
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
