# Enhanced MiniShell

A simple yet powerful shell written in Java, featuring a color-coded interface and multiple useful commands.

![Screenshot](developer_tools/minishell.png?raw=true)

## Features
- Colorful UI with ANSI escape codes
- Dynamic prompt showing current working directory
- Comprehensive command set for file operations and system information

## Available Commands
- `ls [path]` - List directory contents (directories in blue)
- `cd [path]` - Change current directory
- `cat <file>` - Display file content
- `echo <text>` - Print text to console
- `clear` - Clear terminal screen
- `cpu` - Show CPU information
- `mem` - Show memory usage
- `date` - Show current date and time
- `help` - Show available commands
- `exit` - Exit the shell

## Getting Started
1. Compile the program:
   ```bash
   javac MShell.java
   ```
2. Run the shell:
   ```bash
   java MShell
   ```

> Note: Requires a terminal that supports ANSI color codes

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
