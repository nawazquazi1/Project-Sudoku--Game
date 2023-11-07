import java.io.IOException;

import org.javacoders.SudokuDemo.buildLogic.SudokuBuildLogic;
import org.javacoders.SudokuDemo.userInterface.IUserInterfaceContract;
import org.javacoders.SudokuDemo.userInterface.UserInterfaceImpl;

import javafx.application.Application;
import javafx.stage.Stage;

public class SudokuApplication extends Application {
	
	private IUserInterfaceContract.View uiImpl;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// get sudoku object for a new game
		uiImpl = new UserInterfaceImpl(primaryStage);
		
		try {
			SudokuBuildLogic.build(uiImpl);
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
