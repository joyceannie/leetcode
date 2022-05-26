class TrieNode:
    
    def __init__(self):
        self.children = {}
        self.is_word = False

class WordDictionary:

    def __init__(self):
        self.root = TrieNode()

    def addWord(self, word: str) -> None:
        current = self.root
        for letter in word:
            if letter not in current.children:
                current.children[letter] = TrieNode()
            current = current.children[letter]
        current.is_word = True
        

    def search(self, word: str) -> bool:
                
        def helper(current, word):
            for index, letter in enumerate(word):
                if letter == '.':
                    for child in current.children.values():
                        if helper(child, word[index+1:]):
                            return True
                    return False
                else:
                    if letter not in current.children:
                        return False
                    current = current.children[letter]
            return current.is_word
        
        return helper(self.root, word)
