package server.objects;

public class Question {
	
	private String question, correctAnswer;
	private String[] answer;
	
		
	public Question(String question, String[] answer, String correctAnswer) {
		super();
		this.question = question;
		this.answer = answer;
		this.correctAnswer = correctAnswer;
	}
	
	public String getQuestion() {
		return question;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String[] getAnswer() {
		return answer;
	}
	public void setAnswer(String[] answer) {
		this.answer = answer;
	}
	
}
