package br.com.brdev2w.deliveryv1clienteservice.service.auth;


import br.com.brdev2w.deliveryv1clienteservice.Entities.ClienteEntity;
import br.com.brdev2w.deliveryv1clienteservice.Repositories.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserService userService;
	@Autowired
  	ClienteRepository clienteRepository;
	@Autowired
  	ModelMapper modelMapper;

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
	  ClienteEntity clienteEntity = clienteRepository.findByUsername(s.toLowerCase());

		if(clienteEntity == null)
			throw new UsernameNotFoundException("User Not Found");
		var a = modelMapper.map(clienteEntity, NewUserDto.class);
		return MyUserDetails.build(a);
	}

//	@Override
//	@Transactional
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = use
//		if(user == null)
//			throw new UsernameNotFoundException("User Not Found");
//
//		return MyUserDetails.build(user);
//	}

}