# BookBuddy - Library Management System

This repository contains the **BookBuddy Library Management System**, a project developed to analyze the role of AI-assisted programming in modern software development.

## Project Overview

The project demonstrates two distinct development approaches to the same problem:
1. **Version A (Traditional Approach):** Built using standard procedural logic, manual loops, and traditional error handling.
2. **Version B (AI-Assisted Approach):** Built using modern Java 17 features (Streams, Optionals, Lambdas) and robust exception handling, heavily guided and scaffolded by AI assistance.

By comparing these two implementations, the project highlights the impact of AI on development time, code quality, readability, and maintainability.

## Features

- **Librarian Operations:**
  - Add new books to the inventory
  - Register new library members
- **Member Operations:**
  - View available books
  - Borrow books
  - Return books

## Tech Stack

- **Language:** Java 17
- **Build Tool:** Maven
- **Design Tools:** Mermaid (for UML diagrams)

## Project Structure

```text
AI-Assisted-Programming/
├── pom.xml
└── src/
    └── main/
        └── java/
            └── com/
                └── assignment/
                    ├── version_a/                  (Traditional Approach)
                    │   ├── BookBuddyAppA.java      (Main Application Entry)
                    │   ├── models/
                    │   ├── services/
                    │   └── utils/
                    │
                    └── version_b/                  (AI-Assisted Approach)
                        ├── BookBuddyAppB.java      (Main Application Entry)
                        ├── models/
                        ├── services/
                        └── exceptions/
```

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 17 or higher
- Apache Maven

### Build the Project

Clone the repository and compile the project using Maven:

```bash
mvn clean compile
```

### Run the Application

You can run either version of the application:

**Run Version A (Traditional Approach):**
```bash
mvn exec:java -Dexec.mainClass="com.assignment.version_a.BookBuddyAppA"
```

**Run Version B (AI-Assisted Approach):**
```bash
mvn exec:java -Dexec.mainClass="com.assignment.version_b.BookBuddyAppB"
```

## Documentation

The repository includes a comprehensive report (`report.pdf` or `report.md`) detailing the conceptual understanding of AI-assisted programming, practical implementation comparisons, and critical analysis. The UML diagrams used for system design are also included in the `system_design.md` file and as `.png` images.
