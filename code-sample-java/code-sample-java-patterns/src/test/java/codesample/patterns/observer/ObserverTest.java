package codesample.patterns.observer;

import org.junit.Before;
import org.junit.Test;
import patterns.observer.ObserverBar;
import patterns.observer.SubjectImpl;

import java.util.Random;

import static org.junit.Assert.*;

public class ObserverTest {

    private Random rnd;
    private ObserverBar obs1;
    private ObserverBar obs2;
    private SubjectImpl subj;

    @Before
    public void init() {
        int randomSeed = 0;
        rnd = new Random(randomSeed);
        subj = new SubjectImpl();
        obs1 = new ObserverBar();
        obs2 = new ObserverBar();
    }

    @Test
    public void removeObserverTest() {
        subj.registerObserver(obs1);
        subj.registerObserver(obs2);

        subj.setSomeValue(rnd.nextInt());
        subj.notifyObservers();
        subj.removeObserver(obs2);

        int randomValue = rnd.nextInt();
        subj.setSomeValue(randomValue);
        subj.notifyObservers();

        assertEquals(randomValue, obs1.getSomeValue());
        assertNotEquals(randomValue, obs2.getSomeValue());
    }

    @Test
    public void notifyObserverTest() {
        subj.registerObserver(obs1);
        subj.registerObserver(obs2);

        int randomValue = rnd.nextInt();
        subj.setSomeValue(randomValue);
        subj.notifyObservers();

        assertEquals(randomValue, obs1.getSomeValue());
        assertEquals(randomValue, obs2.getSomeValue());
    }
}
