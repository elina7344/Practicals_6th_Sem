#AI AGENT

import random

def display(room):
    print(room)

room = [
    [1, 1, 1, 1],
    [1, 1, 1, 1],
    [1, 1, 1, 1],
    [1, 1, 1, 1],
]
print("All the rooom are dirty")
display(room)

x =0
y= 0

while x < 4:
    while y < 4:
        room[x][y] = random.choice([0,1])
        y+=1
    x+=1
    y=0

print("Before cleaning the room I detect all of these random dirts")
display(room)
x =0
y= 0
z=0
while x < 4:
    while y < 4:
        if room[x][y] == 1:
            print("Vaccum in this location now,",x, y)
            room[x][y] = 0
            print("cleaned", x, y)
            z+=1
        y+=1
    x+=1
    y=0
pro= (100-((z/16)*100))
print("Room is clean now, Thanks for using : 3710933")
display(room)
print('performance=',pro,'%')


#OUTPUT:
'''
All the rooom are dirty
[[1, 1, 1, 1], [1, 1, 1, 1], [1, 1, 1, 1], [1, 1, 1, 1]]
Before cleaning the room I detect all of these random dirts
[[0, 1, 1, 0], [0, 1, 0, 0], [1, 1, 0, 0], [1, 1, 0, 0]]
Vaccum in this location now, 0 1
cleaned 0 1
Vaccum in this location now, 0 2
cleaned 0 2
Vaccum in this location now, 1 1
cleaned 1 1
Vaccum in this location now, 2 0
cleaned 2 0
Vaccum in this location now, 2 1
cleaned 2 1
Vaccum in this location now, 3 0
cleaned 3 0
Vaccum in this location now, 3 1
cleaned 3 1
Room is clean now, Thanks for using : 3710933
[[0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0]]
performance= 56.25 %
'''
