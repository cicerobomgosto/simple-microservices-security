package br.com.brdev2w.deliveryv1clienteservice.service.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
public class NewUserDto {

  private Long id;
  private String username;
  private Collection<? extends GrantedAuthority> roles;

  @JsonIgnore
  private String password;

  public NewUserDto() {
  }

  public NewUserDto(Long id, String username, Collection<? extends GrantedAuthority> roles, String password) {
	this.id = id;
	this.username = username;
	this.roles = roles;
	this.password = password;
  }


  public Collection<? extends GrantedAuthority> getRoles() {
	return roles;
  }

  public void setRoles(Collection<? extends GrantedAuthority> roles) {
	this.roles = roles;
  }


}
