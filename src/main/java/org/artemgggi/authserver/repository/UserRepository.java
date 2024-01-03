package org.artemgggi.authserver.repository;

import org.artemgggi.authserver.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Long> {

    Users findByUsername(String username);
}
