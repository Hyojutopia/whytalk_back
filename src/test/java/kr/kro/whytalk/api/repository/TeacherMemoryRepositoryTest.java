package kr.kro.whytalk.api.repository;

import kr.kro.whytalk.api.domain.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeacherMemoryRepositoryTest {
    TeacherMemoryRepository teacherMemoryRepository = new TeacherMemoryRepository();

    @Test
    void findByIdOrNull() {

        Teacher teacher = new Teacher();
        teacher.setEmail("what@test.com");
        teacher.setName("foo");
        teacher.setPassword("bar");

        Teacher result = teacherMemoryRepository.save(teacher);

        Teacher found = teacherMemoryRepository.findByIdOrNull(result.getId());
        assertSame(result, found);
    }

    @Test
    void findByEmailOrNull() {
    }

    @Test
    void save() {
    }
}