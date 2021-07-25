import java.util.*;

// ArrayList
public class evenPosCollection {
	public static void main(String[] args) throws Exception {
		List<Integer> evenPos = new ArrayList<>();

		int i = 0;
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int val = sc.nextInt();

			if (++i % 2 == 0) {
				evenPos.add(val);
			}
		}

		Collections.reverse(evenPos);
		evenPos.forEach(x -> System.out.print(x + " "));
	}
}
