package tn.com.abt.smw.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PNOM")
public class Pnom implements java.io.Serializable {

	/** 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "IDNOM", unique = true, nullable = false)
	private Long idnom;
	@Column(name = "CNOM")
	private String cnom;
	@Column(name = "CACC")
	private String cacc;
	@Column(name = "LIB1")
	private String lib1;
	@Column(name = "LIB2")
	private String lib2;
	@Column(name = "LIB3")
	private String lib3;
	@Column(name = "LIB4")
	private String lib4;
	@Column(name = "LIB5")
	private String lib5;
	@Column(name = "LIB6")
	private String lib6;
	@Column(name = "LIB7")
	private String lib7;
	@Column(name = "LIB8")
	private String lib8;
	@Column(name = "LIB9")
	private String lib9;
	@Column(name = "LIB10")
	private String lib10;
	@Column(name = "MNT1")
	private Long mnt1;
	@Column(name = "MNT2")
	private Long mnt2;
	@Column(name = "MNT3")
	private Long mnt3;
	@Column(name = "MNT4")
	private Long mnt4;
	@Column(name = "MNT5")
	private Long mnt5;
	@Column(name = "MNT6")
	private Long mnt6;
	@Column(name = "MNT7")
	private Long mnt7;
	@Column(name = "MNT8")
	private Long mnt8;
	@Column(name = "MNT9")
	private Long mnt9;
	@Column(name = "MNT10")
	private Long mnt10;
	@Column(name = "TAU1")
	private Double tau1;
	@Column(name = "TAU2")
	private Double tau2;
	@Column(name = "TAU3")
	private Double tau3;
	@Column(name = "TAU4")
	private Double tau4;
	@Column(name = "TAU5")
	private Double tau5;
	@Column(name = "TAU6")
	private Double tau6;
	@Column(name = "TAU7")
	private Double tau7;
	@Column(name = "TAU8")
	private Double tau8;
	@Column(name = "TAU9")
	private Double tau9;
	@Column(name = "TAU10")
	private Double tau10;
	@Column(name = "UTICRE", nullable = false)
	private String uticre;
	@Column(name = "DATECRE", nullable = false)
	private Date datecre;
	@Column(name = "UTIMOD")
	private String utimod;
	@Column(name = "DATEMOD")
	private Date datemod;

	public Pnom() {

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

	public String getLib3() {
		return lib3;
	}

	public void setLib3(String lib3) {
		this.lib3 = lib3;
	}

	public String getLib4() {
		return lib4;
	}

	public void setLib4(String lib4) {
		this.lib4 = lib4;
	}

	public String getLib5() {
		return lib5;
	}

	public void setLib5(String lib5) {
		this.lib5 = lib5;
	}

	public String getLib6() {
		return lib6;
	}

	public void setLib6(String lib6) {
		this.lib6 = lib6;
	}

	public String getLib7() {
		return lib7;
	}

	public void setLib7(String lib7) {
		this.lib7 = lib7;
	}

	public String getLib8() {
		return lib8;
	}

	public void setLib8(String lib8) {
		this.lib8 = lib8;
	}

	public String getLib9() {
		return lib9;
	}

	public void setLib9(String lib9) {
		this.lib9 = lib9;
	}

	public String getLib10() {
		return lib10;
	}

	public void setLib10(String lib10) {
		this.lib10 = lib10;
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

	public Long getMnt3() {
		return mnt3;
	}

	public void setMnt3(Long mnt3) {
		this.mnt3 = mnt3;
	}

	public Long getMnt4() {
		return mnt4;
	}

	public void setMnt4(Long mnt4) {
		this.mnt4 = mnt4;
	}

	public Long getMnt5() {
		return mnt5;
	}

	public void setMnt5(Long mnt5) {
		this.mnt5 = mnt5;
	}

	public Long getMnt6() {
		return mnt6;
	}

	public void setMnt6(Long mnt6) {
		this.mnt6 = mnt6;
	}

	public Long getMnt7() {
		return mnt7;
	}

	public void setMnt7(Long mnt7) {
		this.mnt7 = mnt7;
	}

	public Long getMnt8() {
		return mnt8;
	}

	public void setMnt8(Long mnt8) {
		this.mnt8 = mnt8;
	}

	public Long getMnt9() {
		return mnt9;
	}

	public void setMnt9(Long mnt9) {
		this.mnt9 = mnt9;
	}

	public Long getMnt10() {
		return mnt10;
	}

	public void setMnt10(Long mnt10) {
		this.mnt10 = mnt10;
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

	public Double getTau3() {
		return tau3;
	}

	public void setTau3(Double tau3) {
		this.tau3 = tau3;
	}

	public Double getTau4() {
		return tau4;
	}

	public void setTau4(Double tau4) {
		this.tau4 = tau4;
	}

	public Double getTau5() {
		return tau5;
	}

	public void setTau5(Double tau5) {
		this.tau5 = tau5;
	}

	public Double getTau6() {
		return tau6;
	}

	public void setTau6(Double tau6) {
		this.tau6 = tau6;
	}

	public Double getTau7() {
		return tau7;
	}

	public void setTau7(Double tau7) {
		this.tau7 = tau7;
	}

	public Double getTau8() {
		return tau8;
	}

	public void setTau8(Double tau8) {
		this.tau8 = tau8;
	}

	public Double getTau9() {
		return tau9;
	}

	public void setTau9(Double tau9) {
		this.tau9 = tau9;
	}

	public Double getTau10() {
		return tau10;
	}

	public void setTau10(Double tau10) {
		this.tau10 = tau10;
	}

	public String getUticre() {
		return uticre;
	}

	public void setUticre(String uticre) {
		this.uticre = uticre;
	}

	public Date getDatecre() {
		return datecre;
	}

	public void setDatecre(Date datecre) {
		this.datecre = datecre;
	}

	public String getUtimod() {
		return utimod;
	}

	public void setUtimod(String utimod) {
		this.utimod = utimod;
	}

	public Date getDatemod() {
		return datemod;
	}

	public void setDatemod(Date datemod) {
		this.datemod = datemod;
	}

	@Override
	public String toString() {
		return "Pnom [idnom=" + idnom + ", cnom=" + cnom + ", cacc=" + cacc + ", lib1=" + lib1 + "]";
	}

}
