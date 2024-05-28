package nvm.poly.asm.service;

import nvm.poly.asm.entity.User;
import nvm.poly.asm.model.request.UserRequest;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface UserService {

    User login(String username, String password);

    String add(UserRequest request);

    String update(UserRequest request, UUID id);

    Page<User> getAll(int page);

    User getUserById(UUID id);

    User findByUsernameAndPassword(String username, String password);

}
