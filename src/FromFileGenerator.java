import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FromFileGenerator implements QuestionGenerator {
    private String fileName = "C:\\Users\\Daniel\\IdeaProjects\\millionaires\\questions.txt";
    private static List<Question> questionList = new ArrayList<>();

    public static void createQuestion(String s) {
        boolean trueOrFalse;
        String secondPart = s.substring(s.indexOf('?') + 1).trim();
        int enumLength = secondPart.length();
        trueOrFalse = Answer.valueOf(secondPart).isCorrect();
        String f = s.substring(0, (s.length() - enumLength));
        questionList.add(new Question(f, trueOrFalse));
    }


    @Override
    public List<Question> generateQuestions() {

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach(FromFileGenerator::createQuestion);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return questionList;
    }
}


