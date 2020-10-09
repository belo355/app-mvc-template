package br.com.templatex.appmvctemplate.Repository;

import br.com.templatex.appmvctemplate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  UserRepository extends JpaRepository<User, Long> {

}
