package easy;

public class AddString {
    public String addStrings(String num1, String num2) {

        if (num1.length() < num2.length()) {
            String num3 = num1;
            num1 = num2;
            num2 = num3;
        }
        StringBuffer sb = new StringBuffer(num1);
        StringBuffer sb2 = new StringBuffer(num2);
        char[] c1 = sb.reverse().toString().toCharArray();
        char[] c2 = sb2.reverse().toString().toCharArray();

        boolean carry = false;
        int len = c1.length > c2.length ? c1.length : c2.length;
        StringBuffer sb3 = new StringBuffer();
        for (int i = 0; i < len; i++) {
            int f = Character.getNumericValue(c1[i]);
            if (i < c2.length) {
                int s = Character.getNumericValue(c2[i]);
                f = f + s;
            }
            if (carry) {
                f++;
                carry = false;
            }
            if (f >= 10) {
                carry = true;
                sb3.append(String.valueOf(f - 10));
            } else {
                sb3.append(String.valueOf(f));
            }
        }
        if (carry) {
            sb3.append("1");
        }
        return sb3.reverse().toString();
    }

}
