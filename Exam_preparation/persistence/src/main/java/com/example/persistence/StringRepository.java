package com.example.persistence;

import org.springframework.data.repository.CrudRepository;

public interface StringRepository extends CrudRepository<StringEntity, String> {    // Repository to save strings to!
    // Is communicating directly with the database!
}
