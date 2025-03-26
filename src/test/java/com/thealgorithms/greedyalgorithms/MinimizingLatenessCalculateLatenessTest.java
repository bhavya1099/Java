
package com.thealgorithms.greedyalgorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.*;
import java.util.Arrays;

public class MinimizingLatenessCalculateLatenessTest {

	@Test
	@Tag("valid")
	public void testCalculateLatenessWithSingleJob() {
		MinimizingLateness.Job singleJob = MinimizingLateness.Job.of("Job1", 5, 10);
		MinimizingLateness.calculateLateness(singleJob);
		Assertions.assertEquals(0, singleJob.startTime);
		Assertions.assertEquals(0, singleJob.lateness);
	}

	@Test
	@Tag("valid")
	public void testCalculateLatenessWithSameDeadlines() {
		MinimizingLateness.Job job1 = MinimizingLateness.Job.of("Job1", 3, 10);
		MinimizingLateness.Job job2 = MinimizingLateness.Job.of("Job2", 7, 10);
		MinimizingLateness.calculateLateness(job1, job2);
		Assertions.assertEquals(0, job1.startTime);
		Assertions.assertEquals(3, job2.startTime);
		Assertions.assertEquals(0, job1.lateness);
		Assertions.assertEquals(0, job2.lateness);
	}

	@Test
	@Tag("valid")
	public void testCalculateLatenessWithDifferentDeadlines() {
		MinimizingLateness.Job job1 = MinimizingLateness.Job.of("Job1", 5, 15);
		MinimizingLateness.Job job2 = MinimizingLateness.Job.of("Job2", 3, 10);
		MinimizingLateness.calculateLateness(job1, job2);
		Assertions.assertEquals(3, job1.startTime);
		Assertions.assertEquals(0, job2.startTime);
		Assertions.assertEquals(0, job1.lateness);
		Assertions.assertEquals(0, job2.lateness);
	}

	@Test
	@Tag("invalid")
	public void testCalculateLatenessWithNullJobs() {
		MinimizingLateness.Job job1 = null;
		MinimizingLateness.Job job2 = null;
		Assertions.assertThrows(NullPointerException.class, () -> {
			MinimizingLateness.calculateLateness(job1, job2);
		});
	}

	@Test
	@Tag("boundary")
	public void testCalculateLatenessWithNoJobs() {
		Assertions.assertDoesNotThrow(() -> MinimizingLateness.calculateLateness());
	}

}