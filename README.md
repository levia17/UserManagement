# User Management System

A simple command-line Java application for managing files with basic file operations.

## Features

- Create new files
- Write content to files
- Read and display file contents
- Edit files with find and replace functionality
- Interactive command-line interface

## Project Structure

```
UserManagement/
├── Main.java                           # Entry point
├── src/
│   ├── lib/
│   │   └── interfaces/                 # Interface definitions
│   │       ├── CommandHandler.java
│   │       ├── FileHandler.java
│   │       └── SystemUserManagementHandler.java
│   ├── service/
│   │   └── SystemUserManagement.java  # Main system logic
│   └── utils/
│       ├── FileUtils.java              # File operation utilities
│       └── system/
│           └── CommandUtils.java       # Command processing
└── README.md
```

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- A text editor or IDE (optional but recommended)

## Compilation

To compile the project, run the following command from the project root directory:

```bash
javac Main.java src/service/*.java src/utils/*.java src/utils/system/*.java src/lib/interfaces/*.java
```

## Running the Application

After compilation, run the application using:

```bash
java Main
```

## Available Commands

| Command | Syntax | Description |
|---------|--------|-------------|
| `crf` | `crf <filename>` | Create a new file |
| `wrf` | `wrf <filename> <content>` | Write content to a file (appends if file exists) |
| `rdf` | `rdf <filename>` | Read and display file contents |
| `edf` | `edf <filename>` | Edit file using find and replace |
| `help` | `help` | Display available commands |
| `q` | `q` | Quit the application |

## Usage Examples

### Creating a File
```
Command: crf myfile.txt
File created: myfile.txt
```

### Writing to a File
```
Command: wrf myfile.txt Hello World
Successfully wrote to the file: myfile.txt
```

### Reading a File
```
Command: rdf myfile.txt

--- File Contents: myfile.txt ---
Hello World
--- End of File ---
```

### Editing a File
```
Command: edf myfile.txt
Enter text to replace: 
World
Enter replacement text: 
Universe
File edited successfully.
```

### Getting Help
```
Command: help

--- Available Commands ---
crf <filename>              - Create a new file
wrf <filename> <content>    - Write content to a file
rdf <filename>              - Read and display file contents
edf <filename>              - Edit file (find and replace)
help                        - Show this help message
q                           - Quit the application
```

## Error Handling

The application includes comprehensive error handling for:
- Missing command arguments
- Invalid file paths
- File permission issues
- I/O errors
- Invalid regex patterns in find/replace

## Code Quality Improvements

This codebase has been improved with:
- **JavaDoc Comments**: All public methods are documented
- **Input Validation**: Proper boundary checking and null checks
- **Exception Handling**: Specific exception types instead of generic catches
- **User Feedback**: Clear error messages and success confirmations
- **Java Conventions**: Proper naming conventions (camelCase for methods)
- **Resource Management**: Try-with-resources for proper resource cleanup
- **Help System**: Built-in help command for user guidance

## Security Considerations

- Input validation prevents ArrayIndexOutOfBoundsException
- File operations include permission checks
- Pattern syntax validation for regex operations
- No sensitive data logging

## Future Enhancements

Potential improvements for future versions:
- Add unit tests (JUnit)
- Support for file deletion
- Directory operations
- File move/rename functionality
- Configuration file support
- Logging framework integration
- Command history
- Tab completion

## License

This project is for educational purposes.

## Contributing

When contributing to this repository, please ensure:
1. Follow Java naming conventions
2. Add JavaDoc comments to all public methods
3. Include proper error handling
4. Test your changes thoroughly
5. Update documentation as needed
