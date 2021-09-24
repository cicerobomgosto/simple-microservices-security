package br.com.brdev2w.deliveryv1clienteservice.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "user_default")
public class UserDefault {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column( length = 30 )
    @NotNull @NotBlank
    private String encryptedPassword;

    @Column( length = 50 )
    @NotNull @NotBlank
    private String username;

    @OneToMany( mappedBy = "listAuthority" )
    private Set<Authority> authorities;

    @OneToOne
    @JoinColumn( name = "cliente_id", referencedColumnName = "id" )
    private ClienteEntity defaultUser;

    @CreationTimestamp
    @Column( updatable = false )
    private Timestamp createDate;

    @UpdateTimestamp
    private Timestamp lastModifiedDate;
}
