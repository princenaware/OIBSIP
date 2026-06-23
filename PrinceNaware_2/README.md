# 🎯 Number Guessing Game

A console-based Java application developed as part of the **Oasis Infobyte Java Development Internship**.

The game generates a random number between **1 and 100**, and the player has to guess the correct number within a limited number of attempts. After each guess, the program provides hints indicating whether the guessed number is too high or too low.

---

## 📌 Project Overview

The Number Guessing Game is designed to demonstrate the implementation of fundamental Java programming concepts such as:

- User Input Handling
- Random Number Generation
- Conditional Statements
- Loops
- Score Calculation
- Input Validation
- Program Flow Control

This project provides an interactive and engaging way to understand core Java concepts through practical implementation.

---

## 🚀 Features

### ✅ Random Number Generation
- Generates a random number between 1 and 100.
- A new random number is generated for every round.

### ✅ Interactive Gameplay
- Accepts user guesses through the console.
- Provides real-time feedback.

### ✅ High / Low Hints
- Displays "Too High!" if the entered number is greater than the target number.
- Displays "Too Low!" if the entered number is smaller than the target number.

### ✅ Limited Attempts
- Maximum of 10 attempts per round.
- Game ends when all attempts are exhausted.

### ✅ Score System
- Calculates score based on the number of attempts used.
- Rewards users who guess the number in fewer attempts.

### ✅ Best Score Tracking
- Tracks and displays the highest score achieved during the session.

### ✅ Multiple Rounds
- Allows users to play multiple rounds without restarting the application.

### ✅ Input Validation
- Prevents invalid inputs.
- Ensures only valid numeric values are accepted.

### ✅ User-Friendly Interface
- Clean and structured console output.
- Easy-to-understand messages and instructions.

---

## 🛠 Technologies Used

| Technology | Purpose |
|------------|----------|
| Java | Core Programming Language |
| Scanner Class | User Input Handling |
| Random Class | Random Number Generation |
| Loops | Repeated Execution |
| Conditional Statements | Decision Making |

---

## 📚 Java Concepts Used

### Variables
Used for storing:
- Secret Number
- User Guess
- Attempts
- Scores
- Best Score

### Scanner Class
Used to take user input from the console.

```java
Scanner sc = new Scanner(System.in);
```

### Random Class
Used to generate a random number.

```java
Random random = new Random();
int secretNumber = random.nextInt(100) + 1;
```

### Conditional Statements

```java
if(guess < secretNumber)
```

```java
else if(guess > secretNumber)
```

```java
else
```

### Loops

```java
while(attempts < maxAttempts)
```

### Input Validation

```java
if(!sc.hasNextInt())
```

### Boolean Variables

```java
boolean playAgain = true;
```

---

## 📊 Score Calculation

The score is calculated using:

```java
score = (maxAttempts - attempts + 1) * 10;
```

### Score Table

| Attempts Used | Score |
|--------------|--------|
| 1 | 100 |
| 2 | 90 |
| 3 | 80 |
| 4 | 70 |
| 5 | 60 |
| 6 | 50 |
| 7 | 40 |
| 8 | 30 |
| 9 | 20 |
| 10 | 10 |

---

## 🔄 Program Flow

```text
Start
  |
  V
Generate Random Number
  |
  V
Take User Input
  |
  V
Compare Guess
  |
  +----> Too Low
  |
  +----> Too High
  |
  +----> Correct Guess
              |
              V
       Calculate Score
              |
              V
       Play Again?
          /      \
        Yes      No
         |        |
         V        V
   New Round    End
```

---

## 📈 Flowchart

```text
 ┌─────────────┐
 │    Start    │
 └──────┬──────┘
        │
        ▼
 ┌─────────────┐
 │ Generate   │
 │ Random No. │
 └──────┬──────┘
        │
        ▼
 ┌─────────────┐
 │ Enter Guess │
 └──────┬──────┘
        │
        ▼
 ┌─────────────┐
 │ Compare     │
 │ Guess       │
 └──────┬──────┘
        │
 ┌──────┼──────┐
 ▼      ▼      ▼
Low   High  Correct
 │      │      │
 ▼      ▼      ▼
Hint  Hint  Score
 │      │      │
 └──────┴──────┘
        │
        ▼
 Play Again?
    │
 ┌──┴──┐
 ▼     ▼
Yes    No
 │      │
 ▼      ▼
Loop   End
```

---

## 🖥 Sample Output

```text
====================================
      NUMBER GUESSING GAME
====================================

I have selected a number between 1 and 100.
You have 10 attempts to guess it.

Enter your guess: 50

Too Low! Try Again.

Attempts Left: 9

Enter your guess: 75

Too High! Try Again.

Attempts Left: 8

Enter your guess: 63

Congratulations!
You guessed the number correctly.

Attempts Used : 3
Your Score    : 80
Best Score    : 80

Do you want to play again? (Y/N)
```

---

## 📂 Project Structure

```text
NumberGuessingGame/
│
├── NumberGuessingGame.java
│
└── README.md
```

---

## ▶️ How to Run

### Compile the Program

```bash
javac NumberGuessingGame.java
```

### Run the Program

```bash
java NumberGuessingGame
```

---

## 🎯 Learning Outcomes

This project helped in understanding:

- Java Fundamentals
- User Input Handling
- Random Number Generation
- Conditional Logic
- Looping Structures
- Input Validation
- Score Tracking
- Problem Solving
- Console Application Development

---

## 🔮 Future Enhancements

Possible improvements include:

- Java Swing GUI
- JavaFX Interface
- Difficulty Levels
- Timer-Based Gameplay
- Database Integration
- Global Leaderboard
- Multiplayer Mode
- Sound Effects
- Save and Load Progress

---

## 👨‍💻 Author

**Prince Naware**


### ⭐ If you found this project useful, consider giving it a star on GitHub.