package com.decagon.fintechpaymentapisqd11a.repositories;

import com.decagon.fintechpaymentapisqd11a.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findUsersById(Long UsersId);
}
