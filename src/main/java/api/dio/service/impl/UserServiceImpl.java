package api.dio.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import api.dio.domain.model.User;
import api.dio.domain.repository.UserRepository;
import api.dio.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("this Account Number already exists.");
        }
        return userRepository.save(userToCreate);
    }

}
