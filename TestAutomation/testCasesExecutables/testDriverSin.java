import java.util.*;
import java.io.*;

class testDriverSin {
	public static void main(String[] args) {
		// Instance of Calculator class
		Calculator calc = new Calculator();
		Double num = Double.parseDouble(args[0]);

		// args is input, test that args contains these
		try {
			System.out.println(calc.calculateMono(Calculator.MonoOperatorModes.sin, num));
		}
		catch(Exception e) {
			System.out.println("Need command-line args!");
		}
	}
}
