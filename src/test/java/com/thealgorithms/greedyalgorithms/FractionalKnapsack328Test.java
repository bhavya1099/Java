package com.thealgorithms.greedyalgorithms;

import org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api;
import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack328Test {

	/*
	 * ROOST_METHOD_HASH=fractionalKnapsack_0c67eb8939
	 * ROOST_METHOD_SIG_HASH=fractionalKnapsack_feda426d78
	 *
	 */@Test
	@Tag("valid")
	public void testFractionalKnapsackSimpleCase() {
		int capacity = 50;
		int[] weight = { 10, 20, 30 };
		int[] value = { 60, 100, 120 };
		int expected = 180;
		assertEquals(expected, FractionalKnapsack.fractionalKnapsack(weight, value, capacity));
	}

	/*
	 * ROOST_METHOD_HASH=fractionalKnapsack_0c67eb8939
	 * ROOST_METHOD_SIG_HASH=fractionalKnapsack_feda426d78
	 *
	 */@Test
	@Tag("valid")
	public void testFractionalKnapsackSameRatio() {
		int capacity = 50;
		int[] weight = { 10, 20, 30 };
		int[] value = { 20, 40, 60 };
		int expected = 100;
		assertEquals(expected, FractionalKnapsack.fractionalKnapsack(weight, value, capacity));
	}

	/*
	 * ROOST_METHOD_HASH=fractionalKnapsack_0c67eb8939
	 * ROOST_METHOD_SIG_HASH=fractionalKnapsack_feda426d78
	 *
	 */@Test
	@Tag("boundary")
	public void testFractionalKnapsackZeroCapacity() {
		int capacity = 0;
		int[] weight = { 10, 20, 30 };
		int[] value = { 60, 100, 120 };
		int expected = 0;
		assertEquals(expected, FractionalKnapsack.fractionalKnapsack(weight, value, capacity));
	}

	/*
	 * ROOST_METHOD_HASH=fractionalKnapsack_0c67eb8939
	 * ROOST_METHOD_SIG_HASH=fractionalKnapsack_feda426d78
	 *
	 */@Test
	@Tag("invalid")
	public void testFractionalKnapsackInconsistentArrayLengths() {
		int capacity = 50;
		int[] weight = { 10, 20 };
		int[] value = { 60, 100, 120 };
		assertThrows(IndexOutOfBoundsException.class,
				() -> FractionalKnapsack.fractionalKnapsack(weight, value, capacity));
	}

	/*
	 * ROOST_METHOD_HASH=fractionalKnapsack_0c67eb8939
	 * ROOST_METHOD_SIG_HASH=fractionalKnapsack_feda426d78
	 *
	 */@Test
	@Tag("invalid")
	public void testFractionalKnapsackNegativeValues() {
		int capacity = 50;
		int[] weight = { 10, -20, 30 };
		int[] value = { 60, 100, 120 };
		assertThrows(IllegalArgumentException.class,
				() -> FractionalKnapsack.fractionalKnapsack(weight, value, capacity));
	}

}