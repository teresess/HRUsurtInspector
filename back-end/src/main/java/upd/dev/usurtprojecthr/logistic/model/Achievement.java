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

    private String title;
    private String description;
    private Integer requiredValue;

    @Enumerated(EnumType.STRING)
    private AchievementType type;

    @Column(columnDefinition = "JSON")
    private String achievementDetails;
}