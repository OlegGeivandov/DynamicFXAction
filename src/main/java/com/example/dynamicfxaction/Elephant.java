package com.example.dynamicfxaction;

public class Elephant {
    String name;

    public Elephant(String name) {
        this.name = name;
    }


    public void say(){
        System.out.println("я слон, меня зовут "+name);
    }

    @Override
    public String toString() {
        return "Elephant{" +
                "name='" + name + '\'' +
                '}';
    }
}
