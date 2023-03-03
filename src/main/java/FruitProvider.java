import java.lang.annotation.*;

/**
 * @author ryan
 * @version Id: FruitProvider, v 0.1 2023/3/3 1:42 PM ryan Exp $
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {

    int id() default -1;

    String name() default "";
}
