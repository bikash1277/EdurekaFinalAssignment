package com.edureka.utility;

public class RandomGenerator {
	static String Random;
	static String abc ;
	static double number, value;
	static int len;
	public RandomGenerator() {
		abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random = "";
		number = Math.random();
	}
	public String randomStringGenerator(int length) {
		for (int i = 0; i < length; i++) {
			double a = Math.random();
			int x = (int) (a * 100);
			if (x > 25 && x < 52) {
				x = x - 26;
			} else if (x > 51 && x < 78) {
				x = x - 52;
			} else if (x > 77 && x < 99) {
				x = x - 78;
			} else {	x = 1;	}
			char letter = abc.charAt(x);
			Random = Random + String.valueOf(letter);
		}return Random;
	}
	public String randomNumberGenerator(int length) {
		
		
		StringBuffer s = new StringBuffer(length);
		s.append("1");
		for (int k = 0; k < length; k++) {
			s.append("0");
		}
		value = Double.parseDouble(s.toString());
		number = number * value;
		int random = (int) (number);
		String randomno = Integer.toString(random);
		len = randomno.length();
		if (len < length) {
			int diff = length - len;
			StringBuffer s1 = new StringBuffer(randomno);
			for (int k = 0; k < diff; k++) {
				s1.append("0");
			}
			randomno = s1.toString();
		}	return randomno; }
}
