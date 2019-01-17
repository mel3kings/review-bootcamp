package designpattern.strategy;

public class ValidStrategy {
    private final Validator validator;

    public ValidStrategy(Validator validator) {
        this.validator = validator;
    }

    public boolean validate(String s) {
        return validator.validate(s);
    }
}
