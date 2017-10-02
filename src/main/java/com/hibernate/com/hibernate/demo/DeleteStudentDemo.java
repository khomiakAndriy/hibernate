package com.hibernate.com.hibernate.demo;

import com.hibernate.com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteStudentDemo {
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
//            int studentId = 9;
//            Student myStudent = session.get(Student.class, studentId);
//            session.delete(myStudent);

            session.createQuery("delete from Student where id>6").executeUpdate();

            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            factory.close();
        }

    }
}
