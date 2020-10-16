def valid_parentheses(string):
    stack = [] 
    for i in string:
        if i == "(":
            stack.append("(")
        if i == ")":
            if "(" in stack:
                stack.remove("(") 
            else:
                return False 
    return len(stack) == 0 
    #your code here 
