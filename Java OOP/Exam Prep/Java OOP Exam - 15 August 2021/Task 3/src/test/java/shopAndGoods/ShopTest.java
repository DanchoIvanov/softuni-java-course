package shopAndGoods;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ShopTest {

    private Shop shop;
    private Goods good;
    private Goods anotherGood;

    @Before
    public void setUp(){
        this.shop = new Shop();
        this.good = new Goods("stock", "stockCode");
        this.anotherGood = new Goods("differentStock", "differentStockCode");
    }


    //Shelf exists
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfShellDoesNotExists() throws OperationNotSupportedException {
        shop.addGoods("123", good);
    }


    //Shelf is empty
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfShellIsTaken() throws OperationNotSupportedException {
        shop.addGoods("Shelves8", good);
        shop.addGoods("Shelves8", anotherGood);

    }

    //Good already exist
    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionIfGoodAlreadyExists() throws OperationNotSupportedException {
        shop.addGoods("Shelves8", good);
        shop.addGoods("Shelves9", good);

    }

    @Test
    public void shouldAddGoodToShelf() throws OperationNotSupportedException {
        shop.addGoods("Shelves8", good);
        String shelfName = "Shelves8";
        String expectedCode = "stockCode";
        String actualCode = shop.getShelves().get(shelfName).getGoodsCode();
        Assert.assertEquals(expectedCode, actualCode);
    }

    @Test
    public void testOutputMessageAfterAddedGood() throws OperationNotSupportedException {
        String actual = shop.addGoods("Shelves8", good);
        String expected = "Goods: stockCode is placed successfully!";
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfShellToRemoveFromDoesNotExists() throws OperationNotSupportedException {
        shop.removeGoods("123", good);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfShelfIsEmpty() throws OperationNotSupportedException {
        shop.removeGoods("Shelves1", good);
    }

    @Test
    public void shouldRemoveGood() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", good);
        shop.removeGoods("Shelves1", good);
        Assert.assertNull(shop.getShelves().get("Shelves1"));
    }

    @Test
    public void TestOutputAfterRemoveGood() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", good);
        String actual = shop.removeGoods("Shelves1", good);
        String expected = "Goods: stockCode is removed successfully!";
        Assert.assertEquals(expected, actual);
    }

}