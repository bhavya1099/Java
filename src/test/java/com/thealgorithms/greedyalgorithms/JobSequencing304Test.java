package com.thealgorithms.greedyalgorithms;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api;
import java.util.Arrays;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Assertions;

public class JobSequencing304Test {

	/*
	 * ROOST_METHOD_HASH=findJobSequence_18fcfb4ae0
	 * ROOST_METHOD_SIG_HASH=findJobSequence_0503336c9c
	 *
	 */@Test
	@Tag("valid")
	public void allJobsFitWithinDeadline() {
		ArrayList<JobSequencing.Job> jobs = new ArrayList<>();
		jobs.add(new JobSequencing.Job("A", 1, 10));
		jobs.add(new JobSequencing.Job("B", 2, 15));
		jobs.add(new JobSequencing.Job("C", 3, 20));
		jobs.add(new JobSequencing.Job("D", 4, 25));
		Collections.sort(jobs);
		String actualSequence = JobSequencing.findJobSequence(jobs, jobs.size());
		String expectedSequence = "Job Sequence: D -> C -> B -> A";
		assertEquals(expectedSequence, actualSequence);
	}

	/*
	 * ROOST_METHOD_HASH=findJobSequence_18fcfb4ae0
	 * ROOST_METHOD_SIG_HASH=findJobSequence_0503336c9c
	 *
	 */@Test
	@Tag("boundary")
	public void noJobsAvailable() {
		ArrayList<JobSequencing.Job> jobs = new ArrayList<>();
		String actualSequence = JobSequencing.findJobSequence(jobs, 0);
		String expectedSequence = "Job Sequence: ";
		assertEquals(expectedSequence, actualSequence);
	}

	/*
	 * ROOST_METHOD_HASH=findJobSequence_18fcfb4ae0
	 * ROOST_METHOD_SIG_HASH=findJobSequence_0503336c9c
	 *
	 */@Test
	@Tag("valid")
	public void conflictingJobsWithSameDeadline() {
		ArrayList<JobSequencing.Job> jobs = new ArrayList<>();
		jobs.add(new JobSequencing.Job("A", 1, 10));
		jobs.add(new JobSequencing.Job("B", 1, 20));
		jobs.add(new JobSequencing.Job("C", 1, 30));
		Collections.sort(jobs);
		String actualSequence = JobSequencing.findJobSequence(jobs, jobs.size());
		String expectedSequence = "Job Sequence: C";
		assertEquals(expectedSequence, actualSequence);
	}

	/*
	 * ROOST_METHOD_HASH=findJobSequence_18fcfb4ae0
	 * ROOST_METHOD_SIG_HASH=findJobSequence_0503336c9c
	 *
	 */@Test
	@Tag("boundary")
	public void jobNotScheduledDueToHighDeadline() {
		ArrayList<JobSequencing.Job> jobs = new ArrayList<>();

		jobs.add(new JobSequencing.Job("A", 5, 10));

		jobs.add(new JobSequencing.Job("B", 6, 15));
		Collections.sort(jobs);

		String actualSequence = JobSequencing.findJobSequence(jobs, 4);
		String expectedSequence = "Job Sequence: ";
		assertEquals(expectedSequence, actualSequence);
	}

	/*
	 * ROOST_METHOD_HASH=findJobSequence_18fcfb4ae0
	 * ROOST_METHOD_SIG_HASH=findJobSequence_0503336c9c
	 *
	 */@Test
	@Tag("valid")
	public void variedProfitsAndDeadlines() {
		ArrayList<JobSequencing.Job> jobs = new ArrayList<>();
		jobs.add(new JobSequencing.Job("A", 2, 50));
		jobs.add(new JobSequencing.Job("B", 1, 60));
		jobs.add(new JobSequencing.Job("C", 3, 20));
		jobs.add(new JobSequencing.Job("D", 2, 40));
		Collections.sort(jobs);
		String actualSequence = JobSequencing.findJobSequence(jobs, jobs.size());
		String expectedSequence = "Job Sequence: B -> A -> C";
		assertEquals(expectedSequence, actualSequence);
	}

	/*
	 * ROOST_METHOD_HASH=findJobSequence_18fcfb4ae0
	 * ROOST_METHOD_SIG_HASH=findJobSequence_0503336c9c
	 *
	 */@Test
	@Tag("boundary")
	public void singleJobScenario() {
		ArrayList<JobSequencing.Job> jobs = new ArrayList<>();
		jobs.add(new JobSequencing.Job("A", 1, 25));
		Collections.sort(jobs);
		String actualSequence = JobSequencing.findJobSequence(jobs, jobs.size());
		String expectedSequence = "Job Sequence: A";
		assertEquals(expectedSequence, actualSequence);
	}

	/*
	 * ROOST_METHOD_HASH=findJobSequence_18fcfb4ae0
	 * ROOST_METHOD_SIG_HASH=findJobSequence_0503336c9c
	 *
	 */@Test
	@Tag("invalid")
	public void zeroOrNegativeProfitJobs() {
		ArrayList<JobSequencing.Job> jobs = new ArrayList<>();

		jobs.add(new JobSequencing.Job("A", 2, 0));

		jobs.add(new JobSequencing.Job("B", 3, -10));
		jobs.add(new JobSequencing.Job("C", 1, 20));
		jobs.add(new JobSequencing.Job("D", 2, 40));
		Collections.sort(jobs);
		String actualSequence = JobSequencing.findJobSequence(jobs, jobs.size());
		String expectedSequence = "Job Sequence: D -> C";
		assertEquals(expectedSequence, actualSequence);
	}

	/*
	 * ROOST_METHOD_HASH=findJobSequence_18fcfb4ae0
	 * ROOST_METHOD_SIG_HASH=findJobSequence_0503336c9c
	 *
	 */@Test
	@Tag("valid")
	public void scatteredAndOverlappingDeadlines() {
		ArrayList<JobSequencing.Job> jobs = new ArrayList<>();
		jobs.add(new JobSequencing.Job("A", 2, 20));
		jobs.add(new JobSequencing.Job("B", 1, 50));
		jobs.add(new JobSequencing.Job("C", 1, 40));
		jobs.add(new JobSequencing.Job("D", 3, 10));
		Collections.sort(jobs);
		String actualSequence = JobSequencing.findJobSequence(jobs, jobs.size());
		String expectedSequence = "Job Sequence: B -> A -> D";
		assertEquals(expectedSequence, actualSequence);
	}

	/*
	 * ROOST_METHOD_HASH=findJobSequence_18fcfb4ae0
	 * ROOST_METHOD_SIG_HASH=findJobSequence_0503336c9c
	 *
	 */@Test
	@Tag("valid")
	public void fullScheduleUtilization() {
		ArrayList<JobSequencing.Job> jobs = new ArrayList<>();
		jobs.add(new JobSequencing.Job("A", 1, 15));
		jobs.add(new JobSequencing.Job("B", 2, 20));
		jobs.add(new JobSequencing.Job("C", 3, 25));
		jobs.add(new JobSequencing.Job("D", 4, 30));
		Collections.sort(jobs);
		String actualSequence = JobSequencing.findJobSequence(jobs, 4);
		String expectedSequence = "Job Sequence: D -> C -> B -> A";
		assertEquals(expectedSequence, actualSequence);
	}

	/*
	 * ROOST_METHOD_HASH=findJobSequence_18fcfb4ae0
	 * ROOST_METHOD_SIG_HASH=findJobSequence_0503336c9c
	 *
	 */@Test
	@Tag("valid")
	public void outputFormattingValidation() {
		ArrayList<JobSequencing.Job> jobs = new ArrayList<>();
		jobs.add(new JobSequencing.Job("X", 3, 80));
		jobs.add(new JobSequencing.Job("Y", 2, 60));
		jobs.add(new JobSequencing.Job("Z", 1, 40));
		Collections.sort(jobs);
		String actualSequence = JobSequencing.findJobSequence(jobs, jobs.size());
		String expectedSequence = "Job Sequence: X -> Y -> Z";
		assertEquals(expectedSequence, actualSequence);
	}

	/*
	 * ROOST_METHOD_HASH=compareTo_d21c6c4fe9 ROOST_METHOD_SIG_HASH=compareTo_ba246ded23
	 *
	 */@Test
	@Tag("valid")
	public void testCompareJobsWithDifferentProfits() {

		Job highProfitJob = new Job('A', 2, 100);

		Job lowProfitJob = new Job('B', 1, 50);

		int comparisonResult = highProfitJob.compareTo(lowProfitJob);

		assertTrue(comparisonResult > 0, "comparisonResult should be > 0 when profit of otherJob is less.");
	}

	/*
	 * ROOST_METHOD_HASH=compareTo_d21c6c4fe9 ROOST_METHOD_SIG_HASH=compareTo_ba246ded23
	 *
	 */@Test
	@Tag("valid")
	public void testCompareJobsWithEqualProfits() {

		Job jobA = new Job('A', 2, 100);

		Job jobB = new Job('B', 1, 100);

		int comparisonResult = jobA.compareTo(jobB);

		assertEquals(0, comparisonResult, "comparisonResult should be 0 when profits are equal.");
	}

	/*
	 * ROOST_METHOD_HASH=compareTo_d21c6c4fe9 ROOST_METHOD_SIG_HASH=compareTo_ba246ded23
	 *
	 */@Test
	@Tag("valid")
	public void testCompareJobsWhenOtherJobHasHigherProfit() {

		Job lowProfitJob = new Job('C', 2, 50);

		Job highProfitJob = new Job('D', 1, 200);

		int comparisonResult = lowProfitJob.compareTo(highProfitJob);

		assertTrue(comparisonResult < 0, "comparisonResult should be < 0 when profit of otherJob is higher.");
	}

	/*
	 * ROOST_METHOD_HASH=compareTo_d21c6c4fe9 ROOST_METHOD_SIG_HASH=compareTo_ba246ded23
	 *
	 */@Test
	@Tag("boundary")
	public void testCompareJobsWithZeroProfit() {

		Job jobA = new Job('E', 2, 0);

		Job jobB = new Job('F', 1, 0);

		int comparisonResult = jobA.compareTo(jobB);

		assertEquals(0, comparisonResult, "comparisonResult should be 0 when both jobs have zero profit.");
	}

	/*
	 * ROOST_METHOD_HASH=compareTo_d21c6c4fe9 ROOST_METHOD_SIG_HASH=compareTo_ba246ded23
	 *
	 */@Test
	@Tag("invalid")
	public void testCompareJobsWithNegativeProfits() {

		Job jobA = new Job('G', 2, -50);

		Job jobB = new Job('H', 1, -100);

		int comparisonResult = jobA.compareTo(jobB);

		assertTrue(comparisonResult > 0, "comparisonResult should be > 0 when comparing jobs with negative profits.");
	}

}