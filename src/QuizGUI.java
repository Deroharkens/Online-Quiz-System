import java.io.*;
import java.util.*;

public class QuizGUI {
    private List<Question> questions;

    public QuizGUI(List<Question> questions) {
        this.questions = questions;
    }

    // Method to read questions from a file
    public static List<Question> readQuestionsFromFile(String filename) {
        List<Question> questions = new ArrayList<>();
        File file = new File(filename);

        // Check if the file exists
        if (!file.exists()) {
            System.err.println("Error: The file 'questions.txt' was not found in the directory.");
            return questions;  // Return an empty list if the file is not found
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String questionText = line;  // First line is the question
                String[] options = reader.readLine().split(",");  // Second line is the options
                int correctAnswerIndex = Integer.parseInt(reader.readLine());  // Third line is the correct answer index
                questions.add(new Question(questionText, options, correctAnswerIndex));  // Add the question to the list
            }
        } catch (IOException e) {
            System.err.println("Error reading questions from file: " + e.getMessage());
        }

        return questions;
    }

    // Method to initialize the GUI (simplified for this example)
    public void initializeGUI() {
        if (questions.isEmpty()) {
            System.err.println("No questions loaded. Please check the file.");
            return;
        }

        // Example: just print the first question (you should implement your GUI here)
        Question firstQuestion = questions.get(0);
        System.out.println("First Question: " + firstQuestion.getQuestionText());
        System.out.println("Options: ");
        for (String option : firstQuestion.getOptions()) {
            System.out.println(option);
        }
    }

    // Main method to test reading the file and initializing the GUI
    public static void main(String[] args) {
        String filename = "questions.txt";  // Relative path to the questions file
        List<Question> questions = readQuestionsFromFile(filename);

        // Ensure that questions are not empty before initializing the GUI
        if (!questions.isEmpty()) {
            QuizGUI quizGUI = new QuizGUI(questions);  // Pass questions to GUI
            quizGUI.initializeGUI();  // Call the method to initialize the GUI
        } else {
            System.err.println("Error: No questions loaded.");
        }
    }
}
