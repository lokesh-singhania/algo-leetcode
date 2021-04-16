package algo.annotations;

public @interface SpaceComplexity {

	ComplexityValue value();
	
	String remark() default "";
}
