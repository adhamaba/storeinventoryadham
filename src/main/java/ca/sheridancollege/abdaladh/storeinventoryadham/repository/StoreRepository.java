package ca.sheridancollege.abdaladh.storeinventoryadham.repository;

import ca.sheridancollege.abdaladh.storeinventoryadham.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
}
