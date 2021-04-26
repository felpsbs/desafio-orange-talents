package br.com.fb.addresscontroller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fb.addresscontroller.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

}
