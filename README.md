# JDBC Learning Project with Builder Design Pattern

This project demonstrates how to work with **JDBC** (Java Database Connectivity) while applying the **Builder Design Pattern** to create clean, maintainable, and flexible code.  
It includes database CRUD operations and a proper Maven setup for dependency management.

---

## 🚀 Features
- Connect to a **MySQL/MariaDB database** using JDBC
- CRUD operations on an `Employee` table
- Implementation of the **Builder Pattern** for constructing `Employee` objects
- Uses **Maven** for dependency management and project structure
- Includes SQL script for database setup
- Ready for deployment with shaded JAR packaging
- Git workflow with **SSH authentication** (no password needed)

---

## 📂 Project Structure


jdbc/
│
├── database/
│ └── db_queries.sql # SQL script to create database and table
│
├── src/main/java/com/jdbc/
│ ├── Main.java # Application entry point
│ │
│ ├── dao/ # Data Access Layer
│ │ ├── DBConnection.java
│ │ ├── EmployeeDao.java
│ │ └── EmployeeDaoImpl.java
│ │
│ ├── model/ # Model Layer
│ │ ├── Employee.java
│ │ └── EmployeeBuilder.java
│ │
│ └── utils/ # Utilities
│ └── Utils.java
│
├── pom.xml # Maven dependencies and build config
└── README.md # Documentation



---

## 🗄 Database Setup
Run the SQL script to create your database and `Employee` table.

### 1. Connect to MySQL/MariaDB
```bash
mysql -u root -p


2. Execute the SQL script
source database/db_queries.sql;


Install dependencies
mvn clean install

mvn clean package

mvn exec:java -Dexec.mainClass="com.jdbc.Main"

java -jar target/jdbc-1.0-SNAPSHOT-shaded.jar






🏗 Builder Pattern Example

This project uses the Builder Pattern for constructing Employee objects in a readable and maintainable way.

Example:
Employee employee = new EmployeeBuilder()
    .setId(0)
    .setName("Hadi")
    .setActive(true)
    .setJoinDate(new java.sql.Date(System.currentTimeMillis()))
    .setSalary(25000d)
    .build();



📝 Example Output

When running Main.java, you should see:
✅ Database connection established successfully.
Employee saved successfully!


🧩 Technologies Used

Java 17

Maven

MySQL / MariaDB

JDBC

Builder Design Pattern

Git + SSH Authentication



🤝 Contribution

Contributions are welcome!
Feel free to:

Fork the repo

Create a new branch

Submit a pull request



👤 Author

Elhadi Muhamedd
GitHub Profile
