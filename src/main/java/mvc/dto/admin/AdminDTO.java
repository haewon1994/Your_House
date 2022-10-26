package mvc.dto.admin;

public class AdminDTO {
	
	private String adminId;
	private String adminPwd;
	
	
	public AdminDTO(String adminId, String adminPwd) {
		super();
		this.adminId = adminId;
		this.adminPwd = adminPwd;
	}


	public String getAdminId() {
		return adminId;
	}


	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}


	public String getAdminPwd() {
		return adminPwd;
	}


	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

	

}


