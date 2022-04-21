package com.indivara.university.controller;

import com.indivara.university.entity.Course;
import com.indivara.university.entity.Student;
import com.indivara.university.repository.CourseRepository;
import com.indivara.university.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public void getAllCourses(){

    }
    @PostMapping("student/addCourse")
    public Course addCourse(@RequestBody Course course){
        return courseService.saveCourse(course);
    }

    @PutMapping("lecturer/addCourse")
    public Course updateCourse(@RequestBody Course course){
        return courseService.updateCourse(course);
    }

    @GetMapping("lecturer/courses")
    public List<Course> findAllCourses(){
        return courseService.getCourses();
    }


    @GetMapping("/student/MyCourses")
    public List<Course> findCourseByStudentID(@RequestParam Integer studentID){
        return courseService.getCourseByStudentID(studentID);
    }
    @GetMapping("/lecturer/MyCourses")
    public List<Course> findCourseByLecturerID(@RequestParam Integer lecturerID){
        return courseService.getCourseByLecturerID(lecturerID);
    }

}
