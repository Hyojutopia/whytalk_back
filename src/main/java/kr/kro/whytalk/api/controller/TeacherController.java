package kr.kro.whytalk.api.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import kr.kro.whytalk.api.domain.Teacher;
import kr.kro.whytalk.api.dto.TeacherDto;
import kr.kro.whytalk.api.repository.TeacherMemoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class TeacherController {
    private final TeacherMemoryRepository teacherMemoryRepository;

    public TeacherController(TeacherMemoryRepository teacherMemoryRepository) {
        this.teacherMemoryRepository = teacherMemoryRepository;
    }

    @PostMapping("/teacher")
    public ResponseEntity<String> postTeacher(@Valid @RequestBody TeacherDto dto) {
        if (isAlreadyUsedEmail(dto.getEmail())) {
            return new ResponseEntity<>("이미 사용중인 이메일입니다.", HttpStatus.BAD_REQUEST);
        }

        Teacher teacher = new Teacher();
        teacher.setEmail(dto.getEmail());
        teacher.setPassword(dto.getPassword());
        teacher.setName(dto.getName());

        teacherMemoryRepository.save(teacher);

        return new ResponseEntity<>("성공적으로 회원가입 되었습니다", HttpStatus.CREATED);
    }

    @GetMapping("/teacher/{id}")
    public ResponseEntity<Teacher> getTeacher(long id, @RequestParam String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("123");
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("whytalk")
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            Long claim = jwt.getClaim("teacherId").asLong();
            if (id != claim) {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } catch (JWTVerificationException exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Teacher result = teacherMemoryRepository.findByIdOrNull(id);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    private boolean isAlreadyUsedEmail(String email) {
        return teacherMemoryRepository.findByEmailOrNull(email) != null;
    }
}