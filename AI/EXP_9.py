#Knowledge representation


#Code for procedural knowledge
# Function to calculate the sum of a list of numbers

'''
Procedural knowledge refers to knowledge about how to do something, rather than just knowledge about facts or relationships. 
In computer programming, procedural knowledge is often represented using algorithms or code that describes a sequence of steps to achieve a particular goal.
Here's an example of how to represent procedural knowledge using Python:
'''
def sum_list(numbers):
    result = 0
    for num in numbers:
        result += num
    return result

# Test the function with a list of numbers
my_list = [1, 2, 3, 4, 5]
print(sum_list(my_list))

'''
In the above example, the sum_list function takes a list of numbers as input and returns the sum of those numbers. 
The function uses a for loop to iterate over each number in the list and add it to a running total (result). 
Finally, the function returns the total sum.
The print statement is used to test the function with a sample list of numbers and print the result.
'''

#OUTPUT
'''
15
'''

'''
This code represents procedural knowledge in the form of a function that performs a specific task. 
The function can be reused with different inputs to perform the same task, making it a powerful tool for automating complex processes. 
Procedural knowledge can be represented using many different programming languages and frameworks, depending on the task and the requirements of the application.
'''
