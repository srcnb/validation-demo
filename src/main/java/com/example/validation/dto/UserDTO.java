package com.example.validation.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserDTO {

    private long id;

    // name alanı boş geçilmemeli ve null olmamalıdır.
    // name alanı en az 2 karakterli olmalıdır.
    @NotEmpty
    @Size(min = 2, message = "İsim en az 2 karakterli olmalıdır.")
    private String name;

    // email formatına uygun olmalıdır.
    // email boş ya da null geçilmemelidir.
    @NotEmpty
    @Email
    private String email;

    // password alanı boş ya da null geçilmemeli
    // password en az 8 karakterli olmalıdır.
    @NotEmpty
    @Size(min = 8, message = "Şifreniz en az 8 karakterli olmalıdır.")
    private String password;

    public UserDTO() {

    }

    public UserDTO(String name, String email, String password) {
        super();
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
