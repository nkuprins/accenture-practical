package com.bootcamp.studentmarktracker;

import com.bootcamp.studentmarktracker.StudentMarkTracker.StudentResult;
import java.util.List;
import java.util.Locale;

public class Main {
    private static final int[][] STUDENT_MARKS = {
            { 80, 90, 70 },
            { 40, 50, 45 },
            { 50, 50, 50 }
    };

    public static void main(String[] args) {
        List<StudentResult> results = StudentMarkTracker.analyzeStudents(STUDENT_MARKS);
        printStudentResults(results);
    }

    private static void printStudentResults(List<StudentResult> results) {
        for (StudentResult result : results) {
            // Two decimals, Locale.ROOT for a dot separator regardless of machine locale.
            System.out.println("Student " + result.studentNumber()
                    + " - Average: " + String.format(Locale.ROOT, "%.2f", result.average())
                    + " - Result: " + result.category());
        }
    }
}
