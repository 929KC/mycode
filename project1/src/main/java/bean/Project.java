package bean;

public class Project {
	private String projectId;
	private String projectName;
	private String deputyName;
	private String telephone;
	private String addr;
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Project(String projectId, String projectName, String deputyName, String telephone, String addr) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.deputyName = deputyName;
		this.telephone = telephone;
		this.addr = addr;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getDeputyName() {
		return deputyName;
	}
	public void setDeputyName(String deputyName) {
		this.deputyName = deputyName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}
