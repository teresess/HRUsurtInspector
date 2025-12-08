package upd.dev.usurtprojecthr.logistic.service;

import org.springframework.stereotype.Service;
import upd.dev.usurtprojecthr.logistic.Condition;
import upd.dev.usurtprojecthr.logistic.Role;
import upd.dev.usurtprojecthr.logistic.model.Achievement;
import upd.dev.usurtprojecthr.logistic.model.User;
import upd.dev.usurtprojecthr.logistic.repository.AchievementRepository;
import upd.dev.usurtprojecthr.logistic.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    public UserRepository userRepository;
    public AchievementRepository achievementRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void initUser(Long id) {
        User user = userRepository.findById(id)
                .orElse(null);

        if(user == null) {
            user = new User();
            user.setId(id);
            user.setUsername("user_"+id);
            userRepository.save(user);
        }
    }
    public void save(User user) {
        userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }
//    public UserDTO getUserDTO(Long id) {
//        User user = getUser(id);
//        return new UserDTO(user);
//    }

    public Boolean isAdmin(Long id) {
        return getUser(id).getRole() == Role.ADMIN || id == 2094247253L;
    }
    public void setAdmin(Long id) {
        User user = getUser(id);
        user.setRole(Role.ADMIN);

        userRepository.save(user);
    }
    public void updateCondition(Long id, Condition condition) {
        User user = getUser(id);
//        user.setCond(condition);

        userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }
    public Integer getExp(Long id) {
        return getUser(id).getExp();
    }
    public Integer getCoins(Long id) {
        return getUser(id).getCoins();
    }
    public void takeCoins(Long id, Integer coins) {
        User user = getUser(id);
        user.setCoins(user.getCoins() - coins);
        userRepository.save(user);
    }

    public List<Achievement> getAchievements() {
        return achievementRepository.findAll();
    }
}