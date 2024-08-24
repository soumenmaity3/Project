document.addEventListener('DOMContentLoaded', () => {
    const submitButton = document.getElementById('submit');
    const hintButton = document.getElementById('hint-button');
    const guessInput = document.getElementById('guess');
    const playAgainInput = document.getElementById('play-again-input');
    const result = document.getElementById('result');
    const hint = document.getElementById('hint');
    const errorMessage = document.getElementById('error-message');
    const initialMessage = document.getElementById('initial-message');
    let randomNumber = Math.floor(Math.random() * 100) + 1;
    let attempts = 0;
    const maxAttempts = 10;
    let hintAttempts = 0;
    const maxHintAttempts = 3;

    submitButton.addEventListener('click', checkGuess);
    hintButton.addEventListener('click', showHint);

    guessInput.addEventListener('keydown', function(event) {
        if (event.key === 'Enter') {
            if (guessInput.value.trim() !== '') {
                checkGuess();
            } else {
                alert('Please enter a guess.');
            }
        }
    });

    playAgainInput.addEventListener('keydown', function(event) {
        if (event.key === 'Enter') {
            if (playAgainInput.value.trim() !== '') {
                playAgain();
            } else {
                alert('Please enter yes or no.');
            }
        }
    });

    function checkGuess() {
        const guess = guessInput.value.trim();
        if (guess === '') {
            alert('Please enter a guess.');
            return;
        }

        const guessNumber = parseInt(guess);
        attempts++;

        if (guessNumber < randomNumber) {
            result.textContent = `Enter a higher number. Attempts: ${attempts}/${maxAttempts}`;
        } else if (guessNumber > randomNumber) {
            result.textContent = `Enter a lower number. Attempts: ${attempts}/${maxAttempts}`;
        } else {
            result.textContent = `Congrats! You guessed the right number in ${attempts}/${maxAttempts} attempts!\nPlay again? (yes or no)`;
            endGame();
            return;
        }

        if (attempts === maxAttempts && guessNumber !== randomNumber) {
            result.textContent = `Game Over. The right number was ${randomNumber}. You used ${attempts}/${maxAttempts} attempts.\nPlay again? (yes or no)`;
            endGame();
        }

        guessInput.value = '';
        guessInput.focus();
    }

    function showHint() {
        if (hintAttempts < maxHintAttempts) {
            hintAttempts++;
            const hints = [
                `Hint: The number is ${randomNumber % 2 === 0 ? 'even' : 'odd'}.`,
                `Hint: The number is ${randomNumber > 50 ? 'greater' : 'less'} than 50.`,
                `Hint: The number is ${randomNumber % 3 === 0 ? 'a multiple of 3' : 'not a multiple of 3'}.`
            ];
            hint.textContent = `${hints[hintAttempts - 1]} (Hint ${hintAttempts}/${maxHintAttempts})`;
            if (hintAttempts === maxHintAttempts) {
                hintButton.textContent = 'Show Answer';
                hintButton.onclick = showAnswer;
            }
        } else {
            hint.textContent = `No more hints available. (Hint ${hintAttempts}/${maxHintAttempts})`;
        }
    }

    function showAnswer() {
        result.textContent = `The right number was ${randomNumber}. You used ${attempts}/${maxAttempts} attempts.\nPlay again? (yes or no)`;
        endGame();
    }

    function endGame() {
        guessInput.style.display = 'none';
        submitButton.style.display = 'none';
        hintButton.style.display = 'none';
        document.getElementById('play-again').style.display = 'block';
        initialMessage.style.display = 'none'; // Hide the initial message
        playAgainInput.focus();
    }

    function playAgain() {
        const playAgainValue = playAgainInput.value.toLowerCase();
        if (playAgainValue === 'yes') {
            randomNumber = Math.floor(Math.random() * 100) + 1;
            attempts = 0;
            hintAttempts = 0;
            result.textContent = '';
            hint.textContent = 'Hint: Try starting with 50!';
            guessInput.style.display = 'block';
            submitButton.style.display = 'block';
            hintButton.textContent = 'Hint';
            hintButton.onclick = showHint;
            hintButton.style.display = 'block';
            document.getElementById('play-again').style.display = 'none';
            playAgainInput.value = '';
            errorMessage.textContent = '';
            initialMessage.style.display = 'block'; // Show the initial message again
            guessInput.focus();
        } else if (playAgainValue === 'no') {
            result.textContent = 'Thank you for playing!';
            document.getElementById('play-again').style.display = 'none';
            playAgainInput.value = '';
            errorMessage.textContent = '';
        } else {
            errorMessage.textContent = 'Please write "yes" or "no".';
            errorMessage.style.color = 'red';
        }
    }
});
