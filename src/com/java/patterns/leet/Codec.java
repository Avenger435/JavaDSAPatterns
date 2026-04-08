package com.java.patterns.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Codec {

	public static String encode(List<String> strs) {
		StringBuilder encoded = new StringBuilder();
		for (final String s : strs) {
			encoded.append(s.length()).append('/').append(s);
		}
		return encoded.toString();
	}

	public static List<String> decode(String s) {
		List<String> decoded = new ArrayList<>();

		for (int i = 0; i < s.length();) {
			final int slash = s.indexOf('/', i);
			final int length = Integer.parseInt(s.substring(i, slash));
			i = slash + length + 1;
			decoded.add(s.substring(slash + 1, i));

		}
		return decoded;
	}

	public static void main(String[] args) {

		List<String> strs = Arrays.asList("Array", "List");

		String encode = encode(strs);
		System.out.println("encode: " + encode);

		List<String> decoded = decode(encode);
		System.out.println(decoded);

	}
}
