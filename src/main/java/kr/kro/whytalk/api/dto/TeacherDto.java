package kr.kro.whytalk.api.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class TeacherDto {
    @Email(message = "유효한 이메일 주소여야 합니다")
    private String email;

    @NotNull(message = "비밀번호는 필수 항목입니다")
    private String password;

    @NotNull(message = "이름은 필수 항목입니다")
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
