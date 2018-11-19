package jamshidpey.elham.json.converter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sample{

	private List<String> stringList = new ArrayList<String>();
	private Integer integerValue;
	private BigDecimal bigDecimalValue;
	private String stringValue;
	private List<Inner> innerObjectList = new ArrayList<Inner>();
	private Set<String> stringSet = new HashSet<String>();
	private Inner innerObject;
	public Sample(){
		
	}

	public Sample(List<String> stringList, Integer integerValue, BigDecimal bigDecimalValue, String stringValue,
			List<Inner> innerObjectList, Set<String> stringSet, Inner innerObject) {
		super();
		this.stringList = stringList;
		this.integerValue = integerValue;
		this.bigDecimalValue = bigDecimalValue;
		this.stringValue = stringValue;
		this.innerObjectList = innerObjectList;
		this.stringSet = stringSet;
		this.innerObject = innerObject;
	}

	public List<String> getStringList() {
		return stringList;
	}

	public void setStringList(List<String> stringList) {
		this.stringList = stringList;
	}

	public Integer getIntegerValue() {
		return integerValue;
	}

	public void setIntegerValue(Integer integerValue) {
		this.integerValue = integerValue;
	}

	public BigDecimal getBigDecimalValue() {
		return bigDecimalValue;
	}

	public void setBigDecimalValue(BigDecimal bigDecimalValue) {
		this.bigDecimalValue = bigDecimalValue;
	}

	public String getStringValue() {
		return stringValue;
	}

	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

	public List<Inner> getInnerObjectList() {
		return innerObjectList;
	}

	public void setInnerObjectList(List<Inner> innerObjectList) {
		this.innerObjectList = innerObjectList;
	}

	public Set<String> getStringSet() {
		return stringSet;
	}

	public void setStringSet(Set<String> stringSet) {
		this.stringSet = stringSet;
	}

	public Inner getInnerObject() {
		return innerObject;
	}

	public void setInnerObject(Inner innerObject) {
		this.innerObject = innerObject;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bigDecimalValue == null) ? 0 : bigDecimalValue.hashCode());
		result = prime * result + ((innerObject == null) ? 0 : innerObject.hashCode());
		result = prime * result + ((innerObjectList == null) ? 0 : innerObjectList.hashCode());
		result = prime * result + ((integerValue == null) ? 0 : integerValue.hashCode());
		result = prime * result + ((stringList == null) ? 0 : stringList.hashCode());
		result = prime * result + ((stringSet == null) ? 0 : stringSet.hashCode());
		result = prime * result + ((stringValue == null) ? 0 : stringValue.hashCode());
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
		Sample other = (Sample) obj;
		if (bigDecimalValue == null) {
			if (other.bigDecimalValue != null)
				return false;
		} else if (!bigDecimalValue.equals(other.bigDecimalValue))
			return false;
		if (innerObject == null) {
			if (other.innerObject != null)
				return false;
		} else if (!innerObject.equals(other.innerObject))
			return false;
		if (innerObjectList == null) {
			if (other.innerObjectList != null)
				return false;
		} else if (!innerObjectList.equals(other.innerObjectList))
			return false;
		if (integerValue == null) {
			if (other.integerValue != null)
				return false;
		} else if (!integerValue.equals(other.integerValue))
			return false;
		if (stringList == null) {
			if (other.stringList != null)
				return false;
		} else if (!stringList.equals(other.stringList))
			return false;
		if (stringSet == null) {
			if (other.stringSet != null)
				return false;
		} else if (!stringSet.equals(other.stringSet))
			return false;
		if (stringValue == null) {
			if (other.stringValue != null)
				return false;
		} else if (!stringValue.equals(other.stringValue))
			return false;
		return true;
	}

}

