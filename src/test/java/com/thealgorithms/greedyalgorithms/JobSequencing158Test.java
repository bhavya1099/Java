package com.thealgorithms.greedyalgorithms;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions.assertEquals;

public class JobSequencing158Test {

	/*
	 * ROOST_METHOD_HASH=findJobSequence_18fcfb4ae0
	 * ROOST_METHOD_SIG_HASH=findJobSequence_0503336c9c
	 *
	 */@Test
	@Tag("valid")
	public void testJobSequencingWithSameDeadline() {
		ArrayList<JobSequencing.Job> jobs = new ArrayList<>(Arrays.asList(new JobSequencing.Job(1, 1, 50),
				new JobSequencing.Job(2, 1, 30), new JobSequencing.Job(3, 1, 40)));
		String actualResult = JobSequencing.findJobSequence(jobs, 1);
		String expectedResult = "Job Sequence: 1";
		assertEquals(expectedResult, actualResult);
	}

	/*
	 * ROOST_METHOD_HASH=findJobSequence_18fcfb4ae0
	 * ROOST_METHOD_SIG_HASH=findJobSequence_0503336c9c
	 *
	 */@Test
	@Tag("valid")
	public void testJobsWithDeadlineExceedingTimeline() {
		ArrayList<JobSequencing.Job> jobs = new ArrayList<>(Arrays.asList(new JobSequencing.Job(1, 5, 100),
				new JobSequencing.Job(2, 3, 50), new JobSequencing.Job(3, 2, 60)));
		String actualResult = JobSequencing.findJobSequence(jobs, 2);
		String expectedResult = "Job Sequence: 1 -> 3";
		assertEquals(expectedResult, actualResult);
	}

	/*
	 * ROOST_METHOD_HASH=findJobSequence_18fcfb4ae0
	 * ROOST_METHOD_SIG_HASH=findJobSequence_0503336c9c
	 *
	 */@Test
	@Tag("valid")
	public void testJobSequencingWithNonContiguousDeadlines() {
		ArrayList<JobSequencing.Job> jobs = new ArrayList<>(Arrays.asList(new JobSequencing.Job(1, 3, 60),
				new JobSequencing.Job(2, 1, 40), new JobSequencing.Job(3, 5, 80)));
		String actualResult = JobSequencing.findJobSequence(jobs, 5);
		String expectedResult = "Job Sequence: 3 -> 1";
		assertEquals(expectedResult, actualResult);
	}

	/*
	 * ROOST_METHOD_HASH=findJobSequence_18fcfb4ae0
	 * ROOST_METHOD_SIG_HASH=findJobSequence_0503336c9c
	 *
	 */@Test
	@Tag("boundary")
	public void testMoreSlotsThanJobs() {
		ArrayList<JobSequencing.Job> jobs = new ArrayList<>(
				Arrays.asList(new JobSequencing.Job(1, 2, 80), new JobSequencing.Job(2, 1, 50)));
		String actualResult = JobSequencing.findJobSequence(jobs, 5);
		String expectedResult = "Job Sequence: 1 -> 2";
		assertEquals(expectedResult, actualResult);
	}

	/*
	 * ROOST_METHOD_HASH=findJobSequence_18fcfb4ae0
	 * ROOST_METHOD_SIG_HASH=findJobSequence_0503336c9c
	 *
	 */@Test
	@Tag("boundary")
	public void testEmptyJobList() {
		ArrayList<JobSequencing.Job> jobs = new ArrayList<>();
		String actualResult = JobSequencing.findJobSequence(jobs, 3);
		String expectedResult = "Job Sequence:";
		assertEquals(expectedResult, actualResult);
	}

	/*
	 * ROOST_METHOD_HASH=findJobSequence_18fcfb4ae0
	 * ROOST_METHOD_SIG_HASH=findJobSequence_0503336c9c
	 *
	 */@Test
	@Tag("boundary")
	public void testSingleJobScenario() {
		ArrayList<JobSequencing.Job> jobs = new ArrayList<>(Arrays.asList(new JobSequencing.Job(1, 1, 100)));
		String actualResult = JobSequencing.findJobSequence(jobs, 2);
		String expectedResult = "Job Sequence: 1";
		assertEquals(expectedResult, actualResult);
	}

	/*
	 * ROOST_METHOD_HASH=findJobSequence_18fcfb4ae0
	 * ROOST_METHOD_SIG_HASH=findJobSequence_0503336c9c
	 *
	 */@Test
	@Tag("invalid")
	public void testJobSequencingWithZeroProfitJobs() {
		ArrayList<JobSequencing.Job> jobs = new ArrayList<>(Arrays.asList(new JobSequencing.Job(1, 1, 0),
				new JobSequencing.Job(2, 3, 0), new JobSequencing.Job(3, 2, 0)));

		String actualResult = JobSequencing.findJobSequence(jobs, 3);
		String expectedResult = "Job Sequence: 2 -> 3";
		assertEquals(expectedResult, actualResult);
	}

	/*
	 * ROOST_METHOD_HASH=findJobSequence_18fcfb4ae0
	 * ROOST_METHOD_SIG_HASH=findJobSequence_0503336c9c
	 *
	 */@Test
	@Tag("boundary")
	public void testConflictInJobSlots() {
		ArrayList<JobSequencing.Job> jobs = new ArrayList<>(Arrays.asList(new JobSequencing.Job(1, 2, 100),
				new JobSequencing.Job(2, 2, 50), new JobSequencing.Job(3, 1, 60)));
		String actualResult = JobSequencing.findJobSequence(jobs, 3);
		String expectedResult = "Job Sequence: 1 -> 3";
		assertEquals(expectedResult, actualResult);
	}

	/*
	 * ROOST_METHOD_HASH=findJobSequence_18fcfb4ae0
	 * ROOST_METHOD_SIG_HASH=findJobSequence_0503336c9c
	 *
	 */@Test
	@Tag("boundary")
	public void testSequencingWithIdenticalProfits() {
		ArrayList<JobSequencing.Job> jobs = new ArrayList<>(Arrays.asList(new JobSequencing.Job(1, 3, 50),
				new JobSequencing.Job(2, 1, 50), new JobSequencing.Job(3, 2, 50)));
		String actualResult = JobSequencing.findJobSequence(jobs, 3);
		String expectedResult = "Job Sequence: 1 -> 3";
		assertEquals(expectedResult, actualResult);
	}

	/*
	 * ROOST_METHOD_HASH=findJobSequence_18fcfb4ae0
	 * ROOST_METHOD_SIG_HASH=findJobSequence_0503336c9c
	 *
	 */@Test
	@Tag("invalid")
	public void testUnschedulableJobsDueToDeadlines() {
		ArrayList<JobSequencing.Job> jobs = new ArrayList<>(Arrays.asList(new JobSequencing.Job(1, 5, 100),
				new JobSequencing.Job(2, 6, 80), new JobSequencing.Job(3, 7, 70)));

		String actualResult = JobSequencing.findJobSequence(jobs, 3);
		String expectedResult = "Job Sequence: 1";
		assertEquals(expectedResult, actualResult);
	}

	/*
	 * ROOST_METHOD_HASH=compareTo_d21c6c4fe9 ROOST_METHOD_SIG_HASH=compareTo_ba246ded23
	 *
	 */@Test
	@Tag("valid")
	public void compareHigherProfitFirstJob() {
		JobSequencing.Job job1 = new JobSequencing.Job('A', 2, 50);
		JobSequencing.Job job2 = new JobSequencing.Job('B', 2, 40);

		int result = job1.compareTo(job2);

		assertEquals((int) (-10), result);
	}

	/*
	 * ROOST_METHOD_HASH=compareTo_d21c6c4fe9 ROOST_METHOD_SIG_HASH=compareTo_ba246ded23
	 *
	 */@Test
	@Tag("valid")
	public void compareHigherProfitSecondJob() {
		JobSequencing.Job job1 = new JobSequencing.Job('A', 2, 30);
		JobSequencing.Job job2 = new JobSequencing.Job('B', 2, 50);

		int result = job1.compareTo(job2);

		assertEquals((int) 20, result);
	}

	/*
	 * ROOST_METHOD_HASH=compareTo_d21c6c4fe9 ROOST_METHOD_SIG_HASH=compareTo_ba246ded23
	 *
	 */@Test
	@Tag("valid")
	public void compareEqualProfitJobs() {
		JobSequencing.Job job1 = new JobSequencing.Job('A', 2, 50);
		JobSequencing.Job job2 = new JobSequencing.Job('B', 2, 50);

		int result = job1.compareTo(job2);

		assertEquals((int) 0, result);
	}

	/*
	 * ROOST_METHOD_HASH=compareTo_d21c6c4fe9 ROOST_METHOD_SIG_HASH=compareTo_ba246ded23
	 *
	 */@Test
	@Tag("boundary")
	public void compareExtremeProfitValues() {
		JobSequencing.Job maxProfitJob = new JobSequencing.Job('A', 5, Integer.MAX_VALUE);
		JobSequencing.Job minProfitJob = new JobSequencing.Job('B', 5, Integer.MIN_VALUE);

		int result = maxProfitJob.compareTo(minProfitJob);

		assertEquals((int) (-Integer.MAX_VALUE - Integer.MIN_VALUE), result);
	}

	/*
	 * ROOST_METHOD_HASH=compareTo_d21c6c4fe9 ROOST_METHOD_SIG_HASH=compareTo_ba246ded23
	 *
	 */@Test
	@Tag("boundary")
	public void compareReverseExtremeProfitValues() {
		JobSequencing.Job minProfitJob = new JobSequencing.Job('A', 5, Integer.MIN_VALUE);
		JobSequencing.Job maxProfitJob = new JobSequencing.Job('B', 5, Integer.MAX_VALUE);

		int result = minProfitJob.compareTo(maxProfitJob);

		assertEquals((int) (Integer.MAX_VALUE - Integer.MIN_VALUE), result);
	}

	/*
	 * ROOST_METHOD_HASH=compareTo_d21c6c4fe9 ROOST_METHOD_SIG_HASH=compareTo_ba246ded23
	 *
	 */@Test
	@Tag("valid")
	public void compareJobWithItself() {
		JobSequencing.Job job = new JobSequencing.Job('A', 3, 100);

		int result = job.compareTo(job);

		assertEquals((int) 0, result);
	}

	/*
	 * ROOST_METHOD_HASH=compareTo_d21c6c4fe9 ROOST_METHOD_SIG_HASH=compareTo_ba246ded23
	 *
	 */@Test
	@Tag("invalid")
	public void compareZeroProfitToPositiveProfit() {
		JobSequencing.Job zeroProfitJob = new JobSequencing.Job('A', 3, 0);
		JobSequencing.Job positiveProfitJob = new JobSequencing.Job('B', 3, 100);

		int result = zeroProfitJob.compareTo(positiveProfitJob);

		assertEquals((int) 100, result);
	}

	/*
	 * ROOST_METHOD_HASH=compareTo_d21c6c4fe9 ROOST_METHOD_SIG_HASH=compareTo_ba246ded23
	 *
	 */@Test
	@Tag("invalid")
	public void compareZeroProfitToNegativeProfit() {
		JobSequencing.Job zeroProfitJob = new JobSequencing.Job('A', 3, 0);
		JobSequencing.Job negativeProfitJob = new JobSequencing.Job('B', 3, -100);

		int result = zeroProfitJob.compareTo(negativeProfitJob);

		assertEquals((int) (-100), result);
	}

	/*
	 * ROOST_METHOD_HASH=compareTo_d21c6c4fe9 ROOST_METHOD_SIG_HASH=compareTo_ba246ded23
	 *
	 */@Test
	@Tag("valid")
	public void compareNegativeProfits() {
		JobSequencing.Job lessNegativeProfitJob = new JobSequencing.Job('A', 4, -20);
		JobSequencing.Job moreNegativeProfitJob = new JobSequencing.Job('B', 4, -50);

		int result = lessNegativeProfitJob.compareTo(moreNegativeProfitJob);

		assertEquals((int) (-30), result);
	}

}