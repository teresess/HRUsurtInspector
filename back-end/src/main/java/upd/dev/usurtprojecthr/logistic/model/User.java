package upd.dev.usurtprojecthr.logistic.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import upd.dev.usurtprojecthr.logistic.PlayerRank;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "players")
public class User {
    @Id
    @Column(unique = true, nullable = false)
    private Long id;

    private String username;

    private Integer level = 1;
    private Integer exp = 0;
    private Integer rating = 0;

    @Enumerated(EnumType.STRING)
    private PlayerRank rank = PlayerRank.TRAINEE;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Achievement> achievements = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<GameSession> gameSessions = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime createdAt;
}

