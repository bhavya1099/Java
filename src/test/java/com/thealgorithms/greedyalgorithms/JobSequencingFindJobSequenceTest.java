
package com.thealgorithms.greedyalgorithms;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.*;
import java.util.Arrays;

public class JobSequencingFindJobSequenceTest {

	@Test
	@Tag("valid")
	public void testWithEmptyJobsList() {
		ArrayList<Job> jobs = new ArrayList<>();
		int size = 0;
		String result = JobSequencing.findJobSequence(jobs, size);
		assertEquals("", result);
	}

	@Test
	@Tag("valid")
	public void testWithSingleJob() {
		ArrayList<Job> jobs = new ArrayList<>();
		jobs.add(new Job(1, 1, 1));
		int size = 1;
		String result = JobSequencing.findJobSequence(jobs, size);
		assertEquals("Job Sequence: 1", result);
	}

	@Test
	@Tag("valid")
	public void testWithSameDeadlineJobs() {
		ArrayList<Job> jobs = new ArrayList<>();
		jobs.add(new Job(1, 1, 1));
		jobs.add(new Job(2, 1, 1));
		jobs.add(new Job(3, 1, 1));
		int size = 3;
		String result = JobSequencing.findJobSequence(jobs, size);
		assertEquals("Job Sequence: 1 -> 2 -> 3", result);
	}

	@Test
	@Tag("valid")
	public void testWithDifferentDeadlineJobs() {
		ArrayList<Job> jobs = new ArrayList<>();
		jobs.add(new Job(1, 1, 1));
		jobs.add(new Job(2, 2, 1));
		jobs.add(new Job(3, 3, 1));
		int size = 3;
		String result = JobSequencing.findJobSequence(jobs, size);
		assertEquals("Job Sequence: 1 -> 2 -> 3", result);
	}

	@Test
	@Tag("boundary")
	public void testWithSizeLargerThanJobs() {
		ArrayList<Job> jobs = new ArrayList<>();
		jobs.add(new Job(1, 1, 1));
		jobs.add(new Job(2, 2, 1));
		int size = 4;
		String result = JobSequencing.findJobSequence(jobs, size);
		assertEquals("Job Sequence: 1 -> 2", result);
	}

}