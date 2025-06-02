<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
 
</head>
<body>

  <h1>✈️ Flight Management System (JDBC Based)</h1>

  <p>This is a simple <strong>Flight Management System</strong> built using <strong>Java</strong> and <strong>JDBC (Java Database Connectivity)</strong>. The project demonstrates basic CRUD operations on a flight database, allowing users to add, view, update, and delete flight records.</p>

  <h2>📌 Features</h2>
  <ul>
    <li>Add new flight details to the database</li>
    <li>View existing flights</li>
    <li>Update flight information</li>
    <li>Delete a flight</li>
    <li>User-friendly command-line interface</li>
    <li>Uses JDBC for seamless interaction with the database</li>
  </ul>

  <h2>🛠️ Technologies Used</h2>
  <ul>
    <li>Java (Core + JDBC)</li>
    <li>MySQL (Database)</li>
    <li>IntelliJ IDEA (Recommended IDE)</li>
    <li>Command Line Interface (CLI)</li>
  </ul>

  <h2>📂 Project Structure</h2>
  <pre>
FlightManagementSystem/
├── Flight.java            # Core logic for interacting with the database
├── FlightManagementSystem.iml
├── .gitignore
└── README.md              # Project documentation
  </pre>

  <h2>🔗 Database Configuration</h2>
  <p>Ensure you have MySQL installed and a database created with a <code>flight</code> table. Below is a sample schema you can use:</p>

  <pre>
CREATE DATABASE flight_db;

USE flight_db;

CREATE TABLE flight (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    source VARCHAR(50),
    destination VARCHAR(50),
    duration DOUBLE
);
  </pre>

  <p>Update the JDBC connection details in <code>Flight.java</code> as needed:</p>

  <pre>
String url = "jdbc:mysql://localhost:3306/flight_db";
String user = "your_mysql_username";
String password = "your_mysql_password";
  </pre>

  <h2>🚀 How to Run</h2>
  <ol>
    <li><strong>Clone the repository</strong>
      <pre>
git clone https://github.com/yourusername/FlightManagementSystem.git
cd FlightManagementSystem
      </pre>
    </li>
    <li><strong>Open in IntelliJ IDEA</strong> or any Java-supported IDE.</li>
    <li><strong>Set up your MySQL database</strong> (see the schema above).</li>
    <li><strong>Run <code>Flight.java</code></strong></li>
    <li><strong>Follow the console prompts</strong> to manage flight records.</li>
  </ol>

  <h2>📸 Sample Console Menu</h2>
  <pre>
1. Add Flight
2. View Flights
3. Update Flight
4. Delete Flight
5. Exit
Enter your choice:
  </pre>

  <h2>🧠 Learning Outcomes</h2>
  <ul>
    <li>Working with JDBC in Java</li>
    <li>Database connectivity and SQL operations</li>
    <li>Building a CLI-based application</li>
    <li>Clean, modular Java code structure</li>
  </ul>

  <h2>🤝 Contributing</h2>
  <p>Contributions are welcome! Feel free to fork the repository and submit pull requests.</p>

  <h2>📄 License</h2>
  <p>This project is licensed under the <a href="#">MIT License</a>.</p>

  <hr>

  <h2>🙋‍♂️ Author</h2>
  <p><strong>Md Ehtesham</strong></p>
  <ul>
    <li>🔗 <a href="https://github.com/yourusername">GitHub Profile</a></li>
    <li>📧 ehtesham@example.com</li>
  </ul>

</body>
</html>
