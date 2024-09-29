package PracPro.PracPro;

public class Debug {
	static int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	public static void main(String[] args) {
		try {
			System.out.println(sumArray(numbers));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int sumArray(int[] numbers) {
		int sum = 0;
		for (int i = 0; i < numbers.length ; i++) { // This line causes the off-by-one error
			sum += numbers[i];
		}
		return sum;
	}

}
