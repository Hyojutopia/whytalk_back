package kr.kro.whytalk.api.repository;

import kr.kro.whytalk.api.domain.Teacher;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class TeacherRepository {
    private final EntityManager entityManager;

    public TeacherRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Teacher save(Teacher teacher) {
        entityManager.persist(teacher);
        return teacher;
    }
}
