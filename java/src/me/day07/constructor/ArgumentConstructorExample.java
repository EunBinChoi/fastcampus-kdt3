package me.day07.constructor;

public class ArgumentConstructorExample {
    private int intVariable;
    private String strVariable;

    // this 의미는 main 함수에서 예를 들어
    // ArgumentConstructorExample argumentConstructorExample = new ArgumentConstructorExample();
    // 라고 하면 argumentConstructorExample의 주소값이 저장되어있음
    public ArgumentConstructorExample(int intVariable) {
        this.intVariable = intVariable;
    }

    public ArgumentConstructorExample(String strVariable) {
        this.strVariable = strVariable;
    }

    public ArgumentConstructorExample(int intVariable, String strVariable) {
        this.intVariable = intVariable;
        this.strVariable = strVariable;
    }

    @Override
    public String toString() {
        return "ArgumentConstructorExample{" +
                "intVariable=" + intVariable +
                ", strVariable='" + strVariable + '\'' +
                '}';
    }
}