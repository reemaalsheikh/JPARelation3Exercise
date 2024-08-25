package com.example.jparelationexercise.Service;

import com.example.jparelationexercise.Api.ApiException;
import com.example.jparelationexercise.Model.Course;
import com.example.jparelationexercise.Model.Teacher;
import com.example.jparelationexercise.Repository.CourseRepository;
import com.example.jparelationexercise.Repository.StudentRepository;
import com.example.jparelationexercise.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    //Get all courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    //• Add new course
    public void addCourse(Course course) {
       courseRepository.save(course);
    }


    //• Update course
    public void updateCourses(Integer id,Course course) {
        Course course1 = courseRepository.findCourseById(id);
        if (course1 == null) {
            throw new ApiException("Course Not Found");
        }
        course1.setName(course.getName());
        courseRepository.save(course1);
    }


    //• Delete course
    public void deleteCourses(Integer id){
        Course course1 = courseRepository.findCourseById(id);
        if(course1 == null){
            throw new ApiException("Course Not Found");
        }
      courseRepository.delete(course1);
    }

    public void assignTeacherToCourses (Integer teacher_id ,Integer course_id){
        Course course = courseRepository.findCourseById(course_id);
        Teacher teacher = teacherRepository.findTeacherById(teacher_id);
        if(course==null || teacher == null){
            throw new ApiException("Cannot assign teacher to course");
        }
        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    //• Create endpoint that take course id and return the teacher name for that class
   public String getTeacherNameByCourseId (Integer id){
        Course course = courseRepository.findCourseById(id);
        if(course == null || course.getTeacher() == null){
            throw new ApiException("Teacher Not Found");
        }
        return course.getTeacher().getName();
   }



}
