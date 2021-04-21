package algo.annotations;

public @interface Remarks {
    String[] value() default "";

    String[] optimizations() default "";
}
