package com.example.demo.CourseApi.Repository;

import com.example.demo.CourseApi.Model.Mark;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MarkRepository extends CrudRepository<Mark, Integer> {

    @Query(value = "SELECT m from Mark m")    //getAllMarks
    List<Mark> getAllMarks();

    @Query(value = "SELECT m from Mark m where m.id = :markId")    //getMarkById
    Mark getMarkById(@Param("markId") Integer id);
}
