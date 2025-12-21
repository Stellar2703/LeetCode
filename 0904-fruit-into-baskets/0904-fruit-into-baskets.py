class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        dic = {}
        l=0
        count =0
        for i in range(len(fruits)):
            dic[fruits[i]] = dic.get(fruits[i],0)+1
            while (len(dic)>2):
                dic[fruits[l]] = dic.get(fruits[l],0)-1
                if(dic[fruits[l]] == 0):
                    del dic[fruits[l]]
                l+=1
            count = max(count,i-l+1)
        return count
            