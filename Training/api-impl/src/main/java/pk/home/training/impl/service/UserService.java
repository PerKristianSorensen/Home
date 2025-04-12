package pk.home.training.impl.service;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import pk.home.training.api.dto.UserDto;
import pk.home.training.impl.repository.UserRepository;

import java.util.Optional;

public class UserService {

    @Inject
    private UserRepository userRepository;

    public Optional<UserDto> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public UserDto createUser(UserDto userDto) {
        userRepository.save(userDto);
    }

    @Transactional
    public void updateUser(Long id, UserDto userDto) {
        if (userRepository.findById(id).isPresent()) {
            userDto.setId(id);
            userRepository.save(userDto);
        }
    }
}