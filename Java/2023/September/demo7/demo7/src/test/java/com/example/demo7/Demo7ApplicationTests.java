package com.example.demo7;

import com.example.demo7.mapper.PersonRepository;
import com.example.demo7.model.Address;
import com.example.demo7.model.Family;
import com.example.demo7.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class Demo7ApplicationTests {
    @Resource
    private PersonRepository personRepository;

    @Test
    void savePseron() {
        List<Family> families = new ArrayList<Family>();
        Family family1 = Family.builder().type("弟弟").userName("叶子秋").build();
        Family family2 = Family.builder().type("父亲").userName("叶知秋").build();
        families.add(family1);
        families.add(family2);
        Address address = Address.builder().city("长沙").country("China").build();
        Person person = Person.builder().firstName("叶").lastName("秋涵").address(address).families(families).build();
        personRepository.save(person);
        System.out.println(person);
    }
    @Test
    void selectPerson() {
        List<Person> list = personRepository.findByAddress_city("长沙");
        System.out.println(list);
    }

    @Test
    void updatePerson() {
        Person person = personRepository.findByFirstNameAndLastName("叶", "秋涵").get(0);
        person.setLastName("哈哈哈哈");
        Person update = personRepository.save(person);
        System.out.println(update);
    }

    @Test
    void deletePerson() {
        Person person = personRepository.findByFirstNameAndLastName("叶", "哈哈哈哈").get(0);
        System.out.println(person);
    }
}
