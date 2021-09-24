package br.com.brdev2w.authenticationservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {

    private String firstName;
    private String lastName;
    private String fpassword;
    private String cpf;
    private String email;
    //private List<RoleDto> roles;
}
