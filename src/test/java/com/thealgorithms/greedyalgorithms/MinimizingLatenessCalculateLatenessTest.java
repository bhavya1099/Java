
package com.thealgorithms.greedyalgorithms;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import org.junit.jupiter.api.*;
import java.util.Arrays;

public class MinimizingLatenessCalculateLatenessTest {

	@Test
	@Tag("valid")
	public void testCalculateLatenessWithSingleJob() {
		Job job = new Job(1, 3, 2);
		MinimizingLateness.calculateLateness(job);
		assertEquals(0, job.lateness, "Lateness calculation for single job failed.");
	}

	@Test
	@Tag("boundary")
	public void testCalculateLatenessWithSameDeadlineJobs() {
		Job job1 = new Job(1, 2, 2);
		Job job2 = new Job(2, 3, 2);
		Job job3 = new Job(3, 1, 2);
		MinimizingLateness.calculateLateness(job1, job2, job3);
		assertEquals(0, job1.lateness, "Lateness calculation for job1 failed.");
		assertEquals(1, job2.lateness, "Lateness calculation for job2 failed.");
		assertEquals(2, job3.lateness, "Lateness calculation for job3 failed.");
	}

	@Test
	@Tag("valid")
	public void testCalculateLatenessWithEmptyJobs() {
		assertDoesNotThrow(() -> MinimizingLateness.calculateLateness(), "Exception thrown when no jobs provided.");
	}

	@Test
	@Tag("boundary")
	public void testCalculateLatenessWithZeroProcessingTimeJobs() {
		Job job1 = new Job(1, 0, 2);
		Job job2 = new Job(2, 0, 3);
		MinimizingLateness.calculateLateness(job1, job2);
		assertEquals(0, job1.lateness, "Lateness calculation for job1 with zero processing time failed.");
		assertEquals(0, job2.lateness, "Lateness calculation for job2 with zero processing time failed.");
	}

}