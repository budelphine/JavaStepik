import java.util.Arrays;

public class AsciiCharSequence implements CharSequence {
	private byte[] byteArray;

	public AsciiCharSequence(byte[] newByteArray) {
		this.byteArray = newByteArray.clone();
	}

	public int length() {
		return byteArray.length;
	}

	public char charAt(int i) {
		return (char)byteArray[i];
	}

	public String toString() {
		String str = new String(byteArray);
		return str;
	}

	public AsciiCharSequence subSequence(int iStart, int iEnd) {
		AsciiCharSequence   newByteArray;

		newByteArray = new AsciiCharSequence(Arrays.copyOfRange(byteArray, iStart, iEnd));
		return newByteArray;
	}

	public static void main(String[] args) {
		byte[] example = {72, 101, 108, 108, 111, 33};
		AsciiCharSequence answer = new AsciiCharSequence(example);
		
		System.out.println("Последовательность (Hello) - " + answer.toString());			//Hello!
		System.out.println("Размер (6) - " + answer.length());								//6
		System.out.println("Символ под №1 (e) - " + answer.charAt(1));						//e
		System.out.println("Подпоследовательность (ello) - " + answer.subSequence(1, 5));	//ello
		
		//проверка на нарушение инкапсуляции private поля
		System.out.println("Проверка на нарушение инкапсуляции private поля (Hello) - " + answer.toString());	//Hello!
		
		example[0] = 74;
		System.out.println(answer.toString());	//Hello!
	}
}
