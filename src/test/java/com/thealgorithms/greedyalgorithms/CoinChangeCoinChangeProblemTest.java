
package com.thealgorithms.greedyalgorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.*;
import java.util.Comparator;

public class CoinChangeCoinChangeProblemTest {

	@Test
	@Tag("invalid")
	public void testCoinChangeProblemWithNegativeAmount() {
		ArrayList<Integer> actual = CoinChange.coinChangeProblem(-5);
		Assertions.assertTrue(actual.isEmpty(), "Expecting Empty List");
	}

	@Test
	@Tag("boundary")
	public void testCoinChangeProblemWithAmountGreaterThanMaxCoinValue() {
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(2000, 2000, 500));
		ArrayList<Integer> actual = CoinChange.coinChangeProblem(4500);
		Assertions.assertEquals(expected, actual, "Expected and actual coin list should be same");
	}

	@Test
	@Tag("valid")
	public void testCoinChangeProblemWithAmountRequiresAllTypesOfCoins() {
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(2000, 500, 100, 50, 20, 10, 5, 2, 2));
		ArrayList<Integer> actual = CoinChange.coinChangeProblem(2689);
		Assertions.assertEquals(expected, actual, "Expected and actual coin list should be same");
	}

	@Test
	@Tag("valid")
	public void testCoinChangeProblemWithAmountMatchingOneCoinValue() {
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(100));
		ArrayList<Integer> actual = CoinChange.coinChangeProblem(100);
		Assertions.assertEquals(expected, actual, "Expected and actual coin list should be same");
	}

}