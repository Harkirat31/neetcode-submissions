class Node:
    def __init__(self,key,val):
        self.val = val
        self.key = key
        self.prev = None
        self.next = None

class LRUCache:

    def __init__(self, capacity: int): 
        self.left = Node(0,0)
        self.right = Node(0,0)
        self.left.next = self.right
        self.right.prev = self.left
        self.cache = {}
        self.cap = capacity


    def insert(self,node):
        pre = self.right.prev
        node.next = self.right
        node.prev = pre
        pre.next = node
        self.right.prev = node

    def remove(self,node):
        pre = node.prev
        nex = node.next
        pre.next = nex
        nex.prev = pre

    def get(self, key: int) -> int:
        if key in self.cache:
            self.remove(self.cache[key])
            self.insert(self.cache[key])
            return self.cache[key].val
        return -1
        

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            self.remove(self.cache[key])
        node = Node(key,value)
        self.cache[key] = node
        self.insert(node)

        if len(self.cache) > self.cap:    
            lru = self.left.next
            self.remove(lru)
            del self.cache[lru.key]
            
            

            

        
