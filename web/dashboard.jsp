<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Available Admin-Added Internships</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .internship-card {
            border: 1px solid #ddd;
            border-radius: 5px;
            padding: 15px;
            margin-bottom: 20px;
            cursor: pointer;
        }
        .internship-card h4 {
            margin: 0;
        }
    </style>
    <script>
        // Function to display internship details in a modal
        function showModal(title, company, duration, role, description, lastDate, applyLink) {
            document.getElementById("modalTitle").innerText = title;
            document.getElementById("modalCompany").innerText = company;
            document.getElementById("modalDuration").innerText = duration;
            document.getElementById("modalRole").innerText = role;
            document.getElementById("modalDescription").innerText = description;
            document.getElementById("modalLastDate").innerText = lastDate;
            document.getElementById("modalApplyLink").href = applyLink;
            $('#internshipModal').modal('show');
        }
    </script>
</head>
<body>
    <header>
        <h1>Student Dashboard</h1>
        <nav>
            <ul class="nav-list">
                <li><a href="home.jsp">Home</a></li>
                <li><a href="viewInternships.jsp">View Internships</a></li>
                <li><a href="addInternship.jsp">Add Internship</a></li>
                <li><a href="profile.jsp">Profile</a></li>
                <li><a href="dashboard.jsp">Dashboard</a></li>
                <li><a href="logout.jsp">Logout</a></li>
            </ul>
        </nav>
    </header>

    <div class="container">
        <h2>Available Admin-Added Internships</h2>

        <!-- Filter Section -->
        <div class="row mb-4">
            <div class="col-md-12">
                <form method="post" action="dashboard.jsp" class="form-inline"> 
                    <label for="filterOption" class="mr-2">Filter by:</label>
                    <select name="filterOption" id="filterOption" class="form-control mr-2">
                        <option value="">Select an Option</option>
                        <option value="company_name">Company Name</option>
                        <option value="role">Role</option>
                    </select>
                    <input type="text" id="filterValue" name="filterValue" class="form-control mr-2" placeholder="Enter value for filter" required>
                    <input type="submit" value="Search" class="btn btn-primary">
                </form>
            </div>
        </div>

        <%
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
        %>
    </div>

    <!-- Internship Modal -->
    <div class="modal fade" id="internshipModal" tabindex="-1" role="dialog" aria-labelledby="internshipModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="modalTitle"></h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p><strong>Company:</strong> <span id="modalCompany"></span></p>
                    <p><strong>Duration:</strong> <span id="modalDuration"></span></p>
                    <p><strong>Role:</strong> <span id="modalRole"></span></p>
                    <p><strong>Description:</strong> <span id="modalDescription"></span></p>
                    <p><strong>Last Date to Apply:</strong> <span id="modalLastDate"></span></p>
                    <p><a id="modalApplyLink" href="#" target="_blank" class="btn btn-primary">Apply Now</a></p>
                </div>
            </div>
        </div>
    </div>

    <!-- Include Bootstrap JS for the modal functionality -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
