package me.day09.inheritance.use.solution;

public class SportCar extends Car {
    // 부모한테서 상속받은 필드
//    protected String ID; // auto-generated
//    protected String modelName;
//    protected int speed;
//    protected static final String COMPANY = "TESLA";
//    protected static int numOfCar = 0;


    // 컴파일러가 부모 객체 super 생성
    // 눈으로는 안보이지만 내부적으로 super 존재함
    // Car super = new Car();가 살고 있음
    private int turbo;
    private static int numOfSportCar = 0;
    static final String COMPANY = "TESLA-SPORT";

    public SportCar() {
        //super();
        numOfSportCar++;
        ID = String.format("%04d", numOfSportCar);
    }

    public SportCar(int turbo) {
        //super();
        this.ID = String.format("%04d", numOfSportCar);
        this.turbo = turbo;
        numOfSportCar++;
    }

    public SportCar(String modelName, int speed, int turbo) {
        super(modelName, speed);
        this.ID = String.format("%04d", numOfSportCar);
        this.turbo = turbo;
    }

    public int getTurbo() {
        return turbo;
    }

    public void setTurbo(int turbo) {
        this.turbo = turbo;
    }

    @Override
    public String toString() {
        return "SportCar{" + super.toString() + ", " + // 부모 객체 호출
                "turbo=" + turbo +
                '}';
    }
}