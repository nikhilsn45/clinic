package com.persistent.entities;
import javax.persistence.*;

@Entity
public class Doctor extends Person {
	
	    @Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
	    
		private String licenseNo;
		
        private String speciality;
        
        //private String University_name;
        
        //private int experience;
        
        //private String Organisation_name;
        
        //private String phone_num;
        
        //private int consultation_fee;
        

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "addressId", referencedColumnName = "id")
        private Address address;

		public Doctor(String userName, String fName, String lName, String contactNo, int id,
				String licenseNo, String speciality, Address address2) {
			super(userName, fName, lName, contactNo);
			this.id = id;
			this.licenseNo = licenseNo;
			this.speciality = speciality;
			address = address2;
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

		@Override
		public String toString() {
			return "Doctor [id=" + id + ", licenseNo=" + licenseNo + ", speciality=" + speciality + ", address="
					+ address + "]";
		}
        
        
}
