
# Weekend Kotlin Challenge: Guess the Word

Welcome to the Weekend Kotlin Challenge! This repository contains a fun and interactive word guessing game implemented in Kotlin. The aim of this game is to help you improve your Kotlin programming skills while having a great time. We encourage you to contribute by adding more features or enhancing existing ones using Kotlin's unique capabilities.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [How to Play](#how-to-play)
- [Contributing](#contributing)
- [License](#license)

## Introduction

The game involves guessing a secret word that the program randomly selects from a predefined list. As you guess letters, the program provides hints showing which letters have been correctly guessed and which ones are still missing. The game is case-insensitive, so you can enter letters in either uppercase or lowercase.

## Features

- **Extension Functions:** Utilized to check and add attempts in a more intuitive way.
- **Lambda Expressions:** Used to handle user input and ensure it is not null before processing.
- **Case Insensitivity:** Allows letters to be entered in either uppercase or lowercase without affecting the comparison.

## How to Play

1. Clone the repository:
    ```sh
    git clone https://github.com/mundodigitalpro/KotlinGuessWordGame.git
    ```
2. Open the project in your favorite Kotlin editor or IDE.
3. Run the program.
4. Follow the prompts to guess the secret word by entering letters one by one.

Here's a snippet of the game code:

```kotlin
fun main() {
    val words = listOf("kotlin", "programming", "challenge", "weekend", "code")
    val secretWord = words.random().lowercase()
    val attempts = mutableSetOf<Char>()
    var correctGuesses = 0

    fun MutableSet<Char>.addAttempt(letter: Char): Boolean {
        return if (letter in this) {
            println("You've already tried the letter '$letter'!")
            false
        } else {
            this.add(letter)
            true
        }
    }

    println("Welcome to the word guessing game!")
    println("The secret word has ${secretWord.length} letters.")

    while (correctGuesses < secretWord.length) {
        print("Guess a letter: ")
        val letter = readLine()?.firstOrNull()?.lowercaseChar()

        letter?.let {
            if (attempts.addAttempt(it) && it in secretWord) {
                correctGuesses = secretWord.count { it in attempts }
                println("Well done! The letter '$it' is in the word.")
            } else if (it !in secretWord) {
                println("Try again!")
            }
        }

        val hint = secretWord.map { if (it in attempts) it else '_' }.joinToString(" ")
        println("Word: $hint")
    }

    println("Congratulations! You've guessed the word: $secretWord")
}
```

## Contributing

We encourage all participants to contribute and make this game even more "Kotlin". Here are some ideas on how you can contribute:

- **Add more extension functions:** Think of other operations that could benefit from extension functions to make the code cleaner and more modular.
- **Improve the user interface:** Add more messages, colors, or any other details to make the game more user-friendly.
- **Implement a scoring system:** Keep track of attempts and the time it took to guess the word to add a competitive component.
- **Add more words:** Extend the word list to make the game more varied and challenging.

### Steps to Contribute

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes.
4. Commit your changes (`git commit -m 'Add some feature'`).
5. Push to the branch (`git push origin feature-branch`).
6. Open a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

We look forward to your contributions to make this game even more interesting and challenging. Happy coding!
