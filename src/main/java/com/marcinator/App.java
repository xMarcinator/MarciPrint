package com.marcinator;

import com.marcinator.prettyprint.*;

import java.awt.Color;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		PrettyColor textColor = new PrettyColor("#4CAF50");
		PrettyPrint pretty = new PrettyPrint(textColor);

		pretty.setBold(true)
				.print("Hello")
				.setBold(false)
				.print(" world");
	}
}
