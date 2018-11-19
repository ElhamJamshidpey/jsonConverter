package jamshidpey.elham.json.converter;

import java.util.ArrayList;
import java.util.List;

public class Inner {
	
	private String stringValue;
	private List<String> stringList = new ArrayList<String>();

	public List<String> getStringList() {
		return stringList;
	}

	public void setStringList(List<String> stringList) {
		this.stringList = stringList;
	}
	
	public void addString(String s) {
		stringList.add(s);
	}

	public String getS() {
		return stringValue;
	}

	public void setS(String s) {
		this.stringValue = s;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stringValue == null) ? 0 : stringValue.hashCode());
		result = prime * result + ((stringList == null) ? 0 : stringList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inner other = (Inner) obj;
		if (stringValue == null) {
			if (other.stringValue != null)
				return false;
		} else if (!stringValue.equals(other.stringValue))
			return false;
		if (stringList == null) {
			if (other.stringList != null)
				return false;
		} else if (!stringList.equals(other.stringList))
			return false;
		return true;
	}
	
	
}
