package com.cinema.demo.repositories;

import com.cinema.demo.enteties.Role;
;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository  extends JpaRepository<Role,Integer> {


}
