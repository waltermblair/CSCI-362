public class Calculator {
	public enum BiOperatorModes {
		normal, add, minus, multiply, divide
	}

	public enum MonoOperatorModes {
		square, squareRoot, oneDevidedBy, cos, sin, tan
	}

	private Double num1, num2;
	private BiOperatorModes mode = BiOperatorModes.normal;

	private Double calculateBiImpl() {
		if (mode == BiOperatorModes.normal) {
			return num2;
		}
		if (mode == BiOperatorModes.add) {
			return num1 + num2;
		}
		if (mode == BiOperatorModes.minus) {
			return num1 - num2;
		}
		if (mode == BiOperatorModes.multiply) {
			return num1 * num2;
		}
		if (mode == BiOperatorModes.divide) {
			return num1 / num2;
		}

		// never reach
		throw new Error();
	}

	public Double calculateBi(BiOperatorModes newMode, Double num) {
		if (mode == BiOperatorModes.normal) {
			num2 = 0.0;
			num1 = num;
			mode = newMode;
			return Double.NaN;
		} else {
			num2 = num;
			num1 = calculateBiImpl();
			mode = newMode;
			return num1;
		}
	}

	public Double calculateEqual(Double num) {
		return calculateBi(BiOperatorModes.normal, num);
	}

	public Double reset() {
		num2 = 0.0;
		num1 = 0.0;
		mode = BiOperatorModes.normal;

		return Double.NaN;
	}

	public Double calculateMono(MonoOperatorModes newMode, Double num) {
		if (newMode == MonoOperatorModes.square) {
			// Fault Injection 1
			// return num * num;
			return num * num + 1;
		}
		if (newMode == MonoOperatorModes.squareRoot) {
			// Fault Injection 2
			// return Math.sqrt(num);
			return Math.sqrt(num) + 1;
		}
		if (newMode == MonoOperatorModes.oneDevidedBy) {
		    // Fault Injection 3
		    // return 1 / num;
			return 2 / num;
		}
		if (newMode == MonoOperatorModes.cos) {
			// Fault Injection 4
			// return Math.cos(num);
			return 1.0 / Math.cos(num);
		}
		if (newMode == MonoOperatorModes.sin) {
			return Math.sin(num);
		}
		if (newMode == MonoOperatorModes.tan) {
			// Fault Injection 5
			// return Math.tan(num);
			return 1.0 / Math.tan(num);
		}

		// never reach
		throw new Error();
	}

}
