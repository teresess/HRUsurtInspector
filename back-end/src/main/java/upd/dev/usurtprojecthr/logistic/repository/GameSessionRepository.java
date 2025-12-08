package upd.dev.usurtprojecthr.logistic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upd.dev.usurtprojecthr.logistic.model.GameSession;

public interface GameSessionRepository extends JpaRepository<GameSession, Long> {
}
