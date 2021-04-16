package algo.annotations;

public @interface TimeComplexity {

	ComplexityValue value();
	
	String remark() default "";
}
