package com.selvigtech.blog.model.dao;

import com.selvigtech.blog.model.LocalUser;
import com.selvigtech.blog.model.VerificationToken;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface VerificationTokenDAO extends ListCrudRepository<VerificationToken, Long> {
    Optional<VerificationToken> findByToken(String token);

    void deleteByUser(LocalUser user);
}
