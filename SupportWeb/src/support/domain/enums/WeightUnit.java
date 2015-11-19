package support.domain.enums;

public enum WeightUnit {
	KT,
	KG,
	LB;
	
	public String getCode() {
		return this.name();
	}
}
