package kr.kro.whytalk.api.controller;

import kr.kro.whytalk.api.dto.TeacherDto;
import kr.kro.whytalk.api.repository.TeacherMemoryRepository;
import kr.kro.whytalk.api.service.TeacherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.*;

class TeacherControllerTest {
    private TeacherMemoryRepository teacherMemoryRepository;
    private TeacherService teacherService;
    private TeacherController teacherController;

    @BeforeEach
    void beforeEach() {
        teacherMemoryRepository = new TeacherMemoryRepository();
        teacherService = new TeacherService(teacherMemoryRepository);
        teacherController = new TeacherController(teacherService);
    }

    @Test
    void postTeacher_usedEmail_fail() {
        // given
        final String duplicatedEmail = "foo@bar.baz";
        TeacherDto first = new TeacherDto(duplicatedEmail, "123", "spring");
        TeacherDto second = new TeacherDto(duplicatedEmail, "456", "boot");

        // when
        ResponseEntity<String> firstResponse = teacherController.postTeacher(first);
        ResponseEntity<String> secondResponse = teacherController.postTeacher(second);

        // then
        assertThat(firstResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(secondResponse.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
}