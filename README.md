# Salamaa
This holds the current iteration of a large text-based adventure game.
The final title is "Lethe".

The entire game is written in Java. Salamaa is a personal project of mine
that began before I could even code in Java, and I have been working on
it as my experience with Java has developed. The game is in 'beta'. 

I still have plans to extend the natural language processing abilities of
the game. Currently, the most complex types of input the game parses are simple
<verb> <noun> commands (No articles or prepositions).

To play, just execute the .jar. Make sure the ambience and effects folders
are in the same directory as the .jar.

The game employs a save feature using serialization, a Swing GUI, sound,
heavy regex usage, and a bit of multithreading, particularly in the Laboratory
and the Tunnels.Dungeon_Monst class.

The primary classes for the game are held in the A_Main package. Any class that
is a parent class is held in the A_Super package. Interfaces and enums are held
there too. All other packages represent rooms. Room classes consist of only four
character corresponding to their ID.

The game works like a large tree. The 3D array of Room objects has a reference
to every room. Every room has references to the furniture inside it. Each furniture
has a reference to its own inventory, which has references to the items inside it.
With all these classes made serializable, all that must be done is to serialize
the tree root. This tree is mounted to the Player class with a static reference.

Each room mantains a list of rooms adjacent to it, so the game also works like a 
graph in that regard.
