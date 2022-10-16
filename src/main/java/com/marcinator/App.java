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
		ColorAttribute back = new ColorAttribute(200, 0, 0);

		PrettyPrintV2 pretty = new PrettyPrintV2();
		pretty.addAttributes(attribute, back, CMDAttributes.BOLD);

		pretty.print(attribute.getAttribute());
	}
}