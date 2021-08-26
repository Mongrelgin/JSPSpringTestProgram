package com.example.demo.services;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    private final UserRepository repo;

    @Autowired
    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public void saveMyUser(User user) {
        repo.save(user);
    }

    public List<User> showAllUsers() {
        List<User> users = new ArrayList<>();
        for (User user : repo.findAll()) {
            users.add(user);
        }
        return users;
    }

    public void deleteMyUser(Integer id) {
        repo.deleteById(id);
    }

    public User editUser(Integer id) {
        return repo.findById(id).get();
    }

    public User findByUsernameAndPassword(String username, String password) {
        return repo.findByUsernameAndPassword(username, password);
    }
}
