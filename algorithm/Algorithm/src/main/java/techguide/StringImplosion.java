package techguide;

/**
 *
 Given a non-empty string like "Code" return a string like "CCoCodCode".

 stringSplosion("Code") → "CCoCodCode"
 stringSplosion("abc") → "aababc"
 stringSplosion("ab") → "aab"
 */
public class StringImplosion {

    public static void main(String[] args){
        stringImplosion("Code");
    }
    public static String stringImplosion(String word){
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i<= word.length(); i++){
            sb.append(word.substring(0, i));
        }
        return sb.toString();
    }
}
