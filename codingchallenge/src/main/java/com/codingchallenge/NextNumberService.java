package com.codingchallenge;

import java.util.Arrays;

import org.springframework.stereotype.Service;

@Service
public class NextNumberService {

	public String findNextNumber(String input) {

		int number;

		// Converting the provided string to a number
		// Appropriate message should be shown if an invalid number is provided
		try {
			number = Integer.parseInt(input);
		} catch (Exception e) {
			return "Invalid Number";
		}

		int lengthOfNumber = input.length();
		int[] digits = new int[lengthOfNumber];
		int temp;
		int counter = lengthOfNumber - 1;

		// Get individual digits of the number and store it in an array
		while (number > 0) {
			temp = number % 10;
			number /= 10;
			digits[counter] = temp;
			counter--;
		}

		// Staring from the last digit find the first digit which is smaller than the digit next to it
		for (counter = lengthOfNumber - 1; counter > 0; counter--) {
			if (digits[counter] > digits[counter - 1]) {
				break;
			}
		}

		if (counter != 0) {

			int temp2 = digits[counter - 1], min = counter;

			// Find the smallest digit present in the right side of the previously identified digit
			for (int j = counter + 1; j < lengthOfNumber; j++) {
				if (digits[j] > temp2 && digits[j] < digits[min]) {
					min = j;
				}
			}

			// Swap the two digits identified
			temp = digits[counter - 1];
			digits[counter - 1] = digits[min];
			digits[min] = temp;

			// Sort out the rest of digits in the right side of the second identified digit
			Arrays.sort(digits, counter, lengthOfNumber);

			// Return the number from the array of digits.
			return "Next number with same set of digits is "
					+ Arrays.stream(digits).mapToObj(String::valueOf).reduce((a, b) -> a.concat(b)).get();

		}

		// If a smaller digit is not found, the given number is the greatest
		return "This is the greatest number possible with same of digits";

	}

}
