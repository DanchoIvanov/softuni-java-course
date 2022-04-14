package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FarmvilleTests {

    private Animal animal;
    private Animal anotherAnimal;
    private Farm zeroCapacityFarm;
    private Farm farm;

    @Before
    public void setUp(){
        this.animal = new Animal("Cow", 1);
        this.anotherAnimal = new Animal("Horse", 10);
        this.zeroCapacityFarm = new Farm("Farm", 0);
        this.farm = new Farm("myFarm", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void fullFarmShouldThrowExceptionOnAdd(){
        this.zeroCapacityFarm.add(animal);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addingSameAnimalShouldThrowException(){
        farm.add(new Animal("Cow", 5));
        farm.add(new Animal("Cow", 12));
    }

    @Test
    public void removeFindsTheRightAnimal(){
        farm.add(animal);
        farm.add(anotherAnimal);
        Assert.assertTrue(farm.remove("Cow"));
        Assert.assertFalse(farm.remove("Chicken"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void instanceOfNegativeCapacityFarmShouldThrowException(){
        Farm negativeCapacity = new Farm("Negative", -1);
    }

    @Test(expected = NullPointerException.class)
    public void emptyNameShouldThrowException(){
        Farm noNameFarm = new Farm(" ", 1);
    }

    @Test(expected = NullPointerException.class)
    public void constructorShouldThrowExceptionBecauseNameIsNull(){
        new Farm(null, 5);
    }

    @Test
    public void testGetCount(){
        farm.add(animal);
        farm.add(anotherAnimal);
        int expected = 2;
        int actual = farm.getCount();
        Assert.assertEquals(expected,actual);
    }

    //3. animal is added
    @Test
    public void addMethodShouldAddAnimal(){
        Farm farm = new Farm("Cow Farm", 5);
        Assert.assertEquals(0, farm.getCount());
        farm.add(new Animal("Pig", 120));
        Assert.assertEquals(1, farm.getCount());
    }


    //1. animal is removed
    @Test
    public void removeMethodShouldRemoveAnimal(){
        Farm farm = new Farm("Cow Farm", 5);
        Assert.assertEquals(0, farm.getCount());
        farm.add(new Animal("Pig", 120));
        Assert.assertEquals(1, farm.getCount());
        Assert.assertTrue(farm.remove("Pig"));
        Assert.assertEquals(0, farm.getCount());


    }

    //2. no animal is removed
    @Test
    public void removeMethodShouldNotRemoveAnimal(){
        Farm farm = new Farm("Cow Farm", 5);
        Assert.assertEquals(0, farm.getCount());
        farm.add(new Animal("Pig", 120));
        Assert.assertEquals(1, farm.getCount());
        Assert.assertFalse(farm.remove("Dog"));
        Assert.assertEquals(1, farm.getCount());
    }

    @Test
    public void constructorShouldCreateFarm(){
        String name = "Cow farm";
        int capacity = 5;
        Farm farm = new Farm(name, capacity);

        Assert.assertEquals(name, farm.getName());
        Assert.assertEquals(capacity, farm.getCapacity());
    }
}
