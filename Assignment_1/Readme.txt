Language Analyser – Java Assignment
Student Name: Glory Pierce Eguare
Student Number: C17332081
Course Code: DT211C

Links
YouTube: https://youtu.be/IUsDeT13lUM
GitHub: https://github.com/GloryPierceEguare/Java-Assignment/tree/master/Assignment_1

Classes
Control – the main() class used to run the whole program.

GUI – the first GUI class, the first gui page that the user sees when they 
      run the program and this gui also acts a home screen for the program.

TextGUI – when the ‘Enter Text’ button is pressed from the home gui page this is next gui page that will be 
	  displayed to the user. This page is used for entering in strings of text directly for analysation. The 
	  text entered is then sent to the TextRead class to be analysed. When the user is finished with 
	  this page they can click the ‘Home’ button to return to the home gui page.

FileGUI – when the ‘Choose File’ button is pressed from the home gui page this is the next gui page that will 
	  be displayed to the user. This page is used for entering files to be analysed. The files entered are then 
	  sent to the FileRead class to begin analysation. When the user is finished with this page, they can 
	  click the ‘Home’ button to return to the home gui page.

TextRead – this is the class that all text needs to be passed through whether it has come from a file entered in the 
	   FileGUI or just plain text entered in the TextGUI. This is where most of the analysation takes place. Points 
	   are also awarded things like correct spelling, punctuation and sentence structure. Each of these things carry one 
	   point and these points are then used to calculate the percentages of formal and informal language.

FileRead – this class is specifically for the use of files entered in through the FileGUI. This class simply writes the contents 
	   of the file into a string and then passes that string to the TextRead class for it to be analysed.

Added Features
* File Chooser
* GUI
* User text analysis
* Help Messages

Extras Used
I quickly constructed another java program that would rewrite a file to lower case letters only and remove all punctuation from it as 
well. I needed to make this program so that my ‘English’ dictionary text file would work more efficiently, and because I was going to 
convert all strings and files entered into my program to lower case so now, they could be analysed easier.