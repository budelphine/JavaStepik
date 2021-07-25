import java.util.Objects;

public final class ComplexNumber {
	private final double re;
	private final double im;

	public ComplexNumber(double re, double im) {
		this.re = re;
		this.im = im;
	}

	public double getRe() {
		return re;
	}

	public double getIm() {
		return im;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		ComplexNumber that = (ComplexNumber) obj;
		return Double.compare(that.re, re) == 0 &&
				Double.compare(that.im, im) == 0;
	}

	@Override
	public int hashCode() {
		final int	prime = 31;
		int			result = 17;

		int	tmpRe = (int)(Double.doubleToLongBits(re) - (Double.doubleToLongBits(re) >> 32));
		int	tmpIm = (int)(Double.doubleToLongBits(im) - (Double.doubleToLongBits(im) >> 32));

		result = prime * result + tmpRe;
		result = prime * result + tmpIm;

		return result;
	}

	public static void main(String[] args) {
		ComplexNumber cn1 = new ComplexNumber(2.3412, 7.2434);
		ComplexNumber cn2 = new ComplexNumber(2.3412, 7.2434);
		ComplexNumber cn3 = new ComplexNumber(3.23124, 1435.23);

		System.out.println("Some tests for ComplexNumber:");
		System.out.println("");

		System.out.println("Equals cn1 & cn2 is true -- " + cn1.equals(cn2));
		System.out.println("Equals cn2 & cn1 is true -- " + cn2.equals(cn1));
		System.out.println("Equals cn2 & cn3 is false -- " + cn2.equals(cn3));
		System.out.println("Equals cn3 & cn1 is false -- " + cn3.equals(cn1));
		System.out.println("");

		System.out.println("Hash cn1 & cn2 is true -- " + (cn1.hashCode() == cn2.hashCode()));
		System.out.println("Hash cn2 & cn1 is true -- " + (cn2.hashCode() == cn1.hashCode()));
		System.out.println("Hash cn3 & cn1 is false -- " + (cn3.hashCode() == cn1.hashCode()));
		System.out.println("Hash cn3 & cn2 is false -- " + (cn3.hashCode() == cn2.hashCode()));
	}
}
