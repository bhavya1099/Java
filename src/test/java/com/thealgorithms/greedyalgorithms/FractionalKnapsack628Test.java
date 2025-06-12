package com.thealgorithms.greedyalgorithms;

import java.util.Arrays;
import java.util.Comparator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api;

public class FractionalKnapsack628Test {

	/*
	 * ROOST_METHOD_HASH=fractionalKnapsack_0c67eb8939
	 * ROOST_METHOD_SIG_HASH=fractionalKnapsack_feda426d78
	 *
	 */@Tag("valid")
	@Test
	public void testBasicKnapsackScenario() {
		int[] weights = { 10, 20, 30 };
		int[] values = { 60, 100, 120 };
		int capacity = 50;
		int actual = FractionalKnapsack.fractionalKnapsack(weights, values, capacity);
		int expected = 240;
		assertEquals(expected, actual);
	}

	/*
	 * ROOST_METHOD_HASH=fractionalKnapsack_0c67eb8939
	 * ROOST_METHOD_SIG_HASH=fractionalKnapsack_feda426d78
	 *
	 */@Tag("invalid")
	@Test
	public void testZeroCapacityKnapsack() {
		int[] weights = { 10, 20, 30 };
		int[] values = { 60, 100, 120 };
		int capacity = 0;
		int actual = FractionalKnapsack.fractionalKnapsack(weights, values, capacity);
		int expected = 0;
		assertEquals(expected, actual);
	}

	/*
	 * ROOST_METHOD_HASH=fractionalKnapsack_0c67eb8939
	 * ROOST_METHOD_SIG_HASH=fractionalKnapsack_feda426d78
	 *
	 */@Tag("boundary")
	@Test
	public void testKnapsackWithSingleItem() {
		int[] weights = { 50 };
		int[] values = { 200 };
		int capacity = 50;
		int actual = FractionalKnapsack.fractionalKnapsack(weights, values, capacity);
		int expected = 200;
		assertEquals(expected, actual);
	}

	/*
	 * ROOST_METHOD_HASH=fractionalKnapsack_0c67eb8939
	 * ROOST_METHOD_SIG_HASH=fractionalKnapsack_feda426d78
	 *
	 */@Tag("valid")
	@Test
	public void testKnapsackWithFractionalItem() {
		int[] weights = { 10, 20, 30 };
		int[] values = { 60, 100, 120 };
		int capacity = 25;
		int actual = FractionalKnapsack.fractionalKnapsack(weights, values, capacity);

		int expected = 160;
		assertEquals(expected, actual);
	}

	/*
	 * ROOST_METHOD_HASH=fractionalKnapsack_0c67eb8939
	 * ROOST_METHOD_SIG_HASH=fractionalKnapsack_feda426d78
	 *
	 */@Tag("invalid")
	@Test
	public void testNoItemFitInKnapsack() {
		int[] weights = { 60, 70, 80 };
		int[] values = { 300, 400, 500 };
		int capacity = 50;
		int actual = FractionalKnapsack.fractionalKnapsack(weights, values, capacity);
		int expected = 0;
		assertEquals(expected, actual);
	}

	/*
	 * ROOST_METHOD_HASH=fractionalKnapsack_0c67eb8939
	 * ROOST_METHOD_SIG_HASH=fractionalKnapsack_feda426d78
	 *
	 */@Tag("boundary")
	@Test
	public void testKnapsackWithLargeCapacity() {

		int[] weights = { 10, 20, 30 };
		int[] values = { 60, 100, 120 };
		int capacity = 100;
		int actual = FractionalKnapsack.fractionalKnapsack(weights, values, capacity);

		int expected = 280;
		assertEquals(expected, actual);
	}

}