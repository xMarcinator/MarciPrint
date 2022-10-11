package com.marcinator.prettyprint;

import java.awt.Color;
import java.awt.color.ColorSpace;

import com.marcinator.prettyprint.utils.MathExtension;

/**
 * Class that contains Colors values
 */
public class PrettyColor2 extends Color {

	public PrettyColor2(ColorSpace cspace, float[] components, float alpha) {
		super(cspace, components, alpha);
	}

	public PrettyColor2(int rgb) {
		super(rgb);
	}

	public PrettyColor2(int rgba, boolean hasalpha) {
		super(rgba, hasalpha);
	}

	public PrettyColor2(int r, int g, int b) {
		super(r, g, b);
	}

	public PrettyColor2(float r, float g, float b) {
		super(r, g, b);
	}

	public PrettyColor2(int r, int g, int b, int a) {
		super(r, g, b, a);
	}

	public PrettyColor2(float r, float g, float b, float a) {
		super(r, g, b, a);
	}

	public String toString() {

		int RGB = this.getRGB();
		String collector = "#";

		for (int i = 2; i >= 0; i++) {
			collector += Integer.toHexString((RGB & 0xff) >> i * 8);
		}

		return collector;
	}

}
