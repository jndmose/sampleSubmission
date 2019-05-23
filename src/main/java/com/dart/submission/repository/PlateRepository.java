package com.dart.submission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dart.submission.model.Submission;
@Repository
public interface PlateRepository extends JpaRepository<Submission, Long> {

}
