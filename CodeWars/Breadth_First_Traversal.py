def do_breadth_first_traversal(binary_tree):
    '''
    binary_tree is a reference to a 'node' object with three properties:
        left  : node
        right : node
        tag   : int
    the left and right properties are references to child nodes.
    Leaf nodes (the bottom of the (upside-down) tree) have None left and right properties.
    Visit and return a list of tags in breath-first, left-to-right order.
    '''
    if(binary_tree == None):
        return tags 
    tags = []
    queue = []
    queue.append(binary_tree)
    while(len(queue) > 0):
        node = queue.pop(0)
        if(node.left != None):
            queue.append(node.left) 
        if(node.right != None):
            queue.append(node.right) 
        tags.append(node.tag) 
    return tags
