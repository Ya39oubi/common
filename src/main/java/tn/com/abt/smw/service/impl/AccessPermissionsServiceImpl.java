package tn.com.abt.smw.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.com.abt.smw.domain.AccessPermissions;
import tn.com.abt.smw.enumeration.MsgHeaderEnum;
import tn.com.abt.smw.enumeration.TypeAccessEnum;
import tn.com.abt.smw.enumeration.TypeSeuilEnum;
import tn.com.abt.smw.repository.AccessPermissionsRepository;
import tn.com.abt.smw.service.AccessPermissionsService;
import tn.com.abt.smw.template.ResourceAccessPermission;
import tn.com.abt.utils.CommonCalendrier;

@Service
public class AccessPermissionsServiceImpl implements AccessPermissionsService {

	@Autowired
	private AccessPermissionsRepository accessPermissionsRepository;

	public ResourceAccessPermission getResourceAccessPermission(Long idAccessClient, String securityRole, String methodName) {
		ResourceAccessPermission result = new ResourceAccessPermission();
		try {

			AccessPermissions accessPermission = accessPermissionsRepository.findByIdAccessClientAndSecurityRole(idAccessClient,
					securityRole, methodName);

			if (accessPermission == null) {
				result.setAuthorized(false);
				result.setResultCode(MsgHeaderEnum.MSG_AD00.getId());
				result.setResultMessage(MsgHeaderEnum.MSG_AD00.getMessage());
			} else {

				result.setAuthorized(true);
				result.setIdAccessClient(idAccessClient);
				result.setIdMicroserviceMethod(accessPermission.getIdMicroserviceMethod());
				result.setWithChecksumControl(accessPermission.getFlgChecksum());
				result.setChecksumPassword(accessPermission.getPwdChecksum());

				if (TypeAccessEnum.S.equals(accessPermission.getTypeAccess())) {
					Long seuilJourRes = accessPermission.getSeuilJourRes();
					Long seuilGlobalRes = accessPermission.getSeuilGlobalRes();
					Date seuilJourDate = accessPermission.getSeuilJourDate();
					if (TypeSeuilEnum.G.equals(accessPermission.getTypeSeuil())
							|| TypeSeuilEnum.JG.equals(accessPermission.getTypeSeuil())) {
						if (accessPermission.getSeuilGlobalRes() == 0) {
							result.setAuthorized(false);
							result.setResultCode("AD00");
							result.setResultMessage("Overall Threshold Reached");
						} else {
							if (seuilGlobalRes != null) {
								seuilGlobalRes = seuilGlobalRes - 1;
							}
						}
					}

					if ((result.isAuthorized() == true) && (TypeSeuilEnum.J.equals(accessPermission.getTypeSeuil())
							|| TypeSeuilEnum.JG.equals(accessPermission.getTypeSeuil()))) {
						if ((CommonCalendrier.getDateAsString("yyyyMMdd", CommonCalendrier.nowTime())
								.equals(CommonCalendrier.getDateAsString("yyyyMMdd", accessPermission.getSeuilJourDate())))
								&& (accessPermission.getSeuilJourRes() == 0)) {
							result.setAuthorized(false);
							result.setResultCode("AD00");
							result.setResultMessage("Daily Threshold Reached");
						} else {

							if (CommonCalendrier.getDateAsString("yyyyMMdd", CommonCalendrier.nowTime())
									.equals(CommonCalendrier.getDateAsString("yyyyMMdd", accessPermission.getSeuilJourDate()))) {
								seuilJourRes = seuilJourRes - 1;
							} else {
								seuilJourDate = CommonCalendrier.nowTime();
								seuilJourRes = accessPermission.getSeuilJour() - 1;
							}

						}
					}

					if (result.isAuthorized() == true) {
						accessPermission.setSeuilJourRes(seuilJourRes);
						accessPermission.setSeuilGlobalRes(seuilGlobalRes);
						accessPermission.setSeuilJourDate(seuilJourDate);
						accessPermissionsRepository.save(accessPermission);
					}

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			result.setAuthorized(false);
			result.setResultCode(MsgHeaderEnum.MSG_A000.getId());
			result.setResultMessage(MsgHeaderEnum.MSG_A000.getMessage());
		}

		return result;

	}

}
