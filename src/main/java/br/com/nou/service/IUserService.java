package br.com.nou.service;

import java.util.List;

import br.com.nou.entity.UserEntity;

public interface IUserService {

	List<UserEntity> obterUsuarios();
	
	boolean salvarUsuario(final UserEntity usuario);
	
	boolean deletarUsari(final String name);
	
	UserEntity editarUsuario(final UserEntity usuario);

	Boolean saveUser(final Long id,final String name, final String email, final String password, final Integer enabled);

	Boolean delete(final Long id);

	Boolean alterUser(final String name, final String email, final String password);

	UserEntity getUser(final String name);

}
