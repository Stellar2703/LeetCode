class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        def convert(num):
            number = 0
            for i in range(len(num)):
                temp = 0
                if num[i] == '1':
                    temp = 1
                    number = number*10 + temp
                elif num[i] == '2':
                    temp = 2
                    number = number*10 + temp   
                elif num[i] == '3':
                    temp = 3
                    number = number*10 + temp
                elif num[i] == '4':
                    temp = 4
                    number = number*10 + temp
                elif num[i] == '5':
                    temp = 5
                    number = number*10 + temp
                elif num[i] == '6':
                    temp = 6
                    number = number*10 + temp   
                elif num[i] == '7':
                    temp = 7
                    number = number*10 + temp
                elif num[i] == '8':
                    temp = 8
                    number = number*10 + temp
                elif num[i] == '9':
                    temp = 9
                    number = number*10 + temp   
                elif num[i] == '0':
                    temp = 0
                    number = number*10 + temp
                    
            return number
        res = convert(num1) * convert(num2)
        return str(res)