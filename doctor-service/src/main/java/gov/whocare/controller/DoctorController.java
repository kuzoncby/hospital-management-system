package gov.whocare.controller;

import gov.whocare.model.Doctor;
import gov.whocare.model.Patient;
import gov.whocare.repository.DoctorRepository;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

/**
 * Created by Kuzon on 2016/7/4.
 */
@RestController
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @RequestMapping(value = "/")
    public String getDoctor() {
        return "Doctor API";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Doctor getDoctor(@RequestBody Doctor doctor) {
        Doctor d = repository.findByName(doctor.getName());
        if (d.equals(null)) {
            return null;
        } else {
            return d;
        }
    }

    @RequestMapping(value = "/{doctor_id}")
    public Doctor getOneDoctor(@PathVariable long doctor_id) {
        return repository.findOne(doctor_id);
    }

    @RequestMapping(value = "/{doctor_id}/patients")
    public Set<Patient> getPatients(@PathVariable long doctor_id){
        Doctor doctor = repository.findOne(doctor_id);
        return doctor.getPatients();
    }

}
