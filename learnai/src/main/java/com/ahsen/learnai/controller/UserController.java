package com.ahsen.learnai.controller;
import com.ahsen.learnai.entity.OpUser;
import com.ahsen.learnai.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/users")
@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping
    public ResponseEntity<List<OpUser>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }
    @PostMapping
    public ResponseEntity<String> create(@RequestBody OpUser opUser) throws Exception {
        return ResponseEntity.ok(userService.create(opUser));
    }
    @GetMapping("/findonebyid")
    public ResponseEntity<OpUser> findOneById(@RequestParam("id") Long id) throws Exception {
        return ResponseEntity.ok(userService.getUserById(id));
    }
    @GetMapping("/login")
    public ResponseEntity<OpUser> login(@RequestParam("username") String username, @RequestParam("password")
    String password) throws Exception {
        return ResponseEntity.ok(userService.login(username, password));
    }
}




