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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author Taqdir Ali
 *
 */
@Entity
@Table(name="tblPatient")
public class Patient {
	
	@Id
    @Column(name="PatientID")
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer PatientID;
	public Integer getPatientID() {
		return PatientID;
	}

	public void setPatientID(Integer patientID) {
		PatientID = patientID;
	}
	
	@Column(name="PatientMRNNo")
	private String PatientMRNNo;
	public String getPatientMRNNo() {
		return PatientMRNNo;
	}

	public void setPatientMRNNo(String patientMRNNo) {
		PatientMRNNo = patientMRNNo;
	}

	@Column(name="PatientName")
	private String PatientName;
	public String getPatientName() {
		return PatientName;
	}

	public void setPatientName(String patientName) {
		PatientName = patientName;
	}
	
	@Column(name="DateOfBirth")
	private Date DateOfBirth;
	public Date getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	
	@Column(name="Age")
	private Integer Age;
	
	public Integer getAge() {
		return Age;
	}

	public void setAge(Integer age) {
		Age = age;
	}

	@Column(name="Gender")
	private String Gender;
	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}
	
	@Column(name="SymptomsAndSigns")
	private Integer SymptomsAndSigns;
	public Integer getSymptomsAndSigns() {
		return SymptomsAndSigns;
	}

	public void setSymptomsAndSigns(Integer symptomsAndSigns) {
		SymptomsAndSigns = symptomsAndSigns;
	}
	
	@Column(name="ClinicalHistory")
	private Integer ClinicalHistory;
	public Integer getClinicalHistory() {
		return ClinicalHistory;
	}

	public void setClinicalHistory(Integer clinicalHistory) {
		ClinicalHistory = clinicalHistory;
	}
	
	@Column(name="PhysicalExam")
	private Integer PhysicalExam;
	public Integer getPhysicalExam() {
		return PhysicalExam;
	}

	public void setPhysicalExam(Integer physicalExam) {
		PhysicalExam = physicalExam;
	}
	
	@Column(name="ECG")
	private Integer ECG;
	public Integer getECG() {
		return ECG;
	}

	public void setECG(Integer eCG) {
		ECG = eCG;
	}
	
	@Column(name="NTproBNP")
	private Float NTproBNP;
	public Float getNTproBNP() {
		return NTproBNP;
	}

	public void setNTproBNP(Float nTproBNP) {
		NTproBNP = nTproBNP;
	}
	
	@Column(name="BNP")
	private Float BNP;
	public Float getBNP() {
		return BNP;
	}

	public void setBNP(Float bNP) {
		BNP = bNP;
	}
	
	@Column(name="LVEF")
	private Float LVEF;
	public Float getLVEF() {
		return LVEF;
	}

	public void setLVEF(Float lVEF) {
		LVEF = lVEF;
	}
	
	@Column(name="LAVI")
	private Float LAVI;
	public Float getLAVI() {
		return LAVI;
	}

	public void setLAVI(Float lAVI) {
		LAVI = lAVI;
	}
	
	@Column(name="LVMI")
	private Float LVMI;
	public Float getLVMI() {
		return LVMI;
	}

	public void setLVMI(Float lVMI) {
		LVMI = lVMI;
	}
	
	@Column(name="Ee")
	private Float Ee;
	public Float getEe() {
		return Ee;
	}

	public void setEe(Float ee) {
		Ee = ee;
	}
	
	@Column(name="eSeptal")
	private Float eSeptal;
	public Float geteSeptal() {
		return eSeptal;
	}

	public void seteSeptal(Float eSeptal) {
		this.eSeptal = eSeptal;
	}
	
	@Column(name="LongitudinalStrain")
	private Float LongitudinalStrain;
	public Float getLongitudinalStrain() {
		return LongitudinalStrain;
	}

	public void setLongitudinalStrain(Float longitudinalStrain) {
		LongitudinalStrain = longitudinalStrain;
	}
	
	@Column(name="TRV")
	private Float TRV;
	public Float getTRV() {
		return TRV;
	}

	public void setTRV(Float tRV) {
		TRV = tRV;
	}
	
	@Column(name="EncounterDate")
	private Date EncounterDate;
	public Date getEncounterDate() {
		return EncounterDate;
	}

	public void setEncounterDate(Date encounterDate) {
		EncounterDate = encounterDate;
	}
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="PatientID")
	@JsonManagedReference
	private List<PatientSymptoms> patientSymptomsList = new ArrayList<PatientSymptoms>();
	public List<PatientSymptoms> getPatientSymptomsList() {
		return patientSymptomsList;
	}

	public void setPatientSymptomsList(List<PatientSymptoms> patientSymptomsList) {
		this.patientSymptomsList = patientSymptomsList;
	}
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="PatientID")
	@JsonManagedReference
	private List<PatientClinicalHistory> patientClinicalHistoryList = new ArrayList<PatientClinicalHistory>();
	public List<PatientClinicalHistory> getPatientClinicalHistoryList() {
		return patientClinicalHistoryList;
	}

	public void setPatientClinicalHistoryList(List<PatientClinicalHistory> patientClinicalHistoryList) {
		this.patientClinicalHistoryList = patientClinicalHistoryList;
	}
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="PatientID")
	@JsonManagedReference
	private List<PatientPhysicalExam> patientPhysicalExamList = new ArrayList<PatientPhysicalExam>();
	public List<PatientPhysicalExam> getPatientPhysicalExamList() {
		return patientPhysicalExamList;
	}

	public void setPatientPhysicalExamList(List<PatientPhysicalExam> patientPhysicalExamList) {
		this.patientPhysicalExamList = patientPhysicalExamList;
	}

}
