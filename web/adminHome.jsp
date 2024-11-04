<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Internship Management System - Admin Dashboard</title>
    <link rel="stylesheet" type="text/css" href="styles.css"> <!-- Link to your CSS file -->
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
        /* Minimal CSS for professional look */
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
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
        header {
            background-color:  #3b5998;
            color: white;
            padding: 15px 0;
            text-align: center;
        }
        header h1 {
            margin: 0;
            font-size: 2.5rem;
        }
        nav ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }
        nav ul li {
            display: inline;
            margin-right: 20px;
        }
        nav ul li a {
            color: white;
            text-decoration: none;
            font-size: 1rem;
            text-transform: uppercase;
        }
        nav ul li a:hover {
            text-decoration: underline;
        }
        .hero-section {
            background: url('images/dd.jpeg.jpg') no-repeat center center/cover;
            color: white;
            padding: 50px 0;
            text-align: center;
        }
        .hero-section h1 {
            font-size: 3rem;
            margin-bottom: 20px;
        }
        .hero-section p {
            font-size: 1.2rem;
            margin-bottom: 40px;
        }
        .btn-primary {
            background-color: #ff6600;
            color: white;
            padding: 15px 30px;
            font-size: 1rem;
            border: none;
            cursor: pointer;
            text-transform: uppercase;
            transition: background-color 0.3s ease;
        }
        .btn-primary:hover {
            background-color: #ff3300;
        }
        .container {
            padding: 50px 15px;
            text-align: center;
            background-color: white;
        }
        .container h2 {
            font-size: 2rem;
            margin-bottom: 20px;
        }
        .container p {
            font-size: 1.1rem;
            margin-bottom: 30px;
            line-height: 1.6;
        }
        footer {
            background-color: #333;
            color: white;
            padding: 20px 0;
            text-align: center;
        }
        footer p {
            margin: 0;
            font-size: 0.9rem;
        }
        .features ul {
            list-style-type: none;
            padding: 0;
            display: flex;
            justify-content: space-around;
            flex-wrap: wrap;
        }
        .features ul li {
            width: 30%;
            margin: 20px 0;
        }
        .features ul li h3 {
            font-size: 1.5rem;
            margin-bottom: 10px;
        }
        .features ul li p {
            font-size: 1rem;
            line-height: 1.4;
        }
        .stats {
            display: flex;
            justify-content: space-around;
            margin: 20px 0;
        }
        .stat-card {
            background-color: #e0e0e0;
            padding: 20px;
            border-radius: 5px;
            width: 30%;
            text-align: center;
        }
        .stat-card h3 {
            margin: 0;
            font-size: 1.2rem;
        }
        .stat-card p {
            font-size: 1.5rem;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <!-- Header Navigation -->
    <header>
        <h1>Admin Dashboard</h1>
         <div class="logout-icon">
            <a href="logout.jsp"><i class="fas fa-sign-out-alt" title="Logout"></i></a>
        </div>
        <nav>
            <ul class="nav-list">
                 <li><a href="adminDashboard.jsp">Dashboard</a></li>
                <li><a href="addIntern.jsp">Add Internship</a></li>
                       <li><a href="interndetails.jsp">Added Internship</a></li>
                <li><a href="logout.jsp">Logout</a></li>
            </ul>
        </nav>
    </header>

    <!-- Hero Section -->
    <div class="hero-section">
        <h1>Welcome to the Admin Dashboard</h1>
        <p>Manage internships, users, and applications efficiently</p>
    </div>

 

    <!-- Features Section -->
    <section class="features">
        <h2>Admin Dashboard Features</h2>
        <ul>
            <li>
                <h3>Total Internships Management</h3>
                <p>Admins can view and manage the total number of internships available, ensuring the listings are up-to-date and relevant.</p>
            </li>
            <li>
                <h3>User Management</h3>
                <p>Easily manage user accounts, including adding, updating, and deactivating users to maintain an active and secure user base.</p>
            </li>
           
         
            <li>
                <h3>Real-Time Notifications</h3>
                <p>Receive updates on application statuses and user activities, enabling timely responses and effective management of the system.</p>
            </li>
            <li>
                <h3>Intuitive Dashboard</h3>
                <p>Navigate through a user-friendly interface designed for quick access to all administrative functionalities and metrics.</p>
            </li>
        </ul>
    </section>

    <!-- Footer -->
    <footer>
        <p>&copy; 2024 Internship Management System. All rights reserved.</p>
    </footer>
</body>
</html>