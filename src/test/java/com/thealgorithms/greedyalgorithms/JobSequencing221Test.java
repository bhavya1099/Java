package com.thealgorithms.greedyalgorithms;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;

public class JobSequencing221Test {

	/*
	 * ROOST_METHOD_HASH=findJobSequence_18fcfb4ae0
	 * ROOST_METHOD_SIG_HASH=findJobSequence_0503336c9c
	 *
	 */@Test
	@Tag("valid")
	public void findJobSequenceWithEmptyList() {

		ArrayList<JobSequencing.Job> jobs = new ArrayList<>();
		int size = 0;
		String result = JobSequencing.findJobSequence(jobs, size);

		assertEquals("Job Sequence: ", result);
	}

	/*
	 * ROOST_METHOD_HASH=findJobSequence_18fcfb4ae0
	 * ROOST_METHOD_SIG_HASH=findJobSequence_0503336c9c
	 *
	 */@Test
	@Tag("boundary")
	public void findJobSequenceWithZeroSize() {

		ArrayList<JobSequencing.Job> jobs = new ArrayList<>();

		jobs.add(new JobSequencing.Job("Job1", 1, 100));
		jobs.add(new JobSequencing.Job("Job2", 2, 200));
		int size = 0;
		String result = JobSequencing.findJobSequence(jobs, size);

		assertEquals("Job Sequence: ", result);
	}

	/*
	 * ROOST_METHOD_HASH=findJobSequence_18fcfb4ae0
	 * ROOST_METHOD_SIG_HASH=findJobSequence_0503336c9c
	 *
	 */@Test
	@Tag("boundary")
	public void findJobSequenceWithDeadlineExceedsSize() {

		ArrayList<JobSequencing.Job> jobs = new ArrayList<>();

		jobs.add(new JobSequencing.Job("Job1", 5, 100));
		jobs.add(new JobSequencing.Job("Job2", 3, 200));
		int size = 2;
		String result = JobSequencing.findJobSequence(jobs, size);

		assertEquals("Job Sequence: Job2 -> ", result);
	}

	/*
	 * ROOST_METHOD_HASH=findJobSequence_18fcfb4ae0
	 * ROOST_METHOD_SIG_HASH=findJobSequence_0503336c9c
	 *
	 */@Test
	@Tag("valid")
	public void findJobSequenceWithOptimalFit() {

		ArrayList<JobSequencing.Job> jobs = new ArrayList<>();

		jobs.add(new JobSequencing.Job("Job1", 1, 100));
		jobs.add(new JobSequencing.Job("Job2", 2, 200));
		jobs.add(new JobSequencing.Job("Job3", 3, 300));
		int size = 3;
		String result = JobSequencing.findJobSequence(jobs, size);

		assertEquals("Job Sequence: Job3 -> Job2 -> Job1", result);
	}

	/*
	 * ROOST_METHOD_HASH=findJobSequence_18fcfb4ae0
	 * ROOST_METHOD_SIG_HASH=findJobSequence_0503336c9c
	 *
	 */@Test
	@Tag("valid")
	public void findJobSequenceWithConflictResolution() {

		ArrayList<JobSequencing.Job> jobs = new ArrayList<>();

		jobs.add(new JobSequencing.Job("Job1", 2, 100));

		jobs.add(new JobSequencing.Job("Job2", 2, 300));

		jobs.add(new JobSequencing.Job("Job3", 1, 200));
		int size = 2;
		String result = JobSequencing.findJobSequence(jobs, size);

		assertEquals("Job Sequence: Job3 -> Job2", result);
	}

	/*
	 * ROOST_METHOD_HASH=compareTo_d21c6c4fe9 ROOST_METHOD_SIG_HASH=compareTo_ba246ded23
	 *
	 */@Test
	@Tag("valid")
	public void checkProfitDescendingOrder() {

		Job job1 = new Job('A', 5, 100);
		Job job2 = new Job('B', 3, 50);

		int comparisonResult = job1.compareTo(job2);

		Assertions.assertTrue(comparisonResult < 0);
	}

	/*
	 * ROOST_METHOD_HASH=compareTo_d21c6c4fe9 ROOST_METHOD_SIG_HASH=compareTo_ba246ded23
	 *
	 */@Test
	@Tag("valid")
	public void checkEqualProfitJobs() {

		Job job1 = new Job('A', 5, 75);
		Job job2 = new Job('B', 3, 75);

		int comparisonResult = job1.compareTo(job2);

		Assertions.assertEquals(0, comparisonResult);
	}

	/*
	 * ROOST_METHOD_HASH=compareTo_d21c6c4fe9 ROOST_METHOD_SIG_HASH=compareTo_ba246ded23
	 *
	 */@Test
	@Tag("valid")
	public void checkLowerProfitComparison() {

		Job job1 = new Job('A', 5, 50);
		Job job2 = new Job('B', 3, 100);

		int comparisonResult = job1.compareTo(job2);

		Assertions.assertTrue(comparisonResult > 0);
	}

	/*
	 * ROOST_METHOD_HASH=compareTo_d21c6c4fe9 ROOST_METHOD_SIG_HASH=compareTo_ba246ded23
	 *
	 */@Test
	@Tag("boundary")
	public void checkNegativeProfitComparison() {

		Job job1 = new Job('A', 5, -100);
		Job job2 = new Job('B', 3, 50);

		int comparisonResult = job1.compareTo(job2);

		Assertions.assertTrue(comparisonResult > 0);
	}

	/*
	 * ROOST_METHOD_HASH=compareTo_d21c6c4fe9 ROOST_METHOD_SIG_HASH=compareTo_ba246ded23
	 *
	 */@Test
	@Tag("invalid")
	public void checkComparisonWithNullJob() {

		Job job1 = new Job('A', 5, 50);

		Assertions.assertThrows(NullPointerException.class, () -> {
			job1.compareTo(null);
		});
	}

}