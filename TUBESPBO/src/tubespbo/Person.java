/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo;

/**
 *
 * @author Haikal
 */
// Abstract class Person
public abstract class Person {
    protected String name;
    protected String address;
    protected int age;

    // Constructor
    public Person(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    // Abstract method
    public abstract void displayInfo();

    // Getter dan setter untuk name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter dan setter untuk address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Getter dan setter untuk age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}



