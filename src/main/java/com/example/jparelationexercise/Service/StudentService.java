package com.example.jparelationexercise.Service;

import com.example.jparelationexercise.Api.ApiException;
import com.example.jparelationexercise.Model.Course;
import com.example.jparelationexercise.Model.Student;
import com.example.jparelationexercise.Repository.CourseRepository;
import com.example.jparelationexercise.Repository.StudentRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    //• Get all students
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    //• Add new student
    public void AddNewStudent(Student student){
       studentRepository.save(student);
    }

    //• Update student
    public void updateStudent(Integer id ,Student student){
        Student student1 = studentRepository.findStudentById(id);
        if(student1 == null){
            throw new ApiException("Student not found");
        }
        student1.setName(student.getName());
        student1.setAge(student.getAge());
        student1.setMajor(student.getMajor());
        studentRepository.save(student1);
    }

    //• Delete student
    public void deleteStudents(Integer id){
        Student student1 = studentRepository.findStudentById(id);
        if(student1 == null){
            throw new ApiException("Student not found");
        }
        studentRepository.delete(student1);
    }

    public void assignStudentsToCourses(Integer student_id, Integer course_id){
        Student student1 = studentRepository.findStudentById(student_id);
        Course course1 = courseRepository.findCourseById(course_id);

        if(student1 == null || course1 == null){
            throw new ApiException("Cannot assign student to course");
        }


        student1.getCourses().add(course1);
        course1.getStudents().add(student1);

        studentRepository.save(student1);
        courseRepository.save(course1);
    }


    //Create endpoint that takes student id and major and change the student major
    // (changing the major will drop all the courses that the student attended to )

    public void changeStudentMajor(Integer student_id, String newMajor){
        Student student1 = studentRepository.findStudentById(student_id);
        if(student1 == null){
            throw new ApiException("Student id not found");
        }
        student1.setMajor(newMajor);
      // Remove the student from all courses they are enrolled in
        for(Course course: student1.getCourses()){
            // Remove student from course's student list
            course.getStudents().remove(student1);

            courseRepository.save(course);   // Save the course to update the changes in the database
        }
        //Set the student's courses to null (they are no longer enrolled in any courses)
        student1.setCourses(null);

        studentRepository.save(student1);
    }


    // • Create endpoint that takes class id and return the student list
    public Set<Student> getStudentsByCourseId(Integer course_id){
        Course course = courseRepository.findCourseById(course_id);
     if(course == null){
         throw new ApiException("Course id is not found");
     }

     if(course.getStudents().isEmpty()){
         throw new ApiException("Students not found, There are no students in this course");
     }
     return course.getStudents();
    }





}
