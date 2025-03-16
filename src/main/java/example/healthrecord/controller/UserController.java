package example.healthrecord.controller;

import example.healthrecord.dto.UserRequestDTO;
import example.healthrecord.dto.UserResponseDTO;
import example.healthrecord.entity.UserEntity;
import example.healthrecord.exception.DuplecateEmailException;
import example.healthrecord.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @PostMapping("/register")
    // ResponseEntity<T> -> T: 응답 본문(body)에 포함될 데이터 타입
    // Header, status ( 상태 )
    public ResponseEntity<?> register(@RequestBody UserRequestDTO userRequestDTO) {
        try{
            UserEntity user = userService.CreateUser(userRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(new UserResponseDTO(user));
        } catch (DuplecateEmailException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("이미 가입된 이메일입니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버 오류가 발생했습니다.");
        }

    }
}
