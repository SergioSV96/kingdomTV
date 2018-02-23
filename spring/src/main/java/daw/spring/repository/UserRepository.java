package daw.spring.repository;

import daw.spring.entities.TypeUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<TypeUser,Long>
{
        TypeUser findByName(String name);
}
