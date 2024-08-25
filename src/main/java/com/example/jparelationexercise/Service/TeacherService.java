package com.example.jparelationexercise.Service;

import com.example.jparelationexercise.Api.ApiException;
import com.example.jparelationexercise.Model.Teacher;
import com.example.jparelationexercise.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

   // • Get all teachers
    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }

   //• Add new teacher
    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

   // • Update teacher
    public void updateTeacher(Integer id,Teacher teacher){
        Teacher teacher1 = teacherRepository.findTeacherById(id);

        if(teacher1 == null){
            throw new ApiException("Teacher Not Found!");
        }
        teacher1.setName(teacher.getName());
        teacher1.setAge(teacher.getAge());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setSalary(teacher.getSalary());
        teacherRepository.save(teacher1);
    }

   //• Delete teacher
    public void deleteTeacher(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if(teacher == null){
            throw new ApiException("Teacher Not Found!");
        }
        teacherRepository.delete(teacher);
    }

    //Create endpoint that takes teacher id and return All teacher details

    public Teacher getTeacherById(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if(teacher == null){
            throw new ApiException("Teacher Not Found!");
        }

        return teacher;
    }


}
