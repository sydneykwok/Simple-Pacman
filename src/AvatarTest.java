/**
* Test for AI class in Simple_Pacman
javac Avatar.java
javac -cp .;junit-4.12.jar;hamcrest-core-1.3.jar *.java
java -cp .;junit-4.12.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore AvatarTest
* @author T10-G02
*/

import static org.junit.Assert.*;
import org.junit.Test;
import constants.ConstantVariables;
import java.lang.Math;
import java.util.ArrayList;


public class AvatarTest {

	//Constructor Tests

	@Test
	public void test_constructor_left() {
		Avatar testAv = new Avatar(0, 1); //Spawn inside wall on left side

		assertEquals("Tried creating the player at an invalid x position, too far left - [x-coord]\n", "" + ConstantVariables.INITIAL_X + ", " + ConstantVariables.INITIAL_Y, "" + testAv.getXCoord() + ", " + testAv.getYCoord());
	}


	@Test
	public void test_constructor_top() {
		Avatar testAv = new Avatar(1, 0); //Spawn inside wall along top row

		assertEquals("Tried creating the player at an invalid y position, too high up - [y-coord]\n", "" + ConstantVariables.INITIAL_X + ", " +  ConstantVariables.INITIAL_Y, "" + testAv.getXCoord() + ", " +  testAv.getYCoord());
	}


	@Test
	public void test_constructor_right() {
		Avatar testAv = new Avatar(ConstantVariables.NUM_COL, 1); //Spawn inside wall on right side

		assertEquals("Tried creating the player at an invalid x position, too far right - [x-coord]\n", "" + ConstantVariables.INITIAL_X + ", " +  ConstantVariables.INITIAL_Y, "" + testAv.getXCoord() + ", " +  testAv.getYCoord());
	}


	@Test
	public void test_constructor_bottom() {
		Avatar testAv = new Avatar(1, ConstantVariables.NUM_ROWS); //Spawn inside wall along top row

		assertEquals("Tried creating the player at an invalid y position, too far down - [y-coord]\n", "" + ConstantVariables.INITIAL_X + ", " +  ConstantVariables.INITIAL_Y, "" + testAv.getXCoord() + ", " +  testAv.getYCoord());
	}


	@Test
	public void test_constructor_proper() {
		Avatar testAv = new Avatar(6, 3); //Acceptable spawn

		assertEquals("Tried creating a valid player, [x, y]", "63", "" + testAv.getXCoord() + testAv.getYCoord());
	}


	@Test
	public void test_constructor_defaultStart() {
		Avatar testAv = new Avatar(ConstantVariables.INITIAL_X, ConstantVariables.INITIAL_Y); //Acceptable spawn

		assertEquals("Tried creating a valid player, [x, y]", "" + ConstantVariables.INITIAL_X + ConstantVariables.INITIAL_Y, "" + testAv.getXCoord() + testAv.getYCoord());
	}


	@Test
	public void test_copyConstructor_xy() {
		Avatar testAv = new Avatar(5, 1);
		Avatar leak = new Avatar(testAv);

		assertEquals("Copied Avatar(5, 1), checking [x, y] coordinates", "51", "" + leak.getXCoord() + leak.getYCoord());
	}


	@Test
	public void test_copyConstructor_score() {
		Avatar testAv = new Avatar(1, 1);
		testAv.addScore(); 
		testAv.addScore();
		Avatar leak = new Avatar(testAv);

		assertEquals("Copied Avatar, score is 2", 2, leak.getScore());
	}


	//Getters and Setters
	
	@Test
	public void test_getScore() {
		Avatar testAv = new Avatar(1, 1);
		for (int i = 0; i < 12; i++) {
			testAv.addScore();
		}

		assertEquals("Testing getScore, created with a score of 12", 12, testAv.getScore());
	}


	@Test
	public void test_addScore() {
		Avatar testAv = new Avatar(1, 1);
		for (int i = 0; i < 5; i++) {
			testAv.addScore();
		}

		assertEquals("Testing addScore, added 5 points", 5, testAv.getScore());
	}


	@Test
	public void test_setScore_validUpper() {
		Avatar testAv = new Avatar(1, 1);
		testAv.setScore(606);

		assertEquals("Created Avatar and set score to 606", 606, testAv.getScore());
	}


	@Test
	public void test_setScore_invalidUpper() {
		Avatar testAv = new Avatar(1, 1);
		testAv.setScore(607);

		assertEquals("Created Avatar and set score to 607", 0, testAv.getScore());
	}


	@Test
	public void test_setScore_validLower() {
		Avatar testAv = new Avatar(1, 1);
		testAv.setScore(0);

		assertEquals("Created Avatar and set score to 0", 0, testAv.getScore());
	}


	@Test
	public void test_setScore_invalidLower() {
		Avatar testAv = new Avatar(1, 1);
		testAv.setScore(-5);

		assertEquals("Created Avatar and set score to an invalid -5", 0, testAv.getScore());
	}


	//Other Methods

	@Test
	public void test_changeDirection_invalidButton() {
		Avatar testAv = new Avatar(1, 1);
		ItemProcess items = new ItemProcess("maze.txt");
		ArrayList<String> goThrough = new ArrayList<String>(); //List of elements to try
		goThrough.add("e"); //Add keys to try
		goThrough.add("Bop");
		goThrough.add("A");
		goThrough.add("ow");
		goThrough.add("rasdw");

		for (int x = 0; x < goThrough.size() - 1; x++) {
			testAv.changeDirection(goThrough.get(x), items);

			assertEquals("Tried moving using valid keys", "00", "" + testAv.getDir(0) + testAv.getDir(1)); //Test for each element in list
		}
	}


	@Test
	public void test_changeDirection_validButton() {
		Avatar testAv = new Avatar(1, 1);
		ItemProcess items = new ItemProcess("maze.txt");
		ArrayList<String> goThrough = new ArrayList<String>(); //List of elements to try
		String dir = ""; //Expected direction output
		goThrough.add("d"); //Add keys to try
		goThrough.add("dab on them");
		goThrough.add("a");
		goThrough.add("w");
		goThrough.add("s");

		for (int x = 0; x < goThrough.size() - 1; x++) {
			testAv.changeDirection(goThrough.get(x), items);
			
			if (x == 0 || x ==1) {
				dir = "10"; //Moving right
			} else if (x == 2) {
				dir = "-10"; //Moving left
			} else if (x == 3) {
				dir = "0-1"; //Moving up
			} else {
				dir = "01"; //Moving down
			}

			assertEquals("Tried moving using valid keys", dir, "" + testAv.getDir(0) + testAv.getDir(1)); //Test for each element in list
		}
	}


}
