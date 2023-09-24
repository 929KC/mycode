package com.example.demo7.mapper;

import com.example.demo7.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PersonRepository extends CrudRepository<Person,String> {
    List<Person> findByLastName(String lastName);
    Page<Person> findPersonsByLastName(String lastName, Pageable page);
    List<Person> findByAddress_city(String city);
    List<Person> findByFirstNameAndLastName(String firstName, String lastName);
    List<Person> findByFamilyListUsername(String username);

}
