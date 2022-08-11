package kr.kro.whytalk.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {
    @PostMapping("/teacher")
    public TempResponse postTeacher(@RequestBody TempRequset request) {
        return new TempResponse("Success");
    }
}


// TODO: 임시 객체, 이후 구현시 삭제할것
class TempResponse {
    private final String message;

    public TempResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}


// TODO: 임시 객체, 이후 구현시 삭제할것
class TempRequset {
    public String username;
    public String password;
}