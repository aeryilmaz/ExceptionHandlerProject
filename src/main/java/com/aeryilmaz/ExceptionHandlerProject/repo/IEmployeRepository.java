package com.aeryilmaz.ExceptionHandlerProject.repo;

import com.aeryilmaz.ExceptionHandlerProject.entity.Employe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeRepository extends CrudRepository<Employe,Long> {
}
