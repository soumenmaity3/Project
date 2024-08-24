let randomNumber = Math.floor(Math.random() * 100) + 1;
let attempts = 0;
const maxAttempts = 10;

document.getElementById('guess').addEventListener('keydown', function(event) {
    if (event.key === 'Enter') {
        checkGuess();
    }
});

document.getElementById('play-again-input').addEventListener('keydown', function(event) {
    if (event.key === 'Enter') {
        playAgain();
    }
});

function checkGuess() {
    const guessInput = document.getElementById('guess');
    const guess = guessInput.value;
    const result = document.getElementById('result');
    attempts++;

    if (guess < randomNumber) {
        result.textContent = `Enter a higher number. Attempts: ${attempts}/${maxAttempts}`;
    } else if (guess > randomNumber) {
        result.textContent = `Enter a lower number. Attempts: ${attempts}/${maxAttempts}`;
    } else {
        result.textContent = 'Congrats! You guessed the right number!\nPlay again? (yes or no)';
        endGame();
        return;
    }

    if (attempts === maxAttempts && guess != randomNumber) {
        result.textContent = `Game Over. The right number was ${randomNumber}.\nPlay again? (yes or no)`;
        endGame();
    }

    guessInput.value = '';
    guessInput.focus();
}

function endGame() {
    document.getElementById('guess').style.display = 'none';
    document.getElementById('submit').style.display = 'none';
    document.getElementById('play-again').style.display = 'block';
    document.getElementById('play-again-input').focus();
}

function playAgain() {
    const playAgainInput = document.getElementById('play-again-input').value.toLowerCase();
    if (playAgainInput === 'yes') {
        randomNumber = Math.floor(Math.random() * 100) + 1;
        attempts = 0;
        document.getElementById('result').textContent = '';
        document.getElementById('guess').style.display = 'block';
        document.getElementById('submit').style.display = 'block';
        document.getElementById('play-again').style.display = 'none';
        document.getElementById('play-again-input').value = '';
        document.getElementById('guess').focus();
    } else if (playAgainInput === 'no') {
        document.getElementById('result').textContent = 'Thank you for playing!';
        document.getElementById('play-again').style.display = 'none';
        document.getElementById('play-again-input').value = '';
    }
}
