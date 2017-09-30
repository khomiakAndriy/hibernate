package com.hibernate.com.hibernate.demo;


import com.hibernate.com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();
        try {
            System.out.println("Creating 3 student objects...");
            Student student1 = new Student("Nata", "Khomiak", "a@gmail.com");
            Student student2 = new Student("Kristi", "Khomiak", "b@gmail.com");
            Student student3 = new Student("Tolik", "Khomiak", "c@gmail.com");
            session.beginTransaction();

            System.out.println("Saving the student");
            session.save(student1);
            session.save(student2);
            session.save(student3);

            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
