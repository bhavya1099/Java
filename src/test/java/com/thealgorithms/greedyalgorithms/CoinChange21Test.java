package com.thealgorithms.greedyalgorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import java.util.ArrayList;
import org.junit.jupiter.api;
import java.util.Arrays;
import java.util.Comparator;

public class CoinChange21Test {

	/*
	 * ROOST_METHOD_HASH=coinChangeProblem_3aeb3fb1d0
	 * ROOST_METHOD_SIG_HASH=coinChangeProblem_d4e3a208c6
	 *
	 */@Test
	@Tag("invalid")
	public void coinChangeNegativeAmount() {

		int amount = -100;

		ArrayList<Integer> result = CoinChange.coinChangeProblem(amount);

		Assertions.assertTrue(result.isEmpty(), "Expected the list to be empty for negative amount.");
	}

	/*
	 * ROOST_METHOD_HASH=coinChangeProblem_3aeb3fb1d0
	 * ROOST_METHOD_SIG_HASH=coinChangeProblem_d4e3a208c6
	 *
	 */@Test
	@Tag("boundary")
	public void coinChangeSmallestDenominationAmount() {

		int amount = 1;

		ArrayList<Integer> result = CoinChange.coinChangeProblem(amount);

		Assertions.assertEquals(new ArrayList<>(java.util.List.of(1)), result,
				"Expected a list containing a single element, 1.");
	}

	/*
	 * ROOST_METHOD_HASH=coinChangeProblem_3aeb3fb1d0
	 * ROOST_METHOD_SIG_HASH=coinChangeProblem_d4e3a208c6
	 *
	 */@Test
	@Tag("invalid")
	public void coinChangeNonFittingAmount() {

		int amount = 0;

		ArrayList<Integer> result = CoinChange.coinChangeProblem(amount);

		Assertions.assertTrue(result.isEmpty(), "Expected the list to be empty for non-fitting amount.");
	}

	/*
	 * ROOST_METHOD_HASH=coinChangeProblem_3aeb3fb1d0
	 * ROOST_METHOD_SIG_HASH=coinChangeProblem_d4e3a208c6
	 *
	 */@Test
	@Tag("boundary")
	public void coinChangeLargestSingleDenomination() {

		int amount = 2000;

		ArrayList<Integer> result = CoinChange.coinChangeProblem(amount);

		Assertions.assertEquals(new ArrayList<>(java.util.List.of(2000)), result,
				"Expected a list containing a single element, 2000.");
	}

	/*
	 * ROOST_METHOD_HASH=coinChangeProblem_3aeb3fb1d0
	 * ROOST_METHOD_SIG_HASH=coinChangeProblem_d4e3a208c6
	 *
	 */@Test
	@Tag("valid")
	public void coinChangeMultipleUsingOneDenomination() {

		int amount = 10;

		ArrayList<Integer> result = CoinChange.coinChangeProblem(amount);

		Assertions.assertEquals(new ArrayList<>(java.util.List.of(5, 5)), result,
				"Expected a list containing two elements, [5, 5].");
	}

	/*
	 * ROOST_METHOD_HASH=coinChangeProblem_3aeb3fb1d0
	 * ROOST_METHOD_SIG_HASH=coinChangeProblem_d4e3a208c6
	 *
	 */@Test
	@Tag("boundary")
	public void zeroArgumentBehaviorNormalizedByExclusion() {

		int amount = 0;

		ArrayList<Integer> result = CoinChange.coinChangeProblem(amount);

		Assertions.assertTrue(result.isEmpty(), "Expected the list to be empty for zero amount.");
	}

}