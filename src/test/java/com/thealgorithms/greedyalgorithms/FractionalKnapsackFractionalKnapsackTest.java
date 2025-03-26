
package com.thealgorithms.greedyalgorithms;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsackFractionalKnapsackTest {

	@Test
	@Tag("valid")
	public void testFractionalKnapsackWithFullCapacity() {
		int[] weights = new int[] { 10, 20, 30 };
		int[] values = new int[] { 60, 100, 120 };
		int capacity = 60;
		int totalValue = FractionalKnapsack.fractionalKnapsack(weights, values, capacity);
		assertEquals(240, totalValue);
	}

	@Test
	@Tag("valid")
	public void testFractionalKnapsackWithExcessWeights() {
		int[] weights = new int[] { 10, 20, 30 };
		int[] values = new int[] { 60, 100, 120 };
		int capacity = 50;
		int totalValue = FractionalKnapsack.fractionalKnapsack(weights, values, capacity);
		assertEquals(220, totalValue);
	}

	@Test
	@Tag("valid")
	public void testFractionalKnapsackWithEqualWeightsAndValues() {
		int[] weights = new int[] { 30, 20, 10 };
		int[] values = new int[] { 30, 20, 10 };
		int capacity = 40;
		int totalValue = FractionalKnapsack.fractionalKnapsack(weights, values, capacity);
		assertEquals(40, totalValue);
	}

	@Test
	@Tag("valid")
	public void testFractionalKnapsackWithZeroWeights() {
		int[] weights = new int[] { 0, 20, 30 };
		int[] values = new int[] { 60, 100, 120 };
		int capacity = 50;
		int totalValue = FractionalKnapsack.fractionalKnapsack(weights, values, capacity);
		assertEquals(260, totalValue);
	}

	@Test
	@Tag("valid")
	public void testFractionalKnapsackWithZeroValues() {
		int[] weights = new int[] { 30, 20, 10 };
		int[] values = new int[] { 0, 0, 0 };
		int capacity = 40;
		int totalValue = FractionalKnapsack.fractionalKnapsack(weights, values, capacity);
		assertEquals(0, totalValue);
	}

}