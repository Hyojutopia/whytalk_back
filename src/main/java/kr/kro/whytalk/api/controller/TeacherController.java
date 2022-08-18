package kr.kro.whytalk.api.controller;

import kr.kro.whytalk.api.domain.Teacher;
import kr.kro.whytalk.api.dto.TeacherDto;
import kr.kro.whytalk.api.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/teacher")
    public ResponseEntity<String> postTeacher(@Valid @RequestBody TeacherDto dto) {
        System.out.println(dto);
        if (teacherService.isAlreadyUsedEmail(dto.getEmail())) {
            return new ResponseEntity<>("이미 사용중인 이메일입니다.", HttpStatus.BAD_REQUEST);
        }

        teacherService.signUp(dto);
        return new ResponseEntity<>("성공적으로 회원가입 되었습니다", HttpStatus.OK);
    }
}