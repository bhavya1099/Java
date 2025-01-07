package com.thealgorithms.greedyalgorithms;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api;
import java.util.Arrays;
import com.thealgorithms.greedyalgorithms.MinimizingLateness.Job;

public class MinimizingLateness166Test {

	@Test
	@Tag("valid")
	public void testToStringWithValidJob() {
		Job job = Job.of("Job1", 5, 10);
		job.startTime = 2;
		job.lateness = 0;
		String expected = "Job1, startTime: 2, endTime: 7, lateness: 0";
		String actual = job.toString();
		assertEquals(expected, actual);
	}

	@Test
	@Tag("boundary")
	public void testToStringWithJobHavingZeroStartTimeAndProcessingTime() {
		Job job = Job.of("Job2", 0, 0);
		job.startTime = 0;
		job.lateness = 0;
		String expected = "Job2, startTime: 0, endTime: 0, lateness: 0";
		String actual = job.toString();
		assertEquals(expected, actual);
	}

	@Test
	@Tag("boundary")
	public void testToStringWithJobHavingLargeProcessingTimeAndDeadline() {
		Job job = Job.of("Job3", Integer.MAX_VALUE, Integer.MAX_VALUE);
		job.startTime = 0;
		job.lateness = 0;
		String expected = "Job3, startTime: 0, endTime: " + Integer.MAX_VALUE + ", lateness: 0";
		String actual = job.toString();
		assertEquals(expected, actual);
	}

}