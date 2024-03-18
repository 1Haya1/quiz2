package org.example.quiz2.Controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.quiz2.Api.ApiResponse;


import org.example.quiz2.Model.User;
import org.example.quiz2.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;



    @GetMapping("/get")
    public ResponseEntity getAllUser(){
        return ResponseEntity.status(200).body(userService.getAllUser());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(userService.addUser(user));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity UpdateUser(@PathVariable Integer id,User user,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdate=userService.UpdateUser(id,user);
        if(isUpdate){
            return ResponseEntity.status(200).body(new ApiResponse("updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletUser(@PathVariable Integer id){
        if(userService.deleteUser(id)==null){
            return ResponseEntity.status(400).body(new ApiResponse("not found"));
        }
        return ResponseEntity.status(200).body(new ApiResponse("deleted"));
    }


    @GetMapping("/getalluser/{Ubalance}")
    public ResponseEntity getUserB(@PathVariable Integer Ubalance){
        return ResponseEntity.status(200).body(userService.getUserB(Ubalance));
    }


    @GetMapping("/getalluser/{Uage}")
    public ResponseEntity getUserAge(@PathVariable Integer Uage){
        return ResponseEntity.status(200).body(userService.getUserAge(Uage));
    }





}
