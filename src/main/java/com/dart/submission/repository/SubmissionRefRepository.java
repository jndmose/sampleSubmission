package com.dart.submission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dart.submission.model.SubmissionReference;

@Repository
public interface SubmissionRefRepository extends JpaRepository<SubmissionReference, Long> {

}
