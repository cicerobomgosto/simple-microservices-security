package br.com.brdev2w.deliveryv1clienteservice.Entities;

import br.com.brdev2w.deliveryv1clienteservice.utils.UUIDGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "clienteregister")
public class ClienteEntity extends BaseEntity{

    @Column( length = 36 )
//    @NotNull
//    @NotBlank
    private String userId = new UUIDGenerator().UUIDGen();

    @Column( length = 30 )
//    @NotNull @NotBlank
    private String firstName;

    @Column( length = 30 )
//    @NotNull @NotBlank
    private String lastName;

    @Column
    private String username;

    @Column( length = 30 )
//    @NotNull @NotBlank
    private String fpassword;

    @Column
    private String email;

//    @CPF
//    @NotNull @NotBlank
    @Column( length = 11 )
    private String cpf;

}
