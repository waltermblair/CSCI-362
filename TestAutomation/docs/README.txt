Testing Instructions:

Clone the project from the Team TBD repository.
Navigate to the TestAutomation folder.
Run ./scripts/runAllTests.sh


Fault Injection:

All faults were injected in project/src/Calculator.java. All of the faults involve changing the calculator method’s calculation that is performed in the method’s return statement. The square, squareRoot, and oneDevidedBy [sic] faults understandably cause all related test cases to fail, but the replacement of cosine with secant and tangent with cotangent leave some room for test cases to potentially pass.

To fix each fault injection, just uncomment the return statement that is commented and comment out the return statement below it.


Open Source Project:

Clone the project from ph7-Simple-Java-Calculator 
To run, navigate to project directory and type <java -jar SimpleJavaCalculator.jar>
