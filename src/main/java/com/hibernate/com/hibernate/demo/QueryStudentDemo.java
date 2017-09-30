package com.hibernate.com.hibernate.demo;


import com.hibernate.com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();

            // query students
            List<Student> students = session.createQuery("from Student").getResultList();

            // display the students
            displayStudents(students);
            System.out.println("-----------");

            // quary students^ firstName = 'Kristi'
            students = session.createQuery("from Student s where s.firstName = 'Kristi' OR s.lastName = 'Duck'").getResultList();
            displayStudents(students);


            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            factory.close();
        }

    }

    private static void displayStudents(List<Student> students) {
        for (Student student: students){
            System.out.println(student);
        }
    }
}
