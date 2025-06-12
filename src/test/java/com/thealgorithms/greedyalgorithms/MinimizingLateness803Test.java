package com.thealgorithms.greedyalgorithms;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import org.junit.jupiter.api;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;

public class MinimizingLateness803Test {

	/*
	 * ROOST_METHOD_HASH=calculateLateness_c431b08d2e
	 * ROOST_METHOD_SIG_HASH=calculateLateness_726ace5b20
	 *
	 */@BeforeEach
	void setUp() {

	}

	/*
	 * ROOST_METHOD_HASH=calculateLateness_c431b08d2e
	 * ROOST_METHOD_SIG_HASH=calculateLateness_726ace5b20
	 *
	 */@Test
	@Tag("boundary")
	public void verifyEmptyJobListHandling() {
		Job[] jobs = {};
		MinimizingLateness.calculateLateness(jobs);
		assertEquals(0, jobs.length, "Empty job list should remain empty without any errors.");
	}

	/*
	 * ROOST_METHOD_HASH=calculateLateness_c431b08d2e
	 * ROOST_METHOD_SIG_HASH=calculateLateness_726ace5b20
	 *
	 */@Test
	@Tag("valid")
	public void verifySingleJobHandledCorrectly() {

		Job[] jobs = { new Job("Job1", 5, 10) };
		MinimizingLateness.calculateLateness(jobs);
		assertEquals(0, (int) jobs[0].lateness,
				"Single job should have 0 lateness if deadline is greater than finishing time.");
		assertEquals(0, (int) jobs[0].startTime, "Job should start at time 0.");
	}

	/*
	 * ROOST_METHOD_HASH=calculateLateness_c431b08d2e
	 * ROOST_METHOD_SIG_HASH=calculateLateness_726ace5b20
	 *
	 */@Test
	@Tag("valid")
	public void verifyJobWithLatenessHandledCorrectly() {
		Job[] jobs = { new Job("Job2", 5, 3) };
		MinimizingLateness.calculateLateness(jobs);
		assertEquals(2, (int) jobs[0].lateness, "Job lateness should be correctly calculated.");
		assertEquals(0, (int) jobs[0].startTime, "Job should start at time 0.");
	}

	/*
	 * ROOST_METHOD_HASH=calculateLateness_c431b08d2e
	 * ROOST_METHOD_SIG_HASH=calculateLateness_726ace5b20
	 *
	 */@Test
	@Tag("valid")
	public void verifyMultipleJobsSortedAndCalculatedCorrectly() {
		Job job1 = new Job("Job1", 3, 5);
		Job job2 = new Job("Job2", 2, 4);
		Job job3 = new Job("Job3", 4, 8);
		Job[] jobs = { job1, job2, job3 };
		MinimizingLateness.calculateLateness(jobs);

		assertEquals(job2, jobs[0], "Jobs should be sorted based on deadline.");
		assertEquals(job1, jobs[1], "Jobs should be sorted based on deadline.");
		assertEquals(job3, jobs[2], "Jobs should be sorted based on deadline.");

		assertEquals(0, (int) jobs[0].lateness, "Job 2 should have 0 lateness.");
		assertEquals(0, (int) jobs[1].lateness, "Job 1 should have 0 lateness.");
		assertEquals(1, (int) jobs[2].lateness, "Job 3 should have lateness of 1.");
	}

	/*
	 * ROOST_METHOD_HASH=calculateLateness_c431b08d2e
	 * ROOST_METHOD_SIG_HASH=calculateLateness_726ace5b20
	 *
	 */@Test
	@Tag("invalid")
	public void verifyJobsWithZeroDeadlineAreHandledProperly() {
		Job[] jobs = { new Job("JobZeroDeadline", 2, 0) };
		MinimizingLateness.calculateLateness(jobs);
		assertEquals((int) jobs[0].processingTime, (int) jobs[0].lateness,
				"Job with zero deadline should have lateness equal to its processing time.");
		assertNotNull(jobs[0].startTime, "Start time should not be null.");
	}

	/*
	 * ROOST_METHOD_HASH=calculateLateness_c431b08d2e
	 * ROOST_METHOD_SIG_HASH=calculateLateness_726ace5b20
	 *
	 */@Test
	@Tag("boundary")
	public void verifyNonNullJobsHandledCorrectly() {
		Job job1 = new Job("JobNullCheck1", 0, 5);
		Job job2 = new Job("JobNullCheck2", 4, 6);
		Job[] jobs = { job1, job2 };
		MinimizingLateness.calculateLateness(jobs);
		for (Job job : jobs) {
			assertNotNull(job.startTime, "Start time should not be null for any job.");
			assertNotNull((Integer) job.lateness, "Lateness should not be null for any job.");
		}
	}

	/*
	 * ROOST_METHOD_HASH=of_eb8138c6bc ROOST_METHOD_SIG_HASH=of_7a04d5363c
	 *
	 */@Test
	@DisplayName("of method creates valid Job object")
	@Tag("valid")
	public void ofMethodCreatesValidObject() {

		String expectedJobName = "Job1";
		int expectedProcessingTime = 5;
		int expectedDeadline = 10;

		MinimizingLateness.Job validJob = MinimizingLateness.Job.of(expectedJobName, expectedProcessingTime,
				expectedDeadline);

		assertNotNull(validJob, "Job object should not be null");
		assertEquals((String) expectedJobName, validJob.jobName, "Job name should match the expected value");
		assertEquals((int) expectedProcessingTime, validJob.processingTime,
				"Processing time should match the expected value");
		assertEquals((int) expectedDeadline, validJob.deadline, "Deadline should match the expected value");
	}

	/*
	 * ROOST_METHOD_HASH=of_eb8138c6bc ROOST_METHOD_SIG_HASH=of_7a04d5363c
	 *
	 */@Test
	@DisplayName("of method handles empty job name")
	@Tag("invalid")
	public void ofMethodHandlesEmptyJobName() {

		String emptyJobName = "";
		int expectedProcessingTime = 5;
		int expectedDeadline = 10;

		MinimizingLateness.Job job = MinimizingLateness.Job.of(emptyJobName, expectedProcessingTime, expectedDeadline);

		assertNotNull(job, "Job object should not be null");
		assertEquals((String) emptyJobName, job.jobName, "Job name should be empty");
		assertEquals((int) expectedProcessingTime, job.processingTime,
				"Processing time should match the expected value");
		assertEquals((int) expectedDeadline, job.deadline, "Deadline should match the expected value");
	}

	/*
	 * ROOST_METHOD_HASH=of_eb8138c6bc ROOST_METHOD_SIG_HASH=of_7a04d5363c
	 *
	 */@Test
	@DisplayName("of method handles negative processing time")
	@Tag("invalid")
	public void ofMethodHandlesNegativeProcessingTime() {

		String jobName = "Job2";
		int negativeProcessingTime = -5;
		int expectedDeadline = 10;

		MinimizingLateness.Job job = MinimizingLateness.Job.of(jobName, negativeProcessingTime, expectedDeadline);

		assertNotNull(job, "Job object should not be null");
		assertEquals((String) jobName, job.jobName, "Job name should match the expected value");
		assertEquals((int) negativeProcessingTime, job.processingTime,
				"Processing time should match the negative value");
		assertEquals((int) expectedDeadline, job.deadline, "Deadline should match the expected value");
	}

	/*
	 * ROOST_METHOD_HASH=of_eb8138c6bc ROOST_METHOD_SIG_HASH=of_7a04d5363c
	 *
	 */@Test
	@DisplayName("of method handles edge deadlines")
	@Tag("boundary")
	public void ofMethodHandlesEdgeDeadlines() {

		String jobName = "Job3";
		int expectedProcessingTime = 5;
		int edgeDeadline = 0;

		MinimizingLateness.Job job = MinimizingLateness.Job.of(jobName, expectedProcessingTime, edgeDeadline);

		assertNotNull(job, "Job object should not be null");
		assertEquals((String) jobName, job.jobName, "Job name should match the expected value");
		assertEquals((int) expectedProcessingTime, job.processingTime,
				"Processing time should match the expected value");
		assertEquals((int) edgeDeadline, job.deadline, "Deadline should match the edge value");
	}

	/*
	 * ROOST_METHOD_HASH=toString_7033209074 ROOST_METHOD_SIG_HASH=toString_bbffdadaa2
	 *
	 */@Tag("valid")
	@Test
	public void validateProperDisplayOfJobDetailsInToStringMethod() {

		MinimizingLateness.Job job = MinimizingLateness.Job.of("Job A", 5, 10);

		MinimizingLateness.calculateLateness(job);

		String actualOutput = job.toString();

		String expectedOutput = "Job A, startTime: 0, endTime: 5, lateness: 0";
		Assertions.assertEquals(expectedOutput, actualOutput);
	}

}