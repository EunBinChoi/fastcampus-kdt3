package me.day12.exception.close.autocloseable;

public class AutoCloseableExample {
    public static void main(String[] args) {
        try (MyFileInputStream myResource = new MyFileInputStream()){
            myResource.read();
            throw new Exception(); // 강제적으로 예외 발생시킴
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
