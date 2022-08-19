package kr.kro.whytalk.api.controller;

import kr.kro.whytalk.api.dto.TeacherDto;
import kr.kro.whytalk.api.repository.TeacherMemoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TeacherControllerTest {
    private TeacherMemoryRepository teacherMemoryRepository;
    private TeacherController teacherController;

    @BeforeEach
    void beforeEach() {
        teacherMemoryRepository = new TeacherMemoryRepository();
        teacherController = new TeacherController(teacherMemoryRepository);
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
        assertEquals(firstResponse.getStatusCode(), HttpStatus.OK);
        assertEquals(secondResponse.getStatusCode(), HttpStatus.BAD_REQUEST);
    }
}