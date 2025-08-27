package com.nikita.app.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.nikita.app.models.Person;

@Component
public class PersonDAO {
  private static int PEOPLE_COUNT;
  private static final String URL = "jdbc:postgresql://localhost:5432/Java_DB";
  private static final String USERNAME = "postgres";
  private static final String PASSWORD = "2124648306fF";

  private static Connection connection;

  static {
    try {
      Class.forName("org.postgresql.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    try {
      connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  public List<Person> index() {
    List<Person> people = new ArrayList<>();
    try {
      Statement statement = connection.createStatement();
      String SQL = "SELECT * FROM Person";
      ResultSet resultSet = statement.executeQuery(SQL);

      while (resultSet.next()) {
        Person person = new Person();

        person.setId(resultSet.getInt("id"));
        person.setName(resultSet.getString("name"));
        person.setAge(resultSet.getInt("age"));
        person.setEmail(resultSet.getString("email"));

        people.add(person);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
    return people;

  }

  public Person show(int id) {
    // return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    return null;
  }

  public void save(Person person) {
    try {
      Statement statement = connection.createStatement();
      String SQL = "INSERT INTO Person VALUES (" + 1 + ", '" + person.getName() + "', " + person.getAge() + ", '" + person.getEmail() + "')";

      statement.executeUpdate(SQL);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void update(int id, Person updatedPerson) {
    // Person personToBeUpdated = show(id);
    // personToBeUpdated.setName(updatedPerson.getName());
    // personToBeUpdated.setAge(updatedPerson.getAge());
    // personToBeUpdated.setEmail(updatedPerson.getEmail());
  }

  public void delete(int id) {
    // people.removeIf(person -> person.getId() == id);
  }
}