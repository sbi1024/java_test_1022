package logicPackage.logicInterface;

public interface LogicInterface {
    public static void test1(){
        System.out.println("true = " + true);
    }

    default void test2(){
        System.out.println("true = " + true);
    }
}
