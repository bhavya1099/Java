package com.thealgorithms.greedyalgorithms;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api;
import java.util.Arrays;

public class MinimizingLateness159Test {

	@Test
	@Tag("valid")
	public void testJobSortedBasedOnDeadline() {
		Job job1 = Job.of("Job1", 2, 5);
		Job job2 = Job.of("Job2", 3, 4);
		Job job3 = Job.of("Job3", 1, 3);
		Job[] jobs = { job1, job2, job3 };
		MinimizingLateness.calculateLateness(jobs);
		assertEquals("Job3", jobs[0].jobName);
		assertEquals("Job2", jobs[1].jobName);
		assertEquals("Job1", jobs[2].jobName);
	}

	@Test
	@Tag("valid")
	public void testAllJobsFinishBeforeDeadline() {
		Job job1 = Job.of("Job1", 2, 5);
		Job job2 = Job.of("Job2", 3, 8);
		Job job3 = Job.of("Job3", 1, 6);
		Job[] jobs = { job1, job2, job3 };
		MinimizingLateness.calculateLateness(jobs);
		for (Job job : jobs) {
			assertEquals(0, job.lateness);
		}
	}

	@Test
	@Tag("invalid")
	public void testAllJobsFinishAfterDeadline() {
		Job job1 = Job.of("Job1", 5, 2);
		Job job2 = Job.of("Job2", 8, 3);
		Job job3 = Job.of("Job3", 6, 1);
		Job[] jobs = { job1, job2, job3 };
		MinimizingLateness.calculateLateness(jobs);
		for (Job job : jobs) {
			assertTrue(job.lateness > 0);
		}
	}

	@Test
	@Tag("boundary")
	public void testEmptyJobsArray() {
		Job[] jobs = {};
		assertDoesNotThrow(() -> MinimizingLateness.calculateLateness(jobs));
	}

}