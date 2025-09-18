from typing import List

class Solution:
    def threeSumMulti(self, arr: List[int], target: int) -> int:
        arr.sort()  # sort for two-pointer technique
        MOD = 10**9 + 7
        n = len(arr)
        ans = 0

        for i in range(n):
            s, e = i + 1, n - 1   # avoid using the same element twice
            while s < e:
                total = arr[i] + arr[s] + arr[e]
                if total == target:
                    # Case 1: arr[s] == arr[e]
                    if arr[s] == arr[e]:
                        count = e - s + 1
                        ans += count * (count - 1) // 2
                        break
                    else:
                        # count duplicates of arr[s]
                        left_count = 1
                        while s + 1 < e and arr[s] == arr[s + 1]:
                            left_count += 1
                            s += 1
                        # count duplicates of arr[e]
                        right_count = 1
                        while e - 1 > s and arr[e] == arr[e - 1]:
                            right_count += 1
                            e -= 1
                        ans += left_count * right_count
                        s += 1
                        e -= 1
                elif total < target:
                    s += 1
                else:
                    e -= 1
        
        return ans % MOD
