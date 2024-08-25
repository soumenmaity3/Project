let randomNumber = Math.floor(Math.random() * 100) + 1;
let attempts = 0;
const maxAttempts = 10;
let hintAttempts = 0;
const maxHintAttempts = 3;

document.getElementById('guess').addEventListener('keydown', function(event) {
    if (event.key === 'Enter') {
        const guessInput = document.getElementById('guess');
        if (guessInput.value.trim() !== '') {
            checkGuess();
        } else {
            alert('Please enter a guess.');
        }
    }
});

document.getElementById('play-again-input').addEventListener('keydown', function(event) {
    if (event.key === 'Enter') {
        const playAgainInput = document.getElementById('play-again-input');
        if (playAgainInput.value.trim() !== '') {
            playAgain();
        } else {
            alert('Please enter yes or no.');
        }
    }
});

function checkGuess() {
    const guessInput = document.getElementById('guess');
    const guess = parseInt(guessInput.value.trim(), 10); // Ensure guess is an integer
    const result = document.getElementById('result');

    if (isNaN(guess)) {
        alert('Please enter a valid number.');
        return; // Exit the function if the input is empty or invalid
    }

    attempts++;

    if (guess < randomNumber) {
        result.textContent = `Enter a higher number. Attempts: ${attempts}/${maxAttempts}`;
    } else if (guess > randomNumber) {
        result.textContent = `Enter a lower number. Attempts: ${attempts}/${maxAttempts}`;
    } else {
        result.textContent = `Congrats! You guessed the right number in ${attempts}/${maxAttempts} attempts!\nPlay again? (yes or no)`;
        endGame();
        return;
    }

    if (attempts === maxAttempts && guess !== randomNumber) {
        result.textContent = `Game Over. The right number was ${randomNumber}. You used ${attempts}/${maxAttempts} attempts.\nPlay again? (yes or no)`;
        endGame();
    }

    guessInput.value = '';
    guessInput.focus();
}

function showHint() {
    const hint = document.getElementById('hint');
    const hintButton = document.getElementById('hint-button');
    if (hintAttempts < maxHintAttempts) {
        hintAttempts++;
        if (randomNumber % 2 === 0) {
            hint.textContent = `Hint: The number is even. (Hint ${hintAttempts}/${maxHintAttempts})`;
        } else {
            hint.textContent = `Hint: The number is odd. (Hint ${hintAttempts}/${maxHintAttempts})`;
        }
        if (hintAttempts === maxHintAttempts) {
            hintButton.textContent = 'Show Answer';
            hintButton.onclick = showAnswer;
        }
    } else {
        hint.textContent = `No more hints available. (Hint ${hintAttempts}/${maxHintAttempts})`;
    }
}

function showAnswer() {
    const result = document.getElementById('result');
    result.textContent = `Game Over. The right number was ${randomNumber}. You used ${attempts}/${maxAttempts} attempts.\nPlay again? (yes or no)`;
    endGame();
}

function endGame() {
    document.getElementById('guess').style.display = 'none';
    document.getElementById('submit').style.display = 'none';
    document.getElementById('hint-button').style.display = 'none';
    document.getElementById('play-again').style.display = 'block';
    document.getElementById('play-again-input').focus();
}

function playAgain() {
    const playAgainInput = document.getElementById('play-again-input').value.toLowerCase().trim();
    const message = document.getElementById('message');
    if (playAgainInput === 'yes') {
        randomNumber = Math.floor(Math.random() * 100) + 1;
        attempts = 0;
        hintAttempts = 0; // Reset hint attempts
        document.getElementById('result').textContent = '';
        document.getElementById('hint').textContent = 'Hint: Try starting with 50!'; // Reset hint text
        document.getElementById('guess').style.display = 'block';
        document.getElementById('submit').style.display = 'block';
        document.getElementById('hint-button').textContent = 'Hint'; // Reset hint button text
        document.getElementById('hint-button').onclick = showHint; // Reset hint button functionality
        document.getElementById('hint-button').style.display = 'block';
        document.getElementById('play-again').style.display = 'none';
        document.getElementById('play-again-input').value = '';
        document.getElementById('guess').focus();
        message.style.display = 'block'; 
    } else if (playAgainInput === 'no') {
        document.getElementById('result').textContent = 'Thank you for playing!';
        document.getElementById('play-again').style.display = 'none';
        document.getElementById('play-again-input').value = '';
        message.style.display = 'none'; // Hide the message
    } else {
        alert('Please enter "yes" or "no".');
        document.getElementById('play-again-input').focus();
    }
}
