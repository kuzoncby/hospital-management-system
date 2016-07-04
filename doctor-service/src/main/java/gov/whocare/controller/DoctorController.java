package gov.whocare.controller;

import gov.whocare.model.Doctor;
import gov.whocare.repository.DoctorRepository;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
