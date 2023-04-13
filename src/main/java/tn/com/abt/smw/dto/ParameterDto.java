package tn.com.abt.smw.dto;

public class ParameterDto {

	private String parameterId;
	private String parameterDesignation;

	public ParameterDto() {
	}

	public ParameterDto(String parameterId, String parameterDesignation) {
		this.parameterId = parameterId;
		this.parameterDesignation = parameterDesignation;
	}

	public String getParameterId() {
		return parameterId;
	}

	public String getParameterDesignation() {
		return parameterDesignation;
	}

	public void setParameterId(String parameterId) {
		this.parameterId = parameterId;
	}

	public void setParameterDesignation(String parameterDesignation) {
		this.parameterDesignation = parameterDesignation;
	}

}
