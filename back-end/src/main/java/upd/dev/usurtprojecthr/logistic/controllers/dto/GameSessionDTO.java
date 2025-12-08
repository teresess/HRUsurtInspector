//package upd.dev.usurtprojecthr.logistic.controllers.dto;
//
//import lombok.Data;
//import upd.dev.usurtprojecthr.logistic.GameMode;
//import upd.dev.usurtprojecthr.logistic.model.Document;
//import upd.dev.usurtprojecthr.logistic.model.GameSession;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//@Data
//public class GameSessionDTO {
//    private Long id;
//    private Integer score;
//    private Integer accuracy;
//    private Integer errorsFound;
//    private Integer durationSeconds;
//    private List<DocumentDTO> documents = new ArrayList<>();
//    private GameMode gameMode;
//    private LocalDateTime completedAt;
//    private String sessionDetails;
//
//    public GameSessionDTO(GameSession gameSession) {
//        this.id = gameSession.getId();
//        this.score = gameSession.getScore();
//        this.accuracy = gameSession.getAccuracy();
//        this.errorsFound = gameSession.getErrorsFound();
//        this.durationSeconds = gameSession.getDurationSeconds();
//
//        for (Document document : gameSession.getDocuments())
//            documents.add(new DocumentDTO(document));
//        this.documents = getDocuments();
//        this.gameMode = gameSession.getGameMode();
//        this.completedAt = gameSession.getCompletedAt();
//        this.sessionDetails = gameSession.getSessionDetails();
//    }
//}
