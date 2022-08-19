package kr.kro.whytalk.api.repository;

import kr.kro.whytalk.api.domain.Teacher;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TeacherMemoryRepository {
    private static final List<Teacher> teachers = new ArrayList<>();
    private static long nextId = 0;

    public Teacher findByIdOrNull(long id) {
        for (Teacher teacher : teachers) {
            if (teacher.getId() == id) {
                return teacher;
            }
        }

        return null;
    }

    public Teacher findByEmailOrNull(String email) {
        for (Teacher teacher : teachers) {
            if (teacher.getEmail().equals(email)) {
                return teacher;
            }
        }

        return null;
    }

    public Long getIdOrNull(String email, String password) {
        for (Teacher teacher : teachers) {
            if (teacher.getEmail().equals(email) && teacher.getPassword().equals(password)) {
                return teacher.getId();
            }
        }

        return null;
    }

    public Teacher save(Teacher teacher) {
        teacher.setId(nextId++);
        teachers.add(teacher);
        return teacher;
    }
}
