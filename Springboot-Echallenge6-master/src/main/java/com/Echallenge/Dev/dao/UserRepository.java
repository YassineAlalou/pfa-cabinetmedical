package com.Echallenge.Dev.dao;


        import com.Echallenge.Dev.classe.User;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.rest.core.annotation.RepositoryRestResource;
        import java.io.Serializable;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User,Long>, Serializable {
        public User findByLogin(String login);
}
