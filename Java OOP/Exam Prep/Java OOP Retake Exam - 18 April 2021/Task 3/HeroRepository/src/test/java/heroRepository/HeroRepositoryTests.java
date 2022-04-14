package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeroRepositoryTests {

    private HeroRepository heroRepository;
    private Hero hero;

    @Before
    public void setUp(){
        this.heroRepository = new HeroRepository();
        this.hero = new Hero("Gencho", 99);
    }

    @Test(expected = NullPointerException.class)
    public void testAddHeroWithNullValueShouldThrowNPE(){
        heroRepository.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddHeroWithSameNameShouldThrowIAE(){
        Hero heroWithTheSameName = new Hero("Gencho", 1);
        heroRepository.create(hero);
        heroRepository.create(heroWithTheSameName);
    }

    @Test
    public void testHeroIsAddedOnCreateCommand() {
        Assert.assertEquals(0,heroRepository.getCount());
        String actualOutput = heroRepository.create(hero);
        Assert.assertEquals(1,heroRepository.getCount());
        String expectedOutput = "Successfully added hero Gencho with level 99";
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveHeroWithNoNameShouldThrowNPE(){
        heroRepository.remove(null);
    }

    @Test
    public void testRemoveExistingHero(){
        heroRepository.create(hero);
        Assert.assertEquals(1,heroRepository.getCount());
        Assert.assertFalse(heroRepository.remove("Ivan"));
        Assert.assertEquals(1,heroRepository.getCount());
        Assert.assertTrue(heroRepository.remove("Gencho"));
        Assert.assertEquals(0,heroRepository.getCount());
    }

    @Test
    public void testGetHeroWithHighestLevelShouldReturnNull(){
        Assert.assertNull(heroRepository.getHeroWithHighestLevel());
    }

    @Test
    public void testGetHeroWithHighestLevelShouldReturnGencho99(){
        heroRepository.create(hero);
        heroRepository.create(new Hero("Ivan", 10));
        heroRepository.create(new Hero("Petar", 12));
        String expectedResult = "Gencho";
        Assert.assertEquals("Gencho", heroRepository.getHeroWithHighestLevel().getName());
    }

    @Test
    public void testGetHeroReturnsTheCorrectHero() {
        heroRepository.create(hero);
        heroRepository.create(new Hero("Ivan", 10));
        String expectedResult = "Gencho";
        Assert.assertEquals("Gencho", heroRepository.getHero("Gencho").getName());
        Assert.assertNull(heroRepository.getHero("Petar"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetHeroesReturnsUnmodifiableCollection(){
        this.heroRepository.getHeroes().clear();
    }
}
