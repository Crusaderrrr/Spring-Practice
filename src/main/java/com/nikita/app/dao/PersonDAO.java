package com.nikita.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.nikita.app.models.Person;

@Component
public class PersonDAO {
  private List<Person> people;
  private static int PEOPLE_COUNT;

  {
    people = new ArrayList<>();

    people.add(new Person(++PEOPLE_COUNT, "Tom", 24, "tom@mail.ru"));
    people.add(new Person(++PEOPLE_COUNT, "Bob", 52, "bob@mail.ru"));
    people.add(new Person(++PEOPLE_COUNT, "Mike", 15, "mike@mail.ru"));
    people.add(new Person(++PEOPLE_COUNT, "Katy", 38, "katy@mail.ru"));
  } 

  public List<Person> index() {
    return people;
  }

  public Person show(int id) {
    return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
  }

  public void save(Person person) {
    people.add(person);
    person.setId(++PEOPLE_COUNT);
  }

  public void update(int id, Person updatedPerson) {
    Person personToBeUpdated = show(id);
    personToBeUpdated.setName(updatedPerson.getName());
    personToBeUpdated.setAge(updatedPerson.getAge());
    personToBeUpdated.setEmail(updatedPerson.getEmail());
  }

  public void delete(int id) {
    people.removeIf(person -> person.getId() == id);
  }
}