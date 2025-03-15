package example.healthrecord.service;

import example.healthrecord.dto.UserRequestDTO;
import example.healthrecord.dto.UserResponseDTO;
import example.healthrecord.entity.UserEntity;
import example.healthrecord.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Data
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    //클라이언트에서 요청한 DTO를 Entity로 바꾸는 것 .
    public UserEntity CreateUser(UserRequestDTO userrequestdto) {
        UserEntity user = new UserEntity();
        user.setUsername(userrequestdto.getUsername());
        user.setPassword(userrequestdto.getPassword());
        user.setUseremail(userrequestdto.getUseremail());
        userRepository.save(user);
        return user;
    }
}
