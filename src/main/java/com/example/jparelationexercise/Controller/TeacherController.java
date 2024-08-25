package com.example.jparelationexercise.Controller;

import com.example.jparelationexercise.Model.Teacher;
import com.example.jparelationexercise.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    // • Get all teachers
    @GetMapping("/get")
    public ResponseEntity getAllTeachers(){
        return ResponseEntity.status(200).body(teacherService.getAllTeachers());
    }

    //• Add new teacher
    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(" Teacher successfully added");
    }

    // • Update teacher
    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher (@PathVariable Integer id ,@Valid @RequestBody  Teacher teacher){
       teacherService.updateTeacher(id,teacher);
        return ResponseEntity.status(200).body(" Teacher successfully updated");
    }

    //• Delete teacher
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
       teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body(" Teacher successfully deleted");
    }

    //Create endpoint that takes teacher id and return All teacher details
    @GetMapping("/TDetails/{id}")
    public ResponseEntity teacherDetails (@PathVariable Integer id){
        Teacher teacher = teacherService.getTeacherById(id);
        return ResponseEntity.status(200).body(teacher);
    }

}
