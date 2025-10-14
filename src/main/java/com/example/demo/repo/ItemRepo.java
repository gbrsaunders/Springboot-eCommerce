package com.example.demo.repo;

import com.example.demo.model.Account;
import com.example.demo.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ItemRepo extends JpaRepository<Item,Integer> {
    Optional<Item> findById(int ID);

}
