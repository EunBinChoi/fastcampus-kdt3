package me.day07.relation.isa;

public class SportCar extends Car {
    // 부모한테서 상속받은 필드
    // String ID;
    // String modelName;
    // String company;
    // int speed;

    // 컴파일러가 부모 객체 super 생성
    // 눈으로는 안보이지만 내부적으로 super 존재함
    // Car super = new Car();가 살고 있음
    int turbo;

    public SportCar() {
        //super();
    }

    public SportCar(int turbo) {
        //super();
        this.turbo = turbo;
    }

    public SportCar(String ID, String modelName, String company, int speed, int turbo) {
        super(ID, modelName, company, speed);
        this.turbo = turbo;
    }

    // 부모한테서 상속받은 메소드
    // public String getID() { return ID; }
    // public String getModelName() { return modelName; }
    // public String getCompany() { return company; }
    // public int getSpeed() { return speed; }

    // public void setID(String ID) { this.ID = ID; }
    // public void setModelName(String modelName) { this.modelName = modelName; }
    // public void setCompany(String company) { this.company = company; }
    // public void setSpeed(int speed) { this.speed = speed; }

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