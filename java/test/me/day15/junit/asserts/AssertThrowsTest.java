package me.day15.junit.asserts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CustomException extends Exception{
    public CustomException(String message) {
        super(message);
    }
}

class CustomClass {

    private int customInt;

    public CustomClass(int customInt) throws CustomException {
        if(customInt < 0){
            throw new CustomException("CustomException!!!");
        }
        this.customInt = customInt;
    }

}

public class AssertThrowsTest {
    @Test
    void test() {
        CustomException exception = assertThrows(CustomException.class, ()-> new CustomClass(-1));
        String message = exception.getMessage();
        assertEquals("CustomException!!!", message);
    }
}
