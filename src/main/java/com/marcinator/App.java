package com.marcinator;

import com.marcinator.prettyprint.*;
import com.marcinator.prettyprint.V2.ColorAttribute;

import java.awt.Color;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		// Color textColor = new Color("#4CAF50");
		// PrettyPrint pretty = new PrettyPrint();

		// pretty.setBold(true)
		// .print("Hello")
		// .setBold(false)
		// .print(" world");

		Color foo = Color.decode("#2CC846");

		ColorAttribute attribute = new ColorAttribute(foo);

		System.out.println(attribute.getAttribute());
	}
}
