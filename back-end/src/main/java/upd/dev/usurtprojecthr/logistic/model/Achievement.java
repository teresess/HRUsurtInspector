package upd.dev.usurtprojecthr.logistic.model;

import jakarta.persistence.*;
import lombok.Data;
import upd.dev.usurtprojecthr.logistic.AchievementType;


@Data
@Entity
@Table(name = "achievements")
public class Achievement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    private User user;

    private String code;
    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private AchievementType type;

    private Integer requiredValue;
    private Integer rewardPoints;
}

