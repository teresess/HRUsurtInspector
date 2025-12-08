package upd.dev.usurtprojecthr.logistic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upd.dev.usurtprojecthr.logistic.model.User;

public interface UserRepository extends JpaRepository<User, Long> {}
