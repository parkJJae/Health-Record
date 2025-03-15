package example.healthrecord.dto;

import example.healthrecord.entity.UserEntity;
import lombok.Data;

//UserResponseDTO는 서버가 사용자에게 응답하는 DTO이므로 비밀번호가 있으면 안 됨
// 서버가 사용자에게 보내는 응답DTO이므로 Entity였던 것을 Dto로 저장하는 과정이다.
// 그러므로 엔티티로 바꾸는 ResponseDTO
@Data
public class UserResponseDTO {

    private Long userid;
    private String username;
    private String message;

    public UserResponseDTO(UserEntity userentity){
        this.userid = userentity.getId();
        this.username = userentity.getUsername();
        this.message = "회원가입 성공!";
    }



}
