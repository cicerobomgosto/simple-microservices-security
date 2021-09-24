package br.com.brdev2w.deliveryv1clienteservice.Entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "user_default")
public class Authority extends BaseEntity{

    @Column( length = 10 )
    @NotBlank @NotNull
    private String name;

    @Column( length = 30 )
    private String description;

    @Column
    private String role;

    @ManyToOne
    @JoinColumn( name = "userdefault_id", referencedColumnName = "id")
    private UserDefault listAuthority;
}
