package pr0304Barracks.core.factories;

import jdk.nashorn.api.tree.TryTree;
import pr0304Barracks.contracts.Unit;
import pr0304Barracks.contracts.UnitFactory;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Constructor;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"pr0304Barracks.models.units.";

	@Override
	public Unit createUnit(String unitType) {
		Unit unit = null;

		try{
			Class unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
			Constructor constructor = unitClass.getConstructor();
			unit = (Unit) constructor.newInstance();

			return unit;
		}
		catch(ReflectiveOperationException e){
			e.printStackTrace();
		}

		return unit;
	}
}
