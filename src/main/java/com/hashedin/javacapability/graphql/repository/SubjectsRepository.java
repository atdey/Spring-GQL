package com.hashedin.javacapability.graphql.repository;

import com.hashedin.javacapability.graphql.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectsRepository extends JpaRepository<Course, Long> {
}
