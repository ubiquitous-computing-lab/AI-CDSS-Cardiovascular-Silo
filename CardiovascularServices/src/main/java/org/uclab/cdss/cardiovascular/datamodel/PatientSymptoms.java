package org.uclab.cdss.cardiovascular.datamodel;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author Taqdir Ali
 *
 */
@Entity
@Table(name="tblPatientSymptoms")
public class PatientSymptoms {

	@Id
    @Column(name="PatientSymptomID")
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer PatientSymptomID;
	public Integer getPatientSymptomID() {
		return PatientSymptomID;
	}

	public void setPatientSymptomID(Integer patientSymptomID) {
		PatientSymptomID = patientSymptomID;
	}
	
	
	
	
	@Column(name="Breathlessness")
	private Integer Breathlessness;
	public Integer getBreathlessness() {
		return Breathlessness;
	}

	public void setBreathlessness(Integer breathlessness) {
		Breathlessness = breathlessness;
	}
	
	@Column(name="Orthopnoea")
	private Integer Orthopnoea;
	public Integer getOrthopnoea() {
		return Orthopnoea;
	}

	public void setOrthopnoea(Integer orthopnoea) {
		Orthopnoea = orthopnoea;
	}
	
	@Column(name="PND")
	private Integer PND;
	public Integer getPND() {
		return PND;
	}

	public void setPND(Integer pND) {
		PND = pND;
	}
	
	@Column(name="ReducedExerciseTolerance")
	private Integer ReducedExerciseTolerance;
	public Integer getReducedExerciseTolerance() {
		return ReducedExerciseTolerance;
	}

	public void setReducedExerciseTolerance(Integer reducedExerciseTolerance) {
		ReducedExerciseTolerance = reducedExerciseTolerance;
	}
	
	@Column(name="Fatigue")
	private Integer Fatigue;
	public Integer getFatigue() {
		return Fatigue;
	}

	public void setFatigue(Integer fatigue) {
		Fatigue = fatigue;
	}
	
	@Column(name="Tiredness")
	private Integer Tiredness;
	public Integer getTiredness() {
		return Tiredness;
	}

	public void setTiredness(Integer tiredness) {
		Tiredness = tiredness;
	}
	
	@Column(name="AnkleSwelling")
	private Integer AnkleSwelling;
	public Integer getAnkleSwelling() {
		return AnkleSwelling;
	}

	public void setAnkleSwelling(Integer ankleSwelling) {
		AnkleSwelling = ankleSwelling;
	}
	
	
	
	@Column(name="EncounterDate")
	private Date EncounterDate;
	public Date getEncounterDate() {
		return EncounterDate;
	}

	public void setEncounterDate(Date encounterDate) {
		EncounterDate = encounterDate;
	}
	
	@ManyToOne(targetEntity = Patient.class)
	@JoinColumn(name="PatientID")
	@JsonBackReference
	private Patient patient;
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
}
