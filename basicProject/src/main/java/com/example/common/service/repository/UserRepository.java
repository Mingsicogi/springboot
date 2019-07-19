package com.example.common.service.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.common.vo.Usera;

/**
 * user repository
 *
 * @author minseok
 */
public interface UserRepository extends CrudRepository<Usera, Integer> {
}
