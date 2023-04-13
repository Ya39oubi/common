package tn.com.abt.smw.dto;

public class ParameterMinimumAttributesDto {

	private String parameterId1;
	private String parameterDesignation1;
	private String parameterId2;
	private String parameterDesignation2;

	public ParameterMinimumAttributesDto() {
	}

	public ParameterMinimumAttributesDto(String parameterId1, String parameterDesignation1, String parameterId2,
			String parameterDesignation2) {
		this.parameterId1 = parameterId1;
		this.parameterDesignation1 = parameterDesignation1;
		this.parameterId2 = parameterId2;
		this.parameterDesignation2 = parameterDesignation2;
	}

	public String getParameterId1() {
		return parameterId1;
	}

	public String getParameterDesignation1() {
		return parameterDesignation1;
	}

	public String getParameterId2() {
		return parameterId2;
	}

	public String getParameterDesignation2() {
		return parameterDesignation2;
	}

	public void setParameterId1(String parameterId1) {
		this.parameterId1 = parameterId1;
	}

	public void setParameterDesignation1(String parameterDesignation1) {
		this.parameterDesignation1 = parameterDesignation1;
	}

	public void setParameterId2(String parameterId2) {
		this.parameterId2 = parameterId2;
	}

	public void setParameterDesignation2(String parameterDesignation2) {
		this.parameterDesignation2 = parameterDesignation2;
	}

}
