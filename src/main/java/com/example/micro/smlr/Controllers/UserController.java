package com.example.micro.smlr.Controllers;

import com.example.micro.smlr.mappers.UserMapper;
import com.example.micro.smlr.models.dto.NewUserDto;
import com.example.micro.smlr.models.dto.UserChangeDto;
import com.example.micro.smlr.models.dto.UserDto;
import com.example.micro.smlr.models.entity.User;
import com.example.micro.smlr.services.dto.UserDtoService;
import com.example.micro.smlr.services.entity.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserDtoService userDtoService;
    private final UserMapper userMapper;

    @GetMapping("getAllUsers")
    public ResponseEntity <List<UserDto>> getAllUsers(){
        return ResponseEntity.ok().body(userDtoService.getAllUsers());
    }

    @PutMapping("changeUser")
    public ResponseEntity<String> changeUsers(@RequestBody UserChangeDto userChangeDto) {
        User user = userMapper.toEntity(userChangeDto);
        if(!userService.changeUser(user)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        return ResponseEntity.ok().body("Done");
    }

    @PostMapping("addNewUser")
    public ResponseEntity<String> addNewUser (@RequestBody NewUserDto newUserDto){
        User newUser = userMapper.toEntity(newUserDto);
        if(!userService.save(newUser)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("Error"));
        }
        return ResponseEntity.ok().body("User was created");
    }
}
