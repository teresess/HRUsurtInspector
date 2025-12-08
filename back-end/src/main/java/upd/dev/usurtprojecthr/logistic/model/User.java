package upd.dev.usurtprojecthr.logistic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import upd.dev.usurtprojecthr.logistic.Condition;
import upd.dev.usurtprojecthr.logistic.PlayerRank;
import upd.dev.usurtprojecthr.logistic.Role;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "players")
public class User {
    @Id
    @Column(unique = true, nullable = false)
    private Long id;

    private String username;

    private Integer exp = 0;
    private Integer rating = 0;
    private Integer coins = 0;

    @Enumerated(EnumType.STRING)
    private PlayerRank rank = PlayerRank.TRAINEE;

    @Enumerated(EnumType.STRING)
    private Role role = Role.PLAYER;

    @ElementCollection
    @CollectionTable(name = "user_game_sessions",
            joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "game_session_id")
    private List<Long> gameSessionIds = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "player_achievements",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "achievement_id")
    )
    private List<Achievement> achievements = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(columnDefinition = "JSON")
    private String userDetails;


    public void addGameSessionId(Long sessionId) {
        if (!this.gameSessionIds.contains(sessionId)) {
            this.gameSessionIds.add(sessionId);
        }
    }

    public void removeGameSessionId(Long sessionId) {
        this.gameSessionIds.remove(sessionId);
    }
}

