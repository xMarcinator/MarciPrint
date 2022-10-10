package com.marcinator.prettyprint.utils;

import org.ejml.simple.*;

public class MatrixHelper {
	public static SimpleMatrix rotationMatrix() {
		return new SimpleMatrix(
				new double[][] {
						{ 1d, 5d, 6d },
						{ 2d, 3d, 1d },
						{ 1d, 7d, 2d }
				});
	}
	// SimpleMatrix firstMatrix = new SimpleMatrix(
	// new double[][] {
	// { 1d, 5d, 6d },
	// { 2d, 3d, 1d },
	// { 1d, 7d, 2d }
	// });
	// SimpleMatrix secondMatrix = new SimpleMatrix(
	// new double[][] {
	// { 1d },
	// { 2d },
	// { 1d }
	// });
	// SimpleMatrix result = firstMatrix.mult(secondMatrix);

	// System.out.println(result);
}
