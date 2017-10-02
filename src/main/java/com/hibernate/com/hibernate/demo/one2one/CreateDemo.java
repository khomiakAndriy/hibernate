package com.hibernate.com.hibernate.demo.one2one;


import com.hibernate.com.hibernate.demo.entity.Instructor;
import com.hibernate.com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // create objects
            Instructor instructor = new Instructor("Andriy2", "Khomiak2", "g2@g.com");

            InstructorDetail instructorDetail = new InstructorDetail("youtube2", "football2");

            instructor.setInstructorDetail(instructorDetail);
            // associate objects


            session.beginTransaction();

            // save instructor
            System.out.println("Saving instructor: " + instructor);
            session.save(instructor);

            session.getTransaction().commit();
            System.out.println("Done!");

        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }
    }

}
