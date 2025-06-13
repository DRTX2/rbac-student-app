package com.uta.edu.ec.students.infrastructure.adapters.in.mappers;

import com.uta.edu.ec.students.domain.Student;
import com.uta.edu.ec.students.infrastructure.adapters.in.request.StudentRequest;
import com.uta.edu.ec.students.infrastructure.adapters.in.response.StudentResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentRestMapper {

    StudentResponse toStudentResponse(Student student);
    Student toStudent(StudentRequest studentRequest);
}
