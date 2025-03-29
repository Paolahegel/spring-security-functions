package dio.spring_security.repository;

import dio.spring_security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


// Repositório é responsável por interagir com nossa entidade e realizar as operações CRUD
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT e FROM User e JOIN FETCH e.roles WHERE e.username= (:username)")
    User findByUsername(@Param("username") String username);
}
