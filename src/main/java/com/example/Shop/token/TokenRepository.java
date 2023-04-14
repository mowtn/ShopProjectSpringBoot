package com.example.Shop.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Integer> {

  @Query(value = "SELECT * FROM _token AS t INNER JOIN users AS u ON u.Id = :id WHERE (t.expired = false OR t.revoked = false)",
          nativeQuery = true
      )
  List<Token> findAllValidTokenByUser(Integer id);

  Optional<Token> findByToken(String token);
}
