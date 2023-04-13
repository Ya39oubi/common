package tn.com.abt.smw.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import tn.com.abt.smw.enumeration.TypeAccessEnum;
import tn.com.abt.smw.enumeration.TypeSeuilEnum;

@Entity
@Table(name = "SYN_ACCESS_PERMISSIONS")
public class AccessPermissions implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idAccessPermission;
	private Long idAccessClient;
	private Long idMicroserviceMethod;
	private TypeAccessEnum typeAccess;
	private TypeSeuilEnum typeSeuil;
	private Long seuilJour;
	private Long seuilJourRes;
	private Date seuilJourDate;
	private Long seuilGlobal;
	private Long seuilGlobalRes;
	private Date seuilGlobalDate;
	private Boolean flgChecksum;
	private String pwdChecksum;
	private String utiCre;
	private String utiMod;
	private Date dateCre;
	private Date dateMod;

	public AccessPermissions() {

	}

	@Id
	@Column(name = "ID_ACCESS_PERMISSION", unique = true, nullable = false)
	public Long getIdAccessPermission() {
		return idAccessPermission;
	}

	public void setIdAccessPermission(Long idAccessPermission) {
		this.idAccessPermission = idAccessPermission;
	}

	@Column(name = "ID_ACCESS_CLIENT", nullable = false)
	public Long getIdAccessClient() {
		return idAccessClient;
	}

	public void setIdAccessClient(Long idAccessClient) {
		this.idAccessClient = idAccessClient;
	}

	@Column(name = "ID_MICROSERVICE_METHOD", nullable = false)
	public Long getIdMicroserviceMethod() {
		return idMicroserviceMethod;
	}

	public void setIdMicroserviceMethod(Long idMicroserviceMethod) {
		this.idMicroserviceMethod = idMicroserviceMethod;
	}

	@Column(name = "TYPE_ACCESS")
	@Enumerated(EnumType.STRING)
	public TypeAccessEnum getTypeAccess() {
		return typeAccess;
	}

	public void setTypeAccess(TypeAccessEnum typeAccess) {
		this.typeAccess = typeAccess;
	}

	@Column(name = "TYPE_SEUIL")
	@Enumerated(EnumType.STRING)
	public TypeSeuilEnum getTypeSeuil() {
		return typeSeuil;
	}

	public void setTypeSeuil(TypeSeuilEnum typeSeuil) {
		this.typeSeuil = typeSeuil;
	}

	@Column(name = "SEUIL_JOUR")
	public Long getSeuilJour() {
		return seuilJour;
	}

	public void setSeuilJour(Long seuilJour) {
		this.seuilJour = seuilJour;
	}

	@Column(name = "SEUIL_JOUR_RES")
	public Long getSeuilJourRes() {
		return seuilJourRes;
	}

	public void setSeuilJourRes(Long seuilJourRes) {
		this.seuilJourRes = seuilJourRes;
	}

	@Column(name = "SEUIL_JOUR_DATE")
	public Date getSeuilJourDate() {
		return seuilJourDate;
	}

	public void setSeuilJourDate(Date seuilJourDate) {
		this.seuilJourDate = seuilJourDate;
	}

	@Column(name = "SEUIL_GLOBAL")
	public Long getSeuilGlobal() {
		return seuilGlobal;
	}

	public void setSeuilGlobal(Long seuilGlobal) {
		this.seuilGlobal = seuilGlobal;
	}

	@Column(name = "SEUIL_GLOBAL_RES")
	public Long getSeuilGlobalRes() {
		return seuilGlobalRes;
	}

	public void setSeuilGlobalRes(Long seuilGlobalRes) {
		this.seuilGlobalRes = seuilGlobalRes;
	}

	@Column(name = "SEUIL_GLOBAL_DATE", length = 11)
	public Date getSeuilGlobalDate() {
		return seuilGlobalDate;
	}

	public void setSeuilGlobalDate(Date seuilGlobalDate) {
		this.seuilGlobalDate = seuilGlobalDate;
	}

	@Column(name = "FLG_CHECKSUM", nullable = false)
	public Boolean getFlgChecksum() {
		return flgChecksum;
	}

	public void setFlgChecksum(Boolean flgChecksum) {
		this.flgChecksum = flgChecksum;
	}

	@Column(name = "PWD_CHECKSUM ")
	public String getPwdChecksum() {
		return pwdChecksum;
	}

	public void setPwdChecksum(String pwdChecksum) {
		this.pwdChecksum = pwdChecksum;
	}

	@Column(name = "UTICRE ", nullable = false)
	public String getUtiCre() {
		return utiCre;
	}

	public void setUtiCre(String utiCre) {
		this.utiCre = utiCre;
	}

	@Column(name = "UTIMOD")
	public String getUtiMod() {
		return utiMod;
	}

	public void setUtiMod(String utiMod) {
		this.utiMod = utiMod;
	}

	@Column(name = "DATECRE", nullable = false)
	public Date getDateCre() {
		return dateCre;
	}

	public void setDateCre(Date dateCre) {
		this.dateCre = dateCre;
	}

	@Column(name = "DATEMOD", length = 11)
	public Date getDateMod() {
		return dateMod;
	}

	public void setDateMod(Date dateMod) {
		this.dateMod = dateMod;
	}

}
