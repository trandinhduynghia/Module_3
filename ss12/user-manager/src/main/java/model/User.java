package model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class User {
    protected int id;
    protected String name;
    protected String email;
    protected String country;

    public User(){

    }

    public User(String name, String email, String country){
        super();
        this.name = name;
        this.email = email;
        this.country = country;
    }

    public User(int id, String name, String email, String country){
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotEmpty(message = "Tên không được để trống")
    @Length(min = 3, max = 10, message = "Tên dài từ 3 - 10")
    //@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})", message = "Format password not right") mat khau
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotEmpty(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotEmpty(message = "Địa chỉ không được để trống")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

