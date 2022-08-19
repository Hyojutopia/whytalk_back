package kr.kro.whytalk.api.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class TeacherLoginDto {
    @Email
    private final String email;

    @NotBlank
    private final String password;

    public TeacherLoginDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TeacherLoginDto{");
        sb.append("email='").append(email).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
