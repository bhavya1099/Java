
// ********RoostGPT********
/*
Test generated by RoostGPT for test java-customannotation-test using AI Type  and AI Model

ROOST_METHOD_HASH=activitySelection_77631a6e2d
ROOST_METHOD_SIG_HASH=activitySelection_bf79d28a9f

Based on the provided method and instructions, here are several test scenarios for the `activitySelection` method:

```
Scenario 1: Basic Activity Selection

Details:
  TestName: basicActivitySelection
  Description: Test the activity selection algorithm with a simple set of non-overlapping activities.
Execution:
  Arrange: Create arrays of start times and end times for non-overlapping activities.
  Act: Call activitySelection with the arranged start and end times.
  Assert: Verify that all activities are selected in the correct order.
Validation:
  This test ensures that the method correctly selects all activities when there are no conflicts. It validates the basic functionality of the algorithm for a straightforward case.

Scenario 2: Overlapping Activities

Details:
  TestName: overlappingActivities
  Description: Test the activity selection algorithm with a set of overlapping activities.
Execution:
  Arrange: Create arrays of start times and end times for activities with some overlaps.
  Act: Call activitySelection with the arranged start and end times.
  Assert: Verify that the method selects the maximum number of non-overlapping activities.
Validation:
  This test checks if the algorithm correctly handles overlapping activities and selects the optimal set of non-overlapping activities. It validates the core logic of the activity selection problem.

Scenario 3: Empty Input Arrays

Details:
  TestName: emptyInputArrays
  Description: Test the behavior of the method when given empty input arrays.
Execution:
  Arrange: Create empty arrays for start times and end times.
  Act: Call activitySelection with the empty arrays.
  Assert: Verify that the method returns an empty ArrayList.
Validation:
  This test ensures that the method handles edge cases gracefully, specifically when no activities are provided. It checks for proper behavior with minimal input.

Scenario 4: Single Activity

Details:
  TestName: singleActivity
  Description: Test the activity selection algorithm with only one activity.
Execution:
  Arrange: Create start times and end times arrays with a single element each.
  Act: Call activitySelection with the single-element arrays.
  Assert: Verify that the method returns an ArrayList containing only the index of the single activity.
Validation:
  This test checks if the method correctly handles the case of a single activity, ensuring it's selected and returned properly.

Scenario 5: Activities with Same End Time

Details:
  TestName: activitiesWithSameEndTime
  Description: Test the algorithm's behavior when multiple activities have the same end time.
Execution:
  Arrange: Create start times and end times arrays where multiple activities end at the same time.
  Act: Call activitySelection with these arrays.
  Assert: Verify that the method selects activities correctly, prioritizing those with earlier start times when end times are the same.
Validation:
  This test ensures that the method can handle activities with identical end times, validating the sorting and selection logic in such cases.

Scenario 6: Activities with Same Start Time

Details:
  TestName: activitiesWithSameStartTime
  Description: Test the algorithm's behavior when multiple activities have the same start time.
Execution:
  Arrange: Create start times and end times arrays where multiple activities start at the same time.
  Act: Call activitySelection with these arrays.
  Assert: Verify that the method selects activities correctly, prioritizing those with earlier end times.
Validation:
  This test checks if the method correctly handles activities starting simultaneously, ensuring it selects the optimal set based on end times.

Scenario 7: Large Number of Activities

Details:
  TestName: largeNumberOfActivities
  Description: Test the performance and correctness of the algorithm with a large number of activities.
Execution:
  Arrange: Create large arrays of start times and end times (e.g., 10000 activities).
  Act: Call activitySelection with these large arrays.
  Assert: Verify that the method returns a valid selection of activities within a reasonable time frame.
Validation:
  This test assesses the algorithm's efficiency and correctness when dealing with a large dataset, ensuring it scales well and maintains accuracy.
```

These scenarios cover various aspects of the `activitySelection` method, including basic functionality, edge cases, and potential challenging inputs. They aim to thoroughly test the method's behavior and correctness across different situations.
*/

// ********RoostGPT********

package com.thealgorithms.greedyalgorithms;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.*;
import java.util.Comparator;

class ActivitySelectionActivitySelectionTest {

	@Test
	@Tag("valid")
	void basicActivitySelection() {
		int[] startTimes = { 1, 3, 0, 5, 8, 5 };
		int[] endTimes = { 2, 4, 6, 7, 9, 9 };
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0, 1, 3, 4));
		ArrayList<Integer> result = ActivitySelection.activitySelection(startTimes, endTimes);
		assertThat(result).isEqualTo(expected);
	}

	@Test
	@Tag("valid")
	void overlappingActivities() {
		int[] startTimes = { 1, 3, 2, 5, 4 };
		int[] endTimes = { 4, 5, 6, 7, 8 };
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0, 2, 4));
		ArrayList<Integer> result = ActivitySelection.activitySelection(startTimes, endTimes);
		assertThat(result).isEqualTo(expected);
	}

	@Test
	@Tag("boundary")
	void emptyInputArrays() {
		int[] startTimes = {};
		int[] endTimes = {};
		ArrayList<Integer> result = ActivitySelection.activitySelection(startTimes, endTimes);
		assertThat(result).isEmpty();
	}

	@Test
	@Tag("boundary")
	void singleActivity() {
		int[] startTimes = { 1 };
		int[] endTimes = { 2 };
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0));
		ArrayList<Integer> result = ActivitySelection.activitySelection(startTimes, endTimes);
		assertThat(result).isEqualTo(expected);
	}

	@Test
	@Tag("valid")
	void activitiesWithSameEndTime() {
		int[] startTimes = { 1, 3, 2, 4, 5 };
		int[] endTimes = { 6, 6, 6, 6, 6 };
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0));
		ArrayList<Integer> result = ActivitySelection.activitySelection(startTimes, endTimes);
		assertThat(result).isEqualTo(expected);
	}

	@Test
	@Tag("valid")
	void activitiesWithSameStartTime() {
		int[] startTimes = { 1, 1, 1, 1, 1 };
		int[] endTimes = { 2, 3, 4, 5, 6 };
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0));
		ArrayList<Integer> result = ActivitySelection.activitySelection(startTimes, endTimes);
		assertThat(result).isEqualTo(expected);
	}

	@Test
	@Tag("valid")
	void largeNumberOfActivities() {
		int[] startTimes = new int[10000];
		int[] endTimes = new int[10000];
		for (int i = 0; i < 10000; i++) {
			startTimes[i] = i;
			endTimes[i] = i + 1;
		}
		ArrayList<Integer> result = ActivitySelection.activitySelection(startTimes, endTimes);
		assertThat(result).hasSize(10000);
		for (int i = 0; i < 10000; i++) {
			assertThat(result.get(i)).isEqualTo(i);
		}
	}

}