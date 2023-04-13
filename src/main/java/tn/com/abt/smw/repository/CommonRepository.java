package tn.com.abt.smw.repository;

import java.util.List;

/**
 * 
 * @author AMMAR.MAHER
 *
 */
public interface CommonRepository {

	class StoredProcedureParameterBindVars {

		private String parameterName;
		private Class<?> parameterClass;
		private Object parameterValue;

		public StoredProcedureParameterBindVars(String parameterName, Class<?> parameterClass, Object parameterValue) {
			this.parameterName = parameterName;
			this.parameterClass = parameterClass;
			this.parameterValue = parameterValue;
		}

		public String getParameterName() {
			return parameterName;
		}

		public Class<?> getParameterClass() {
			return parameterClass;
		}

		public Object getParameterValue() {
			return parameterValue;
		}

	}

	Boolean callStoredProcedure(String sql, List<StoredProcedureParameterBindVars> bindVars);

	Integer executeQuery(String sql, List<Object> bindVars);

	List<Object> findByQuery(String sql);

	List<Object> findByQuery(String sql, List<Object> bindVars);

	@SuppressWarnings("rawtypes")
	List findByQuery(Class<?> entityClass, String sql, List<Object> bindVars);

	Integer findIntegerByQuery(String sql, List<Object> bindVars);

	Long findLongByQuery(String sql, List<Object> bindVars);

	Double findDoubleByQuery(String sql, List<Object> bindVars);

	String findStringByQuery(String sql, List<Object> bindVars);

}
