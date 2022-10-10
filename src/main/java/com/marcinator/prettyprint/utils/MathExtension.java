package com.marcinator.prettyprint.utils;

import java.awt.Color;

public class MathExtension {
	/**
	 * Clamp Integer values to a given range
	 *
	 * @param value
	 *              the value to clamp
	 * @param min
	 *              the minimum value
	 * @param max
	 *              the maximum value
	 * @return the clamped value
	 */
	public static int clamp(int value, int min, int max) {
		return Math.max(min, Math.min(max, value));
	}

	/**
	 * Map a value from one range to another
	 *
	 * @param value
	 *                the value to map
	 * @param fromMin
	 *                smallest value in from range
	 * @param fromMax
	 *                biggest value in from range
	 * @param toMin
	 *                smallest value in to range
	 * @param toMax
	 *                biggest value in to range
	 * @return the mapped value
	 */
	public static int map(int value, int fromMin, int fromMax, int toMin, int toMax) {
		return zeroBasedMap(value - fromMin, fromMax, toMax) + toMin;
	}

	/**
	 * Map a value from one range to another where minimum is shared at zero
	 *
	 * @param value
	 *                the value to map
	 * @param fromMin
	 *                smallest value in from range
	 * @param fromMax
	 *                biggest value in from range
	 * @return the mapped value
	 */
	public static int zeroBasedMap(int value, int fromMax, int toMax) {
		float percent = value / fromMax;

		Color foo = new Color(300, 300, 300);

		for (float channel : foo.getRGBColorComponents(null)) {
			System.out.println(channel);
		}

		return (int) (percent * toMax);
	}
}
