// ********RoostGPT********
/*
Test generated by RoostGPT for test test-workflow using AI Type Azure Open AI and AI Model roostgpt-4-32k
ROOST_METHOD_HASH=of_eb8138c6bc
ROOST_METHOD_SIG_HASH=of_7a04d5363c
"""
  Scenario 1: Creating job object with valid arguments
  Details:
    TestName: createJobWithValidArgs.
    Description: The test aims to verify whether the Job object is created successfully with valid string and integer arguments.
  Execution:
    Arrange: Initialize expected jobName, processingTime, deadline values.
    Act: Call the "of" method with valid jobName, processingTime, deadline.
    Assert: Verify if the Job object returned is not null.
  Validation:
    Assert is verifying that the returned Job object isn't null hence confirming its successful creation. An important aspect for the application to schedule jobs accordingly.
  Scenario 2: Creating job object with null job name
  Details:
    TestName: createJobWithNullJobName.
    Description: This test checks the behavior of "of" method when the jobName parameter is null.
  Execution:
    Arrange: Do not initialize the jobName, set valid values for processingTime and deadline.
    Act: Invoke "of" method with null jobName, processingTime, deadline.
    Assert: Expected an IllegalArgumentException or NullPointerException.
  Validation:
    An exception will be thrown when the jobName is null. This verifies the method's validity check for its parameters.
  Scenario 3: Invalid negative processing time
  Details:
    TestName: createJobWithNegativeProcessingTime.
    Description: Should verify if the method throws an exception when the processingTime is negative.
  Execution:
    Arrange: Initialize jobName and deadline with valid values and processingTime to a negative integer.
    Act: Call "of" method with jobName, negative processingTime, deadline.
    Assert: An exception should be thrown.
  Validation:
    Processing time should not be negative seeing that this doesn't adhere to job processing concept, thus an exception should be thrown.
  Scenario 4: Deadline less than processing time
  Details:
    TestName: createTimeLessThanProcessingTime.
    Description: Verify if the method behaves appropriately when deadline is less than processing time.
  Execution:
    Arrange: Initialize jobName, processingTime and deadline, such that deadline < processingTime.
    Act: Invoke "of" method with jobName, processingTime, deadline.
    Assert: Assure an exception is thrown.
  Validation:
    An exception should be thrown as the deadline should not be less than the processing time for proper Job management.
 """
*/
// ********RoostGPT********
package com.thealgorithms.greedyalgorithms;

import org.junit.jupiter.api.Test;
import com.thealgorithms.greedyalgorithms.Job;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.*;

@Tag("com.thealgorithms.greedyalgorithms")
@Tag("com.thealgorithms.greedyalgorithms.of")
@Tag("roostTest1")
@Tag("roostTest2")
// Add this import statement to address Job
public class MinimizingLatenessOfTest {

	@Test
	public void createJobWithValidArgs() {
		String expectedJobName = "TestJob";
		int expectedProcessingTime = 5;
		int expectedDeadline = 10;

		// Act
		Job actualJob = Job.of(expectedJobName, expectedProcessingTime, expectedDeadline);
		// Assert
		assertNotNull(actualJob);
		assertEquals(expectedJobName, actualJob.getJobName());
		assertEquals(expectedProcessingTime, actualJob.getProcessingTime());
		assertEquals(expectedDeadline, actualJob.getDeadline());
	}

	@Test
	public void createJobWithNullJobName() {
		int processingTime = 5;
		int deadline = 10;
		// Act & Assert
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			Job job = Job.of(null, processingTime, deadline);
		});
	}

	@Test
	public void createJobWithNegativeProcessingTime() {
		String jobName = "TestJob";
		int negativeProcessingTime = -5;
		int deadline = 10;
		// Act & Assert
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			Job job = Job.of(jobName, negativeProcessingTime, deadline);
		});
	}

	@Test
	public void createTimeLessThanProcessingTime() {
		String jobName = "TestJob";
		int processingTime = 10;
		int deadline = 5;
		// Act & Assert
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			Job job = Job.of(jobName, processingTime, deadline);
		});
	}

}