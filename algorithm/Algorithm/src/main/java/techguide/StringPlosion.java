package techguide;

public class StringPlosion {

    /**
     * stringSplosion("Code") → "CCoCodCode"
     * stringSplosion("abc") → "aababc"
     * stringSplosion("ab") → "aab"
     * @param str
     * @return
     */
    public String stringSplosion(String str) {
        String imploded = "";

        for(int i = 0; i <= str.length(); i++){
            imploded += str.substring(0, i);
        }
        return imploded;
    }

}
