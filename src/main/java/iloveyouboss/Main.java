package iloveyouboss;

public class Main {
    public static void main(String[] args) {
        var collection = new ScoreCollection();
        collection.add(() -> 5);
        collection.add(() -> 7);
        System.out.println(collection.arithmeticMean());
    }
}
