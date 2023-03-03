/**
 * @author ryan
 * @version Id: Apple, v 0.1 2023/3/3 1:43 PM ryan Exp $
 */
public class Apple {

    @FruitProvider(id = 1, name = "陕西红富士集团")
    private String appleProvider;

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }

    public String getAppleProvider() {
        return appleProvider;
    }
}
