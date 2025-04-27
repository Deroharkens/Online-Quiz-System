import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filename = "questions.txt";  // Path to the questions file

        // Read questions from the file
        List<Question> questions = QuizGUI.readQuestionsFromFile(filename);

        // Check if questions were loaded successfully
        if (!questions.isEmpty()) {
            // Initialize the Quiz GUI with the loaded questions
            QuizGUI quizGUI = new QuizGUI(questions);
            quizGUI.initializeGUI();  // This can be expanded to launch a full GUI
        } else {
            System.err.println("No questions loaded. Please check the questions.txt file.");
        }
    }
}
