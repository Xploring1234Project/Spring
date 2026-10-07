package com.springjpa.SpringDataJpa.controller;

import com.springjpa.SpringDataJpa.entity.Course;
import com.springjpa.SpringDataJpa.entity.Profile;
import com.springjpa.SpringDataJpa.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> findAllCourses(){
        return courseService.findAllCourses();
    }

    @GetMapping("/{courseId}")
    public Course findCourseById(@PathVariable Long courseId){
        return  courseService.findCourseById(courseId);
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course){
        return courseService.createCourse(course);
    }

    @PutMapping("/{courseId}")
    public Course updateCourse(@RequestBody Course course, @PathVariable Long courseId){
        Course oldCourse = courseService.findCourseById(courseId);
        if(oldCourse != null){
            // Update Course Code if the new one is not null and not empty
            oldCourse.setCourseCode(course.getCourseCode()!=null && !course.getCourseCode().equals("")?course.getCourseCode():oldCourse.getCourseCode());
            oldCourse.setTitle(course.getTitle()!=null && !course.getTitle().equals("")?course.getTitle():oldCourse.getTitle());
            return courseService.updateCourse(oldCourse);
        }
        return null;

    }

    @DeleteMapping("/{courseId}")
    public void deleteProfile(@PathVariable Long courseId){
        courseService.deleteCourseById(courseId);
    }
}
