package example.healthrecord.controller;

import example.healthrecord.dto.UserRequestDTO;
import example.healthrecord.dto.UserResponseDTO;
import example.healthrecord.entity.UserEntity;
import example.healthrecord.service.UserService;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<UserResponseDTO> register(@RequestBody UserRequestDTO userRequestDTO) {
        UserEntity user = userService.CreateUser(userRequestDTO);
        return ResponseEntity.ok(new UserResponseDTO(user));
    }
}
