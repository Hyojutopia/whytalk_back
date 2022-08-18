package kr.kro.whytalk.api.service;

import kr.kro.whytalk.api.domain.Teacher;
import kr.kro.whytalk.api.dto.TeacherDto;
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

    public Teacher signUp(TeacherDto dto) {
        Teacher teacher = new Teacher();
        teacher.setEmail(dto.getEmail());
        teacher.setPassword(dto.getPassword());
        teacher.setName(dto.getName());

        return teacherMemoryRepository.save(teacher);
    }

    public boolean isAlreadyUsedEmail(String email) {
        return teacherMemoryRepository.findByEmailOrNull(email) != null;
    }
}
