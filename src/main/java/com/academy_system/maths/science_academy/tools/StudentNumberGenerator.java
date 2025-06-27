package com.academy_system.maths.science_academy.tools;

import com.academy_system.maths.science_academy.service.AdminService;

public class StudentNumberGenerator {
    private long id;
    private static StudentNumberGenerator instance;
    private  final AdminService service;



    private StudentNumberGenerator(AdminService service ) {
        this.service = service;
    }






    public static synchronized StudentNumberGenerator getInstance() {
        if (instance == null) {
//            instance = new StudentNumberGenerator();
        }
        return instance;
    }


    public synchronized long generateId() {
      id = service.getLastStudentNo();;
        return id++;
    }
}
