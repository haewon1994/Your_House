package mvc.service;

import java.sql.SQLException;
import java.util.List;

import mvc.dao.product.AdminTongyeDAO;
import mvc.dao.product.AdminTongyeDAOImpl;
import mvc.dto.product.AdminTongyeDTO;

public class AdminTongyeServiceImpl implements AdminTongyeService {

	private AdminTongyeDAO adminTongyeDAO=new AdminTongyeDAOImpl();
	
	@Override
	public AdminTongyeDTO selectTongyePrAllSum(String startDate, String lastDate) throws SQLException {
		AdminTongyeDTO adminTongye=adminTongyeDAO.selectTongyePrAllSum(startDate, lastDate);
		
		if(adminTongye==null) throw new SQLException("정보가 없습니다");
		if(startDate==null||lastDate==null) throw new SQLException("날짜입력 형식을 확인해주세요 : ex)20221027 ");
		
		return adminTongye;
	}

	@Override
	public List<AdminTongyeDTO> selectTongyePrAllPro(String startDate, String lastDate) throws SQLException {
		List<AdminTongyeDTO> adminTongyeList=adminTongyeDAO.selectTongyePrAllPro(startDate, lastDate);
		
		if(adminTongyeList==null) throw new SQLException("정보가 없습니다");
		if(startDate==null||lastDate==null) throw new SQLException("날짜입력 형식을 확인해주세요 : ex)20221027 ");
		
		return adminTongyeList;
	}

	@Override
	public AdminTongyeDTO selectTongyeCaAllSum(int categoryCode, String startDate, String lastDate)
			throws SQLException {
		AdminTongyeDTO adminTongye=adminTongyeDAO.selectTongyeCaAllSum(categoryCode, startDate, lastDate);
		
		if(adminTongye==null) throw new SQLException("정보가 없습니다");
		if(startDate==null||lastDate==null) throw new SQLException("날짜입력 형식을 확인해주세요 : ex)20221027 ");
		
		return adminTongye;
	}

	@Override
	public List<AdminTongyeDTO> selectTongyeCaAllPro(int categoryCode, String startDate, String lastDate)
			throws SQLException {
		List<AdminTongyeDTO> adminTongyeList=adminTongyeDAO.selectTongyeCaAllPro(categoryCode, startDate, lastDate);
		
		if(adminTongyeList==null) throw new SQLException("정보가 없습니다");
		if(startDate==null||lastDate==null) throw new SQLException("날짜입력 형식을 확인해주세요 : ex)20221027 ");
		
		return adminTongyeList;
	}

	@Override
	public AdminTongyeDTO selectTongyeProdSum(int productCode, String startDate, String lastDate) throws SQLException {
		AdminTongyeDTO adminTongye=adminTongyeDAO.selectTongyeProdSum(productCode, startDate, lastDate);
		
		if(adminTongye==null) throw new SQLException("정보가 없습니다");
		if(startDate==null||lastDate==null) throw new SQLException("날짜입력 형식을 확인해주세요 : ex)20221027 ");
		
		return adminTongye;
	}

	@Override
	public List<AdminTongyeDTO> selectTongyeProdPro(int productCode, String startDate, String lastDate)
			throws SQLException {
		List<AdminTongyeDTO> adminTongyeList=adminTongyeDAO.selectTongyeProdPro(productCode, startDate, lastDate);
		
		if(adminTongyeList==null) throw new SQLException("정보가 없습니다");
		if(startDate==null||lastDate==null) throw new SQLException("날짜입력 형식을 확인해주세요 : ex)20221027 ");
		
		return adminTongyeList;
	}

}
