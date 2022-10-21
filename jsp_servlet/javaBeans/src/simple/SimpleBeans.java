package simple;

import java.io.Serializable;

public class SimpleBeans implements Serializable {
    private static final long serialVersionUID = -2277779669394301690L;
    // Serializable class without 'serialVersionUID' ON! 시키기

    private String name;
    private String value;
    private String keyword;

    // 액션태그로 자바 빈즈를 사용하기 위함
    // 무조건 선언되어야 함 (**)
    public SimpleBeans() {
    }

    public SimpleBeans(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String toString() {
        return "SimpleBeans{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
