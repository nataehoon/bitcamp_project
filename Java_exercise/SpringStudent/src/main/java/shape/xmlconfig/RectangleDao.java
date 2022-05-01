package shape.xmlconfig;

import java.util.ArrayList;
import java.util.List;

public class RectangleDao implements ShapeDao {

	@Override
	public Object GetShapeOne() {
		RectangleBean bean = new RectangleBean(4.0, 3.0);
		return bean;
	}

	@Override
	public List<Object> GetAllShapes() {
		List<Object> lists = new ArrayList<Object>();
		
		lists.add(new RectangleBean(5.0, 2.0));
		lists.add(new RectangleBean(4.0, 7.0));
		return lists;
	}

}
