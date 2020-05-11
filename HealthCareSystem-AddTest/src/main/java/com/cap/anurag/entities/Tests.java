package com.cap.anurag.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "test_s9")
public class Tests {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String testId;
	private String testName;
	@ManyToOne
	@JoinColumn(name = "dgcentre_id")
	private DiagnosticCentre centre;

	private String centreName;

	public String getCentreName() {
		return centreName;
	}

	public void setCentreName(String centreName) {
		this.centreName = centreName;
	}

	public Tests() {

	}

	public DiagnosticCentre getCentre() {
		return centre;
	}

	public void setCentre(DiagnosticCentre centre) {
		this.centre = centre;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public Tests(String testName,DiagnosticCentre centreName) {
		super();
		this.testName = testName;
		this.centre = centreName;
		this.centreName = centreName.getCentreName();
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	@Override
	public String toString() {
		return "Tests [testId=" + testId + ", testName=" + testName + ", centre=" + centre + ", centreName="
				+ centreName + "]";
	}

}
