package damo.com.damchat.service.user;

import damo.com.damchat.dto.request.RegisterUserDTO;
import damo.com.damchat.exception.AppException;

public interface UserService {
    void createUser(RegisterUserDTO registerBloggerDTO);

    void deleteUser(String id) throws AppException;

    void findUser(String id)throws AppException;
}
