#CodeForces
#Queue At The School
#Python

student_and_time = input().split()
student_and_time = [int(f) for f in student_and_time] 
students = list(input())
time = student_and_time[1]

while(time > 0):
    i = 0
    while( i < len(students) - 1):
        if( students[i] == "B" and students[i+1] == "G"):
            students[i], students[i + 1] = "G", "B"
            i += 1
        i+= 1
    time -= 1
print(''.join(students))
