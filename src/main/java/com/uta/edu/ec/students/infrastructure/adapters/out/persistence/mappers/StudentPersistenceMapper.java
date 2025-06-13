package com.uta.edu.ec.students.infrastructure.adapters.out.persistence.mappers;

import com.uta.edu.ec.students.domain.Student;
import com.uta.edu.ec.students.infrastructure.adapters.out.persistence.student.StudentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentPersistenceMapper {

    Student toStudent(StudentEntity entity);
    StudentEntity toStudentEntity(Student student);

}
