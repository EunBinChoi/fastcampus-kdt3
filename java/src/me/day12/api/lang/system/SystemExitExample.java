package me.day12.api.lang.system;

public class SystemExitExample {
    public static void main(String[] args) {
        // 종료 상태값이 5일 경우 프로세스 종료
        System.setSecurityManager(new SecurityManager(){
            @Override
            public void checkExit(int status) {
                if (status != 5) {
                    throw new SecurityException("SecurityException");
                }
            }
        });

        for (int i = 0; i < 10; i++) {
            System.out.println("i = " + i);
            try {
                System.exit(i);
            } catch (SecurityException e) {
                System.out.println("e.getMessage() = " + e.getMessage());
            }
        }
    }
}
