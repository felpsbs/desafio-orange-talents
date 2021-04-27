package br.com.fb.addresscontroller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fb.addresscontroller.domain.Address;
import br.com.fb.addresscontroller.domain.User;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

	@Transactional(readOnly = true)
	List<Address> findByUser(User user);
	
}
