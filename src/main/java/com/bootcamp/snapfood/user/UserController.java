package com.bootcamp.snapfood.user;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping(value = "/user/")
@AllArgsConstructor
public class UserController {
    private IUserService userService;
    private UserMapper userMapper;

    @PostMapping
    @RolesAllowed(
            {"admin", "user", "supplier" }
    )


    public ResponseEntity<Void> save(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO);
        User user = userMapper.toUser(userDTO);
        userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDTO) {
        User user = userMapper.toUser(userDTO);
        val dto = userMapper.toUserDTO(userService.update(user));
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Long id) {
        User user = userService.getById(id);
        UserDTO userDTO = userMapper.toUserDTO(user);
        return ResponseEntity.ok(userDTO);
    }


    @GetMapping()
    public ResponseEntity<List<UserDTO>> getAll() {
        List<User> users = userService.getAll();
        List<UserDTO> usersDto = userMapper.toUserDTOs(users);

        return ResponseEntity.ok(usersDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
