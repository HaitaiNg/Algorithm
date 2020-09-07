class Tree_Node:
    def __init__(self,root_value,children_nodes):
        self.value = root_value
        self.left_child = children_nodes[0]
        self.right_child = children_nodes[1]


def depth_first_search(Root_Node):
    if Root_Node.value is None:
        return

    stack = []
    stack.append(Root_Node.value)

    while(len(stack) > 0):

        node_value = stack.pop()
        print (node_value)
        children_nodes = nodes_dic[node_value]

        if not(len(children_nodes) == 1 and children_nodes[0] == None):
            if children_nodes[1] is not None:
                stack.append(children_nodes[1])
            if children_nodes[0] is not None:
                stack.append(children_nodes[0])
