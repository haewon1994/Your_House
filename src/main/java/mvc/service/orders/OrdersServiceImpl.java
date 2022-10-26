package mvc.service.orders;

import java.sql.SQLException;
import java.util.List;

import mvc.dao.orders.OrdersDAO;
import mvc.dao.orders.OrdersDAOImpl;
import mvc.dto.orders.OrdersDTO;

public class OrdersServiceImpl implements OrdersService {
	private OrdersDAO dao = new OrdersDAOImpl();

	@Override
	public List<OrdersDTO> selectAll(int userCode) throws SQLException {
		return dao.selectAll(userCode);
	}

	@Override
	public OrdersDTO selectByOrderCode(int orderCode) throws SQLException {
		OrdersDTO order = dao.selectByOrderCode(orderCode);
		if(order==null) {
			throw new SQLException("정보가 올바르지 않습니다");
		}
		return order;
	}

	@Override
	public void insert(OrdersDTO order) throws SQLException {
		int result = dao.insert(order);
		if(result==0) {
			throw new SQLException("등록 실패 되었습니다");
		}
	}

}
