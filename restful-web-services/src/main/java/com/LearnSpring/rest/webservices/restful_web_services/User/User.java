package com.LearnSpring.rest.webservices.restful_web_services.User;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "user_details")
public class User {

    protected User() {

    }

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min=2, message = "Name Should Have Atleast 2 Characters") // Adding Validations
    //@JsonProperty("user_name") // This will help the api output to have the given string value for that name
    private String name;

    @Past(message = "Birthday should be past")// Validations as part of Jakarta Validation Constraints
    //@JsonProperty("birth_date")
    private LocalDate birthdate;


    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Post> posts;



    public User(Integer id, String name, LocalDate birthdate) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
