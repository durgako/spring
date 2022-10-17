package com.secondspring.secondspring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface Myrepo extends JpaRepository<Employee, Long>
{

}
