package com.bootcamp.studentmarktracker;

import java.util.ArrayList;
import java.util.List;

public class StudentMarkTracker {
    private static final int GOOD_AVERAGE_THRESHOLD = 50;
    private static final int EXCELLENT_AVERAGE_THRESHOLD = 80;

    private StudentMarkTracker() {}

    public static List<StudentResult> analyzeStudents(int[][] studentMarks) {
        List<StudentResult> results = new ArrayList<>();
        for (int studentIndex = 0; studentIndex < studentMarks.length; studentIndex++) {
            double average = calculateAverage(studentMarks[studentIndex]);
            ResultCategory category = classifyResult(average);
            results.add(new StudentResult(studentIndex + 1, average, category));
        }
        return results;
    }

    // I use for loop with explicit type casting to show that I understand the material.
    // However, in real project, I would (probably) use IntStream.of(...).average().orElseThrow(...)
    public static double calculateAverage(int[] marks) {
        if (marks == null || marks.length == 0) {
            throw new IllegalArgumentException("Marks must not be null or empty");
        }
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return (double) total / marks.length;
    }

    public static ResultCategory classifyResult(double average) {
        if (average >= EXCELLENT_AVERAGE_THRESHOLD) {
            return ResultCategory.EXCELLENT;
        }
        if (average >= GOOD_AVERAGE_THRESHOLD) {
            return ResultCategory.GOOD;
        }
        return ResultCategory.POOR;
    }

    public enum ResultCategory {
        POOR,
        GOOD,
        EXCELLENT
    }

    // The other approach would be to print directly in the analyzeStudents loop.
    // However, using a record allows us to return structured data cleanly,
    // keeping business calculation completely separate from console presentation.
    public record StudentResult(int studentNumber, double average, ResultCategory category) {}
}
