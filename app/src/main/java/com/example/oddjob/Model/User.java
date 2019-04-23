package com.example.oddjob.Model;

import android.location.Address;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Node;

import java.util.HashMap;

public class User {
    private String firstName;
    private String lastName;
    private String Phone;
    private String Email;
    private String Address;
    private String AddressLn2;
    private String Postal;
    private String Type;
    private String School;
    private String Neighbourhood;
    private String Grade;
    private String addressJob;
    private String Age;
    private String Bio;
    private String Job;

    public User() {}
    public User(DatabaseReference ref){
        Age = ref.child("Age").toString();
    }


    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPhone() {
        return Phone;
    }
    public void setPhone(String phone) {
        Phone = phone;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;

    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public String getAddressLn2() {
        return AddressLn2;
    }
    public void setAddressLn2(String addressLn2) {
        AddressLn2 = addressLn2;
    }
    public String getPostal() {
        return Postal;
    }
    public void setPostal(String postal) {
        Postal = postal;
    }
    public String getType() {
        return Type;
    }
    public void setType(String type) {
        Type = type;
    }
    public String getSchool() {
        return School;
    }
    public void setSchool(String school) {
        School = school;
    }
    public String getNeighbourhood() {
        return Neighbourhood;
    }
    public void setNeighbourhood(String neighbourhood) {
        Neighbourhood = neighbourhood;
    }
    public String getGrade() {
        return Grade;
    }
    public void setGrade(String grade) {
        Grade = grade;
    }
    public String getJob() {
        return Job;
    }
    public void setJob(String job) {
        Job = job;
    }
    public String getAge() {
        return Age;
    }
    public void setAge(String age) {
        Age = age;
    }
    public String getBio() {
        return Bio;
    }
    public void setBio(String bio) {
        Bio = bio;
    }
}
