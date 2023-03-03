import java.lang.reflect.Field;

/**
 * @author ryan
 * @version Id: FruitInfoUtil, v 0.1 2023/3/3 1:44 PM ryan Exp $
 */
public class FruitInfoUtil {
    public static void getFruitInfo(Class<?> clazz) {
        String strFruitProvider = "供应商信息:";
        Field[] fields = clazz.getDeclaredFields();//通过反射获取处理注解
        for (Field field : fields) {
            if (field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fruitProvider = (FruitProvider) field.getAnnotation(FruitProvider.class); //注解信息的处理地方
                strFruitProvider = " 供应商编号:" + fruitProvider.id() + " 供应商名称:" + fruitProvider.name();
                System.out.println(strFruitProvider);
            }
        }
    }

    public static void main(String[] args) {
        FruitInfoUtil.getFruitInfo(Apple.class);
    }
}
