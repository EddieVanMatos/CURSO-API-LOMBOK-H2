package com.example.curso_api.service;

import com.example.curso_api.model.Course;
import com.example.curso_api.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> findCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public Optional<Course> updateCourse(Long id, Course courseDetails) {
        return courseRepository.findById(id).map(course -> {
            course.setNome(courseDetails.getNome());
            course.setDescricao(courseDetails.getDescricao());
            course.setConteudo(courseDetails.getConteudo());
            return courseRepository.save(course);
        });
    }

    public boolean deleteCourse(Long id) {
        return courseRepository.findById(id).map(course -> {
            courseRepository.delete(course);
            return true;
        }).orElse(false);
    }
}
