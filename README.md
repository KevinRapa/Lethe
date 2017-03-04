# Lethe
This holds the current iteration of a large text-based adventure game.
The final title is <i>"Lethe"</i>.

The entire game is written in Java. Lethe is a personal project of mine
that began before I could even code in Java, and I have been working on
it as my experience with Java has developed. 

To play, just execute the .jar. <b>Make sure Title.jpg, and the ambience, maps and effects folders
are in the same directory as the .jar!</b>.

The game employs a save feature using serialization, a Swing GUI, sound,
heavy regex usage, and a bit of multithreading, particularly in the Laboratory
and the <code>Tunnels.Dungeon_Monst</code> class.

The primary classes for the game are held in the <code>A_Main</code> package. Any class that
is a parent class is held in the <code>A_Super</code> package. Interfaces and enums are held
there too. All other packages represent rooms. Room classes are named according to 
their IDs, which are four characters long.

Each room mantains a list of rooms adjacent to it, so the game map is essentially a
graph given directional properties with a 3D array structure.
