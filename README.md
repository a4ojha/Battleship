# Welcome to Battleship! #

## Description
This is an in-console Java implementation of the classic Battleship game, played between the user and CPU. I created this project to practice OOP (object oriented programming) through the use of inheritance and polymorphism. For future updates I hope to implement a drowned ship detection system, and an overall better looking UI. 

## Instructions ##
Ensure Java is installed on your device (install [here](https://www.java.com/en/download/help/download_options.html "(target|_blank)"))
Clone this repo or download the following files into a _single_ folder:
- [BattleshipGame.java](BattleshipGame.java)
- [CPU.java](CPU.java)
- [Main.java](Main.java)
- [Player.java](Player.java)
- [Ship.java](Ship.java)

Run Main.java on your IDE, game will now be playable on your console

## Rules ##

<img src="https://creazilla-store.fra1.digitaloceanspaces.com/cliparts/3868258/battleship-clipart-md.png" width="450" height="200" />

### You will be given _5 ships_:

- Aircraft Carrier (**_5 squares_**)

- Crusier (**_3 Squares_**)

- Destroyer (**_2 Squares_**)

- 2 Boats (**_1 Square_**)

These ships will be randomly assigned a position on the 10x10 grid that is printed to the console.

In this game, you will be playing against the computer in a game of battleship:

<img src="https://i.postimg.cc/ZnKNhjVj/Screenshot-2023-12-02-141526.png" width="500" height="520" />

### Key:
- □ = empty spot
- X = alive ship
- ■ = hit ship
- ◪ = misfire

You and the computer will take turns firing shots at each other's grid, without seeing each other's ship placement. With each turn, you will enter the coordinates for where you want to attack, and your opponent will shoot at a random spot on your grid.

The goal is to destroy all 5 of your opponent's ships!

Once either you or the CPU wins, both boards will be displayed to reveal possible leftover ships of your opponent. Good luck and have fun!
