package tn.com.abt.utils;

import java.util.ArrayList;
import java.util.List;

import tn.com.abt.smw.domain.Pnom;
import tn.com.abt.smw.dto.PnomAllAttributesDto;
import tn.com.abt.smw.dto.PnomMediumAttributesDto;
import tn.com.abt.smw.dto.PnomMinimumAttributesDto;

public class CommonPnom {

	public static List<PnomMinimumAttributesDto> convertToPnomMinimumAttributesDto(List<Pnom> pnoms) {
		List<PnomMinimumAttributesDto> result = new ArrayList<PnomMinimumAttributesDto>();
		PnomMinimumAttributesDto pnomDto = null;
		for (int i = 0; i < pnoms.size(); i++) {
			pnomDto = new PnomMinimumAttributesDto();
			pnomDto.setIdnom(pnoms.get(i).getIdnom());
			pnomDto.setCnom(pnoms.get(i).getCnom());
			pnomDto.setCacc(pnoms.get(i).getCacc());
			pnomDto.setLib1(pnoms.get(i).getLib1());
			pnomDto.setLib2(pnoms.get(i).getLib2());
			pnomDto.setMnt1(pnoms.get(i).getMnt1());
			pnomDto.setMnt2(pnoms.get(i).getMnt2());
			pnomDto.setTau1(pnoms.get(i).getTau1());
			pnomDto.setTau2(pnoms.get(i).getTau2());
			result.add(pnomDto);
		}

		return result;
	}

	public static List<PnomMediumAttributesDto> convertToPnomMediumAttributesDto(List<Pnom> pnoms) {
		List<PnomMediumAttributesDto> result = new ArrayList<PnomMediumAttributesDto>();
		PnomMediumAttributesDto pnomDto = null;
		for (int i = 0; i < pnoms.size(); i++) {
			pnomDto = new PnomMediumAttributesDto();
			pnomDto.setIdnom(pnoms.get(i).getIdnom());
			pnomDto.setCnom(pnoms.get(i).getCnom());
			pnomDto.setCacc(pnoms.get(i).getCacc());
			pnomDto.setLib1(pnoms.get(i).getLib1());
			pnomDto.setLib2(pnoms.get(i).getLib2());
			pnomDto.setLib3(pnoms.get(i).getLib3());
			pnomDto.setLib4(pnoms.get(i).getLib4());
			pnomDto.setLib5(pnoms.get(i).getLib5());
			pnomDto.setMnt1(pnoms.get(i).getMnt1());
			pnomDto.setMnt2(pnoms.get(i).getMnt2());
			pnomDto.setMnt3(pnoms.get(i).getMnt3());
			pnomDto.setMnt4(pnoms.get(i).getMnt4());
			pnomDto.setMnt5(pnoms.get(i).getMnt5());
			pnomDto.setTau1(pnoms.get(i).getTau1());
			pnomDto.setTau2(pnoms.get(i).getTau2());
			pnomDto.setTau3(pnoms.get(i).getTau3());
			pnomDto.setTau4(pnoms.get(i).getTau4());
			pnomDto.setTau5(pnoms.get(i).getTau5());
			result.add(pnomDto);
		}

		return result;
	}

	public static List<PnomAllAttributesDto> convertToPnomAllAttributesDto(List<Pnom> pnoms) {
		List<PnomAllAttributesDto> result = new ArrayList<PnomAllAttributesDto>();
		PnomAllAttributesDto pnomDto = null;
		for (int i = 0; i < pnoms.size(); i++) {
			pnomDto = new PnomAllAttributesDto();
			pnomDto.setIdnom(pnoms.get(i).getIdnom());
			pnomDto.setCnom(pnoms.get(i).getCnom());
			pnomDto.setCacc(pnoms.get(i).getCacc());
			pnomDto.setLib1(pnoms.get(i).getLib1());
			pnomDto.setLib2(pnoms.get(i).getLib2());
			pnomDto.setLib3(pnoms.get(i).getLib3());
			pnomDto.setLib4(pnoms.get(i).getLib4());
			pnomDto.setLib5(pnoms.get(i).getLib5());
			pnomDto.setLib6(pnoms.get(i).getLib6());
			pnomDto.setLib7(pnoms.get(i).getLib7());
			pnomDto.setLib8(pnoms.get(i).getLib8());
			pnomDto.setLib9(pnoms.get(i).getLib9());
			pnomDto.setLib10(pnoms.get(i).getLib10());
			pnomDto.setMnt1(pnoms.get(i).getMnt1());
			pnomDto.setMnt2(pnoms.get(i).getMnt2());
			pnomDto.setMnt3(pnoms.get(i).getMnt3());
			pnomDto.setMnt4(pnoms.get(i).getMnt4());
			pnomDto.setMnt5(pnoms.get(i).getMnt5());
			pnomDto.setMnt6(pnoms.get(i).getMnt6());
			pnomDto.setMnt7(pnoms.get(i).getMnt7());
			pnomDto.setMnt8(pnoms.get(i).getMnt8());
			pnomDto.setMnt9(pnoms.get(i).getMnt9());
			pnomDto.setMnt10(pnoms.get(i).getMnt10());
			pnomDto.setTau1(pnoms.get(i).getTau1());
			pnomDto.setTau2(pnoms.get(i).getTau2());
			pnomDto.setTau3(pnoms.get(i).getTau3());
			pnomDto.setTau4(pnoms.get(i).getTau4());
			pnomDto.setTau5(pnoms.get(i).getTau5());
			pnomDto.setTau6(pnoms.get(i).getTau6());
			pnomDto.setTau7(pnoms.get(i).getTau7());
			pnomDto.setTau8(pnoms.get(i).getTau8());
			pnomDto.setTau9(pnoms.get(i).getTau9());
			pnomDto.setTau10(pnoms.get(i).getTau10());
			result.add(pnomDto);
		}

		return result;
	}
}
