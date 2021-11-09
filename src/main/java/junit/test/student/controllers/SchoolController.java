package junit.test.student.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import junit.test.student.models.School;
import junit.test.student.services.SchoolService;

@RestController
public class SchoolController {
    @Autowired
    private SchoolService schoolService;
    @GetMapping("/schools")
    public List<School> getAllSchools() {
        return schoolService.getAllSchools();
    }

    @PostMapping("/schools")
    public void addSchool(@RequestBody School school) {
        schoolService.addSchool(school);
    }

    @PutMapping("/schools/{id}")
    public ResponseEntity<School> updateSchool(@RequestBody School school, @PathVariable Integer id) {
        return ResponseEntity.ok().body(schoolService.updateSchool(id, school));
    }
    @DeleteMapping("/schools/{id}")
    public void deleteSchool(@PathVariable Integer id) {
        schoolService.deleteSchool(id);
    }

}