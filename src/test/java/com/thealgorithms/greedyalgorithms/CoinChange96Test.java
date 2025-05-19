package com.thealgorithms.greedyalgorithms;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api;
import java.util.Arrays;
import java.util.Comparator;

public class CoinChange96Test {

	@Test
	@Tag("valid")
	public void coinChangeForPositiveInteger() {
		ArrayList<Integer> expected1 = new ArrayList<>();
		expected1.add(2000);
		expected1.add(500);
		assertEquals(expected1, CoinChange.coinChangeProblem(2500));
		ArrayList<Integer> expected2 = new ArrayList<>();
		expected2.add(2000);
		expected2.add(500);
		expected2.add(200);
		expected2.add(100);
		expected2.add(50);
		expected2.add(20);
		expected2.add(20);
		expected2.add(5);
		expected2.add(2);
		assertEquals(expected2, CoinChange.coinChangeProblem(2897));
	}

	@Test
	@Tag("invalid")
	public void coinChangeForNegativeInteger() {
		ArrayList<Integer> expected = new ArrayList<>();
		assertEquals(expected, CoinChange.coinChangeProblem(-2500));
	}

	@Test
	@Tag("boundary")
	public void coinChangeForZeroAmount() {
		ArrayList<Integer> expected = new ArrayList<>();
		assertEquals(expected, CoinChange.coinChangeProblem(0));
	}

	@Test
	@Tag("valid")
	public void coinChangeUnrepresentableAmount() {
		ArrayList<Integer> expected = new ArrayList<>();
		expected.add(2000);
		expected.add(500);
		expected.add(200);
		expected.add(100);
		expected.add(50);
		expected.add(20);
		expected.add(20);
		expected.add(5);
		assertEquals(expected, CoinChange.coinChangeProblem(2895));
	}

}