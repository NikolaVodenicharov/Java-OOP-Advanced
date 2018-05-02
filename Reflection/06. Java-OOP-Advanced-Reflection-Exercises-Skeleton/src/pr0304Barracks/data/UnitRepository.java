package pr0304Barracks.data;

import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.Unit;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Map;
import java.util.TreeMap;

public class UnitRepository implements Repository {

	private Map<String, Integer> amountOfUnits;

	public UnitRepository() {
		this.amountOfUnits = new TreeMap<>();
	}

	public void addUnit(Unit unit) {
		String unitType = unit.getClass().getSimpleName();
		if (!this.amountOfUnits.containsKey(unitType)) {
			this.amountOfUnits.put(unitType, 0);
		}

		int newAmount = this.amountOfUnits.get(unitType) + 1;
		this.amountOfUnits.put(unitType, newAmount);
	}

	public String getStatistics() {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, Integer> entry : amountOfUnits.entrySet()) {
			String formattedEntry =
					String.format("%s -> %d%n", entry.getKey(), entry.getValue());
			sb.append(formattedEntry);
		}
		sb.setLength(
				sb.length() - System.lineSeparator().length());

		return sb.toString();
	}

	public void removeUnit(String unitType) {
		// TODO: implement for problem 4
		throw new NotImplementedException();
	}
}
