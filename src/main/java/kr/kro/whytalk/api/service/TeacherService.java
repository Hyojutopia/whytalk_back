package kr.kro.whytalk.api.service;

import kr.kro.whytalk.api.domain.Teacher;
import kr.kro.whytalk.api.repository.TeacherMemoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TeacherService {
    private final TeacherMemoryRepository teacherMemoryRepository;

    public TeacherService(TeacherMemoryRepository teacherMemoryRepository) {
        this.teacherMemoryRepository = teacherMemoryRepository;
    }

    public Teacher signUpOrNull(Teacher teacher) {
        if (isAlreadyUsedEmail(teacher.getEmail())) {
            return null;
        }

        return teacherMemoryRepository.save(teacher);
    }

    public boolean isAlreadyUsedEmail(String email) {
        return teacherMemoryRepository.findByEmailOrNull(email) != null;
    }
}
