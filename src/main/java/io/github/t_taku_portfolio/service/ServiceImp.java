package io.github.t_taku_portfolio.service;

import io.github.t_taku_portfolio.model.StudentBodyDTO;
import io.github.t_taku_portfolio.repository.ConcreteRepository;

public class ServiceImp {
    StudentBodyDTO studentBodyDTO;
    ConcreteRepository concreteRepository;

    public ServiceImp(ConcreteRepository concreteRepository) {
        this.concreteRepository = concreteRepository;
    }

    public void setStudentBodyDTO(StudentBodyDTO studentBodyDTO) {
        this.studentBodyDTO = studentBodyDTO;
    }

    public void doSomething(){
        // toggle methods based on request method
        // currently single method only exists
        saveStudent();
    }

    void saveStudent(){
        concreteRepository.save(studentBodyDTO);
    }

    StudentBodyDTO readStudent(){
        return null;
    }
}
