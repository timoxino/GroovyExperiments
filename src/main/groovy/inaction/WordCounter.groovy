package inaction

def inputText = """ Look for the bare necessities
The simple bare necessities
Forget about your worries and your strife
I mean the bare necessities
Old Mother Nature's recipes
That bring the bare necessities of life
"""

def words = inputText.tokenize()
def wordFrequency = [:]

words.each { word ->
    wordFrequency[word] = wordFrequency.get(word, 0) + 1
}

def keys = wordFrequency.keySet().toList()
keys.sort({ wordFrequency[it] })

report = "\n"
keys[-1..-5].each {word ->
    report += word.padLeft(12) + ': '
    report += wordFrequency[word] + '\n'
}

assert report == """
 necessities: 4
        bare: 4
         the: 3
        your: 2
        life: 1
"""