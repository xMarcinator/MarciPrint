package com.marcinator;

import com.marcinator.prettyprint.*;

import java.awt.Color;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Color foo = Color.decode("#2CC846");

		ColorAttribute attribute = new ColorAttribute(foo);

		System.out.println(attribute.getAttribute());
	}
}
