import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class QuizFrame extends JFrame implements ActionListener {

    //JLabel = text;
    //JButton = przycisk;
    private QuestionGenerator questionGenerator;
    private List<Question> questionList = new ArrayList<Question>();
    private int currentQuestion;
    private JLabel jLabel;
    private byte numberOfPoints;

    public void setQuestionGenerator(QuestionGenerator questionGenerator) {
        this.questionGenerator = questionGenerator;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public QuizFrame() {
        setQuestionGenerator(new FromFileGenerator());
        setQuestionList(questionGenerator.generateQuestions());
        setDefaultFrameProperities();
        setDefaultView();

    }

    private void setDefaultView() {
        jLabel = new JLabel(questionList.get(currentQuestion).getText());
        jLabel.setHorizontalAlignment(JLabel.CENTER);
        JButton yesButton = new JButton(Answer.YES.toString());
        yesButton.addActionListener(this);
        JButton noButton = new JButton(Answer.NO.toString());
        noButton.addActionListener(this);
        add(jLabel);
        add(yesButton);
        add(noButton);
    }

    private void setDefaultFrameProperities() {
        setLayout(new GridLayout(3, 1));
        setSize(500, 500);
        setTitle("Quizownia");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new QuizFrame();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button.getText().equals(Answer.YES.toString())) {
            if (questionList.get(currentQuestion).isCorrect())
                numberOfPoints++;
        }
        if (button.getText().equals(Answer.NO.toString())) {
            if (!questionList.get(currentQuestion).isCorrect())
                numberOfPoints++;
        }
        currentQuestion++;
        if (currentQuestion == questionList.size()) {
            JOptionPane.showMessageDialog(null, "Zdobyłeś " + numberOfPoints + " punktów, na "+questionList.size()+" możliwych!");
            System.exit(0);
        } else {
            jLabel.setText(questionList.get(currentQuestion).getText());
        }

    }

}