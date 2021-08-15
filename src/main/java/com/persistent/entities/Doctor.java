package com.persistent.entities;
import javax.persistence.*;

@Entity
public class Doctor extends Person {
	
	    @Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
	    
		private String licenseNo;
		
        private String speciality;
        
        private String university_name;
        
        private Integer experience;
        
        private String organisation_name;
        
        private Integer consultation_fee;
        
        private String verification;
        

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "addressId", referencedColumnName = "id")
        private Address address;

		
		public Doctor(String userName, String fName, String lName, String contactNo, int id, String licenseNo,
				String speciality, String university_name, Integer experience, String organisation_name,
				Integer consultation_fee, String verification, Address address) {
			super(userName, fName, lName, contactNo);
			this.id = id;
			this.licenseNo = licenseNo;
			this.speciality = speciality;
			this.university_name = university_name;
			this.experience = experience;
			this.organisation_name = organisation_name;
			this.consultation_fee = consultation_fee;
			this.verification = verification;
			this.address = address;
		}

		public Doctor() {
			super();
			// TODO Auto-generated constructor stub
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getLicenseNo() {
			return licenseNo;
		}

		public void setLicenseNo(String licenseNo) {
			this.licenseNo = licenseNo;
		}

		public String getSpeciality() {
			return speciality;
		}

		public void setSpeciality(String speciality) {
			this.speciality = speciality;
		}

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}
		
		public String getUniversity_name() {
			return university_name;
		}

		public void setUniversity_name(String university_name) {
			this.university_name = university_name;
		}

		public Integer getExperience() {
			return experience;
		}

		public void setExperience(Integer experience) {
			this.experience = experience;
		}

		public String getOrganisation_name() {
			return organisation_name;
		}

		public void setOrganisation_name(String organisation_name) {
			this.organisation_name = organisation_name;
		}

		public Integer getConsultation_fee() {
			return consultation_fee;
		}

		public void setConsultation_fee(Integer consultation_fee) {
			this.consultation_fee = consultation_fee;
		}

		public String getVerification() {
			return verification;
		}

		public void setVerification(String verification) {
			this.verification = verification;
		}

		@Override
		public String toString() {
			return "Doctor [id=" + id + ", licenseNo=" + licenseNo + ", speciality=" + speciality + ", university_name="
					+ university_name + ", experience=" + experience + ", organisation_name=" + organisation_name
					+ ", consultation_fee=" + consultation_fee + ", verification=" + verification + ", address="
					+ address + "]";
		}

				
        
        
}
