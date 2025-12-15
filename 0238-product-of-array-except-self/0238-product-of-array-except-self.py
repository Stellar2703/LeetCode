class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        # l = [0] * len(nums)
        # r = [0] * len(nums)
        # l_num,r_num = 1,1
        # for i in range(len(nums)):
        #     j = -i -1
        #     l[i] = l_num
        #     r[j] = r_num
        #     l_num*=nums[i]
        #     r_num*=nums[j]
        # return [x*y for x,y in zip(l,r)]
        result = []
        number = 1
        zero = 0
        for i in nums:
            if i == 0:
                zero+=1
            else:
                number = number * i
        for i in nums:
            if zero > 1:
                result.append(0)
            elif zero == 1:
                if i == 0:
                    result.append(number)
                else:
                    result.append(0)
            else:
                result.append(number//i)
        return result
