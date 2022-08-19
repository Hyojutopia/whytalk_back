package kr.kro.whytalk.api.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import kr.kro.whytalk.api.dto.TeacherLoginDto;
import kr.kro.whytalk.api.repository.TeacherMemoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {
    // TODO: inject secret key from config file with environment variable
    private static final String SECRET_KEY = "123";
    private static final String ISSUER = "whytalk";
    private static final Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);

    private final TeacherMemoryRepository teacherMemoryRepository;

    public AuthController(TeacherMemoryRepository teacherMemoryRepository) {
        this.teacherMemoryRepository = teacherMemoryRepository;
    }

    @GetMapping("/token")
    public ResponseEntity<String> getToken(@Valid @RequestBody TeacherLoginDto dto) {
        Long id = teacherMemoryRepository.getIdOrNull(dto.getEmail(), dto.getPassword());
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        String token = JWT.create()
                .withIssuer(ISSUER)
                .withClaim("teacherId", id)
                .sign(algorithm);

        return new ResponseEntity<>(token, HttpStatus.OK);
    }
}