package com.example.jparelationexercise.Controller;

import com.example.jparelationexercise.Model.Student;
import com.example.jparelationexercise.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    //• Get all students
    @GetMapping("/get")
    public ResponseEntity getAllStudents(){
        return ResponseEntity.status(200).body(studentService.getAllStudents());
    }

    //• Add new student
    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student){
        studentService.AddNewStudent(student);
        return ResponseEntity.status(200).body("Student added successfully!");
    }

    //• Update student
    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id,@Valid @RequestBody Student student){
        studentService.updateStudent(id,student);
        return ResponseEntity.status(200).body("Student updated successfully!");
    }

    //• Delete student
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id){
       studentService.deleteStudents(id);
        return ResponseEntity.status(200).body("Student deleted successfully!");
    }

    @PutMapping("/assignSC/{student_id}/{course_id}")
    public ResponseEntity AssignStudentToCourses (@PathVariable Integer student_id , @PathVariable Integer course_id){
        studentService.assignStudentsToCourses(student_id,course_id);
        return ResponseEntity.status(200).body("Assigned successfully!");
    }

    //Create endpoint that takes student id and major and change the student major
    // (changing the major will drop all the cousres that the student attended to )
    @PutMapping("/change/{student_id}/{major}")
   public ResponseEntity changeStudentMajor (@PathVariable Integer student_id,@PathVariable String major) {
        studentService.changeStudentMajor(student_id,major);
        return ResponseEntity.status(200).body("Student major updated successfully!");
    }
    
    @GetMapping("/getStudents/{course_id}")
        public ResponseEntity getAllStudentsByCourseId(@PathVariable Integer course_id){
        return ResponseEntity.status(200).body(studentService.getStudentsByCourseId(course_id));
        }


}
