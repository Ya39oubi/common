package tn.com.abt.smw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import tn.com.abt.smw.domain.Pnom;

@Repository
public interface PnomRepository extends JpaRepository<Pnom, Long> {

	List<Pnom> findByCnom(String cnom);

	List<Pnom> findByCnomAndCacc(String cnom, String cacc);

	List<Pnom> findByCnomAndCaccAndMnt1(String cnom, String cacc, Long mnt1);

	List<Pnom> findByCnomAndMnt1(String cnom, Long mnt1);

	List<Pnom> findByCnomAndMnt1OrderByMnt2Asc(String cnom, Long mnt1);

	List<Pnom> findByCnomAndMnt2(String cnom, Long mnt1);

	List<Pnom> findByCnomAndMnt3(String cnom, Long mnt1);

	List<Pnom> findByCnomAndMnt4(String cnom, Long mnt1);

	List<Pnom> findByCnomAndMnt5(String cnom, Long mnt1);

	List<Pnom> findByCnomAndMnt6(String cnom, Long mnt1);

	List<Pnom> findByCnomAndMnt7(String cnom, Long mnt1);

	List<Pnom> findByCnomAndMnt8(String cnom, Long mnt1);

	List<Pnom> findByCnomAndMnt9(String cnom, Long mnt1);




	Pnom findByCacc(String cacc);
	@Query(value = "SELECT p.* FROM pnom p WHERE p.cnom = ?1 and p.cacc=?2 ", nativeQuery = true)
	List<Pnom> getByCnomAndCacc(String cnom,String cacc);
	
	@Query(value = "SELECT p.* FROM pnom p WHERE p.cnom = ?1 ORDER BY p.mnt1 ASC", nativeQuery = true)
	List<Pnom> findByCnomOrderByMnt1(String cnom);


}
