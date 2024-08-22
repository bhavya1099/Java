// ********RoostGPT********
/*
Test generated by RoostGPT for test java-customannotation-test using AI Type  and AI Model
ROOST_METHOD_HASH=of_eb8138c6bc
ROOST_METHOD_SIG_HASH=of_7a04d5363c
```
Scenario 1: Valid Job Creation with Positive Processing Time and Deadline
Details:
  TestName: createJobWithValidParameters
  Description: This test checks the creation of a Job object with valid job name, positive processing time, and positive deadline to ensure that the object is instantiated correctly.
Execution:
  Arrange: Define the input parameters (jobName, processingTime, deadline).
  Act: Call the of method with the provided parameters.
  Assert: Assert that the returned Job object is not null and its properties match the provided parameters.
Validation:
  Clarify what the assertion aims to verify and the reason behind the expected result. The assertion verifies that the Job object is correctly instantiated with the specified attributes. This test is significant as it confirms the basic functionality of job creation in the system.
Scenario 2: Job Creation with Null Job Name
Details:
  TestName: createJobWithNullJobName
  Description: This test checks the behavior of the of method when a null job name is passed. It should ideally handle the null input gracefully, possibly throwing an IllegalArgumentException.
Execution:
  Arrange: Set jobName to null, and define valid processingTime and deadline.
  Act: Attempt to create a Job object using the of method with the null jobName.
  Assert: Expect an IllegalArgumentException or a specific handling of null values.
Validation:
  Clarify what the assertion aims to verify and the reason behind the expected result. This test verifies that the method can handle null input for jobName without causing unexpected failures, ensuring robustness in job creation.
Scenario 3: Job Creation with Negative Processing Time
Details:
  TestName: createJobWithNegativeProcessingTime
  Description: This test examines the system's response to a negative processing time, which is typically an invalid argument for job processing time.
Execution:
  Arrange: Provide a valid jobName and deadline, but set processingTime to a negative value.
  Act: Call the of method with these parameters.
  Assert: Expect an IllegalArgumentException or similar error handling.
Validation:
  Clarify what the assertion aims to verify and the reason behind the expected result. This test is essential to confirm that the job creation logic correctly handles invalid input values for processing time, preserving data integrity.
Scenario 4: Job Creation with Zero Deadline
Details:
  TestName: createJobWithZeroDeadline
  Description: This test checks the system's handling of a job with a zero deadline, which might be a boundary condition in scheduling algorithms.
Execution:
  Arrange: Provide a valid jobName and processingTime, but set the deadline to zero.
  Act: Create a Job object using the of method with these parameters.
  Assert: Check that the Job object is created without errors and verify its properties.
Validation:
  Clarify what the assertion aims to verify and the reason behind the expected result. This test ensures that jobs with a zero deadline are handled correctly, which might be valid in certain contexts or need special handling in scheduling logic.
Scenario 5: Job Creation with Extreme Large Values for Processing Time and Deadline
Details:
  TestName: createJobWithExtremeValues
  Description: This test evaluates the creation of a Job object with extremely large values for processing time and deadline to test the robustness of the system under stress conditions.
Execution:
  Arrange: Set a very large value for processingTime and deadline along with a valid jobName.
  Act: Call the of method with these parameters.
  Assert: Verify that the Job object is created and its properties correspond to the provided values.
Validation:
  Clarify what the assertion aims to verify and the reason behind the expected result. This test checks the system's ability to handle very large input values, ensuring that the application can manage extreme cases without failure.
```
*/
// ********RoostGPT********
package com.thealgorithms.greedyalgorithms;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import org.junit.jupiter.api.*;

@Tag("com.thealgorithms.greedyalgorithms")
@Tag("com.thealgorithms.greedyalgorithms.of")
public class MinimizingLatenessOfTest {

	@Test
	@Tag("valid")
	public void createJobWithValidParameters() {
		// Arrange
		String jobName = "Job1";
		int processingTime = 5;
		int deadline = 10;
		// Act
		Job result = new Job(jobName, processingTime, deadline);
		// Assert
		assertThat(result).isNotNull();
		assertThat(result.jobName).isEqualTo(jobName);
		assertThat(result.processingTime).isEqualTo(processingTime);
		assertThat(result.deadline).isEqualTo(deadline);
	}

	@Test
	@Tag("invalid")
	public void createJobWithNullJobName() {
		// Arrange
		String jobName = null;
		int processingTime = 5;
		int deadline = 10;
		// Act & Assert
		assertThatThrownBy(() -> new Job(jobName, processingTime, deadline))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("jobName cannot be null");
	}

	@Test
	@Tag("invalid")
	public void createJobWithNegativeProcessingTime() {
		// Arrange
		String jobName = "Job2";
		int processingTime = -1;
		int deadline = 10;
		// Act & Assert
		assertThatThrownBy(() -> new Job(jobName, processingTime, deadline))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("processingTime must be positive");
	}

	@Test
	@Tag("boundary")
	public void createJobWithZeroDeadline() {
		// Arrange
		String jobName = "Job3";
		int processingTime = 5;
		int deadline = 0;
		// Act
		Job result = new Job(jobName, processingTime, deadline);
		// Assert
		assertThat(result).isNotNull();
		assertThat(result.jobName).isEqualTo(jobName);
		assertThat(result.processingTime).isEqualTo(processingTime);
		assertThat(result.deadline).isEqualTo(deadline);
	}

	@Test
	@Tag("valid")
	public void createJobWithExtremeValues() {
		// Arrange
		String jobName = "Job4";
		int processingTime = Integer.MAX_VALUE;
		int deadline = Integer.MAX_VALUE;
		// Act
		Job result = new Job(jobName, processingTime, deadline);
		// Assert
		assertThat(result).isNotNull();
		assertThat(result.jobName).isEqualTo(jobName);
		assertThat(result.processingTime).isEqualTo(processingTime);
		assertThat(result.deadline).isEqualTo(deadline);
	}

}