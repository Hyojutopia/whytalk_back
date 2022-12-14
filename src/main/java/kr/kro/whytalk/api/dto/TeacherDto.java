package kr.kro.whytalk.api.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class TeacherDto {
    @Email
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String name;

    public TeacherDto(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TeacherDto{");
        sb.append("email='").append(email).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
