#CodeForces
#Queue At the School
#Python 3.6.5

import sys

def studentSort(students, time, start):

    for i in range(start, len(students), 2):
        if(students[i] == "G" and students[i-1] == "B"):
            students[i-1], students[i] = "G","B"
            #print(students)
        else:
            pass
    if(len(students) % 2 == 1):
        if(students[-1] == "G" and students[-2] == "B"):
            students[-2], students[-1] = "G","B"
    time = time - 1

    if(start == 1):
        start = 0
    else:
        start = 1 
    
    if(time > 0):
        students = studentSort(students,time, start)

    if(start == 1):
        students.reverse()
    return students
        





studentCount_time = input().split()
time = int(studentCount_time[1]) 
students = list(input())
print(''.join(studentSort(students, time, 1)))
