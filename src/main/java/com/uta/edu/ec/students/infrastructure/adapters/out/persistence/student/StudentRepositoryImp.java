package com.uta.edu.ec.students.infrastructure.adapters.out.persistence.student;

import com.uta.edu.ec.students.application.out.StudentRepository;
import com.uta.edu.ec.students.domain.Student;
import com.uta.edu.ec.students.infrastructure.adapters.out.persistence.mappers.StudentPersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class StudentRepositoryImp implements StudentRepository {

    private final StudentRepositoryJpa studentRepositoryJpa;
    private final StudentPersistenceMapper mapper;

    @Override
    public List<Student> findAll() {
        return  studentRepositoryJpa
                .findAll()
                .stream()
                .map(mapper::toStudent)
                .toList();
    }

    @Override
    public Optional<Student> findByDni(String dni) {
        return studentRepositoryJpa
                .findById(dni)
                .map(mapper::toStudent);
    }

    @Override
    public Student save(Student student) {
        StudentEntity entity = mapper.toStudentEntity(student);
        return mapper.toStudent(studentRepositoryJpa.save(entity));
    }

    @Override
    public void deleteByDni(String dni) {
        studentRepositoryJpa.deleteById(dni);
    }

    @Override
    public List<Student> findByDniContaining(String dni) {
        return studentRepositoryJpa
                .findByDniContaining(dni)
                .stream()
                .map(mapper::toStudent)
                .toList();
    }
}
