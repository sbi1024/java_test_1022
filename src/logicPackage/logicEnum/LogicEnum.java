package logicPackage.logicEnum;

public enum LogicEnum {
    TEST1(10){
        @Override
        public void logicMethod(){
            System.out.println("Test1 logicMethod");
        }
    } , TEST2(20) {
        @Override
        public void logicMethod(){
            System.out.println("Test2 logicMethod");
        }
    } , TEST3(30) {
        @Override
        public void logicMethod(){
            System.out.println("Test3 logicMethod");
        }
    } ;

    private int i ;

    public int getI() {
        return i;
    }
    private LogicEnum(int i) {
        this.i = i ;
    }

    public abstract void logicMethod();
}
