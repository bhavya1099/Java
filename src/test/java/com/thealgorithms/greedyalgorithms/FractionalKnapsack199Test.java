package com.thealgorithms.greedyalgorithms;

import org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack199Test {

	/*
	 * ROOST_METHOD_HASH=fractionalKnapsack_0c67eb8939
	 * ROOST_METHOD_SIG_HASH=fractionalKnapsack_feda426d78
	 *
	 */@BeforeEach
	public void setup() {

	}

	/*
	 * ROOST_METHOD_HASH=fractionalKnapsack_0c67eb8939
	 * ROOST_METHOD_SIG_HASH=fractionalKnapsack_feda426d78
	 *
	 */@Test
	@Tag("valid")
	public void fractionalKnapsackWithEqualValueToWeightRatios() {
		int[] weight = { 2, 3, 8 };

		int[] value = { 4, 6, 16 };
		int capacity = 5;
		int expected = 10;
		int actual = FractionalKnapsack.fractionalKnapsack(weight, value, capacity);
		assertEquals(expected, (int) actual);
	}

	/*
	 * ROOST_METHOD_HASH=fractionalKnapsack_0c67eb8939
	 * ROOST_METHOD_SIG_HASH=fractionalKnapsack_feda426d78
	 *
	 */@Test
	@Tag("valid")
	public void fractionalKnapsackWithSingleItemExceedingCapacity() {
		int[] weight = { 10 };
		int[] value = { 20 };
		int capacity = 5;
		int expected = 10;
		int actual = FractionalKnapsack.fractionalKnapsack(weight, value, capacity);
		assertEquals(expected, (int) actual);
	}

	/*
	 * ROOST_METHOD_HASH=fractionalKnapsack_0c67eb8939
	 * ROOST_METHOD_SIG_HASH=fractionalKnapsack_feda426d78
	 *
	 */@Test
	@Tag("boundary")
	public void fractionalKnapsackWithZeroWeightItem() {
		int[] weight = { 0, 5, 10 };
		int[] value = { 10, 20, 40 };
		int capacity = 10;

		int expected = 60;
		int actual = FractionalKnapsack.fractionalKnapsack(weight, value, capacity);
		assertEquals(expected, (int) actual);
	}

	/*
	 * ROOST_METHOD_HASH=fractionalKnapsack_0c67eb8939
	 * ROOST_METHOD_SIG_HASH=fractionalKnapsack_feda426d78
	 *
	 */@Test
	@Tag("valid")
	public void fractionalKnapsackWithCapacityExceedingTotalWeight() {
		int[] weight = { 2, 3, 4 };
		int[] value = { 10, 20, 30 };

		int capacity = 20;
		int expected = 60;
		int actual = FractionalKnapsack.fractionalKnapsack(weight, value, capacity);
		assertEquals(expected, (int) actual);
	}

	/*
	 * ROOST_METHOD_HASH=fractionalKnapsack_0c67eb8939
	 * ROOST_METHOD_SIG_HASH=fractionalKnapsack_feda426d78
	 *
	 */@Test
	@Tag("valid")
	public void fractionalKnapsackWithNonIncreasingRatios() {
		int[] weight = { 2, 3, 5 };

		int[] value = { 20, 15, 10 };
		int capacity = 6;
		int expected = 35;
		int actual = FractionalKnapsack.fractionalKnapsack(weight, value, capacity);
		assertEquals(expected, (int) actual);
	}

	/*
	 * ROOST_METHOD_HASH=fractionalKnapsack_0c67eb8939
	 * ROOST_METHOD_SIG_HASH=fractionalKnapsack_feda426d78
	 *
	 */@Test
	@Tag("invalid")
	public void fractionalKnapsackWithNegativeValues() {
		int[] weight = { 2, 3, 4 };

		int[] value = { -10, 20, 30 };
		int capacity = 5;

		int expected = 50;
		int actual = FractionalKnapsack.fractionalKnapsack(weight, value, capacity);
		assertEquals(expected, (int) actual);
	}

	/*
	 * ROOST_METHOD_HASH=fractionalKnapsack_0c67eb8939
	 * ROOST_METHOD_SIG_HASH=fractionalKnapsack_feda426d78
	 *
	 */@Test
	@Tag("valid")
	public void fractionalKnapsackWithLargeDataset() {
		int[] weight = new int[1000];
		int[] value = new int[1000];
		int capacity = 500;

		for (int i = 0; i < 1000; i++) {
			weight[i] = i + 1;
			value[i] = (i + 1) * 2;
		}

		int expected = 625500;
		int actual = FractionalKnapsack.fractionalKnapsack(weight, value, capacity);
		assertEquals(expected, (int) actual);
	}

	/*
	 * ROOST_METHOD_HASH=fractionalKnapsack_0c67eb8939
	 * ROOST_METHOD_SIG_HASH=fractionalKnapsack_feda426d78
	 *
	 */@Test
	@Tag("valid")
	public void fractionalKnapsackWithAllItemsFitting() {
		int[] weight = { 2, 3, 4 };
		int[] value = { 10, 20, 30 };

		int capacity = 9;
		int expected = 60;
		int actual = FractionalKnapsack.fractionalKnapsack(weight, value, capacity);
		assertEquals(expected, (int) actual);
	}

	/*
	 * ROOST_METHOD_HASH=fractionalKnapsack_0c67eb8939
	 * ROOST_METHOD_SIG_HASH=fractionalKnapsack_feda426d78
	 *
	 */@Test
	@Tag("valid")
	public void fractionalKnapsackWithZeroValueItems() {
		int[] weight = { 2, 3, 4 };

		int[] value = { 0, 20, 30 };
		int capacity = 9;

		int expected = 50;
		int actual = FractionalKnapsack.fractionalKnapsack(weight, value, capacity);
		assertEquals(expected, (int) actual);
	}

	/*
	 * ROOST_METHOD_HASH=fractionalKnapsack_0c67eb8939
	 * ROOST_METHOD_SIG_HASH=fractionalKnapsack_feda426d78
	 *
	 */@Test
	@Tag("integration")
	public void fractionalKnapsackWithDuplicateItems() {
		int[] weight = { 2, 2, 3 };
		int[] value = { 10, 10, 20 };

		int capacity = 5;
		int expected = 40;
		int actual = FractionalKnapsack.fractionalKnapsack(weight, value, capacity);
		assertEquals(expected, (int) actual);
	}

}