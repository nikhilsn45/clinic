package com.persistent.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserInfo {
	
	        @Id
			@GeneratedValue(strategy=GenerationType.IDENTITY)
			private int id;
	        
	        private String user_name;
			
	        private String f_name;
			
			private String l_name;
			
	        private String email_id;
	        
            private String contact_no;
			
			public UserInfo() {
			}

			public UserInfo(int id, String user_name, String f_name, String l_name, String email_id, String contact_no) {
				this.id = id;
				this.user_name = user_name;
				this.f_name = f_name;
				this.l_name = l_name;
				this.email_id = email_id;
				this.contact_no = contact_no;
			}

			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public String getF_name() {
				return f_name;
			}

			public void setF_name(String f_name) {
				this.f_name = f_name;
			}

			public String getL_name() {
				return l_name;
			}

			public void setL_name(String l_name) {
				this.l_name = l_name;
			}

			public String getEmail_id() {
				return email_id;
			}

			public void setEmail_id(String email_id) {
				this.email_id = email_id;
			}

			public String getContact_no() {
				return contact_no;
			}

			public void setContact_no(String contact_no) {
				this.contact_no = contact_no;
			}

			public String getUser_name() {
				return user_name;
			}

			public void setUser_name(String user_name) {
				this.user_name = user_name;
			}

			@Override
			public String toString() {
				return "UserInfo [id=" + id + ", user_name=" + user_name + ", f_name=" + f_name + ", l_name=" + l_name
						+ ", email_id=" + email_id + ", contact_no=" + contact_no + "]";
			}

}
