package damo.com.damchat.service.user;

import damo.com.damchat.dto.request.RegisterUserDTO;
import damo.com.damchat.exception.AppException;
import damo.com.damchat.model.user.User;
import damo.com.damchat.repository.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    UserRepository userRepository;

    public boolean existById(String id) {
        return userRepository.existsById(id);
    }

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public void createUser(RegisterUserDTO registerUserDTO) {
        User user = new User();
        user.setFirstName(registerUserDTO.getFirstName());
        user.setLastName(registerUserDTO.getLastName());
        modelMapper.map(user, registerUserDTO);
        userRepository.save(user);

    }

    @Override
    public void deleteUser(String id) throws AppException {
        Optional<User> currentUser = userRepository.findById(id);
        if (currentUser.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new AppException("User with ID " + id + " not found");
        }
    }

    public void findUser(String id) throws AppException {
        Optional<User> currentUser = userRepository.findById(id);
        if (currentUser.isPresent()) {
            userRepository.findById(id);
            System.out.println(id);
        } else {
            throw new AppException("User with ID " + id + " not found");
        }
    }

    public User updateUser(String id, User updatedUser) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with ID " + id + " not found"));
        existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setLastName(updatedUser.getLastName());

        return userRepository.save(existingUser);

    }
}