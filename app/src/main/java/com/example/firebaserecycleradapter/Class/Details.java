package com.example.firebaserecycleradapter.Class;

public class Details {

   private String Name;
    private String Age;
    private String LastName;
    private String Post;

    public Details() {
    }

    public Details(String name, String age, String lastName, String post) {
        Name = name;
        Age = age;
        LastName = lastName;
        Post = post;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPost() {
        return Post;
    }

    public void setPost(String post) {
        Post = post;
    }
}
