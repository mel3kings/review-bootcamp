package easy;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class GradeTheStudent {

    /*
     * Complete the gradingStudents function below.
     */
    static int[] gradingStudents(int[] grades) {
        return Arrays.stream(grades).map(grade -> {
            if (grade < 38) {
                return grade;
            } else {
                if ((grade + 2) % 5 == 0) {
                    return grade + 2;
                } else if ((grade + 1) % 5 == 0) {
                    return grade + 1;
                } else {
                    return grade;
                }
            }
        }).toArray();
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(scan.nextLine().trim());

        int[] grades = new int[n];

        for (int gradesItr = 0; gradesItr < n; gradesItr++) {
            int gradesItem = Integer.parseInt(scan.nextLine().trim());
            grades[gradesItr] = gradesItem;
        }

        int[] result = gradingStudents(grades);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            System.out.println(String.valueOf(result[resultItr]));

        }

    }
}
