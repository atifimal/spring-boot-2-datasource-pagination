package com.atifimal.demo.stuff.repository;

import com.atifimal.demo.stuff.entity.Stuff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StuffRepository extends JpaRepository<Stuff, Long> {
}
