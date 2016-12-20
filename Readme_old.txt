Thank you for taking the time to look over the game I have been working on.
I have been working on it for about 6 months now. I hope you might find this
interesting.

For kicks, I have coded a non-player character into the game that will
play blackjack with you if you speak to it (according to the specification). 

Here's some short instructions that I hope will give a feel for some of the types
of things I integrated into the game. This is a text-based game with a GUI for
inputting commands. To run the game, just execute the .jar file in /dist.
You can also of course run it from the IDE.

The main method is located in the package "Core" in class "Salamaa.java"
You may collapse all the folds to make things easier to read.

1. If the Game window is too large, then:
	at the first line under the main method, pass false to the GUI constructor.

2. The second to last line in the Driver class "Salamaa.java" sets the player location (me.setOccupies(cou4))
	cou4 (Courtyard 4) is the default starting location.
	
	To interact with the NPC that plays blackjack, change cou4 to cou6, then start the game.
		You will start in the area with the NPC. Enter 'x' in the text field and type 'play ghost'
	Alternatively, just start the game without changing anything, then walk north ('w'), east ('d'), and north again. You will be in the same area.
	
	the code for the blackjack playing NPC is in package "Courtyard" class "Cou6_BlackJackGhost.java"
	the related "Deck" and "Card" class I wrote can be found in the same package.
	I included some test cases you can uncomment in the BlackJackGhost class.

3. You can try a couple puzzles I designed for it. An illustration of them I included in the project.
	1. Try setting your starting location in obs1 (me.setOccupies(obs1) - bottom of Salamaa.java)  
	2. Enter 'x' to interact and enter 'rotate statues'. Play around with this a little. The solution is inside Puzzle_Designs.jpg
	
	3. Try setting your starting location in gal2 (me.setOccupies(gal2))  
	4. Uncomment what I wrote at the bottom of Salamaa.java and start the game
	5. Try storing the orb in the statue and then walking west ('a')
	6. There's a dragon statue in this room. Search the dragon ('e' and then type 'dragon')
	7. Try exchanging the foci in your inventory with the dragon. This is a light-based puzzle so the light will change color.
	8. Design for this in Puzzle_Designs.jpg. The object is to insert the lenses in the correct order to charge the orb
		that the statue holds.

4. Otherwise, just start the game in cou4 (me.setOccupies(cou4)). The game has built-in help, but it's not too complicated to play.