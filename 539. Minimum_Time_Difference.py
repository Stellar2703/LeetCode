# import math
class Solution(object):
    def findMinDifference(self, timePoints):
        """
        :type timePoints: List[str]
        :rtype: int
        """
        min_diff = float('inf')        
        minutes = sorted(int(time[:2]) * 60 + int(time[3:]) for time in timePoints)
        minutes.append(24*60 + minutes[0])
        print(minutes)

        for i in range(1,len(minutes)):
            diff = minutes[i]-minutes[i-1]

            if diff < min_diff:
                min_diff = diff
        
        return min_diff