package model;



	public class Developer extends Person {
		
		private String developerKey;

		public String toString() {
			return super.getId() + " " + super.getUsername() + " " + this.developerKey ;
		}
		
		public Developer() {
			super();
		}

		public Developer(int id, String firstName, String lastName, String username, String password, String email,
				String dob, String developerKey) {
			super(id, firstName, lastName, username, password, email, dob);
			this.developerKey = developerKey;
		}

		public String getDeveloperKey() {
			return developerKey;
		}

		public void setDeveloperKey(String developerKey) {
			this.developerKey = developerKey;
		}
		
	}

