package com.common.code;

import java.util.Random;

public class Code {
	private static String generateRandomCode() {
		StringBuffer strCode = new StringBuffer();
		for (int type : randomTypes()) {
			strCode.append(randomChar(type));
		}
		return strCode.toString();
	}

	private static char randomChar(int type) {
		Random r = new Random();
		final String[] strs = new String[] { "abcdefghijklmnopqrstuvwxyz",
				"0123456789", };
		String typeStr = strs[type];
		return typeStr.charAt(r.nextInt(typeStr.length()));
	}

	private static int[] randomTypes() {
		final int[][] indexes = new int[][] { { 0, 0, 1, 1 }, { 0, 1, 0, 1 },
				{ 0, 1, 1, 0 }, { 1, 0, 0, 1 }, { 1, 0, 1, 0 }, { 1, 1, 0, 0 }, };
		Random r = new Random();
		return indexes[r.nextInt(indexes.length)];
	}

	public static void main(String[] args) {
		System.out.println(generateRandomCode());
	}

}
