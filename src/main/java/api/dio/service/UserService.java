package api.dio.service;

import api.dio.domain.model.User;

public interface UserService {

    
    User findById(Long id);

    User create(User userToCreate);
}
