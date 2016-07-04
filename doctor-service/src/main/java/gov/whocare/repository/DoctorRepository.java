package gov.whocare.repository;

import gov.whocare.model.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Kuzon on 2016/7/4.
 */
@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long> {

    Doctor findByName(String name);

}
