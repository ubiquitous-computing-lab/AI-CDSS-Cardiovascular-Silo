package org.uclab.cdss.cardiovascular.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.uclab.cdss.cardiovascular.datamodel.Patient;


/**
 * Patient Service Interface
 * Patient Service
 * @author Taqdir Ali
 *
 */

public interface PatientService {

	public Patient addPatient(Patient objPatient);
    public Patient updatePatient(Patient objPatient);
    public List<Patient> listPatient(String patientMRNNo);
    public List<Patient> listPatient();
    public Patient getPatientById(int id);
    public String removePatient(int id);
}
