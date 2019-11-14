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
@Table(name="tblPatientClinicalHistory")
public class PatientClinicalHistory {

	@Id
    @Column(name="PatientClinicalHistoryID")
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer PatientClinicalHistoryID;
	public Integer getPatientClinicalHistoryID() {
		return PatientClinicalHistoryID;
	}

	public void setPatientClinicalHistoryID(Integer patientClinicalHistoryID) {
		PatientClinicalHistoryID = patientClinicalHistoryID;
	}
	
	@Column(name="CAD")
	private Integer CAD;
	public Integer getCAD() {
		return CAD;
	}

	public void setCAD(Integer cAD) {
		CAD = cAD;
	}
	
	@Column(name="ArterialHypertension")
	private Integer ArterialHypertension;
	public Integer getArterialHypertension() {
		return ArterialHypertension;
	}

	public void setArterialHypertension(Integer arterialHypertension) {
		ArterialHypertension = arterialHypertension;
	}
	
	@Column(name="ExpositionToCardiotoxic")
	private Integer ExpositionToCardiotoxic;
	public Integer getExpositionToCardiotoxic() {
		return ExpositionToCardiotoxic;
	}

	public void setExpositionToCardiotoxic(Integer expositionToCardiotoxic) {
		ExpositionToCardiotoxic = expositionToCardiotoxic;
	}
	
	@Column(name="UseOfDiuretics")
	private Integer UseOfDiuretics;
	public Integer getUseOfDiuretics() {
		return UseOfDiuretics;
	}

	public void setUseOfDiuretics(Integer useOfDiuretics) {
		UseOfDiuretics = useOfDiuretics;
	}
	
	@Column(name="OrthopnoeaParoxysmal")
	private Integer OrthopnoeaParoxysmal;
	public Integer getOrthopnoeaParoxysmal() {
		return OrthopnoeaParoxysmal;
	}

	public void setOrthopnoeaParoxysmal(Integer orthopnoeaParoxysmal) {
		OrthopnoeaParoxysmal = orthopnoeaParoxysmal;
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
