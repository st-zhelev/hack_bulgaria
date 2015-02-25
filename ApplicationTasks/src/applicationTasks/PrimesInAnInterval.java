package applicationTasks;

import java.util.ArrayList;

public class PrimesInAnInterval {
	public static void main(String[] args) {
		ArrayList<Integer> primesList = primesInAnInterval(2, 20);
		if (primesList != null) {
			System.out.println(primesList.toString());
		}
	}

	private static ArrayList<Integer> primesInAnInterval(int firstNum, int lastNum) {
		if (firstNum < 1 || lastNum < 1 || firstNum > lastNum) {
			return null;
		}

		ArrayList<Integer> primesList = new ArrayList<>();
		for (int i = 5, k = 4;; i += k) {
			if (i >= firstNum && i <= lastNum && i % 2 != 0 && i % 3 != 0) {
				primesList.add(i);
			} else if (i > lastNum) {
				return primesList;
			}
			k = 6 - k;

		}

	}

}
