package ru.netology.netolstringbootrest.repository;

import org.springframework.stereotype.Repository;
import ru.netology.netolstringbootrest.authorities.Authorities;
import ru.netology.netolstringbootrest.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    private Map<String, User> userRep = new HashMap<>();
    {
        userRep.put("Oleg", new User("Oleg", "123Oleg123"));
        userRep.put("Anna", new User("Anna", "123Anna123"));
        userRep.put("Sveta", new User("Sveta", "123Sveta123"));
    }

    public List<Authorities> getUserAuthorities(User user) {
        User userFromRep = userRep.get(user.getUser());
        if (user.equals(userFromRep)){
            return List.of(Authorities.values());
        } else {
            return new ArrayList<>();
        }
    }
}
