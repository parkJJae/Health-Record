package example.healthrecord.service;

import example.healthrecord.JwtUtil;
import example.healthrecord.dto.UserRequestDTO;
import example.healthrecord.dto.UserResponseDTO;
import example.healthrecord.entity.UserEntity;
import example.healthrecord.exception.DuplecateEmailException;
import example.healthrecord.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Data
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtutil;

    //클라이언트에서 요청한 DTO를 Entity로 바꾸는 것 .
    public UserEntity CreateUser(UserRequestDTO userrequestdto) {
        if(userRepository.existsByUserEmail(userrequestdto.getUseremail())){
            throw new DuplecateEmailException("이미 가입된 이메일입니다.");
        }
        UserEntity user = new UserEntity();
        user.setUsername(userrequestdto.getUsername());
        user.setPassword(userrequestdto.getPassword());
        user.setUseremail(userrequestdto.getUseremail());
        userRepository.save(user);
        return user;
    }
}
