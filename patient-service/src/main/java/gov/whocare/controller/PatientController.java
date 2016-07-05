package gov.whocare.controller;

import gov.whocare.model.Patient;
import gov.whocare.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Kuzon on 2016/7/5.
 */
@RestController
public class PatientController {

    @Autowired
    private PatientRepository repository;

    @RequestMapping(value = "/")
    public String getPatient() {
        return "Patient API";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Iterable<Patient> getPatient(@RequestBody Patient patient) {
        return repository.findAll();
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public Patient getOnePatient(@RequestBody Patient patient) {
        return repository.findOne(new Long(patient.getId()));
    }

    @RequestMapping(value = " /{patient_id}")
    public Patient getOnePatient(@PathVariable long patient_id) {
        return repository.findOne(patient_id);
    }

}
