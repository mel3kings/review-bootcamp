package designpattern.strategy;

public class LengthValidator implements Validator {

    private final int MAX_LENGTH = 10;

    @Override
    public boolean validate(String s) {
        return s.length() > MAX_LENGTH;
    }
}
