package com.thealgorithms.dynamicprogramming;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CoinChangeChangeTest {
    private CoinChange coinChange;
    @Before
    public void setUp() {
        coinChange = new CoinChange();
    }
    @Test
    public void testValidCoinsAndAmount() {
        int[] coins = {1, 2, 3};
        int amount = 4;
        // TODO: Change the expected result if necessary
        int expectedCombinations = 4;
        
        assertEquals(expectedCombinations, coinChange.change(coins, amount));
    }
    @Test
    public void testZeroAmount() {
        int[] coins = {1, 2, 3};
        int amount = 0;
        // There is 1 combination for the zero amount - providing no coin
        assertEquals(1, coinChange.change(coins, amount));
    }
    @Test
    public void testEmptyCoinsList() {
        int[] coins = {};
        int amount = 5;
        // For an empty coin list, no combinations are possible
        assertEquals(0, coinChange.change(coins, amount));
    }
    @Test
    public void testCoinsBiggerThanAmount() {
        int[] coins = {5, 6, 7};
        int amount = 4;
        // All coin values are bigger than the given amount. Therefore, no combinations are possible.
        assertEquals(0, coinChange.change(coins, amount));
    }
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testNegativeAmount() {
        int[] coins = {1 ,2 ,3};
        int amount = -5;
        // Expecting an ArrayIndexOutOfBoundsException since the amount is negative
        coinChange.change(coins, amount);
    }
}