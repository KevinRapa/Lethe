# Salamaa
This holds the current iteration of a large text-based adventure game.
The final title is "Lethe".

The entire game is written in Java. Lethe is a personal project of mine
that began before I could even code in Java, and I have been working on
it as my experience with Java has developed. 

To play, just execute the .jar. Make sure the ambience and effects folders
are in the same directory as the .jar.

The game employs a save feature using serialization, a Swing GUI, sound,
heavy regex usage, and a bit of multithreading, particularly in the Laboratory
and the Tunnels.Dungeon_Monst class.

The primary classes for the game are held in the A_Main package. Any class that
is a parent class is held in the A_Super package. Interfaces and enums are held
there too. All other packages represent rooms. Room classes consist of only four
character corresponding to their ID.

Each room mantains a list of rooms adjacent to it, so the game map is essentially a
graph given directional properties with a 3D array structure.
