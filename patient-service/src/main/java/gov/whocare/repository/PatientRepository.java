package gov.whocare.repository;

import gov.whocare.model.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Kuzon on 2016/7/5.
 */
@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {

    Patient findByName(String name);

}
