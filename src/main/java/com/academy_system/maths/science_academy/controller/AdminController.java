package com.academy_system.maths.science_academy.controller;

import com.academy_system.maths.science_academy.service.AdminService;
import com.academy_system.maths.science_academy.service.domainObject.ResponseRequest;
import com.academy_system.maths.science_academy.service.domainObject.StudentDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AdminController {
    private final AuthenticationManager authenticationManager;
    private final AdminService service;

    @Autowired
    public AdminController(AuthenticationManager authenticationManager, AdminService service) {
        this.authenticationManager =  authenticationManager;
        this.service = service;
    }

    @PostMapping("/capture-student")
    public ResponseEntity<?> capture(@RequestBody StudentDO studentDO) {

        String cutName = studentDO.getUser().getPassword().substring(6);
        studentDO.getUser().setPassword(cutName);
        ResponseRequest responseRequest = new ResponseRequest();
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(studentDO.getUser().getUsername(), studentDO.getUser().getPassword())

            );

            service.captureStudent(studentDO);
            return ResponseEntity.ok(studentDO);
        } catch (BadCredentialsException e) {
            responseRequest.setMessage("bad credentials");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("NOT AUTHORIZED");
        }
    }

    @PostMapping("/viewApplications")
    public ResponseEntity<?> viewApplications(@RequestBody StudentDO studentDO){

        String cutName = studentDO.getUser().getPassword().substring(6);
        studentDO.getUser().setPassword(cutName);
        ResponseRequest responseRequest = new ResponseRequest();
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(studentDO.getUser().getUsername(), studentDO.getUser().getPassword())

            );
            System.out.println(studentDO.getUser().getUsername());
            System.out.println(studentDO.getUser().getPassword());

           List<StudentDO> applications = service.viewApplications();

            return ResponseEntity.ok(applications);
        } catch (BadCredentialsException e) {
            responseRequest.setMessage("bad credentials");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("NOT AUTHORIZED");
        }
    }

    @PostMapping("/processApplication")

    public ResponseEntity<?> processApplication(@RequestBody StudentDO studentDO) {
        System.out.println(studentDO.getUser().getUsername());
        System.out.println(studentDO.getUser().getPassword());
        String cutName = studentDO.getUser().getPassword().substring(6);
        studentDO.getUser().setPassword(cutName);
        ResponseRequest responseRequest = new ResponseRequest();
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(studentDO.getUser().getUsername(), studentDO.getUser().getPassword())

            );
            service.processApplication(studentDO);

            return ResponseEntity.ok(studentDO);
        } catch (BadCredentialsException e) {
            responseRequest.setMessage("bad credentials");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("NOT AUTHORIZED");
        }
    }
}
