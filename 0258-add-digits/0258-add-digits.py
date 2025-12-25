class Solution(object):
    def addDigits(self, num):
        """
        :type num: int
        :rtype: int
        """
        # while num >= 10:
        #     num =sum([int(x) for x in str(num)])
        # return num
        if num == 0:
            return 0
        return ((num-1)% 9 )+1