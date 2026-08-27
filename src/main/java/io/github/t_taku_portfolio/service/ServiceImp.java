package io.github.t_taku_portfolio.service;

import io.github.t_taku_portfolio.model.StudentBodyDTO;
import io.github.t_taku_portfolio.repository.ConcreteRepository;

public class ServiceImp {
    StudentBodyDTO studentBodyDTO;
    ConcreteRepository concreteRepository;

    public ServiceImp(ConcreteRepository concreteRepository) {
        this.concreteRepository = concreteRepository;
        System.out.println("in constructor: " + getClass().getSimpleName());
    }

    public void setStudentBodyDTO(StudentBodyDTO studentBodyDTO) {
        this.studentBodyDTO = studentBodyDTO;
    }

    public boolean doSomething(){
        // toggle methods based on request method
        // currently single method only exists
        if(!saveStudent()) {
            System.out.println("save failed");
            return false;
        }
        return true;
    }

    boolean saveStudent(){
        return concreteRepository.save(studentBodyDTO);
    }

    StudentBodyDTO readStudent(){
        return null;
    }
}
