package iloveyouboss;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreCollectionTest {
    ScoreCollection collection;

    @BeforeEach
    void setup() {
        collection = new ScoreCollection();
    }

    @Test
    void answerArithmeticMeanOfTwoNumbers() {
        collection.add(() -> 5);
        collection.add(() -> 7);

        int actual = collection.arithmeticMean();

        assertEquals(6, actual);
    }

    @Test
    @DisplayName("nullを追加すると例外が発生する")
    void throwsExceptionWhenAddingNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            collection.add(null);
        });
    }

    @Test
    @DisplayName("何も追加されていない場合はゼロを返す")
    void answersZeroWhenNoElementsAdded() {
        assertEquals(0, collection.arithmeticMean());
    }

    @Test
    @DisplayName("Integerとしてのオーバーフローに対処する")
    void dealsWithIntegerOverflow() {
        collection.add(() -> Integer.MAX_VALUE);
        collection.add(() -> 1);
        assertEquals(1073741824, collection.arithmeticMean());
    }
}
