package kr.kro.whytalk.api.controller;

import kr.kro.whytalk.api.domain.Response;
import kr.kro.whytalk.api.domain.Teacher;
import kr.kro.whytalk.api.service.TeacherService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/teacher")
    public Response postTeacher(@RequestBody Teacher teacher) {
        Teacher result = teacherService.signUpOrNull(teacher);

        if (result == null) {
            return new Response("Failed!!");
        } else {
            return new Response("Success!!");
        }
    }
}