package algo.annotations;

public @interface Tags {

	Value[] value();
	
	public enum Value{
		Math,
	}
}
