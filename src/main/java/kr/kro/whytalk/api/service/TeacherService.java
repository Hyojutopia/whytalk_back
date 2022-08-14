package kr.kro.whytalk.api.service;

import kr.kro.whytalk.api.domain.Teacher;
import kr.kro.whytalk.api.repository.TeacherRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public void signUp(Teacher teacher) {
        teacherRepository.save(teacher);
    }
}
