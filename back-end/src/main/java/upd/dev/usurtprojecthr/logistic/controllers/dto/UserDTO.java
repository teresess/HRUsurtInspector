//package upd.dev.usurtprojecthr.logistic.controllers.dto;
//
//import lombok.Data;
//import org.telegram.telegrambots.meta.api.objects.games.Game;
//import upd.dev.usurtprojecthr.logistic.PlayerRank;
//import upd.dev.usurtprojecthr.logistic.Role;
//import upd.dev.usurtprojecthr.logistic.model.Achievement;
//import upd.dev.usurtprojecthr.logistic.model.GameSession;
//import upd.dev.usurtprojecthr.logistic.model.User;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//@Data
//public class UserDTO {
//    private Long id;
//    private String username;
//    private Integer exp;
//    private Integer rating;
//    private Integer coins;
//    private PlayerRank rank;
//    private Role role;
//    private List<Achievement> achievements;
//    private List<GameSessionDTO> gameSessions = new ArrayList<>();
//    private LocalDateTime createdAt;
//    private String userDetails;
//
//    public UserDTO(User user) {
//        this.id = user.getId();
//        this.username = user.getUsername();
//        this.exp = user.getExp();
//        this.rating = user.getRating();
//        this.coins = user.getCoins();
//        this.rank = user.getRank();
//        this.role = user.getRole();
//        this.achievements = user.getAchievements();
//
//        for (GameSession gameSession : user.getGameSessions())
//            gameSessions.add(new GameSessionDTO(gameSession));
//
//        this.gameSessions = getGameSessions();
//        this.createdAt = user.getCreatedAt();
//        this.userDetails = user.getUserDetails();
//    }
//}
