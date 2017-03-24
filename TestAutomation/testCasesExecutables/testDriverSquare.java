import java.util.*;
import java.io.*;

class testDriverSquare {
	public static void main(String[] args) {
		// Instance of Calculator class
		Calculator calc = new Calculator();
		Double num = Double.parseDouble(args[0]);
		try {
			System.out.println(calc.calculateMono(Calculator.MonoOperatorModes.square, num));
		}
		catch(Exception e) {
			System.out.println("Need command-line args!");
		}
	}
}
