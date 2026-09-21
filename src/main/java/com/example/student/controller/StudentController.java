package com.example.student.controller;

import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.*;
import com.example.student.entity.Student;
import com.example.student.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // 1. Lấy tất cả sinh viên
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAll();
    }

    // 2. Lấy sinh viên theo ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable UUID id) {
        return studentService.getById(id);
    }

    // 3. Tìm theo mã sinh viên
    @GetMapping("/code/{code}")
    public Student getStudentByCode(@PathVariable String code) {
        return studentService.getByStudentCode(code);
    }

    // 4. Tìm kiếm sinh viên
    @GetMapping("/search")
    public List<Student> searchStudents(@RequestParam(required = false, defaultValue = "") String keyword) {
        return studentService.search(keyword);
    }

    // 5. Thêm sinh viên
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    // 6. Cập nhật sinh viên
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable UUID id, @RequestBody Student student) {
        return studentService.update(id, student);
    }

    // 7. Xóa sinh viên theo ID
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable UUID id) {
        studentService.delete(id);
        return "Đã xóa sinh viên có ID: " + id;
    }

    // 8. Xóa tất cả sinh viên
    @DeleteMapping
    public String deleteAllStudents() {
        studentService.deleteAll();
        return "Đã xóa toàn bộ sinh viên!";
    }
}
