package com.thealgorithms.greedyalgorithms;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions.assertNotNull;

public class MinimizingLateness189Test {

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
	@Tag("valid")
	public void testAllJobsMeetDeadlines() {
		MinimizingLateness.Job[] jobs = { TestJob.of("Job1", 2, 5), TestJob.of("Job2", 3, 8),
				TestJob.of("Job3", 4, 12) };
		MinimizingLateness.calculateLateness(jobs);
		assertEquals(0, (int) jobs[0].lateness);
		assertEquals(0, (int) jobs[1].lateness);
		assertEquals(0, (int) jobs[2].lateness);
		assertEquals(0, (int) jobs[0].startTime);
		assertEquals(2, (int) jobs[1].startTime);
		assertEquals(5, (int) jobs[2].startTime);
	}

	/*
	 * ROOST_METHOD_HASH=calculateLateness_c431b08d2e
	 * ROOST_METHOD_SIG_HASH=calculateLateness_726ace5b20
	 *
	 */@Test
	@Tag("boundary")
	public void testSingleJobExceedsDeadline() {
		MinimizingLateness.Job[] jobs = { TestJob.of("Job1", 2, 5), TestJob.of("Job2", 6, 7) };
		MinimizingLateness.calculateLateness(jobs);
		assertEquals(0, (int) jobs[0].lateness);
		assertEquals(1, (int) jobs[1].lateness);
		assertEquals(0, (int) jobs[0].startTime);
		assertEquals(2, (int) jobs[1].startTime);
	}

	/*
	 * ROOST_METHOD_HASH=calculateLateness_c431b08d2e
	 * ROOST_METHOD_SIG_HASH=calculateLateness_726ace5b20
	 *
	 */@Test
	@Tag("valid")
	public void testJobsWithDecreasingDeadlines() {
		MinimizingLateness.Job[] jobs = { TestJob.of("Job1", 2, 8), TestJob.of("Job2", 4, 6),
				TestJob.of("Job3", 3, 5) };
		MinimizingLateness.calculateLateness(jobs);

		Arrays.sort(jobs, (a, b) -> a.deadline - b.deadline);
		assertEquals(0, (int) jobs[0].startTime);
		assertEquals(3, (int) jobs[1].startTime);
		assertEquals(8, (int) jobs[2].startTime);
	}

	/*
	 * ROOST_METHOD_HASH=calculateLateness_c431b08d2e
	 * ROOST_METHOD_SIG_HASH=calculateLateness_726ace5b20
	 *
	 */@Test
	@Tag("valid")
	public void testJobsWithIdenticalDeadlines() {
		MinimizingLateness.Job[] jobs = { TestJob.of("Job1", 3, 10), TestJob.of("Job2", 2, 10) };
		MinimizingLateness.calculateLateness(jobs);
		assertEquals(0, (int) jobs[0].startTime);
		assertEquals(3, (int) jobs[1].startTime);
		assertEquals(0, (int) jobs[0].lateness);
		assertEquals(0, (int) jobs[1].lateness);
	}

	/*
	 * ROOST_METHOD_HASH=calculateLateness_c431b08d2e
	 * ROOST_METHOD_SIG_HASH=calculateLateness_726ace5b20
	 *
	 */@Test
	@Tag("boundary")
	public void testZeroProcessingTimeJobs() {
		MinimizingLateness.Job[] jobs = { TestJob.of("Job1", 0, 5), TestJob.of("Job2", 0, 10) };
		MinimizingLateness.calculateLateness(jobs);
		assertEquals(0, (int) jobs[0].lateness);
		assertEquals(0, (int) jobs[1].lateness);
		assertEquals(0, (int) jobs[0].startTime);
		assertEquals(0, (int) jobs[1].startTime);
	}

	/*
	 * ROOST_METHOD_HASH=calculateLateness_c431b08d2e
	 * ROOST_METHOD_SIG_HASH=calculateLateness_726ace5b20
	 *
	 */@Test
	@Tag("valid")
	public void testCascadingLatenessEffect() {
		MinimizingLateness.Job[] jobs = { TestJob.of("Job1", 5, 10), TestJob.of("Job2", 4, 12),
				TestJob.of("Job3", 6, 15) };
		MinimizingLateness.calculateLateness(jobs);
		assertEquals(0, (int) jobs[0].lateness);
		assertEquals(2, (int) jobs[1].lateness);
		assertEquals(6, (int) jobs[2].lateness);
		assertEquals(0, (int) jobs[0].startTime);
		assertEquals(5, (int) jobs[1].startTime);
		assertEquals(9, (int) jobs[2].startTime);
	}

	/*
	 * ROOST_METHOD_HASH=calculateLateness_c431b08d2e
	 * ROOST_METHOD_SIG_HASH=calculateLateness_726ace5b20
	 *
	 */@Test
	@Tag("invalid")
	public void testSingleJobWithDeadlineExceeded() {
		MinimizingLateness.Job[] jobs = { TestJob.of("Job1", 6, 5) };
		MinimizingLateness.calculateLateness(jobs);
		assertEquals(1, (int) jobs[0].lateness);
		assertEquals(0, (int) jobs[0].startTime);
	}

	/*
	 * ROOST_METHOD_HASH=calculateLateness_c431b08d2e
	 * ROOST_METHOD_SIG_HASH=calculateLateness_726ace5b20
	 *
	 */@Test
	@Tag("integration")
	public void testEmptyJobsList() {
		MinimizingLateness.Job[] jobs = {};
		MinimizingLateness.calculateLateness(jobs);

		assertEquals(0, jobs.length);
	}

	/*
	 * ROOST_METHOD_HASH=calculateLateness_c431b08d2e
	 * ROOST_METHOD_SIG_HASH=calculateLateness_726ace5b20
	 *
	 */@Test
	@Tag("boundary")
	public void testJobsWithZeroDeadlines() {
		MinimizingLateness.Job[] jobs = { TestJob.of("Job1", 3, 0), TestJob.of("Job2", 5, 0) };
		MinimizingLateness.calculateLateness(jobs);
		assertEquals(3, (int) jobs[0].lateness);
		assertEquals(8, (int) jobs[1].lateness);
		assertEquals(0, (int) jobs[0].startTime);
		assertEquals(3, (int) jobs[1].startTime);
	}

	/*
	 * ROOST_METHOD_HASH=calculateLateness_c431b08d2e
	 * ROOST_METHOD_SIG_HASH=calculateLateness_726ace5b20
	 *
	 */@Test
	@Tag("valid")
	public void testLargeProcessingAndDeadlines() {
		MinimizingLateness.Job[] jobs = { TestJob.of("Job1", 100000, 200000), TestJob.of("Job2", 500000, 600000) };
		MinimizingLateness.calculateLateness(jobs);
		assertEquals(0, (int) jobs[0].lateness);
		assertEquals(0, (int) jobs[1].lateness);
		assertEquals(0, (int) jobs[0].startTime);
		assertEquals(100000, (int) jobs[1].startTime);
	}

	/*
	 * ROOST_METHOD_HASH=of_eb8138c6bc ROOST_METHOD_SIG_HASH=of_7a04d5363c
	 *
	 */@Test
	@Tag("valid")
	public void creatingJobWithValidParameters() {

		MinimizingLateness.Job job = MinimizingLateness.Job.of("Job1", 4, 10);

		assertNotNull(job, "The job object should not be null");
		assertEquals("Job1", job.jobName, "Job name should match the provided value");
		assertEquals(4, (int) job.processingTime, "Processing time should match the provided value");
		assertEquals(10, (int) job.deadline, "Deadline should match the provided value");
	}

	/*
	 * ROOST_METHOD_HASH=of_eb8138c6bc ROOST_METHOD_SIG_HASH=of_7a04d5363c
	 *
	 */@Test
	@Tag("boundary")
	public void creatingJobWithZeroProcessingTime() {

		MinimizingLateness.Job job = MinimizingLateness.Job.of("Job2", 0, 10);

		assertNotNull(job, "The job object should not be null");
		assertEquals("Job2", job.jobName, "Job name should match the provided value");
		assertEquals(0, (int) job.processingTime, "Processing time should match the provided value");
		assertEquals(10, (int) job.deadline, "Deadline should match the provided value");
	}

	/*
	 * ROOST_METHOD_HASH=of_eb8138c6bc ROOST_METHOD_SIG_HASH=of_7a04d5363c
	 *
	 */@Test
	@Tag("boundary")
	public void creatingJobWithZeroDeadline() {

		MinimizingLateness.Job job = MinimizingLateness.Job.of("Job3", 5, 0);

		assertNotNull(job, "The job object should not be null");
		assertEquals("Job3", job.jobName, "Job name should match the provided value");
		assertEquals(5, (int) job.processingTime, "Processing time should match the provided value");
		assertEquals(0, (int) job.deadline, "Deadline should match the provided value");
	}

	/*
	 * ROOST_METHOD_HASH=of_eb8138c6bc ROOST_METHOD_SIG_HASH=of_7a04d5363c
	 *
	 */@Test
	@Tag("invalid")
	public void creatingJobWithNegativeProcessingTime() {

		MinimizingLateness.Job job = MinimizingLateness.Job.of("Job4", -1, 10);

		assertNotNull(job, "The job object should not be null");
		assertEquals("Job4", job.jobName, "Job name should match the provided value");
		assertEquals(-1, (int) job.processingTime, "Processing time should match the provided value");
		assertEquals(10, (int) job.deadline, "Deadline should match the provided value");
	}

	/*
	 * ROOST_METHOD_HASH=of_eb8138c6bc ROOST_METHOD_SIG_HASH=of_7a04d5363c
	 *
	 */@Test
	@Tag("invalid")
	public void creatingJobWithNegativeDeadline() {

		MinimizingLateness.Job job = MinimizingLateness.Job.of("Job5", 5, -10);

		assertNotNull(job, "The job object should not be null");
		assertEquals("Job5", job.jobName, "Job name should match the provided value");
		assertEquals(5, (int) job.processingTime, "Processing time should match the provided value");
		assertEquals(-10, (int) job.deadline, "Deadline should match the provided value");
	}

	/*
	 * ROOST_METHOD_HASH=toString_7033209074 ROOST_METHOD_SIG_HASH=toString_bbffdadaa2
	 *
	 */@BeforeEach
	public void setUp() {

	}

	/*
	 * ROOST_METHOD_HASH=toString_7033209074 ROOST_METHOD_SIG_HASH=toString_bbffdadaa2
	 *
	 */@Test
	@Tag("valid")
	public void toStringReturnsExpectedFormatForValidJob() {
		MinimizingLateness.Job job = new MinimizingLateness.Job("JobA", 5, 10);
		job.lateness = 0;
		String result = job.toString();
		assertEquals("JobA, startTime: 0, endTime: 5, lateness: 0", result);
	}

	/*
	 * ROOST_METHOD_HASH=toString_7033209074 ROOST_METHOD_SIG_HASH=toString_bbffdadaa2
	 *
	 */@Test
	@Tag("valid")
	public void toStringHandlesZeroProcessingTimeProperly() {
		MinimizingLateness.Job job = new MinimizingLateness.Job("JobB", 0, 10);
		job.lateness = 0;
		String result = job.toString();
		assertEquals("JobB, startTime: 0, endTime: 0, lateness: 0", result);
	}

	/*
	 * ROOST_METHOD_HASH=toString_7033209074 ROOST_METHOD_SIG_HASH=toString_bbffdadaa2
	 *
	 */@Test
	@Tag("valid")
	public void toStringHandlesNoLatenessScenario() {
		MinimizingLateness.Job job = new MinimizingLateness.Job("JobC", 5, 15);
		job.lateness = 0;
		String result = job.toString();
		assertEquals("JobC, startTime: 0, endTime: 5, lateness: 0", result);
	}

	/*
	 * ROOST_METHOD_HASH=toString_7033209074 ROOST_METHOD_SIG_HASH=toString_bbffdadaa2
	 *
	 */@Test
	@Tag("boundary")
	public void toStringHandlesEarliestStartTimeCorrectly() {
		MinimizingLateness.Job job = new MinimizingLateness.Job("JobD", 5, 10);
		job.lateness = 0;
		String result = job.toString();
		assertEquals("JobD, startTime: 0, endTime: 5, lateness: 0", result);
	}

	/*
	 * ROOST_METHOD_HASH=toString_7033209074 ROOST_METHOD_SIG_HASH=toString_bbffdadaa2
	 *
	 */@Test
	@Tag("boundary")
	public void toStringReflectsMaximumLatenessCorrectly() {
		MinimizingLateness.Job job = new MinimizingLateness.Job("JobE", 10, 5);
		job.lateness = 5;
		String result = job.toString();
		assertEquals("JobE, startTime: 0, endTime: 10, lateness: 5", result);
	}

}