package mvp.wangyukui.com.myapplication.tools;

/**
 * Created by lenvo on 2018/11/16.
 */

public class OffNovelBook extends NovelBook {
    public OffNovelBook(String name, int price, String author) {
        super(name, price, author);
    }

    @Override
    public int getPrice(int price) {
        if (price > 80) {
            return (int) (this.price * 0.6);
        } else {
            return (int) (this.price * 0.8);
        }
    }

}
