player1 = None
player2 = None
player1 = input("whats player 1's name?")
player2 = input("whats player 2's name?")
print(f"Hello {player1} and {player2}. {player1} will be using X and {player2} will be using O")
playerWon = False
numberOfTurns = 0
movesDictionary = {'1': '\t', '2': '\t', '3': '\t', '4': '\t', '5': '\t', '6': '\t', '7': '\t', '8': '\t', '9': '\t'}

def display_board(value, token):
    movesDictionary[value] = token
    print(f'\t {movesDictionary["1"]} | \t {movesDictionary["2"]} | {movesDictionary["3"]}')
    print("\t ------------")
    print(f'\t {movesDictionary["4"]} | \t {movesDictionary["5"]} | {movesDictionary["6"]}')
    print("\t ------------")
    print(f'\t {movesDictionary["7"]} | \t {movesDictionary["8"]} | {movesDictionary["9"]}')

while not playerWon:
    playerMove = None
    playerToken = None
    if numberOfTurns % 2 == 0:
        playerMove = player1
        playerToken = 'X'
    else:
        playerMove = player2
        playerToken = 'O'
    nextMove = input(f"Enter where you want next move {playerMove} (1-9):")
    userInput = int(nextMove)
    while not userInput < 10:
        nextMove = input(f"values can only be from (1-9), try again!")
        userInput = int(nextMove)
    numberOfTurns += 1
    display_board(nextMove, playerToken)



