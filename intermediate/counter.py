import collections
from collections import Counter

#Containers
#Containers
#1ist
#dict
# tuple — inmuttable

# Types
#1. counter this video
# 2. deque
# 3. namedTup1e d)
# 4. orderdDict
# 5. defaultdict

c = Counter('gallahad')
print(c)
d = Counter(['gallahad', 'gallahad', 'gallahad'])
print(d)
e = Counter({'g': 3, 'a': 3, 'l': 3, 'h': 2, 'd': 1})
print(e)
f = Counter(g=3, a=3, l=3, h=2, d=1)  
print(f)

e.most_common(2)  # Returns the two most common elements
print(e.most_common(2))

e.update('gallahad')  # Updates the counts with another iterable

print(e & f)  # Intersection: min of corresponding counts
print(e | f)  # Union: max of corresponding counts