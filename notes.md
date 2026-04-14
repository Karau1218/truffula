# Truffula Notes
As part of Wave 0, please fill out notes for each of the below files. They are in the order I recommend you go through them. A few bullet points for each file is enough. You don't need to have a perfect understanding of everything, but you should work to gain an idea of how the project is structured and what you'll need to implement. Note that there are programming techniques used here that we have not covered in class! You will need to do some light research around things like enums and and `java.io.File`.

PLEASE MAKE FREQUENT COMMITS AS YOU FILL OUT THIS FILE.

## App.java
App java is where the main method is and deals with the user input to which you create the options of the tree - whether it should be colored or not, whther to show hidden stuff or no, the directory path. the truffula options is where these options are and you make the truffula printer using these options . then youncall printtree on the truffula printer to display it 

## ConsoleColor.java
The consolecolor enum has the ANSI escape codes that color the texts in the console. Each color has its string code and can be used in print statements
## ColorPrinter.java / ColorPrinterTest.java
The color printer basically prints the messages with the colorcodes applied on the text. setcurrentcolor sets the color for future prints, getcurrentcolor return the color being used now. println --> calls print and adds a newline, println (string message, boolean reset) --> prints the message, the color code  
## TruffulaOptions.java / TruffulaOptionsTest.java
this is where the options apply - the directory to print, whrther files should be hidden or showed / wther color output should be enabled
## TruffulaPrinter.java / TruffulaPrinterTest.java
This class basically prints the directory tree with the options provided. You basically traverse the and print each file / folder
## AlphabeticalFileSorter.java