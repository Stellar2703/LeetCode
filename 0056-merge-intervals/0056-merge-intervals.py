class Solution:
    def merge(self, n: List[List[int]]) -> List[List[int]]:
        ans = []
        n.sort() 
        ans.append(n[0])
        print(n)
        ptr = 1
        for i in range(1,len(n)):
            if (ans[ptr-1][1] >= n[i][0]):
                # ans[ptr-1] = [ans[ptr-1][0],n[i][1]]
                ans[ptr-1] = [min(n[i][0],ans[ptr-1][0]),max(n[i][1],ans[ptr-1][1])]
            else:
                ans.append(n[i])
                ptr+=1
        return ans

            
    