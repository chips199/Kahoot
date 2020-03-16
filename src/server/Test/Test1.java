package server.Test;

import server.main.Controller;
import server.objects.Question;

public class Test1 {

	public static void main(String[] args) {
		System.out.println("start");
		Controller controller = new Controller(10001);
		String [] answers = {"a", "b", "c", "d"};
		controller.addQuestion(new Question("A", answers));
		String [] answers2 = {"a2", "b2", "c2", "d2"};
		controller.addQuestion(new Question("A2", answers2));
		do {
			try {
				Thread.sleep(1000);
				System.out.println("test");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (controller.getPlayers().size() == 2);
		System.out.println("StarteQUiz" + controller.getPlayers().size());
		controller.startQuiz();
		controller.sendPointsToEach();
		System.out.println("fertig");
	}

}