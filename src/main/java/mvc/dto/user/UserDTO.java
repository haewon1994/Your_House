package mvc.dto.user;

public class UserDTO {
	
	private String user_code;
	private String email;
	private String password;
	private String birth;
	private String nickname;
	private String phone;
	private String adress;
	private String gender;
	private String reg_date;
	private String category_code;
	
	   public UserDTO() {}
	   public UserDTO(String email, String password) {
			super();
			this.email = email;
			this.password = password;
			
		}
		public UserDTO(String email, String password, String nickname) {
		super();
		this.email = email;
		this.password = password;
		this.nickname = nickname;
	}
	
	public UserDTO(String user_code, String email, String password, String birth, String nickname, String phone,
			String adress, String gender, String reg_date, String category_code) {
		super();
		this.user_code = user_code;
		this.email = email;
		this.password = password;
		this.birth = birth;
		this.nickname = nickname;
		this.phone = phone;
		this.adress = adress;
		this.gender = gender;
		this.reg_date = reg_date;
		this.category_code = category_code;
	}
	


	public String getUser_code() {
		return user_code;
	}

	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public String getCategory_code() {
		return category_code;
	}

	public void setCategory_code(String category_code) {
		this.category_code = category_code;
	}
   

}


