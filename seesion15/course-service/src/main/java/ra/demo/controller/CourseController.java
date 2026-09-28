package ra.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final List<Map<String, Object>> courses = new ArrayList<>(List.of(
            Map.of("id", 1, "title", "Lập trình Microservices"),
            Map.of("id", 2, "title", "Spring Security Advanced")
    ));

    // GET /api/courses: Cần quyền COURSE_READ
    @GetMapping
    public ResponseEntity<?> getAllCourses() {
        return ResponseEntity.ok(courses);
    }

    // POST /api/courses: Cần quyền COURSE_WRITE
    @PostMapping
    public ResponseEntity<String> createCourse(@RequestBody Map<String, Object> newCourse) {
        courses.add(newCourse);
        return ResponseEntity.ok("Tạo khóa học thành công!");
    }
}
