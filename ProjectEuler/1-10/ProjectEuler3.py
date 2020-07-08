"""
Description: The prime factors of 13195 are 5,7,13
and 29. What is the largest prime factor of 
a given number N? Completed using Python 3.7.5 

This solution is based off of : Oussama Zaki
"""


#!/bin/python3

import sys


t = int(input().strip())
for a0 in range(t):
    n = int(input().strip())
    #Ssieve of eratosthenes