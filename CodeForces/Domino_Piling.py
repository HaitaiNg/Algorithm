#CodeForces 
#Domino Piling
#Python 3.6.5 

import sys 

m_and_n = input()
m_and_n = m_and_n.split()
m = int(m_and_n[0])
n = int(m_and_n[1])
product = int(m) * int(n)
while(True):
    if(product % 2 == 0):
        print(int(product/2))
        break
    product -=1
    if(product == 0):
        print(0)
        break 

