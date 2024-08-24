let randomNumber = Math.floor(Math.random() * 100) + 1;
let attempts = 0;
const maxAttempts = 10;

document.getElementById('guess').addEventListener('keydown', function(event) {
    if (event.key === 'Enter') {
        checkGuess();
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
        result.textContent = 'Congrats! You guessed the right number!';
    }

    if (attempts === maxAttempts && guess != randomNumber) {
        result.textContent = `Game Over. The right number was ${randomNumber}.`;
    }

    
    guessInput.value = '';
    guessInput.focus();
}
