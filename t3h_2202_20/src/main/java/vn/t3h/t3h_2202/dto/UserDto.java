package vn.t3h.t3h_2202.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.t3h.t3h_2202.entity.UserEntity;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String userName;
    private String password;
    private String fullName;
    private String rePassword;
    private String email;
    private String phone;
    private Integer gender;
    private Integer status;
    private String role;

    List<String> address;

    public UserEntity conVertEntity(){
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(email);
        userEntity.setId(id);
        userEntity.setFullName(fullName);
        userEntity.setGender(gender);
        userEntity.setPhone(phone);
        userEntity.setUserName(userName);
        userEntity.setRole(role);
        userEntity.setPassword(password);
        return userEntity;
    }
}
