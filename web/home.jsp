<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Internship Management System - Home</title> 
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"> <!-- Font Awesome -->
    <style>
        /* General Body */
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
            color: #333;
        }
        header {
            background-color: #3b5998;
            color: white;
            padding: 20px;
            text-align: center;
            position: sticky;
            top: 0;
            z-index: 1000;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        header h1 {
            font-size: 2.5rem;
            font-weight: 700;
        }
        nav ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
        }
        nav ul li {
            margin: 0 15px;
        }
        nav ul li a {
            color: white;
            text-decoration: none;
            font-size: 1.2rem;
            font-weight: 500;
        }
        nav ul li a:hover {
            color: #ffcc00;
        }

        /* Profile Icon & Dropdown */
        .profile-icon {
            position: absolute;
            top: 20px;
            right: 20px;
        }
        .profile-icon i {
            font-size: 28px;
            color: white;
            cursor: pointer;
        }
        .dropdown {
            position: relative;
            display: inline-block;
        }
        .dropdown-content {
            display: none;
            position: absolute;
            background-color: white;
            min-width: 200px;
            box-shadow: 0px 8px 16px rgba(0, 0, 0, 0.2);
            z-index: 1;
            right: 0;
            border-radius: 5px;
            overflow: hidden;
        }
        .dropdown-content a {
            color: #333;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
            font-size: 1.1rem;
        }
        .dropdown-content a:hover {
            background-color: #f1f1f1;
        }
        .dropdown:hover .dropdown-content {
            display: block;
        }

        /* Hero Section */
        .hero-section {
            background: url('images/dd.jpeg.jpg') no-repeat center center/cover;
            color: white;
            padding: 100px 0;
            text-align: center;
            box-shadow: inset 0 0 100px rgba(0, 0, 0, 0.4);
        }
        .hero-section h1 {
            font-size: 3.5rem;
            margin-bottom: 20px;
        }
        .hero-section p {
            font-size: 1.5rem;
            margin-bottom: 40px;
        }
        .btn-primary {
            background-color: #ff6600;
            color: white;
            padding: 15px 40px;
            font-size: 1.2rem;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .btn-primary:hover {
            background-color: #ff4500;
        }

        /* Container & Sections */
        .container {
            padding: 50px 15px;
            background-color: white;
            max-width: 1200px;
            margin: auto;
        }
        .container h2 {
            font-size: 2.5rem;
            color: #3b5998;
            margin-bottom: 20px;
        }
        .container p {
            font-size: 1.2rem;
            margin-bottom: 30px;
            line-height: 1.6;
        }

        /* Features */
        .features ul {
            list-style: none;
            padding: 0;
            display: flex;
            justify-content: space-around;
            flex-wrap: wrap;
        }
        .features ul li {
            width: 28%;
            background-color: #f9f9f9;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s;
        }
        .features ul li:hover {
            transform: scale(1.05);
        }
        .features ul li h3 {
            font-size: 1.8rem;
            margin-bottom: 10px;
            color: #ff6600;
        }
        .features ul li p {
            font-size: 1rem;
            line-height: 1.4;
            color: #666;
        }

        /* Footer */
        footer {
            background-color: #333;
            color: white;
            padding: 30px 0;
            text-align: center;
        }
        footer p {
            font-size: 0.9rem;
            margin: 0;
        }

        /* Media Queries for responsiveness */
        @media (max-width: 768px) {
            nav ul li {
                margin: 0 10px;
            }
            .hero-section h1 {
                font-size: 2.5rem;
            }
            .btn-primary {
                padding: 10px 30px;
                font-size: 1rem;
            }
            .features ul li {
                width: 100%;
                margin: 10px 0;
            }
        }
    </style>
</head>
<body>
    <!-- Header Navigation -->
    <header>
        <h1>Internship Management System</h1>
        <nav>
            <ul class="nav-list">
                <li><a href="home.jsp">Home</a></li>
                <li><a href="viewInternships.jsp">View Internships</a></li>
                <li><a href="addInternship.jsp">Add Internship</a></li>
                <li><a href="dashboard.jsp">Dashboard</a></li>
                <li><a href="logout.jsp">Logout</a></li>
            </ul>
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

    <!-- Hero Section -->
    <div class="hero-section">
        <h1>Discover Your Next Internship</h1>
        <p>Connecting students with companies for real-world experiences</p>
        <a href="dashboard.jsp" class="btn-primary">Explore Internships</a>
    </div>

    <!-- Main Content -->
    <div class="container">
        <section>
            <h2>About Our System</h2>
            <p>Our Internship Management System helps bridge the gap between students and companies. We offer a user-friendly platform where students can search and apply for internships, while companies can manage their listings and recruit top talent.</p>
        </section>

        <section class="features">
            <h2>Key Features</h2>
            <ul>
                <li>
                    <h3>Wide Internship Listings</h3>
                    <p>Find internships across different industries with detailed descriptions and application instructions.</p>
                </li>
                <li>
                    <h3>Real-Time Tracking</h3>
                    <p>Track the status of your internship applications and get notified of updates.</p>
                </li>
                <li>
                    <h3>Internship Details</h3>
                    <p>Students can easily add, update, and review applications through a dedicated dashboard.</p>
                </li>
            </ul>
        </section>

        <section>
            <h2>Why Choose Us?</h2>
            <p>Our platform offers a simple, secure, and efficient way to connect students and companies. Whether you’re a student looking to kickstart your career or a company seeking fresh talent, we provide the tools to make the process seamless and effective.</p>
        </section>
    </div>

    <!-- Footer -->
    <footer>
        <p>&copy; 2024 Internship Management System. All rights reserved.</p>
    </footer>
</body>
</html>