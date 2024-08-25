package com.example.jparelationexercise.Controller;

import com.example.jparelationexercise.Model.Course;
import com.example.jparelationexercise.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;


    //• Get all courses
    @GetMapping("/get")
    public ResponseEntity getAllCourses(){
        return ResponseEntity.status(200).body(courseService.getAllCourses());
    }

    //• Add new course
    @PostMapping("/add")
    public ResponseEntity addCourse(@Valid @RequestBody Course course){
        courseService.addCourse(course);
        return ResponseEntity.status(200).body("Courses added successfully!");
    }

    //• Update course
    @PutMapping("/update/{id}")
    public ResponseEntity updateCourses(@PathVariable Integer id,@Valid @RequestBody Course course){
        courseService.updateCourses(id,course);
        return ResponseEntity.status(200).body("Course updated successfully!");
    }

    //• Delete course
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id){
        courseService.deleteCourses(id);
        return ResponseEntity.status(200).body("Course deleted successfully!");
    }

    //Assign Teacher To Courses
    @PutMapping("/assign/{teacher_id}/{course_id}")
    public ResponseEntity assignTeacherToCourses (@PathVariable Integer teacher_id , @PathVariable Integer course_id){
        courseService.assignTeacherToCourses(teacher_id,course_id);
        return ResponseEntity.status(200).body("Teacher assigned successfully!");
    }


    //• Create endpoint that take course id and return the teacher name for that class
    @GetMapping("/getName/{course_id}")
    public ResponseEntity getTeacherNameByCourseId (@PathVariable Integer course_id){
        return ResponseEntity.status(200).body(courseService.getTeacherNameByCourseId(course_id));
    }


}
