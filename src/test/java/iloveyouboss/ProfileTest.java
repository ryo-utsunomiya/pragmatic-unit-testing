package iloveyouboss;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfileTest {

    @Test
    void matchAnswersFalseWhenMustMatchCriteriaNotMet() {
        var profile = new Profile("Bull Hockey, Inc.");
        var question = new BooleanQuestion(1, "ボーナスは支給されますか？");
        var profileAnswer = new Answer(question, Bool.FALSE);
        profile.add(profileAnswer);
        var criteria = new Criteria();
        var criteriaAnswer = new Answer(question, Bool.TRUE);
        var criterion = new Criterion(criteriaAnswer, Weight.MustMatch);
        criteria.add(criterion);

        boolean matches = profile.matches(criteria);
        assertFalse(matches);
    }

    @Test
    void matchAnswersTrueForAnyDontCareCriteria() {
        var profile = new Profile("Bull Hockey, Inc.");
        var question = new BooleanQuestion(1, "牛乳は支給されますか？");
        var profileAnswer = new Answer(question, Bool.FALSE);
        profile.add(profileAnswer);
        var criteria = new Criteria();
        var criteriaAnswer = new Answer(question, Bool.TRUE);
        var criterion = new Criterion(criteriaAnswer, Weight.DontCare);
        criteria.add(criterion);

        boolean matches = profile.matches(criteria);
        assertTrue(matches);
    }
}
