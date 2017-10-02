package com.hibernate.com.hibernate.demo.begin;

import com.hibernate.com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ReadStudentDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();
        try {
            System.out.println("Creating new student object...");
            Student student = new Student("Daffy", "Duck", "asdf@gmail.com");

            session.beginTransaction();

            System.out.println("Saving the student");
            System.out.println(student);
            session.save(student);

            session.getTransaction().commit();


            // My new code

            // find out the student's id: primary key
            System.out.println("Saved student. Generated id: " + student.getId());

            // now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student based on the id: primary key
            System.out.println("Getting student with id: " + student.getId());

            Student myStudent = session.get(Student.class, student.getId());
            System.out.println("Get complete: " + myStudent);
            session.getTransaction().commit();

            // commit the transaction




            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
