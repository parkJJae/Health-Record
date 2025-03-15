package example.healthrecord.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class UserRequestDTO {

    @NotBlank(message = "이름을 입력하세요")
    private String username;

    @Email(message = "이메일 형식이 아닙니다.")
    private String useremail;

    @NotBlank(message = "비밀번호를 입력하세요.")
    @Size(min = 6, max = 20, message = "비밀번호는 최소 6자리 이상 입력해주세요.")
    private String password;
}
