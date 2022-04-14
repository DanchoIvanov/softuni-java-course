package cats;

import org.junit.Assert;
import org.junit.Test;

public class HouseTests {

    @Test
    public void testHouseConstructor(){
        String expectedName = "myHouse";
        int expectedCapacity = 10;
        int expectedCount = 0;
        House house = new House("myHouse", 10);
        Assert.assertEquals(expectedName, house.getName());
        Assert.assertEquals(expectedCapacity, house.getCapacity());
        Assert.assertEquals(expectedCount, house.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testNullNameShouldThrowNPE(){
        House house = new House(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void whiteSpacesNameShouldThrowNPE(){
        House house = new House("   ", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeCapacityShouldThrowIAE(){
        House house = new House("myHouse", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void fullHouseShouldThrowIAE(){
        House house = new House("myHouse", 0);
        house.addCat(new Cat("Tom"));
    }

    @Test
    public void testHouseAddsCat(){
        House house = new House("myHouse", 2);
        Assert.assertEquals(0, house.getCount());
        house.addCat(new Cat("Tom"));
        Assert.assertEquals(1, house.getCount());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testOnRemoveInexistentCatShouldThrowIAE(){
        House house = new House("myHouse", 2);
        house.addCat(new Cat("Tom"));
        house.removeCat("Snowflake");
    }

    @Test
    public void testRemoveRemovesCat(){
        House house = new House("myHouse", 3);
        house.addCat(new Cat("Tom"));
        house.addCat(new Cat("Snowflake"));
        Assert.assertEquals(2, house.getCount());
        house.removeCat("Snowflake");
        Assert.assertEquals(1, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCatForSaleInExistentCatShouldThrowIAE(){
        House house = new House("myHouse", 2);
        house.addCat(new Cat("Tom"));
        house.catForSale("Snowflake");
    }

    @Test
    public void testCatForSaleShouldSetTheRightCatToNotHungry(){
        House house = new House("myHouse", 2);
        house.addCat(new Cat("Tom"));
        house.addCat(new Cat("Snowflake"));
        Cat fedTom = house.catForSale("Tom");
        Assert.assertEquals("Tom", fedTom.getName());
        Assert.assertFalse(fedTom.isHungry());
    }

    @Test
    public void testStatisticsReturnsCorrectMessage(){
        House house = new House("myHouse", 2);
        house.addCat(new Cat("Tom"));
        house.addCat(new Cat("Snowflake"));
        String expected = "The cat Tom, Snowflake is in the house myHouse!";
        String actual = house.statistics();
        Assert.assertEquals(expected, actual);
    }


}
