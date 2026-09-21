package com.example.student.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {

    // Tìm chính xác theo mã sinh viên
    Optional<Student> findByStudentCode(String studentCode);

    // Tìm kiếm theo mã, họ tên, email hoặc số điện thoại
    List<Student> findByStudentCodeContainingIgnoreCaseOrFullNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrPhoneContainingIgnoreCase(
            String studentCode,
            String fullName,
            String email,
            String phone
    );
}