# Student Management System

A Java-based student record management application that demonstrates core OOP concepts, exception handling, multithreading, and interface implementation.

## Features

- **Student Record Management**: Add and search student records
- **Automatic Grade Calculation**: Grades assigned based on marks (A/B/C/D)
- **Custom Exception Handling**: Robust error handling for invalid inputs
- **Multithreading**: Loading animation using threads
- **Input Validation**: Validates student data (marks range, empty fields)

## Technologies Used

- Java
- Object-Oriented Programming
- Exception Handling
- Multithreading
- Collections Framework (HashMap)

## Class Structure

### Main Classes
- **`Student`**: Represents a student with roll number, name, email, course, marks, and auto-calculated grade
- **`StudentManager`**: Manages student records using HashMap, implements RecordActions interface
- **`StudentNotFoundException`**: Custom exception for handling missing student records
- **`Loader`**: Runnable class for displaying loading animation
- **`RecordActions`**: Interface defining core operations (add/search students)

## Grading System

| Marks Range | Grade |
|-------------|-------|
| 90 - 100    | A     |
| 75 - 89     | B     |
| 60 - 74     | C     |
| 0 - 59      | D     |

## How to Run

1. **Compile the program:**
   ```bash
   javac Main.java
   ```

2. **Run the program:**
   ```bash
   java Main
   ```

3. **Follow the prompts to enter student information:**
   - Roll Number (Integer)
   - Name (String)
   - Email (String)
   - Course (String)
   - Marks (Double, 0-100)

## Sample Run

```
Enter Roll No (Integer): 101
Enter Name: Rhythm
Enter Email: Rhythm@example.com
Enter Course: Computer Science
Enter Marks (Double): 85.5
Loading.....
Student added successfully!

Roll No: 101
Name: Rhythm
Email: Rhythm@example.com
Course: Computer Science
Marks: 85.5
Grade: B

Program execution completed.
```

## Error Handling

The application handles various error scenarios:
- **Invalid Number Format**: Non-numeric input for roll number or marks
- **Empty Fields**: Name or course cannot be empty
- **Invalid Marks Range**: Marks must be between 0 and 100
- **Student Not Found**: Custom exception when searching for non-existent students
- **Thread Interruption**: Handles interrupted thread exceptions

## Requirements

- Java Development Kit (JDK) 8 or higher# Student_ManagementSystem
