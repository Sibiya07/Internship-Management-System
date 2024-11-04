<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Internship</title>
    <link rel="stylesheet" type="text/css" href="styles.css"> <!-- Link to your CSS file -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"> <!-- Font Awesome for icons -->
    
    <script>
        function toggleCertificationLink() {
            var statusCompleted = document.getElementById("statusCompleted").checked;
            var certificationDiv = document.getElementById("certificationDiv");
            certificationDiv.style.display = statusCompleted ? "block" : "none";
        }
    </script>
    <style>
        /* General container styling for radio button group */
.radio-label {
    display: inline-block;
    margin-right: 20px;
    font-family: Arial, sans-serif;
    font-size: 16px;
    cursor: pointer;
    position: relative;
    padding-left: 30px;
    margin-bottom: 10px;
    color: #333;
    line-height: 20px;
}

.radio-label input[type="radio"] {
    position: absolute;
    opacity: 0;
    cursor: pointer;
}

.radio-label input[type="radio"] + label::before {
    content: "";
    position: absolute;
    left: 0;
    top: 50%;
    transform: translateY(-50%);
    width: 15px;
    height: 15px;
    border: 2px solid black; /* Border color for the radio */
    border-radius: 50%;
    background-color: #fff;
    transition: background-color 0.3s ease;
}

.radio-label input[type="radio"]:checked + label::before {
    background-color: #007bff; /* Background color when checked */
}

.radio-label input[type="radio"] + label::after {
    content: "";
    position: absolute;
    top: 50%;
    left: 4px;
    transform: translateY(-50%);
    width: 12px;
    height: 12px;
    border-radius: 50%;
    background-color: white;
    opacity: 0;
    transition: opacity 0.3s ease;
}

.radio-label input[type="radio"]:checked + label::after {
    opacity: 1;
    background-color: white; /* Inner circle color when checked */
}

.radio-label label {
    margin-left: 8px; /* Space between label and radio */
    color: #333;
    font-size: 16px;
    vertical-align: middle;
}
        </style>
</head>

<body>
    <header>
        <h1>Internship Management System</h1>
        <nav>
            <ul class="nav-list">
                <li><a href="home.jsp">Home</a></li>
                <li><a href="viewInternships.jsp">View Internships</a></li>
                <li><a href="addInternship.jsp">Add Internship</a></li>
             
                <li><a href="dashboard.jsp">Dashboard</a></li>
             
        </nav>
        <div class="profile-icon">
            <div class="dropdown">
                <i class="fas fa-user-circle"></i>
                <div class="dropdown-content">
                    <a href="profile.jsp"><i class="fas fa-user"></i> My Profile</a>
                    <a href="viewInternships.jsp"><i class="fas fa-briefcase"></i> View Internships</a>
                    <a href="addInternship.jsp"><i class="fas fa-plus"></i> Add Internship</a>
                    <a href="logout.jsp"><i class="fas fa-sign-out-alt"></i> Logout</a>
                </div>
            </div>
        </div>
    </header>
    </header>
    
    <h2>Add New Internship</h2>

    <%
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
    %>

    <form method="post" action="addInternship.jsp">
        <label for="title">Internship Title:</label>
        <input type="text" id="title" name="title" required>

        <label for="companyName">Company Name:</label>
        <input type="text" id="companyName" name="companyName" required>

        <label for="duration">Duration:</label>
        <input type="text" id="duration" name="duration" required>

        <label for="role">Role:</label>
        <input type="text" id="role" name="role" required>

        <label>Status:</label>
        <span class="radio-label">
            <input type="radio" id="statusCompleted" name="status" value="Completed" onclick="toggleCertificationLink()" required>
            <label for="statusCompleted">Completed</label>
        </span>
        <span class="radio-label">
            <input type="radio" id="statusOngoing" name="status" value="Ongoing" onclick="toggleCertificationLink()" required>
            <label for="statusOngoing">Ongoing</label>
        </span>

        <div id="certificationDiv" style="display:none;">
            <label for="certificationLink">Certification Link:</label>
            <input type="text" id="certificationLink" name="certificationLink" placeholder="Enter certification link (if any)">
        </div>

        <label for="description">Description:</label>
        <textarea id="description" name="description" rows="4" required></textarea>

        <input type="submit" value="Add Internship">
    </form>
</body>
</html>
