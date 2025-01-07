package com.thealgorithms.greedyalgorithms;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api;
import java.util.Arrays;

public class JobSequencing629Test {

	@Test
	@Tag("valid")
	public void testJobSequenceWithEmptyJobs() {
		ArrayList<Job> jobs = new ArrayList<>();
		String result = JobSequencing.findJobSequence(jobs, 0);
		assertEquals("", result);
	}

	@Test
	@Tag("valid")
	public void testJobSequenceWithSameDeadlineJobs() {
		ArrayList<Job> jobs = new ArrayList<>();
		jobs.add(new Job('a', 1, 100));
		jobs.add(new Job('b', 1, 200));
		jobs.add(new Job('c', 1, 300));
		String result = JobSequencing.findJobSequence(jobs, jobs.size());
		assertEquals("Job Sequence: c -> b -> a", result);
	}

	@Test
	@Tag("valid")
	public void testJobSequenceWithDifferentDeadlineJobs() {
		ArrayList<Job> jobs = new ArrayList<>();
		jobs.add(new Job('a', 1, 100));
		jobs.add(new Job('b', 2, 200));
		jobs.add(new Job('c', 3, 300));
		String result = JobSequencing.findJobSequence(jobs, jobs.size());
		assertEquals("Job Sequence: c -> b -> a", result);
	}

	@Test
	@Tag("boundary")
	public void testJobSequenceWithSmallerSize() {
		ArrayList<Job> jobs = new ArrayList<>();
		jobs.add(new Job('a', 1, 100));
		jobs.add(new Job('b', 2, 200));
		jobs.add(new Job('c', 3, 300));
		String result = JobSequencing.findJobSequence(jobs, 2);
		assertEquals("Job Sequence: b -> a", result);
	}

}