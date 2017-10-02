package com.hibernate.com.hibernate.demo.begin;


import com.hibernate.com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            int studentId = 6;
            Student myStudent = session.get(Student.class, studentId);
            myStudent.setFirstName("Yuriy");
            myStudent.setLastName("Kuzko");
            myStudent.setEmail("kuzko@gmail.com");


            session.getTransaction().commit();
            System.out.println("Done!");

            session = factory.getCurrentSession();
            session.beginTransaction();

            session.createQuery("update Student set email = 'all@gmail.com'").executeUpdate();


            session.getTransaction().commit();


        } finally {
            factory.close();
        }

    }
}
