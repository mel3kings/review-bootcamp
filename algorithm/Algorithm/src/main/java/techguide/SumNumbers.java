package techguide;

public class SumNumbers {


    /**
     * Given a string, return the sum of the numbers appearing in the string,
     * ignoring all other characters. A number is a series of 1 or more digit chars in a row.
     * (Note: Character.isDigit(char) tests if a char is one of the chars '0', '1', .. '9'. Integer.parseInt(string)
     * converts a string to an int.)
     * <p>
     * SumNumbers("abc123xyz") → 123
     * SumNumbers("aa11b33") → 44
     * SumNumbers("7 11") → 18
     *
     * @param str
     * @return
     */
    public int sumNumbers(String str) {
        int total = 0;
        boolean isNumber = false;
        String holder = "";
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                holder = holder + String.valueOf(c);
                isNumber = true;
            } else {
                isNumber = false;
            }

            if (!isNumber && !holder.equals("")) {
                int currentValue = Integer.parseInt(holder);
                total += currentValue;
                holder = "";
            }
        }

        if (!"".equals(holder)) {
            int currentValue = Integer.parseInt(holder);
            total += currentValue;
        }
        return total;
    }

}
