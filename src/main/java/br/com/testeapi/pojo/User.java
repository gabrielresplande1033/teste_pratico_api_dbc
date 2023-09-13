package br.com.testeapi.pojo;

public class User {
	private Integer id;
	private String createdAt;
	private String name;
	private String job;
	
	public Integer getId() {
		return id;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
}
