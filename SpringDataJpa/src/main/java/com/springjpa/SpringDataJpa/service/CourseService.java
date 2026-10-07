package com.springjpa.SpringDataJpa.service;

import com.springjpa.SpringDataJpa.entity.Course;
import com.springjpa.SpringDataJpa.entity.Profile;
import com.springjpa.SpringDataJpa.repository.CourseRepository;
import com.springjpa.SpringDataJpa.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepo;

    public List<Course> findAllCourses(){
        return courseRepo.findAll();
    }

    public Course findCourseById(Long id){
        return courseRepo.findById(id).get();
    }

    public Course createCourse(Course course){
        return courseRepo.save(course);
    }

    public Course updateCourse(Course course){
        return courseRepo.save(course);
    }

    public void deleteCourseById(Long id){
        courseRepo.deleteById(id);
    }

}
