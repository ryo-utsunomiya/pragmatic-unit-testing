package iloveyouboss;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreCollectionTest {

    @Test
    void answerArithmeticMeanOfTwoNumbers() {
        var collection = new ScoreCollection();
        collection.add(() -> 5);
        collection.add(() -> 7);

        int actual = collection.arithmeticMean();

        assertEquals(6, actual);
    }
}
