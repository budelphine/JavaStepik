public class CallClassAndMethodName {
	public static String getCallerClassAndMethodName() {
		StackTraceElement[] stackTraceElementArrays = new Exception().getStackTrace();

		if (stackTraceElementArrays.length >= 3 ) {
			return stackTraceElementArrays[2].getClassName() + "#" + stackTraceElementArrays[2].getMethodName();
		}
		else {
			return null;
		}
	}

	static void m3() {
		System.out.println(getCallerClassAndMethodName());
	}

	static void m2() {
		System.out.println(getCallerClassAndMethodName());
		m3();
	}

	static void m1() {
		System.out.println(getCallerClassAndMethodName());
		m2();
	}

	public static void main(String[] args) {
		System.out.println(getCallerClassAndMethodName());
		m1();
	}
}
