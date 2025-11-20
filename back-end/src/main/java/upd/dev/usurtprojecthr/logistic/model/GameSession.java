package upd.dev.usurtprojecthr.logistic.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import upd.dev.usurtprojecthr.logistic.GameMode;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "game_sessions")
public class GameSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    private User user;

    private Integer score;
    private Integer accuracy;
    private Integer documentsChecked;
    private Integer errorsFound;
    private Integer durationSeconds;

    @Enumerated(EnumType.STRING)
    private GameMode gameMode;

    @CreationTimestamp
    private LocalDateTime completedAt;

    @Column(columnDefinition = "JSON")
    private String sessionDetails;
}

