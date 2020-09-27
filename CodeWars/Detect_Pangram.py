import string

def is_pangram(s):
    s = s.lower() 
    alphabet = "abcdefghijklmnopqrstuvwxyz"
    sett = set()
    for i in s:
        if i.lower() in alphabet:
            sett.add(i.lower()) 
    return len(sett) == 26