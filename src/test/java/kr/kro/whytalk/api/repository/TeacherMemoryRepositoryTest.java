package kr.kro.whytalk.api.repository;

import kr.kro.whytalk.api.domain.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TeacherMemoryRepositoryTest {
    private final TeacherMemoryRepository teacherMemoryRepository = new TeacherMemoryRepository();

    @Test
    void findByIdOrNull_sameId_returnsSameEntity() {
        // given
        Teacher saved = teacherMemoryRepository.save(new Teacher());
        long id = saved.getId();

        // when
        Teacher found = teacherMemoryRepository.findByIdOrNull(id);

        // then
        assertEquals(saved, found);
    }

    @Test
    void findByIdOrNull_wrongId_returnsNull() {
        // given
        Teacher saved = teacherMemoryRepository.save(new Teacher());
        long id = saved.getId();

        // when
        Teacher found = teacherMemoryRepository.findByIdOrNull(id + 1);

        // then
        assertNull(found);
    }
}