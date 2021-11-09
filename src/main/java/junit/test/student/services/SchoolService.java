package junit.test.student.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import junit.test.student.models.School;
import junit.test.student.repositories.SchoolRepository;

@Service
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }
    public School addSchool(School school) {
        return schoolRepository.save(school);
    }

    public void deleteSchool(Integer id) {
        schoolRepository.findById(id);
        schoolRepository.deleteById(id);
    }

    public School updateSchool(Integer id, School school) {
        schoolRepository.findById(id);
        school.setId(id);
        return schoolRepository.save(school);
    }

    public Optional<School> findById(Integer id) {
        return schoolRepository.findById(id);
    }
}
