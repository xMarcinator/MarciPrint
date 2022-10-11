package com.marcinator.prettyprint;

import com.marcinator.prettyprint.utils.MathExtension;

/**
 * Class that contains Colors values
 */
public class PrettyColor {
	int r;
	int g;
	int b;

	public PrettyColor(int r, int g, int b) {
		set(r, g, b);
	}

	public PrettyColor(String hex) {
		int[] channels = new int[3];

		if (hex.startsWith("#"))
			hex = hex.substring(1);

		int hexLength = hex.length() / channels.length;

		for (int i = channels.length - 1; i >= 0; i--) {
			int statIndex = i * hexLength;

			String hexPart = hex.substring(statIndex, statIndex + hexLength);

			channels[i] = Integer.parseInt(hexPart, 16);

			if (hexLength == 1)
				channels[i] = MathExtension.zeroBasedMap(channels[i], 15, 255);

		}
		set(channels[0], channels[1], channels[2]);
	}

	public PrettyColor() {
		set(0, 0, 0);
	}

	void set(int r, int g, int b) {
		this.r = MathExtension.clamp(r, 0, 255);
		this.g = MathExtension.clamp(g, 0, 255);
		this.b = MathExtension.clamp(b, 0, 255);
	}

	public int getRGB() {
		return (r & 0xff) << 16 | (g & 0xff) << 8 | (b & 0xff) << 0;
	}

	public boolean equals(PrettyColor obj) {
		return obj.r == r
				&& obj.g == g
				&& obj.b == b;
	}

	public String toString() {
		return "#" + Integer.toHexString(r)
				+ Integer.toHexString(g)
				+ Integer.toHexString(b);
	}

}
