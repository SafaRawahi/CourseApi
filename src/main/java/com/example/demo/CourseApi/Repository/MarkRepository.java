package com.example.demo.CourseApi.Repository;

import com.example.demo.CourseApi.Model.Mark;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MarkRepository extends CrudRepository<Mark, Integer> {

    @Query(value = "SELECT m from Mark m")
    List<Mark> getAllMarks();

}
