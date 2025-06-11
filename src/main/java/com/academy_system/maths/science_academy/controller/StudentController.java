package com.academy_system.maths.science_academy.controller;

import com.academy_system.maths.science_academy.repository.entity.User;
import com.academy_system.maths.science_academy.service.StudentService;
import com.academy_system.maths.science_academy.service.domainObject.ResponseRequest;
import com.academy_system.maths.science_academy.service.domainObject.StudentDO;
import com.academy_system.maths.science_academy.service.domainObject.UserDO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentController {
    private final StudentService studentService;
    private final AuthenticationManager authenticationManager;


    @Autowired
    public StudentController(StudentService studentService, AuthenticationManager authenticationManager) {
        this.studentService = studentService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> captureStudent(@RequestBody User user, HttpServletRequest request) {
        ResponseRequest responseRequest = new ResponseRequest();
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())

            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            request.getSession(true);
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
            responseRequest.setMessage("logged in");

            StudentDO studentDO = studentService.findStudentByUserName(user.getUsername());
            return ResponseEntity.ok(studentDO);
        } catch (BadCredentialsException e) {
            responseRequest.setMessage("bad credentials");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }



    @PostMapping("/auth/sign-up")
    public  void signIn(@RequestBody UserDO userDO) {
        System.out.println(userDO.getUsername());
        System.out.println(userDO.getPassword());

        studentService.signUp(userDO);
    }

    @PostMapping("/apply")
    public ResponseEntity<?> apply(@RequestBody StudentDO studentDO){
        String cutName = studentDO.getUser().getPassword().substring(6);
        studentDO.getUser().setPassword(cutName);
        ResponseRequest responseRequest = new ResponseRequest();
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(studentDO.getUser().getUsername(), studentDO.getUser().getPassword())

            );



            studentService.apply(studentDO);

            return ResponseEntity.ok(studentDO);
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("NOT AUTHORIZED");
        }
    }



}
