import java.util.function.DoubleUnaryOperator;

public class IntegralFunction {
	//метод левых прямоугольников

	public static void main(String[] args) {
		System.out.println(integrate(x -> 1, 0, 10));//10.0
		System.out.println(integrate(x -> x + 2, 0, 10));//70.0
		System.out.println(integrate( x -> Math.sin(x) / x , 1, 5));//0.603848
	}

	public static double integrate(DoubleUnaryOperator f, double a, double b) {

		double  widthOfSegment = 0.0000001;
		double  numOfSegment = (b - a) / widthOfSegment;
		double  heightOfSegment, result;

		result = 0;

		for(int curSegment = 0; curSegment < numOfSegment; curSegment++) {
			heightOfSegment = f.applyAsDouble(a + widthOfSegment * curSegment);
			result += heightOfSegment * widthOfSegment;
		}

		return result;
	}
}