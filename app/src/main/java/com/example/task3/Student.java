package com.example.task3;

public class Student {
    private int placeInList;
    private int id;
    private String name;
    private String phone_number;
    private String address;
    boolean flag = true;
    //private String imageURL;


    public Student(int placeInList, int id, String name, String phone_number, String address, boolean flag) {
        this.placeInList = placeInList;
        this.id = id;
        this.name = name;
        this.phone_number = phone_number;
        this.address = address;
        this.flag = flag;
    }


    @Override
    public String toString() {
        return "Student{" +
                "placeInList=" + placeInList +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", address='" + address + '\'' +
                ", flag=" + flag +
                '}';
    }

    public int getPlaceInList() {
        return placeInList;
    }

    public void setPlaceInList(int placeInList) {
        this.placeInList = placeInList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }


}
