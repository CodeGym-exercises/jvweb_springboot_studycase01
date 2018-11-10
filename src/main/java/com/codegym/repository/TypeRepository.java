package com.codegym.repository;

import com.codegym.model.NoteType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends CrudRepository<NoteType,Integer> {
}
