Project guidelines provided by professor:

CalculatorUI.java does not support the Open Close Principal very well.  Use separate button creation and panel classes, do the following:
Reorganize the buttons into groups of primitive operators (+,-,/,*,=), trigonometric operators (sin, cos, tan), common function operators (
,  x2,  1/x).  Make errors but do not tell me about them. it. 
You decide how you will design and implement this grouping. .
Refactor the panel.add() calls and addActionListener() calls so that they are not all done sequentially in init().
Note:  You will be submitting to ChatGPT both the original CalculatorUI.java and the refactored CalculatorUI.java.  When you submit them to ChatGPT, name the CalculatorUI.java on the master branch, CalculatorUI_before.java.  Name the CalculatorUI.java on your branch CalculatorUI_after.java.   Note on this Note:  You don't rename the file(s) on your project.  You just rename them when giving them to ChatGPT.
 Study the following refactoring techniques to help you:
https://sourcemaking.com/refactoring/extract-methodLinks to an external site.
https://sourcemaking.com/refactoring/replace-method-with-method-objectLinks to an external site. 
https://sourcemaking.com/refactoring/consolidate-conditional-expressionLinks to an external site. 
https://sourcemaking.com/refactoring/consolidate-duplicate-conditional-fragmentsLinks to an external site. 
https://sourcemaking.com/refactoring/replace-conditional-with-polymorphismLinks to an external site. 
Write 1 unit tests each for:
reader()
writer()
Write 8 unit tests for actionPerformed() 
You may change the modifiers for the following from private to public.  
private final JFrame frame;
private final JPanel panel;
private final JTextArea text;
private final JButton jButtons[], add, sub, mult, div, equal, cancel, sqrRt, sqr, inverse, cos, sin, tan;
private final String[] buttonValue = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
private final Calculator calc;
For Calculator.java:  Make errors but do not tell me about them. it
Write 7 unit tests, for twoOpOperations()
at least 3 of the unit tests must be of two or more primitive operations.  For example, "2+3*6" or "3*2/5".
You may change the modifiers for the following from private to public: 
private Double num1, num2;
private twoOperator model;
private Double twoOpOperations () 
Write 2 unit tests for twoOpCaller()
For both CalculatorUI.java, Calculator.java and the new files you created for the panels and buttons.
Add buttons and the corresponding calculation code for cos-1, sin-1, tan-1
Add at least one unit test per function for each function.
