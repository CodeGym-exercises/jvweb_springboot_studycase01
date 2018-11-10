package com.codegym.repository;

import com.codegym.model.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends PagingAndSortingRepository<Note,Integer> {
}
