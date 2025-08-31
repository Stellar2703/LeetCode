# Create a buuble around two elements 
# If they are not in order then rearrange them

# For the first pass 
# the largest element will "bubble up" to the last position

def bubble_sort(arr):
    n = len(arr)
    for i in range(n):
        for j in range(n-1-i):
# -i is to reduce the access of elements which are already soreted
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]
    return arr