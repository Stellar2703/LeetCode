from collections import Counter
# s="shashwath"
# for i in s:
#     if s.count(char)==1:
#         return 1
    
# return -1

# queryIP="192:168.10.1"
# if '.' in queryIP:
#     ip=queryIP.split(".")
# if ':' in queryIP:
#     ip=queryIP.split(":")

# print(ip)


# li = [1, 2, 3, 4, 8, 7, 7, 9, 9]
# b = set(li)
# b.sort()
# print(b[len(b)-2])
# print(b)

# str1 = "zebra"
# cou = Counter(str1)
# print(cou)  

# a = int(input())
# b = input()
# c= b.split(" ")
# print(tuple(map(int, c)))
# print(hash(c))



# import mysql.connector

# mydb = mysql.connector.connect(
#   host="localhost",
#   user="test",
#   password="test",
#   port = 3307,
#   database="linux"
# )
# mycursor = mydb.cursor()

# sql = "INSERT INTO admin_users (id ,email , name) VALUES (2 , 'jeevitha@bitsathy.ac.in', 'Jeevitha')"
# mycursor.execute(sql)

# mydb.commit()

# print(mydb)



# mycursor.execute("SELECT * FROM admin_users")

# myresult = mycursor.fetchall()

# for x in myresult:
#   print(x)


# a = "Hello, World!"
# for i in a:
#     print(i)


# j = 1
# for i in range(1, 10):
#     if nums[i-1] ==nums[i]:
#         count +=1
#     else:
#         count = 1
#     if count <= 3:
        

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

num = "1234567890"
result = convert(num)
print(result)