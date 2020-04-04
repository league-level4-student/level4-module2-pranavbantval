package StringMethods;

import java.util.Arrays;
import java.util.Base64;

/*
Visit the JavaDocs for the String class to view everything you can do with a String.  


HINT:  Here are some String methods you might find useful 
contains
replace
trim
length
getBytes
endsWith
split 
indexOf
lastIndexOf
compareTo(IgnoreCase)
substring


Here are some Character methods you might find useful:
Character.toLowerCase(char c);
Character.isLetter(char c);
Character.isDigit(char c);
Character.getNumericValue(char c);
 */

public class StringMethods {

	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {
		if (s1.length() >= s2.length()) {
			return s1;
		} else if (s2.length() > s1.length()) {
			return s2;
		} else {
			return null;
		}
	}

	// if String s contains the word "underscores", change all of the spaces to
	// underscores
	public static String formatSpaces(String s) {

		if (s.contains("underscores")) {
			s = s.replace(' ', '_');
		}

		return s;
	}

	// Return the name of the person whose LAST name would appear first if they were
	// in alphabetical order
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	public static String lineLeader(String s1, String s2, String s3) {
		s1 = s1.trim();
		s2 = s2.trim();
		s3 = s3.trim();
		int n1 = Character.getNumericValue(s1.charAt(s1.length() - 1));
		int n2 = Character.getNumericValue(s2.charAt(s2.length() - 1));
		int n3 = Character.getNumericValue(s3.charAt(s3.length() - 1));
		if (n1 < n2 && n1 < n3) {
			return s1;
		} else if (n2 < n1 && n2 < n3) {
			return s2;
		} else if (n3 < n1 && n3 < n2) {
			return s3;
		}
		return null;
	}

	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		int x = 0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				Character c = s.charAt(i);
				x += Integer.parseInt(c.toString());
			}
		}
		return x;
	}

	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
		int x = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.contains(substring)) {
				s = s.replaceFirst(substring, "");
				x += 1;
			}
		}
		return x;
	}

	// Call Utitilities.encrypt to encrypt String s
	public static String encrypt(String s, char key) {
		byte b = (byte) key;
		s = Utilities.encrypt(s.getBytes(), b);
		return s;

	}

	// Call Utilities.decrypt to decrypt the cyphertext
	public static String decrypt(String s, char key) {
		byte b = (byte) key;
		s = Utilities.decrypt(s, b);
		return s;
	}

	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
		int x = 0;
		substring = substring + " ";
		for (int i = 0; i < s.length(); i++) {

			if (s.contains(substring)) {
				x++;
				s = s.replaceFirst(substring, " ");
			}
		}
		return x;
	}

	// Given String s, return the number of characters between the first occurrence
	// of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
		int y = s.indexOf(substring) + substring.length();
		int x = s.lastIndexOf(substring);
		s = s.substring(y, x);
		int n = s.length();
		return n;
	}

	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		
		for (int i = 0; i < s.length(); i++) {
			String test = Character.toString(s.charAt(i));
			if (!test.equalsIgnoreCase("a") && !test.equalsIgnoreCase("b") && !test.equalsIgnoreCase("c")
					&& !test.equalsIgnoreCase("d") && !test.equalsIgnoreCase("e") && !test.equalsIgnoreCase("f")
					&& !test.equalsIgnoreCase("g") && !test.equalsIgnoreCase("h") && !test.equalsIgnoreCase("j")
					&& !test.equalsIgnoreCase("k") && !test.equalsIgnoreCase("l") && !test.equalsIgnoreCase("m")
					&& !test.equalsIgnoreCase("n") && !test.equalsIgnoreCase("o") && !test.equalsIgnoreCase("p")
					&& !test.equalsIgnoreCase("q") && !test.equalsIgnoreCase("r") && !test.equalsIgnoreCase("s")
					&& !test.equalsIgnoreCase("t") && !test.equalsIgnoreCase("u") && !test.equalsIgnoreCase("v")
					&& !test.equalsIgnoreCase("w") && !test.equalsIgnoreCase("x") && !test.equalsIgnoreCase("y")
					&& !test.equalsIgnoreCase("z") && !test.equalsIgnoreCase("i")) {
				s=s.replace(test, "");
			}
		} 
		if(s.contains("€")) {
			s=s.replaceAll("€", "");
		}
		String x = "";
		for (int i = s.length()-1; i >= 0; i--) {
			x+= Character.toString(s.charAt(i));
			}
		System.out.println(x);
		System.out.println(s);
		if (x.equalsIgnoreCase(s)) {
			return true;
		}
		return false;
	}

}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a single
	// byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}
