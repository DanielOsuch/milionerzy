import java.util.ArrayList;
import java.util.List;

public class SimpleQuestionGenerator implements QuestionGenerator {
    @Override
    public List<Question> generateQuestions() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Czy 1410 to rok bitwy pod Grunwaldem?",true));
        questions.add(new Question("Czy OOP to projektowanie obiektowe?",true));
        questions.add(new Question("Czy w Warszawie można podróżować metrem?",true));
        questions.add(new Question("Czy Polska leży na południu Europy?",false));
        questions.add(new Question("Czy Berlin to stolica Niemiec?",true));
        questions.add(new Question("Czy Faceook jest płatnym serwisem społecznościowym?",false));
        return questions;
    }
}
