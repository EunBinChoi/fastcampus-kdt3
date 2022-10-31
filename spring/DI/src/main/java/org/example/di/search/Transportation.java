package org.example.di.search;

import org.springframework.stereotype.Component;

@Component
public class Transportation {
    private Long no;
    private String type;
    private String company;

    public Transportation() {
    }

    public Transportation(Long no, String type, String company) {
        this.no = no;
        this.type = type;
        this.company = company;
    }

    public void move() {
        System.out.println("move()");
    }

    @Override
    public String toString() {
        return "Transportation{" +
                "no=" + no +
                ", type='" + type + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
