package com.thealgorithms.greedyalgorithms;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api;

public class MinimizingLateness907Test {

	/*
	 * ROOST_METHOD_HASH=calculateLateness_c431b08d2e
	 * ROOST_METHOD_SIG_HASH=calculateLateness_726ace5b20
	 *
	 */@Tag("valid")
	@Test
	public void testVerifyNoLatenessWhenJobsMeetDeadlines() {

		Job job1 = Job.of("Job1", 2, 5);
		Job job2 = Job.of("Job2", 3, 8);
		Job job3 = Job.of("Job3", 1, 6);
		Job job4 = Job.of("Job4", 4, 10);

		MinimizingLateness.calculateLateness(job1, job2, job3, job4);

		assertEquals(0, (int) job1.lateness);
		assertEquals(0, (int) job2.lateness);
		assertEquals(0, (int) job3.lateness);
		assertEquals(0, (int) job4.lateness);
	}

	/*
	 * ROOST_METHOD_HASH=calculateLateness_c431b08d2e
	 * ROOST_METHOD_SIG_HASH=calculateLateness_726ace5b20
	 *
	 */@Tag("valid")
	@Test
	public void testVerifyLatenessWhenJobsMissDeadlines() {

		Job job1 = Job.of("Job1", 3, 4);
		Job job2 = Job.of("Job2", 2, 3);
		Job job3 = Job.of("Job3", 1, 2);
		Job job4 = Job.of("Job4", 4, 7);

		MinimizingLateness.calculateLateness(job1, job2, job3, job4);

		assertEquals(1, (int) job1.lateness);

		assertEquals(0, (int) job2.lateness);
		assertEquals(2, (int) job3.lateness);
		assertEquals(1, (int) job4.lateness);
	}

	/*
	 * ROOST_METHOD_HASH=of_eb8138c6bc ROOST_METHOD_SIG_HASH=of_7a04d5363c
	 *
	 */@Test
	@Tag("valid")
	public void createJobWithValidParameters() {

		String jobName = "A";
		int processingTime = 5;
		int deadline = 10;

		MinimizingLateness.Job job = MinimizingLateness.Job.of(jobName, processingTime, deadline);

		assertThat(job.toString()).isEqualTo("A, startTime: 0, endTime: 5, lateness: 0");
	}

	/*
	 * ROOST_METHOD_HASH=of_eb8138c6bc ROOST_METHOD_SIG_HASH=of_7a04d5363c
	 *
	 */@Test
	@Tag("invalid")
	public void createJobWithZeroProcessingTime() {

		String jobName = "B";

		int processingTime = 0;
		int deadline = 10;

		MinimizingLateness.Job job = MinimizingLateness.Job.of(jobName, processingTime, deadline);

		assertThat(job.jobName).isEqualTo("B");
		assertThat((int) job.processingTime).isEqualTo(0);
		assertThat((int) job.deadline).isEqualTo(10);
	}

	/*
	 * ROOST_METHOD_HASH=of_eb8138c6bc ROOST_METHOD_SIG_HASH=of_7a04d5363c
	 *
	 */@Test
	@Tag("boundary")
	public void createJobWithBoundaryValues() {

		String jobName = "C";

		int processingTime = Integer.MAX_VALUE;

		int deadline = Integer.MAX_VALUE;

		MinimizingLateness.Job job = MinimizingLateness.Job.of(jobName, processingTime, deadline);

		assertThat((int) job.processingTime).isEqualTo(Integer.MAX_VALUE);
		assertThat((int) job.deadline).isEqualTo(Integer.MAX_VALUE);
		assertThat(job.jobName).isEqualTo("C");
	}

	/*
	 * ROOST_METHOD_HASH=of_eb8138c6bc ROOST_METHOD_SIG_HASH=of_7a04d5363c
	 *
	 */@Test
	@Tag("invalid")
	public void createJobWithNegativeProcessingTime() {

		String jobName = "D";

		int processingTime = -5;
		int deadline = 10;

		MinimizingLateness.Job job = MinimizingLateness.Job.of(jobName, processingTime, deadline);

		assertThat(job.jobName).isEqualTo("D");
		assertThat((int) job.processingTime).isEqualTo(-5);
		assertThat((int) job.deadline).isEqualTo(10);
	}

	/*
	 * ROOST_METHOD_HASH=of_eb8138c6bc ROOST_METHOD_SIG_HASH=of_7a04d5363c
	 *
	 */@Test
	@Tag("boundary")
	public void createJobWithMinimumValues() {

		String jobName = "E";
		int processingTime = 0;
		int deadline = 0;

		MinimizingLateness.Job job = MinimizingLateness.Job.of(jobName, processingTime, deadline);

		assertThat((int) job.processingTime).isEqualTo(0);
		assertThat((int) job.deadline).isEqualTo(0);
		assertThat(job.jobName).isEqualTo("E");
	}

	/*
	 * ROOST_METHOD_HASH=toString_7033209074 ROOST_METHOD_SIG_HASH=toString_bbffdadaa2
	 *
	 */@Test
	@Tag("valid")
	public void verifyToStringOutputFormat() {

		MinimizingLateness minimizingLateness = new MinimizingLateness();
		MinimizingLateness.Job job = MinimizingLateness.Job.of("Job1", 5, 10);
		MinimizingLateness.calculateLateness(job);

		String actualOutput = job.toString();

		String expectedOutput = "Job1, startTime: 0, endTime: 5, lateness: 0";
		Assertions.assertEquals(expectedOutput, actualOutput, "The toString output format is incorrect.");
	}

	/*
	 * ROOST_METHOD_HASH=toString_7033209074 ROOST_METHOD_SIG_HASH=toString_bbffdadaa2
	 *
	 */@Test
	@Tag("boundary")
	public void verifyToStringForZeroProcessingTimeAndDeadline() {

		MinimizingLateness minimizingLateness = new MinimizingLateness();
		MinimizingLateness.Job job = MinimizingLateness.Job.of("JobZero", 0, 0);
		MinimizingLateness.calculateLateness(job);

		String actualOutput = job.toString();

		String expectedOutput = "JobZero, startTime: 0, endTime: 0, lateness: 0";
		Assertions.assertEquals(expectedOutput, actualOutput,
				"The toString output format for boundary values is incorrect.");
	}

	/*
	 * ROOST_METHOD_HASH=toString_7033209074 ROOST_METHOD_SIG_HASH=toString_bbffdadaa2
	 *
	 */@Test
	@Tag("boundary")
	public void verifyToStringForLateJob() {

		MinimizingLateness minimizingLateness = new MinimizingLateness();
		MinimizingLateness.Job job = MinimizingLateness.Job.of("LateJob", 10, 5);
		MinimizingLateness.calculateLateness(job);

		String actualOutput = job.toString();

		String expectedOutput = "LateJob, startTime: 0, endTime: 10, lateness: 5";
		Assertions.assertEquals(expectedOutput, actualOutput, "The toString output format for late jobs is incorrect.");
	}

	/*
	 * ROOST_METHOD_HASH=toString_7033209074 ROOST_METHOD_SIG_HASH=toString_bbffdadaa2
	 *
	 */@Test
	@Tag("invalid")
	public void verifyToStringForNullJobName() {

		MinimizingLateness minimizingLateness = new MinimizingLateness();

		MinimizingLateness.Job job = MinimizingLateness.Job.of(null, 5, 10);
		MinimizingLateness.calculateLateness(job);

		String actualOutput = job.toString();

		String expectedOutput = "null, startTime: 0, endTime: 5, lateness: 0";
		Assertions.assertEquals(expectedOutput, actualOutput,
				"The toString output format for null jobName is incorrect.");
	}

	/*
	 * ROOST_METHOD_HASH=toString_7033209074 ROOST_METHOD_SIG_HASH=toString_bbffdadaa2
	 *
	 */@Test
	@Tag("valid")
	public void verifyToStringForMultipleJobs() {

		MinimizingLateness minimizingLateness = new MinimizingLateness();
		MinimizingLateness.Job job1 = MinimizingLateness.Job.of("Job1", 3, 5);
		MinimizingLateness.Job job2 = MinimizingLateness.Job.of("Job2", 4, 7);
		MinimizingLateness.calculateLateness(job1, job2);

		String actualOutputJob1 = job1.toString();
		String actualOutputJob2 = job2.toString();

		String expectedOutputJob1 = "Job1, startTime: 0, endTime: 3, lateness: 0";
		String expectedOutputJob2 = "Job2, startTime: 3, endTime: 7, lateness: 0";
		Assertions.assertEquals(expectedOutputJob1, actualOutputJob1,
				"The toString output format for Job1 is incorrect.");
		Assertions.assertEquals(expectedOutputJob2, actualOutputJob2,
				"The toString output format for Job2 is incorrect.");
	}

}