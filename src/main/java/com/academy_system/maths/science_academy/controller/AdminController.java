package com.academy_system.maths.science_academy.controller;

import com.academy_system.maths.science_academy.service.AdminService;
import com.academy_system.maths.science_academy.service.domainObject.*;
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
            System.out.println("im here");
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


    @PostMapping("/captureSubject")

    public ResponseEntity<?> captureSubject(@RequestBody SubjectDO subjectDO) {

        String cutName = subjectDO.getStudents().get(0).getUser().getPassword().substring(6);
//        subjectDO.getStudents().get(0).getUser().setPassword(cutName);
        ResponseRequest responseRequest = new ResponseRequest();
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken( subjectDO.getStudents().get(0).getUser().getUsername() ,cutName)

            );
            service.captureSubject(subjectDO);
            return ResponseEntity.ok(subjectDO);
        } catch (BadCredentialsException e) {
            responseRequest.setMessage("bad credentials");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("NOT AUTHORIZED");
        }
    }


    @PostMapping("/viewSubjects")
    public ResponseEntity<?> viewSubjects(@RequestBody StudentDO studentDO) {
        String cutName = studentDO.getUser().getPassword().substring(6);
        studentDO.getUser().setPassword(cutName);
        ResponseRequest responseRequest = new ResponseRequest();
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(studentDO.getUser().getUsername(), studentDO.getUser().getPassword())

            );
            System.out.println(studentDO.getUser().getUsername());
            System.out.println(studentDO.getUser().getPassword());


            List<SubjectDO> subjects = service.viewSubjects();

            for(SubjectDO subjectDO : subjects){
                for (ResultsDO result: subjectDO.getResults()){
                    System.out.println(result.getStudent().getName() + " the student");
                    System.out.println(subjectDO.getSubjectName() +" the Subject ");
                }
            }
            return ResponseEntity.ok(subjects);
        } catch (BadCredentialsException e) {
            responseRequest.setMessage("bad credentials");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("NOT AUTHORIZED");
        }
    }

    @PostMapping("/captureResults")
    public ResponseEntity<?> captureResults(@RequestBody StudentDO studentDO) {
        System.out.println(studentDO.getUser().getUsername());
        System.out.println(studentDO.getUser().getPassword());

        String cutName = studentDO.getUser().getPassword().substring(6);
//        subjectDO.getStudents().get(0).getUser().setPassword(cutName);
        ResponseRequest responseRequest = new ResponseRequest();
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken( studentDO.getUser().getUsername(),cutName)

            );

            for(SubjectDO subjectDO : studentDO.getSubjects()){
                for (ResultsDO resultsDO : subjectDO.getResults()){
                    System.out.println(subjectDO.getSubjectName() +" " + resultsDO.getMarks() + " " + resultsDO.getTerm()
                    + " " + resultsDO.getYear());
                }
            }
            service.captureResults(studentDO);

            return ResponseEntity.ok(studentDO);
        } catch (BadCredentialsException e) {
            responseRequest.setMessage("bad credentials");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("NOT AUTHORIZED");
        }
    }

    @PostMapping("/capturePayment")
    public ResponseEntity<?> capturePayments(@RequestBody StudentDO studentDO) {
        System.out.println(studentDO.getUser().getUsername());
        System.out.println(studentDO.getUser().getPassword());
        String cutName = studentDO.getUser().getPassword().substring(6);
//        subjectDO.getStudents().get(0).getUser().setPassword(cutName);
        ResponseRequest responseRequest = new ResponseRequest();
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken( studentDO.getUser().getUsername(),cutName)

            );
            System.out.println(studentDO.getTransactions().get(0).getAmount() + "-"  + studentDO.getTransactions().get(0).getDate());
            service.capturePayment(studentDO);

            return ResponseEntity.ok(studentDO);
        } catch (BadCredentialsException e) {
            responseRequest.setMessage("bad credentials");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("NOT AUTHORIZED");
        }
    }

    @PostMapping("/captureLesson")
    public ResponseEntity<?> captureLesson(@RequestBody SubjectDO subjectDO) {
        for(LessonDO lessonDO: subjectDO.getLessons() ){
            System.out.println(lessonDO.getTopic());
            System.out.println(lessonDO.getSubTopic());
            for (AttendanceDO attendanceDO : lessonDO.getAttendances()){
                System.out.println(attendanceDO.getStudent().getUser().getUsername());
                System.out.println(attendanceDO.isPresent());
            }
        }
        String cutName = subjectDO.getLessons().get(0).getAttendances().get(0).getStudent().getUser().getPassword().substring(6);
//        subjectDO.getStudents().get(0).getUser().setPassword(cutName);
        ResponseRequest responseRequest = new ResponseRequest();
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken( subjectDO.getLessons().get(0).getAttendances().get(0).getStudent().getUser()
                            .getUsername(),cutName)
            );

            service.captureLesson(subjectDO);

            return ResponseEntity.ok(subjectDO);
        } catch (BadCredentialsException e) {
            responseRequest.setMessage("bad credentials");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("NOT AUTHORIZED");
        }
    }

    @PostMapping("/captureTimetable")
    public ResponseEntity<?> captureTimeTable(@RequestBody TimeTableDO timeTableDO) {
        System.out.println(timeTableDO.getTime() + "time: " );
        System.out.println(timeTableDO.getStudent().getUser().getUsername());
        System.out.println(timeTableDO.getStudent().getUser().getPassword());

        String cutName = timeTableDO.getStudent().getUser().getPassword().substring(6);
        timeTableDO.getStudent().getUser().setPassword(cutName);
        ResponseRequest responseRequest = new ResponseRequest();
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(timeTableDO.getStudent().getUser().getUsername(),  cutName)

            );

            service.captureTimeTable(timeTableDO);

            return ResponseEntity.ok(timeTableDO);
        } catch (BadCredentialsException e) {
            responseRequest.setMessage("bad credentials");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("NOT AUTHORIZED");
        }
    }

   
}
