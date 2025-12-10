# flu-track-system
5003 group project

## Project Overview
This is an influenza/epidemic information management system developed with Java Swing, designed to manage influenza-related information on campus, including patient information, nucleic acid testing, vaccination, close contacts, and other data management and statistics.

## Tech Stack

- **Programming Language**: Java
- **UI Framework**: Java Swing
- **Database**: MySQL
- **Database Driver**: MySQL Connector/J 8.0.23

## Main Features

- User login and authentication
- Patient information management (Pat)
- Nucleic acid test record management (Nat)
- Vaccination management (Isino)
- Close contact management (Clop)
- Category management (Cate)
- User operation log (Userlog)
- Data statistics and queries

## Project Structure

```
influenza_management/
├── src/com/zl/          # Source code directory
│   ├── dao/             # Data access layer
│   ├── model/           # Data models
│   ├── frame/           # Window interfaces
│   ├── panel/           # Panel components
│   └── uitls/           # Utility classes
├── database/            # Database scripts
│   ├── init.sql         # Database initialization script
│   └── create-db-template.sql
└── lib/                 # Dependencies
    └── mysql-connector-java-8.0.23.jar
```

## Requirements

- JDK 11
- MySQL 8.0 or higher
- IDE: VScode or Eclipse

## Quick Start

1. Import the project into your IDE
2. Configure database connection (modify database connection information in `DbUtil.java`)
3. Execute `database/init.sql` to initialize the database
4. Run the main class `com.zl.Index` to start the application
5. You can also run the following command in the cmd (Command Prompt) under the path of the unzipped folder to execute it.(java -cp "out\production\flu_track_sys;lib\
mysql-connector-java-8.0.23.jar" com.zl.Index)

## Notes

- Ensure MySQL service is running before first launch
- Create a database named `campus_covid_system`
- Modify database connection configuration according to your actual environment
