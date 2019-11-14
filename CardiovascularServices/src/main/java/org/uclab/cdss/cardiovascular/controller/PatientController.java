package org.uclab.cdss.cardiovascular.controller;



import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.uclab.cdss.cardiovascular.datamodel.Patient;
import org.uclab.cdss.cardiovascular.service.PatientService;

import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin
@RestController
@EnableAutoConfiguration
@Component
public class PatientController {

	@Autowired
	private PatientService objPatientService;
	
	@CrossOrigin
    @RequestMapping(value = "/AddPatient", method = RequestMethod.POST)
    public Patient createPatientProfile(@RequestBody @Valid final Patient objPatient) {
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			System.out.println(mapper.writeValueAsString(objPatient));
			return objPatientService.addPatient(objPatient);
		}
		catch(Exception ex)
		{
			return objPatient;
		}
    }
	
	@CrossOrigin
    @RequestMapping(value = "/UpdatePatient", method = RequestMethod.POST)
    public Patient updatePatient(@RequestBody @Valid final Patient objPatient) {
		
		try
		{
			 return objPatientService.updatePatient(objPatient);
		}
		catch(Exception ex)
		{
			return objPatient;
		}
       
    }
	
	@CrossOrigin
    @RequestMapping(value = "/getPatient/{patientID}", method = RequestMethod.GET)
    public @ResponseBody Patient getPatient(@PathVariable("patientID") int patientID) {
		try
		{
			return objPatientService.getPatientById(patientID);
		}
		catch(Exception ex)
		{
			return null;
		}
    }
    
	@CrossOrigin
    @RequestMapping(value = "/getPatientList", method = RequestMethod.GET)
    public @ResponseBody List<Patient> getPatientList() {
		try
		{
			return objPatientService.listPatient();
		}
		catch(Exception ex)
		{
			return null;
		}
    }
    
	@CrossOrigin
    @RequestMapping(value = "/getPatientList/{patientMRNNo}", method = RequestMethod.GET)
    public @ResponseBody List<Patient> getPatientList(@PathVariable("patientMRNNo") String patientMRNNo) {
		try
		{
			System.out.println(patientMRNNo);
	    	return objPatientService.listPatient(patientMRNNo);
		}
		catch(Exception ex)
		{
			return null;
		}
    }
    
	@CrossOrigin
    @RequestMapping(value = "/deletePatient/{patientID}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody String deletePatient(@PathVariable("patientID") int patientID) {
    	return objPatientService.removePatient(patientID);
    }
	
}
