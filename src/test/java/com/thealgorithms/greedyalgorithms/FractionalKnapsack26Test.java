package com.thealgorithms.greedyalgorithms;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api;
import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack26Test {

	/*
	 * ROOST_METHOD_HASH=fractionalKnapsack_0c67eb8939
	 * ROOST_METHOD_SIG_HASH=fractionalKnapsack_feda426d78
	 *
	 */@Test
	@Tag("valid")
	public void testFractionalKnapsackSingleItemFitsEntirely() {

		int[] weight = { 5 };

		int[] value = { 10 };

		int capacity = 5;

		int result = FractionalKnapsack.fractionalKnapsack(weight, value, capacity);

		assertEquals(10, result, "The value should be equal to the value of the single item.");
	}

	/*
	 * ROOST_METHOD_HASH=fractionalKnapsack_0c67eb8939
	 * ROOST_METHOD_SIG_HASH=fractionalKnapsack_feda426d78
	 *
	 */@Test
	@Tag("valid")
	public void testFractionalKnapsackMultipleItemsFitsEntirely() {

		int[] weight = { 10, 20, 30 };
		int[] value = { 60, 100, 120 };
		int capacity = 50;

		int result = FractionalKnapsack.fractionalKnapsack(weight, value, capacity);

		assertEquals(240, result, "The value should be the sum of the values of the items that fit.");
	}

	/*
	 * ROOST_METHOD_HASH=fractionalKnapsack_0c67eb8939
	 * ROOST_METHOD_SIG_HASH=fractionalKnapsack_feda426d78
	 *
	 */@Test
	@Tag("valid")
	public void testFractionalKnapsackPartialFit() {

		int[] weight = { 10, 20, 30 };
		int[] value = { 60, 100, 120 };
		int capacity = 15;

		int result = FractionalKnapsack.fractionalKnapsack(weight, value, capacity);

		assertEquals(75, result, "The value should be the value of the fraction of the item that fits.");
	}

	/*
	 * ROOST_METHOD_HASH=fractionalKnapsack_0c67eb8939
	 * ROOST_METHOD_SIG_HASH=fractionalKnapsack_feda426d78
	 *
	 */@Test
	@Tag("boundary")
	public void testFractionalKnapsackNoFit() {

		int[] weight = { 5, 10, 15 };
		int[] value = { 10, 20, 30 };
		int capacity = 0;

		int result = FractionalKnapsack.fractionalKnapsack(weight, value, capacity);

		assertEquals(0, result, "The value should be 0 when capacity is 0.");
	}

	/*
	 * ROOST_METHOD_HASH=fractionalKnapsack_0c67eb8939
	 * ROOST_METHOD_SIG_HASH=fractionalKnapsack_feda426d78
	 *
	 */@Test
	@Tag("boundary")
	public void testFractionalKnapsackExactFit() {

		int[] weight = { 10, 20, 30 };
		int[] value = { 60, 100, 120 };
		int capacity = 60;

		int result = FractionalKnapsack.fractionalKnapsack(weight, value, capacity);

		assertEquals(280, result, "The value should be the sum of all item values when capacity matches perfectly.");
	}

	/*
	 * ROOST_METHOD_HASH=fractionalKnapsack_0c67eb8939
	 * ROOST_METHOD_SIG_HASH=fractionalKnapsack_feda426d78
	 *
	 */@Test
	@Tag("invalid")
	public void testFractionalKnapsackEmptyItems() {

		int[] weight = {};

		int[] value = {};
		int capacity = 50;

		int result = FractionalKnapsack.fractionalKnapsack(weight, value, capacity);

		assertEquals(0, result, "The value should be 0 when no items are present.");
	}

	/*
	 * ROOST_METHOD_HASH=fractionalKnapsack_0c67eb8939
	 * ROOST_METHOD_SIG_HASH=fractionalKnapsack_feda426d78
	 *
	 */@Test
	@Tag("invalid")
	public void testFractionalKnapsackNullWeightsAndValues() {

		int[] weight = null;

		int[] value = null;
		int capacity = 50;

		try {
			FractionalKnapsack.fractionalKnapsack(weight, value, capacity);
		}
		catch (NullPointerException e) {

		}
	}

}