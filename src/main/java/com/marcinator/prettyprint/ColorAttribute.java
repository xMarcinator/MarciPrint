package com.marcinator.prettyprint;

import java.awt.Color;

import com.marcinator.prettyprint.utils.MathExtension;

public class ColorAttribute implements CMDAttribute {
	int rgb;
	boolean background;

	public boolean isBackground() {
		return background;
	}

	public ColorAttribute(int RGB) {
		this(RGB, false);
	}

	public ColorAttribute(int RGB, boolean isBackground) {
		this.rgb = RGB;
		this.background = isBackground;
	}

	public ColorAttribute(int R, int G, int B) {
		this(R, G, B, false);
	}

	public ColorAttribute(int R, int G, int B, boolean isBackground) {
		R = MathExtension.clamp(R, 0, 255);
		G = MathExtension.clamp(G, 0, 255);
		B = MathExtension.clamp(B, 0, 255);
		this.rgb = (R & 0xff) << 16 | (G & 0xff) << 8 | (B & 0xff) << 0;

		this.background = isBackground;
	}

	public ColorAttribute(Color RGB) {
		this(RGB, false);
	}

	public ColorAttribute(Color RGB, boolean isBackground) {
		this.rgb = RGB.getRGB();
		this.background = isBackground;
	}

	public ColorAttribute(PrettyColor2 RGB) {
		this(RGB, false);
	}

	public ColorAttribute(PrettyColor2 RGB, boolean isBackground) {
		this.rgb = RGB.getRGB();
		this.background = isBackground;
	}

	@Override
	public String getAttribute() {
		String collector = PrettyPrintV2.SEPARATOR + "38" + PrettyPrintV2.SEPARATOR + "2";
		for (int i = 2; i >= 0; i--) {
			int channel = (0xff << i * 8 & rgb) >> i * 8;
			collector += PrettyPrintV2.SEPARATOR + channel;
		}
		return collector;
	}

	@Override
	public boolean attributeMatch(CMDAttribute attribute) {
		if (!(attribute instanceof ColorAttribute))
			return false;
		ColorAttribute colorAt = (ColorAttribute) attribute;

		if (colorAt.isBackground() != this.isBackground())
			return false;

		return true;
	}

}
