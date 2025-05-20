package com.thealgorithms.dynamicprogramming;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api;
import org.junit.jupiter.api.Assertions.assertThrows;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;

public class CoinChangeTest {

	/*
	 * ROOST_METHOD_HASH=change_88fb536f2a ROOST_METHOD_SIG_HASH=change_9733b93333
	 *
	 */@Test
	@Tag("valid")
	public void testChangeWithRegularValues() {
		int amount = 12;
		int[] coins = { 2, 4, 5 };
		int combinations = CoinChange.change(coins, amount);
		assertEquals(5, combinations);
	}

	/*
	 * ROOST_METHOD_HASH=change_88fb536f2a ROOST_METHOD_SIG_HASH=change_9733b93333
	 *
	 */@Test
	@Tag("boundary")
	public void testChangeWithZeroAmount() {
		int amount = 0;
		int[] coins = { 2, 5, 7 };
		int combinations = CoinChange.change(coins, amount);
		assertEquals(1, combinations);
	}

	/*
	 * ROOST_METHOD_HASH=change_88fb536f2a ROOST_METHOD_SIG_HASH=change_9733b93333
	 *
	 */@Test
	@Tag("invalid")
	public void testChangeWithNegativeAmount() {
		int amount = -2;
		int[] coins = { 1, 2, 5 };
		int combinations = CoinChange.change(coins, amount);
		assertEquals(0, combinations);
	}

	/*
	 * ROOST_METHOD_HASH=change_88fb536f2a ROOST_METHOD_SIG_HASH=change_9733b93333
	 *
	 */@Test
	@Tag("boundary")
	public void testChangeWithEmptyCoins() {
		int amount = 7;
		int[] coins = {};
		int combinations = CoinChange.change(coins, amount);
		assertEquals(0, combinations);
	}

	/*
	 * ROOST_METHOD_HASH=change_88fb536f2a ROOST_METHOD_SIG_HASH=change_9733b93333
	 *
	 */@Test
	@Tag("valid")
	public void testChangeWithCoinsGreaterThanAmount() {
		int amount = 2;
		int[] coins = { 3, 4, 5 };
		int combinations = CoinChange.change(coins, amount);
		assertEquals(0, combinations);
	}

	/*
	 * ROOST_METHOD_HASH=minimumCoins_69f77dede2
	 * ROOST_METHOD_SIG_HASH=minimumCoins_f4b712e193
	 *
	 */@Test
	@Tag("valid")
	public void testMinimumCoinsWithValidData() {
		int[] coins = { 2, 3, 5 };
		int amount = 10;
		assertEquals(2, CoinChange.minimumCoins(coins, amount));
	}

	/*
	 * ROOST_METHOD_HASH=minimumCoins_69f77dede2
	 * ROOST_METHOD_SIG_HASH=minimumCoins_f4b712e193
	 *
	 */@Test
	@Tag("invalid")
	public void testMinimumCoinsWithUnachievableAmount() {
		int[] coins = { 3, 7, 10 };
		int amount = 2;
		assertEquals(Integer.MAX_VALUE, CoinChange.minimumCoins(coins, amount));
	}

	/*
	 * ROOST_METHOD_HASH=minimumCoins_69f77dede2
	 * ROOST_METHOD_SIG_HASH=minimumCoins_f4b712e193
	 *
	 */@Test
	@Tag("boundary")
	public void testMinimumCoinsWithZeroAmount() {
		int[] coins = { 2, 3, 5 };
		int amount = 0;
		assertEquals(0, CoinChange.minimumCoins(coins, amount));
	}

	/*
	 * ROOST_METHOD_HASH=minimumCoins_69f77dede2
	 * ROOST_METHOD_SIG_HASH=minimumCoins_f4b712e193
	 *
	 */@Test
	@Tag("invalid")
	public void testMinimumCoinsWithNegativeAmount() {
		int[] coins = { 2, 3, 5 };
		int amount = -2;
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> CoinChange.minimumCoins(coins, amount));
	}

	/*
	 * ROOST_METHOD_HASH=minimumCoins_69f77dede2
	 * ROOST_METHOD_SIG_HASH=minimumCoins_f4b712e193
	 *
	 */@Test
	@Tag("invalid")
	public void testMinimumCoinsWithEmptyCoinsArray() {
		int[] coins = {};
		int amount = 10;
		assertEquals(Integer.MAX_VALUE, CoinChange.minimumCoins(coins, amount));
	}

	/*
	 * ROOST_METHOD_HASH=printAmount_9cc8d855d5
	 * ROOST_METHOD_SIG_HASH=printAmount_a15fc26a6c
	 *
	 */@Test
	@Tag("valid")
	void testPrintAmountWithPositiveIntegers() {
		int[] array = { 1, 2, 3, 5, 10 };
		String expected = "1 2 3 5 10 \n";
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		CoinChange.printAmount(array);
		assertEquals(expected, outContent.toString());
	}

	/*
	 * ROOST_METHOD_HASH=printAmount_9cc8d855d5
	 * ROOST_METHOD_SIG_HASH=printAmount_a15fc26a6c
	 *
	 */@Test
	@Tag("boundary")
	void testPrintAmountWithEmptyArray() {
		int[] array = {};
		String expected = "\n";
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		CoinChange.printAmount(array);
		assertEquals(expected, outContent.toString());
	}

	/*
	 * ROOST_METHOD_HASH=printAmount_9cc8d855d5
	 * ROOST_METHOD_SIG_HASH=printAmount_a15fc26a6c
	 *
	 */@Test
	@Tag("valid")
	void testPrintAmountWithNegativeIntegers() {
		int[] array = { -1, -2, -3, -5, -10 };
		String expected = "-1 -2 -3 -5 -10 \n";
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		CoinChange.printAmount(array);
		assertEquals(expected, outContent.toString());
	}

	/*
	 * ROOST_METHOD_HASH=printAmount_9cc8d855d5
	 * ROOST_METHOD_SIG_HASH=printAmount_a15fc26a6c
	 *
	 */@Test
	@Tag("valid")
	void testPrintAmountWithZeroes() {
		int[] array = { 0, 0, 0, 0, 0 };
		String expected = "0 0 0 0 0 \n";
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		CoinChange.printAmount(array);
		assertEquals(expected, outContent.toString());
	}

	/*
	 * ROOST_METHOD_HASH=printAmount_9cc8d855d5
	 * ROOST_METHOD_SIG_HASH=printAmount_a15fc26a6c
	 *
	 */@Test
	@Tag("boundary")
	void testPrintAmountWithLargeArray() {
		int[] array = IntStream.rangeClosed(1, 10000).toArray();
		assertDoesNotThrow(() -> CoinChange.printAmount(array));
	}

}