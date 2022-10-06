package me.day12.exception.close.autocloseable;

public class MyFileInputStream implements AutoCloseable {

    public MyFileInputStream() {
    }

    public void read() {
        System.out.println("MyResource Read ...");
    }

    // 구체적인 Exception을 throw 하고 close() 동작이 절대 실패할리가 없을 때에는 Exception을 던지지 않도록 구현하는 것을 권고함
    // close() 메소드에서 InterruptedException 던지지 않는 것을 강하게 권고함
    // InterruptedException은 스레드의 인터럽트 상태이므로 InterruptedException을 던지면 런타임에서 잘못된 동작이 발생할 수 있음
    @Override
    public void close() throws Exception {
        System.out.println("MyResource Closed!");
    }
}
