package designpattern.strategy;

public class StrategyMain {


    public static void main(String[] args) {
        String longString = "123412341234";
        ValidStrategy vs = new ValidStrategy((s) -> s.length() > 10);
        System.out.println(vs.validate(longString));

        ValidStrategy vs2 = new ValidStrategy(new LengthValidator());
        System.out.println(vs2.validate(longString));

    }
}