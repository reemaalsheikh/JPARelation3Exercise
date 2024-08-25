package com.example.jparelationexercise.Repository;
import com.example.jparelationexercise.Model.Course;
import com.example.jparelationexercise.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {

    Teacher findTeacherById(Integer id);


}
