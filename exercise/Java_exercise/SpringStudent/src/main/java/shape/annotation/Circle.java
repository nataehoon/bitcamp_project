package shape.annotation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component("myCircle")
public class Circle implements Shape{
	@Autowired(required = true)
	@Qualifier("myCircleDao")
	private ShapeDao shapeDao;
	
	@Override
	public Object GetShapeOne() {
		return this.shapeDao.GetShapeOne();
	}

	@Override
	public List<Object> GetAllShapes() {
		return this.shapeDao.GetAllShapes();
	}
	

}
