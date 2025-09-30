class Solution:
    def groupThePeople(self, groupSizes: List[int]) -> List[List[int]]:
        ans = []
        temp = defaultdict(list)
        for  person,groupsize in enumerate(groupSizes):
            temp[groupsize].append(person)
            if len(temp[groupsize]) == groupsize:
                ans.append(temp[groupsize])
                temp[groupsize] = []
        # for i in temp.values():
        #     if i:
        #         ans.append(i)
        return ans
