package shape.xmlconfig;

import java.util.List;

public class Circle implements Shape{
	private ShapeDao shapeDao;
	
	public void setShapeDao(ShapeDao shapeDao) {
		this.shapeDao = shapeDao;
	}

	@Override
	public Object GetShapeOne() {
		return this.shapeDao.GetShapeOne();
	}

	@Override
	public List<Object> GetAllShapes() {
		return this.shapeDao.GetAllShapes();
	}
	

}
