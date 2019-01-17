package designpattern.template;

public class TemplateMain {

    public static void main(String[] args){
        new LocalBanking().doBanking(1234);
        new LocalBanking().doBanking(1234, (c)-> System.out.println("Dynamic invokation"));
    }
}
