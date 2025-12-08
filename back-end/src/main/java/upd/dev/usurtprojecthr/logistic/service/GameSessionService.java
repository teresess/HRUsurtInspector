package upd.dev.usurtprojecthr.logistic.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import upd.dev.usurtprojecthr.logistic.GameMode;
import upd.dev.usurtprojecthr.logistic.controllers.Controller;
import upd.dev.usurtprojecthr.logistic.model.Document;
import upd.dev.usurtprojecthr.logistic.model.GameSession;
import upd.dev.usurtprojecthr.logistic.model.User;
import upd.dev.usurtprojecthr.logistic.repository.GameSessionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameSessionService {
    public GameSessionRepository gameSessionRepository;

    public GameSessionService(GameSessionRepository gameSessionRepository) {
        this.gameSessionRepository = gameSessionRepository;
    }

    private static final Integer COINS_MULTIPLY = 2;
    private static final Integer EXP_MULTIPLY = 10;

    @Transactional
    public void saveGameSession(User user,
                                GameMode gameMode,
                                Integer score,
                                Integer accuracy,
                                Integer errorsFound,
                                Integer durationSeconds,
                                List<Document> documents,
                                String sessionDetails) {

        GameSession gameSession = new GameSession();
        gameSession.setPlayerId(user.getId());
        gameSession.setGameMode(gameMode);
        gameSession.setScore(score);
        gameSession.setAccuracy(accuracy);
        gameSession.setErrorsFound(errorsFound);
        gameSession.setDurationSeconds(durationSeconds);
        gameSession.setSessionDetails(sessionDetails);

        if (documents != null) {
            gameSession.setDocuments(documents);
        }

        GameSession savedSession = gameSessionRepository.save(gameSession);

        user.addGameSessionId(savedSession.getId());
        user.setCoins(user.getCoins() + gameSession.getScore() * COINS_MULTIPLY);
        user.setExp(user.getExp() + gameSession.getScore() * EXP_MULTIPLY);
        Controller.get().user().save(user);
    }

    public GameSession getGame(Long id) {
        return gameSessionRepository.findById(id).get();
    }
    public  List<GameSession> getGames(Long id) {
        List<GameSession> games = new ArrayList<>();
        List<Long> ids = Controller.get().user().getUser(id).getGameSessionIds();

        for (Long gameId : ids) {
            games.add(getGame(gameId));
        }

        return games;
    }

    public List<GameSession> getAll() {
        return gameSessionRepository.findAll();
    }
}
