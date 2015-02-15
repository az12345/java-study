package nedis.demo.webtasks.annotations;

/**
 * @author nedis
 * @version 1.0
 */
public @interface Column {
	String value() default "";
}
