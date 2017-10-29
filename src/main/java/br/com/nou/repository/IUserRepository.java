package br.com.nou.repository;

import java.util.List;

import br.com.nou.entity.UserEntity;

public interface IUserRepository {
	
	List<UserEntity> obterUsuarios();
	
	boolean salvarUsuario(final UserEntity usuario);
	
	boolean deletarUsari(final String name);
	
	UserEntity editarUsuario(final UserEntity usuario);

	Boolean saveUser(final UserEntity entity);

	Boolean delete(final Long id);

	

	boolean alterUser(final UserEntity usuario);

	UserEntity getUser(final String name);

	UserEntity getUser(final Long id);

	UserEntity getUserByName(final UserEntity user);

	UserEntity getUserByNamePassword(final UserEntity user);

}
