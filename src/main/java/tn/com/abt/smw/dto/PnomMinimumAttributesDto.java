package tn.com.abt.smw.dto;

public class PnomMinimumAttributesDto {

	private Long idnom;
	private String cnom;
	private String cacc;
	private String lib1;
	private String lib2;
	private Long mnt1;
	private Long mnt2;
	private Double tau1;
	private Double tau2;

	public PnomMinimumAttributesDto() {
	}

	public PnomMinimumAttributesDto(Long idnom, String cnom, String cacc, String lib1, String lib2, Long mnt1, Long mnt2, Double tau1,
			Double tau2) {
		this.idnom = idnom;
		this.cnom = cnom;
		this.cacc = cacc;
		this.lib1 = lib1;
		this.lib2 = lib2;
		this.mnt1 = mnt1;
		this.mnt2 = mnt2;
		this.tau1 = tau1;
		this.tau2 = tau2;
	}

	public Long getIdnom() {
		return idnom;
	}

	public void setIdnom(Long idnom) {
		this.idnom = idnom;
	}

	public String getCnom() {
		return cnom;
	}

	public void setCnom(String cnom) {
		this.cnom = cnom;
	}

	public String getCacc() {
		return cacc;
	}

	public void setCacc(String cacc) {
		this.cacc = cacc;
	}

	public String getLib1() {
		return lib1;
	}

	public void setLib1(String lib1) {
		this.lib1 = lib1;
	}

	public String getLib2() {
		return lib2;
	}

	public void setLib2(String lib2) {
		this.lib2 = lib2;
	}

	public Long getMnt1() {
		return mnt1;
	}

	public void setMnt1(Long mnt1) {
		this.mnt1 = mnt1;
	}

	public Long getMnt2() {
		return mnt2;
	}

	public void setMnt2(Long mnt2) {
		this.mnt2 = mnt2;
	}

	public Double getTau1() {
		return tau1;
	}

	public void setTau1(Double tau1) {
		this.tau1 = tau1;
	}

	public Double getTau2() {
		return tau2;
	}

	public void setTau2(Double tau2) {
		this.tau2 = tau2;
	}

}
