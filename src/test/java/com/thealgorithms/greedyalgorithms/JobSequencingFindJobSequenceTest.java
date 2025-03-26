
package com.thealgorithms.greedyalgorithms;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;
import org.junit.jupiter.api.*;
import java.util.Arrays;

public class JobSequencingFindJobSequenceTest {

	@Test
	@Tag("valid")
	public void testEmptyJobList() {
		ArrayList<Job> jobs = new ArrayList<>();
		String result = JobSequencing.findJobSequence(jobs, 0);
		assertEquals("Job Sequence: ", result);
	}

	@Test
	@Tag("valid")
	public void testSingleJob() {
		ArrayList<Job> jobs = new ArrayList<>();
		jobs.add(new Job("1", 3, 100));
		String result = JobSequencing.findJobSequence(jobs, 1);
		assertEquals("Job Sequence: 1", result);
	}

	@Test
	@Tag("boundary")
	public void testMaxSizeLimit() {
		// TODO: Change the maximum size limit value as per system configuration
		int maxSize = 100;
		ArrayList<Job> jobs = new ArrayList<>();
		for (int i = 0; i < maxSize; i++) {
			jobs.add(new Job(Integer.toString(i + 1), i + 1, 100 * i));
		}
		String result = JobSequencing.findJobSequence(jobs, maxSize);

		StringBuilder sb = new StringBuilder();
		sb.append("Job Sequence: ");
		for (int i = 0; i < jobs.size(); i++) {
			sb.append(Integer.toString(i + 1)).append(" -> ");
		}

		if (sb.length() >= 4) {
			sb.setLength(sb.length() - 4);
		}

		assertEquals(sb.toString(), result);
	}

	@Test
	@Tag("valid")
	public void testJobsWithSameDeadline() {
		ArrayList<Job> jobs = new ArrayList<>();
		jobs.add(new Job("1", 3, 100));
		jobs.add(new Job("2", 3, 150));
		jobs.add(new Job("3", 1, 200));
		String result = JobSequencing.findJobSequence(jobs, 3);
		// Assuming that method sorts jobs with same deadline based on profit
		// So job 2 will be given preference over job 1
		assertEquals("Job Sequence: 2 -> 3", result);
	}

}