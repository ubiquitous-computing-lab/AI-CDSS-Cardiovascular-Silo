package org.uclab.cdss.cardiovascular.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.uclab.cdss.cardiovascular.datamodel.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

	@Query("Select pp from Patient pp where pp.PatientMRNNo like CONCAT('%',:patientMRNNo,'%')")
    List<Patient> findByPatientMRNNoContaining(@Param("patientMRNNo") String patientMRNNo);
	
}
