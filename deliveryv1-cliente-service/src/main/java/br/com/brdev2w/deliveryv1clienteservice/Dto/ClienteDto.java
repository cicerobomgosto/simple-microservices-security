package br.com.brdev2w.deliveryv1clienteservice.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {

    private String firstName;
    private String lastName;
    private String fpassword;
    private String cpf;
    private String email;
}
