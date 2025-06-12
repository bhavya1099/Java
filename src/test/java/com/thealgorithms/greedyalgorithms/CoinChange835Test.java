package com.thealgorithms.greedyalgorithms;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api;
import java.util.Comparator;

public class CoinChange835Test {

	/*
	 * ROOST_METHOD_HASH=coinChangeProblem_3aeb3fb1d0
	 * ROOST_METHOD_SIG_HASH=coinChangeProblem_d4e3a208c6
	 *
	 */@Test
	@Tag("invalid")
	public void coinChangeWithUnreachableAmount() {

		int amount = -1;
		ArrayList<Integer> expected = new ArrayList<>();

		ArrayList<Integer> actual = CoinChange.coinChangeProblem(amount);

		assertEquals(expected, actual);
	}

	/*
	 * ROOST_METHOD_HASH=coinChangeProblem_3aeb3fb1d0
	 * ROOST_METHOD_SIG_HASH=coinChangeProblem_d4e3a208c6
	 *
	 */@Test
	@Tag("valid")
	public void coinChangeWithExactAmount() {

		int amount = 50;
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(50));

		ArrayList<Integer> actual = CoinChange.coinChangeProblem(amount);

		assertEquals(expected, actual);
	}

	/*
	 * ROOST_METHOD_HASH=coinChangeProblem_3aeb3fb1d0
	 * ROOST_METHOD_SIG_HASH=coinChangeProblem_d4e3a208c6
	 *
	 */@Test
	@Tag("valid")
	public void coinChangeWithMultipleCoins() {

		int amount = 72;
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(50, 20, 2));

		ArrayList<Integer> actual = CoinChange.coinChangeProblem(amount);

		assertEquals(expected, actual);
	}

	/*
	 * ROOST_METHOD_HASH=coinChangeProblem_3aeb3fb1d0
	 * ROOST_METHOD_SIG_HASH=coinChangeProblem_d4e3a208c6
	 *
	 */@Test
	@Tag("boundary")
	public void coinChangeWithMinimumAmount() {

		int amount = 1;
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1));

		ArrayList<Integer> actual = CoinChange.coinChangeProblem(amount);

		assertEquals(expected, actual);
	}

	/*
	 * ROOST_METHOD_HASH=coinChangeProblem_3aeb3fb1d0
	 * ROOST_METHOD_SIG_HASH=coinChangeProblem_d4e3a208c6
	 *
	 */@Test
	@Tag("boundary")
	public void coinChangeWithLargeAmount() {

		int amount = 3887;
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2));

		ArrayList<Integer> actual = CoinChange.coinChangeProblem(amount);

		assertEquals(expected, actual);
	}

	/*
	 * ROOST_METHOD_HASH=coinChangeProblem_3aeb3fb1d0
	 * ROOST_METHOD_SIG_HASH=coinChangeProblem_d4e3a208c6
	 *
	 */@Test
	@Tag("invalid")
	public void coinChangeWithZeroAmount() {

		int amount = 0;
		ArrayList<Integer> expected = new ArrayList<>();

		ArrayList<Integer> actual = CoinChange.coinChangeProblem(amount);

		assertEquals(expected, actual);
	}

	/*
	 * ROOST_METHOD_HASH=coinChangeProblem_3aeb3fb1d0
	 * ROOST_METHOD_SIG_HASH=coinChangeProblem_d4e3a208c6
	 *
	 */@Test
	@Tag("valid")
	public void coinChangeWithNonDivisibleAmount() {

		int amount = 3;
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(2, 1));

		ArrayList<Integer> actual = CoinChange.coinChangeProblem(amount);

		assertEquals(expected, actual);
	}

}