package sushil.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sushil.test.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
