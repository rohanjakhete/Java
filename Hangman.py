def isWordGuessed(secretWord, lettersGuessed): 
    ans = True
    for char in secretWord:
        if char not in lettersGuessed:
            ans = False
    return ans
# secretWord hidden here:
secretWord = 'harvard'
#secretWord hidden here:
def getGuessedWord(secretWord, lettersGuessed):
    ans = ''
    for char in secretWord:
        if char not in lettersGuessed:
            ans += ' _ '
        else:
            ans += char
    return ans

def getAvailableLetters(lettersGuessed):
    import string
    alphabet = string.ascii_lowercase
    ans = ''
    for char in alphabet:
        if char not in lettersGuessed:
            ans += char
    return ans

def hangman(secretWord):
    print('Welcome to the game, Hangman!')
    print('I am thinking of a word that is', str(len(secretWord)), 'letters long')
    print('Category: Famous Colleges')
    
    numGuesses = 8
    lettersGuessed = []
    availableLetters = getAvailableLetters(lettersGuessed)
    userGuess = ''
    answered = False
    
    while numGuesses != 0 and answered == False:
        print('-------------')
        print('You have', str(numGuesses), 'guesses left.')
        print('Available letters:', str(availableLetters))
        userGuess = input('Please guess a letter:')
        
        if userGuess in lettersGuessed:
            lettersGuessed.append(userGuess)
            print('Oops! You\'ve already guessed that letter:', getGuessedWord(secretWord, lettersGuessed))
        elif userGuess in secretWord:
            lettersGuessed.append(userGuess)
            print('Good guess:', getGuessedWord(secretWord, lettersGuessed))
        else:
            lettersGuessed.append(userGuess)
            print('Oops! That letter is not in my word')
            numGuesses -= 1
        
        availableLetters.replace(userGuess,'')
        availableLetters = getAvailableLetters(lettersGuessed)
        if isWordGuessed(secretWord, lettersGuessed):
            answered = True
    
    print('---------')
    if answered == True:
        print('Congrats, you have won')
    else:
        print('Sorry, you ran out of guesses. The word was', str(secretWord))
        
        

hangman(secretWord)