package br.com.fb.addresscontroller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fb.addresscontroller.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

}
