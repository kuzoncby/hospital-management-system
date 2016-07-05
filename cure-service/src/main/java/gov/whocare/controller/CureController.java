package gov.whocare.controller;

import gov.whocare.model.Cure;
import gov.whocare.model.Doctor;
import gov.whocare.model.Patient;
import gov.whocare.repository.DoctorRepository;
import gov.whocare.repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * Created by Kuzon on 2016/7/5.
 */
@RestController
public class CureController {

    private static final Logger logger = LoggerFactory.getLogger(CureController.class);

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    // /cure/{patient_id}
    @RequestMapping(value = "{patient_id}")
    public Set<Cure> getCure(@PathVariable Long patient_id, Model model) {
        Patient patient = patientRepository.findOne(patient_id);
        logger.info(patient.toString());
        return patient.getCures();
    }

}
