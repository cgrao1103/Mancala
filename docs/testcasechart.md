
1. captureStones(int stoppingPoint)

Test Cases:
Test Case ID    Input    Expected Output
1    stoppingPoint = 5    Number of stones captured
2    stoppingPoint = 11    Number of stones captured
3    stoppingPoint = 0    PitNotFoundException
4    stoppingPoint = 13    PitNotFoundException


2. distributeStones(int startingPoint)

Test Cases:
Test Case ID    Input    Expected Output
1    startingPoint = 5    Number of stones added
2    startingPoint = 11    Number of stones added
3    startingPoint = 0    PitNotFoundException
4    startingPoint = 13    PitNotFoundException


3. getNumStones(int pitNum)

Test Cases:
Test Case ID    Input    Expected Output
1    pitNum = 5    Number of stones
2    pitNum = 11    Number of stones
3    pitNum = 0    PitNotFoundException
4    pitNum = 13    PitNotFoundException


4. isSideEmpty(int pitNum)

Test Cases:
Test Case ID    Input    Expected Output
1    pitNum = 5    True/False (Empty/Not Empty)
2    pitNum = 11    True/False (Empty/Not Empty)
3    pitNum = 0    PitNotFoundException
4    pitNum = 13    PitNotFoundException


5. resetBoard()

Test Case:
Test Case ID    Expected Output
1    Board is reset with initial configuration


6. registerPlayers(Player one, Player two)

Test Cases:
Test Case ID    Input    Expected Output
1    Players one and two provided    Players are registered with their respective stores
2    One or both players are null    IllegalArgumentException
