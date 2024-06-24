package com.thealgorithms.dynamicprogramming;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CoinChangePrintAmountTest {
    @Test
    public void testPrintAmountWithAllPositiveNumbers() {
        // Arrange
        int[] arr = {1, 2, 3, 4, 5};
        // Act
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        CoinChange.printAmount(arr);
        // Assert
        assertEquals("1 2 3 4 5 \n", outContent.toString());
    }
    @Test
    public void testPrintAmountWithNegativeNumbers() {
        // Arrange
        int[] arr = {-1, -2, -3, -4, -5};
        // Act
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        CoinChange.printAmount(arr);
        // Assert
        assertEquals("-1 -2 -3 -4 -5 \n", outContent.toString());
    }
    @Test
    public void testPrintAmountWithEmptyArray() {
        // Arrange
        int[] arr = {};
        // Act
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        CoinChange.printAmount(arr);
        // Assert
        assertEquals("\n", outContent.toString());
    }
    @Test
    public void testPrintAmountWithNullArray() {
        // Arrange
        int[] arr = null;
        // Act & Assert
        assertThrows(NullPointerException.class, () -> CoinChange.printAmount(arr));
    }
}