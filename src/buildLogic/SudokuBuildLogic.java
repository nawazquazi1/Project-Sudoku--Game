package buildLogic;

import java.io.IOException;

import computationLogic.GameLogic;
import persistence.LocalStorageImpl;
import problemdomain.IStorage;
import problemdomain.SudokuGame;
import userInterface.IUserInterfaceContract;
import userInterface.logic.ControlLogic;

public class SudokuBuildLogic {
	
	/**
     * This class takes in the uiImpl object which is tightly-coupled to the JavaFX framework,
     * and binds that object to the various other objects necessary for the application to function.
     */
	public static void build(IUserInterfaceContract.View userInterface) throws IOException {
		SudokuGame initialState;
		IStorage storage = new LocalStorageImpl();
		
		try {
			// will throw if no game data is found in local storage
			
			initialState = storage.getGameData();
		} catch (IOException e) {
			initialState = GameLogic.getNewGame();
			// this method below will also throw an IOException
			// if we cannot update the game data. At this point
			// the application is considered unrecoverable
			storage.updateGameData(initialState);
		}
		
		IUserInterfaceContract.EventListener uiLogic = new ControlLogic(storage, userInterface);
		userInterface.setListener(uiLogic);
		userInterface.updateBoard(initialState);
	}
	
}
