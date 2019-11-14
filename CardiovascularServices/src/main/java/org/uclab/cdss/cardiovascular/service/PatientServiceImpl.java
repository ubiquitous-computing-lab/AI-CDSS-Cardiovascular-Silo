package org.uclab.cdss.cardiovascular.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.uclab.cdss.cardiovascular.datamodel.Patient;
import org.uclab.cdss.cardiovascular.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {
	
	private final PatientRepository repository;
	@Inject
    public PatientServiceImpl(final PatientRepository repository) {
        this.repository = repository;
    }

	@Override
	@Transactional
	public Patient addPatient(Patient objPatient) {
		try
		{
			Calendar calendar = Calendar.getInstance();
			Date todayDate = new Date(calendar.getTime().getTime());
			objPatient.setEncounterDate(todayDate);
	        return repository.save(objPatient);
		}
		catch(Exception ex)
		{
			return null;
		}
	}

	@Override
	@Transactional
	public Patient updatePatient(Patient objPatient) {
		try
		{
			Calendar calendar = Calendar.getInstance();
			Date todayDate = new Date(calendar.getTime().getTime());
			if(objPatient.getEncounterDate() == null)
			{ objPatient.setEncounterDate(todayDate); }
	
			repository.save(objPatient);
			return objPatient;
		}
		catch(Exception ex)
		{
			String a = ex.getMessage();
			return null;
		}
	}

	@Override
	public List<Patient> listPatient(String patientMRNNo) {
		try
		{
			List<Patient> objListPatient = new ArrayList<Patient>();
			objListPatient = repository.findByPatientMRNNoContaining(patientMRNNo);
			return objListPatient;
		}
		catch(Exception ex)
		{
			return null;
		}
	}

	@Override
	public List<Patient> listPatient() {
		try
		{
			List<Patient> objListPatient = new ArrayList<Patient>();
			objListPatient = repository.findAll();
			return objListPatient;
		}
		catch(Exception ex)
		{
			return null;
		}
	}

	@Override
	public Patient getPatientById(int id) {
		try
		{
			Patient objPatient = new Patient();
			objPatient = repository.findOne(id);
			return objPatient;
		}
		catch(Exception ex)
		{
			return null;
		}
	}

	@Override
	public String removePatient(int id) {
		try
		{
		    repository.delete(id);
		    return "{ \"message\" : \"Patient profile deleted successfuly\" }";
		}
		catch(Exception ex)
		{
			return "{ \"message\" : \"Error occured in Patient profile deleting\" }";
		}
	}

}
