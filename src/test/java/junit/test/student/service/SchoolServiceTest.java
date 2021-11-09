package junit.test.student.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import junit.test.student.services.SchoolService;
import junit.test.student.models.School;
import junit.test.student.repositories.SchoolRepository;

@RunWith(MockitoJUnitRunner.class)
public class SchoolServiceTest {
    @Mock
    private SchoolRepository schoolRepositoryMock;

    @InjectMocks
    private SchoolService schoolService;

    @Test
    public void createNewSchool_withElements(){
        School school = new School();
        school.setName("Test School Name");
        school.setPrinciple("Test School Principle");
        school.setAddress("Test School Address");
        when(schoolRepositoryMock.save(ArgumentMatchers.any(School.class))).thenReturn(school);
        School schoolCreated = schoolService.addSchool(school);
        assertEquals(schoolCreated.getName(), school.getName());
        verify(schoolRepositoryMock).save(school);
    }

    @Test
    public void getAll_withSomeElements(){
        List<School> schools = new ArrayList();
        schools.add(new School());
        given(schoolRepositoryMock.findAll()).willReturn(schools);
        assertEquals(schoolService.getAllSchools(), schools);
        verify(schoolRepositoryMock).findAll();
    }

    @Test
    public void update_withId(){
        School school = new School();
        school.setId(7);
        school.setName("Test School Name");
        School newSchool = new School();
        school.setName("New Test School Name");
        given(schoolRepositoryMock.findById(school.getId())).willReturn(Optional.of(school));
        schoolService.updateSchool(school.getId(), newSchool);
        verify(schoolRepositoryMock).save(newSchool);
        verify(schoolRepositoryMock).findById(school.getId());
    }

    @Test
    public void delete_withId(){
        School school = new School();
        school.setName("Test School Name");;
        school.setId(1);
        when(schoolRepositoryMock.findById(school.getId())).thenReturn(Optional.of(school));
        schoolService.deleteSchool(school.getId());
        verify(schoolRepositoryMock).deleteById(school.getId());
    }
//    @Test
//    public void findById() {
//        School school = new School();
//        school.setId(4);
//        when(schoolRepositoryMock.findById(school.getId())).thenReturn(Optional.of(school));
//        assertEquals(schoolService.findById(school.getId()), school);
//        verify(schoolRepositoryMock).findById(school.getId());
//
//    }
}
