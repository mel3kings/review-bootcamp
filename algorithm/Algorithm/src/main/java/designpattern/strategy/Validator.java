package designpattern.strategy;

/**
 * Note this is an implicit Functional interface even if you annotate with
 * @FunctionalInterface
 */
public interface Validator {

    public boolean validate(String s);
}
