package com.example.jparelationexercise.Repository;

import com.example.jparelationexercise.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {

    Course findCourseById(Integer id);



}


