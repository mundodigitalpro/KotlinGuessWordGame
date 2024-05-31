package dev.josejordan

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
        val letter = readlnOrNull()?.firstOrNull()?.lowercaseChar()

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