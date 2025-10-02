from typing import List

class Solution:
    # def anagram(self, i: str, j: str) -> bool:
    #     # Check if both words are anagrams
    #     return sorted(i) == sorted(j)
        
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
    #     res = []
    #     visited = [False] * len(strs)  # To avoid reusing words

    #     for i in range(len(strs)):
    #         if visited[i]:
    #             continue
    #         sol = [strs[i]]
    #         visited[i] = True
    #         for j in range(i + 1, len(strs)):
    #             if not visited[j] and self.anagram(strs[i], strs[j]):
    #                 sol.append(strs[j])
    #                 visited[j] = True
    #         res.append(sol)
    #     return res
        
        # ans = defaultdict(list)
        # for i in strs:
        #     ans[''.join(sorted(i))].append(i)
        # return list(ans.values())


        ans = defaultdict(list)
    
        for word in strs:
            count = [0] * 26
            for ch in word:
                count[ord(ch) - ord('a')] += 1
            ans[tuple(count)].append(word)  # tuple is hashable
        
        return list(ans.values())
            
            