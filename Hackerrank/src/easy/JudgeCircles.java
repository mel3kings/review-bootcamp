package easy;

public class JudgeCircles {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        char[] ch = moves.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char curr = ch[i];
            if (curr == 'U') {
                x++;
            } else if (curr == 'D') {
                x--;
            } else if (curr == 'L') {
                y++;
            } else if (curr == 'R') {
                y--;
            }
        }
        return x == 0 && y == 0;
    }
}
