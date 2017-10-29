package br.com.nou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nou.entity.UserEntity;
import br.com.nou.repository.IUserRepository;
import br.com.nou.service.IUserService;

@Service("userService")
public class UserService implements IUserService{

	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public List<UserEntity> obterUsuarios() {
		return userRepository.obterUsuarios();
	}

	@Override
	public boolean salvarUsuario(final UserEntity usuario) {
		
		return userRepository.salvarUsuario(usuario);
	}


	@Override
	public boolean deletarUsari(String name) {
		return userRepository.deletarUsari(name);
	}

	@Override
	public UserEntity editarUsuario(final UserEntity usuario) {
		return userRepository.editarUsuario(usuario);
	}
	
	@Override
	public UserEntity getUser(final String name) {
		return userRepository.getUser(name);
	}

	@Override
	public Boolean saveUser(final Long id, final String name, final String email, final String password, final Integer enabled) {
		final UserEntity entity = new UserEntity();
		entity.setId(id);
		entity.setName(name);
		entity.setEmail(email);
		entity.setPassword(password);
		entity.setPerfil(1);
		entity.setEnabled(enabled);
		return userRepository.saveUser(entity);
	}
	
	@Override
	public Boolean alterUser(final String name, final String email, final String password) {
		final UserEntity entity = new UserEntity();
		entity.setName(name);
		entity.setEmail(email);
		entity.setPassword(password);
		entity.setPerfil(1);
		entity.setEnabled(1);
		return userRepository.alterUser(entity);
	}

	@Override
	public Boolean delete(final Long id) {
		return userRepository.delete(id);
	}

}
