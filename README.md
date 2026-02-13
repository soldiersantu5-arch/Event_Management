# 🎉 Event Management System

A **Java Swing Desktop Application** for managing events and attendees.
📝 A Java Swing desktop application with MySQL backend for managing events and attendees, featuring CRUD operations, a user-friendly GUI, and database connectivity practice.
This project is built to practice **GUI development**, **CRUD operations**, and **database connectivity** with **MySQL**.

---

## ✨ Features

✅ Add new events with **name, date, and location**
✅ Add attendees linked to specific events
✅ View all events with their details and attendees
✅ Simple & user-friendly **Swing-based UI**
✅ Basic **CRUD operations** with MySQL
✅ **Logging** enabled with SLF4J

---

## 🛠️ Tech Stack

* **Java (JDK 11+)** – Core programming
* **Java Swing** – Desktop GUI
* **MySQL** – Data storage
* **Maven** – Dependency & build management
* **SLF4J** – Logging

---

## 📂 Project Structure

```bash
EventManagementSystem/
│── pom.xml
│── db/
│   └── schema.sql
│
└── src/
    └── main/
        ├── java/
        │   └── ems/
        │       ├── App.java
        │       ├── db/
        │       │   └── DBConnection.java
        │       ├── dao/
        │       │   ├── EventDAO.java
        │       │   └── AttendeeDAO.java
        │       ├── model/
        │       │   ├── Event.java
        │       │   └── Attendee.java
        │       └── ui/
        │           ├── EventForm.java
        │           ├── AttendeeForm.java
        │           └── MainDashboard.java
        │
        └── resources/
            └── db.properties
```

---

## ⚙️ Installation & Setup

### 1️⃣ Clone the repository

```bash
git clone https://github.com/<your-username>/EventManagementSystem.git
cd EventManagementSystem
```

### 2️⃣ Setup Database

Run the following in MySQL:

```sql
CREATE DATABASE IF NOT EXISTS ems;
USE ems;

CREATE TABLE IF NOT EXISTS events (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    date DATE NOT NULL,
    location VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS attendees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    event_id INT,
    FOREIGN KEY (event_id) REFERENCES events(id) ON DELETE CASCADE
);
```

Update `src/main/resources/db.properties`:

```properties
db.url=jdbc:mysql://localhost:3306/ems?useSSL=false&serverTimezone=UTC
db.user=root
db.password=yourpassword
```

### 3️⃣ Build the Project

```bash
mvn clean compile
```

### 4️⃣ Run the Application

```bash
mvn exec:java
```

👉 The **Main Dashboard** will open.
From there:

* ➕ Add Events
* 👤 Add Attendees
* 📋 View Events & Attendees

---

## 📊 Verify Database

Check stored data with:

```sql
USE ems;
SELECT * FROM events;
SELECT * FROM attendees;
```

---

## 🚀 Future Enhancements

* [ ] Add **Update/Delete** functionality for events & attendees
* [ ] Generate **event reports** (PDF/Excel)
* [ ] Improve UI with **JavaFX or modern look-and-feel**
* [ ] Add **authentication & roles** (Admin/User)

---

## 👨‍💻 Author

**Santosh M C**
*Event Management System*


---

## 📜 License

This project is licensed under the **MIT License**.

---
