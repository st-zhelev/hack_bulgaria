package applicationTasks;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

public class SmallestSubstringContainingTheAlphabet {

	private static final int MINIMAL_LENGTH = 26;

	public static boolean isPureAscii(String s) {
		CharsetEncoder asciiEncoder = Charset.forName("US-ASCII").newEncoder();
		return asciiEncoder.canEncode(s);
	}

	public static void main(String[] args) {

		String str = "aaaaacbcdefghijklmnopqrasdvrstuvwxyzaac";
		String s = findShortest(str);
		System.out.println("String : \n" + str);
		System.out.println("Shortest substring containing the alphabet is :\n"+s);
	}

	private static String findShortest(String str) {
		int[] helper = new int[MINIMAL_LENGTH];
		int shortestLength = 0;
		int currentLength = 0;
		int startIndex = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 97 && str.charAt(i) <= 122) {
				helper[str.charAt(i) - 97]++;
				currentLength++;
				shortestLength++;
			}
			if (isFormed(helper)) {
				break;
			}
		}

		for (int i = 0; i <= str.length() - MINIMAL_LENGTH
				&& shortestLength > MINIMAL_LENGTH; i++) {
			char c = str.charAt(i);
			currentLength--;
			if (c >= 97 && c <= 122) {
				if (helper[c - 97] <= 1) {
					boolean foundMissingChar = false;
					for (++currentLength; i + currentLength < str.length(); ++currentLength) {
						int nextChar = str.charAt(i + (currentLength));
						if (nextChar >= 97 && nextChar <= 122) {
							if (nextChar == str.charAt(i)) {
								startIndex++;
								foundMissingChar = true;
								break;
							} else {
								helper[nextChar - 97]++;
							}
						}
					}
					if (foundMissingChar == false) {
						startIndex++;
						break;
					}

				} else {
					helper[c - 97]--;
				}
			}

			if (currentLength < shortestLength) {
				shortestLength = currentLength;
				startIndex = i;
			}

		}
		return str.substring(startIndex, startIndex + shortestLength);
	}

	private static boolean isFormed(int[] helper) {
		for (int i = 0; i < helper.length; i++) {
			if (helper[i] <= 0) {
				return false;
			}
		}
		return true;
	}
}
