package sushil.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sushil.test.entity.Industry;


@Repository
public interface IndustryRepo extends JpaRepository<Industry, Long> {

}
