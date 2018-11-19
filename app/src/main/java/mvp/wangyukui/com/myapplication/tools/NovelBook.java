package mvp.wangyukui.com.myapplication.tools;

/**
 * Created by lenvo on 2018/11/16.
 */

public class NovelBook implements IBook {
    public String name;
    public int price;
    public String author;

    public NovelBook(String name, int price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    @Override
    public String getName(String name) {
        return name;
    }

    @Override
    public int getPrice(int price) {
        return price;
    }

    @Override
    public String getAuthor(String author) {
        return author;
    }
}
