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
@Table(name="tblPatientPhysicalExam")
public class PatientPhysicalExam {

	@Id
    @Column(name="PatientPhysicalExamID")
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer PatientPhysicalExamID;
	
	public Integer getPatientPhysicalExamID() {
		return PatientPhysicalExamID;
	}

	public void setPatientPhysicalExamID(Integer patientPhysicalExamID) {
		PatientPhysicalExamID = patientPhysicalExamID;
	}

	@Column(name="Rales")
	private Integer Rales;
	
	public Integer getRales() {
		return Rales;
	}

	public void setRales(Integer rales) {
		Rales = rales;
	}

	@Column(name="BilateralAnkleEdema")
	private Integer BilateralAnkleEdema;
	
	public Integer getBilateralAnkleEdema() {
		return BilateralAnkleEdema;
	}

	public void setBilateralAnkleEdema(Integer bilateralAnkleEdema) {
		BilateralAnkleEdema = bilateralAnkleEdema;
	}

	@Column(name="HeartMurmur")
	private Integer HeartMurmur;
	
	public Integer getHeartMurmur() {
		return HeartMurmur;
	}

	public void setHeartMurmur(Integer heartMurmur) {
		HeartMurmur = heartMurmur;
	}

	@Column(name="JugularVenousDilatation")
	private Integer JugularVenousDilatation;
	
	public Integer getJugularVenousDilatation() {
		return JugularVenousDilatation;
	}

	public void setJugularVenousDilatation(Integer jugularVenousDilatation) {
		JugularVenousDilatation = jugularVenousDilatation;
	}

	@Column(name="LaterallyDisplacedApical")
	private Integer LaterallyDisplacedApical;
	
	public Integer getLaterallyDisplacedApical() {
		return LaterallyDisplacedApical;
	}

	public void setLaterallyDisplacedApical(Integer laterallyDisplacedApical) {
		LaterallyDisplacedApical = laterallyDisplacedApical;
	}
	
	@Column(name="ElevatedJVP")
	private Integer ElevatedJVP;
	public Integer getElevatedJVP() {
		return ElevatedJVP;
	}

	public void setElevatedJVP(Integer elevatedJVP) {
		ElevatedJVP = elevatedJVP;
	}
	
	@Column(name="S3")
	private Integer S3;
	public Integer getS3() {
		return S3;
	}

	public void setS3(Integer s3) {
		S3 = s3;
	}
	
	@Column(name="NocternalCough")
	private Integer NocternalCough;
	public Integer getNocternalCough() {
		return NocternalCough;
	}

	public void setNocternalCough(Integer nocternalCough) {
		NocternalCough = nocternalCough;
	}
	
	@Column(name="Impulse")
	private Integer Impulse;
	public Integer getImpulse() {
		return Impulse;
	}

	public void setImpulse(Integer impulse) {
		Impulse = impulse;
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
