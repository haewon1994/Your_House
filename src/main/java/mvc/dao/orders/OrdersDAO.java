package mvc.dao.orders;

import java.sql.SQLException;
import java.util.List;

import mvc.dto.orders.OrdersDTO;

public interface OrdersDAO {

	List<OrdersDTO> selectAll(int userCode) throws SQLException;
	
	int update() throws SQLException;

	OrdersDTO selectByOrderCode(int ordersCode) throws SQLException;

	int insert(OrdersDTO order) throws SQLException;
}
