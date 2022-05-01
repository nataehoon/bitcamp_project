package shape.xmlconfig;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

public class CircleDao implements ShapeDao {

	@Override
	public Object GetShapeOne() {
		CircleBean bean = new CircleBean(3.0, 4.0, 5.0);
		return bean;
	}

	@Override
	public List<Object> GetAllShapes() {
		List<Object> lists = new ArrayList<Object>();
		
		lists.add(new CircleBean(3.0, 4.0, 5.0));
		lists.add(new CircleBean(6.0, 5.0, 5.0));
		lists.add(new CircleBean(4.0, 6.0, 8.0));
		lists.add(new CircleBean(5.0, 7.0, 5.0));
		return lists;
	}

}
