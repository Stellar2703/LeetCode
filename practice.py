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



import mysql.connector

mydb = mysql.connector.connect(
  host="localhost",
  user="test",
  password="test",
  port = 3307,
  database="linux"
)
mycursor = mydb.cursor()

# sql = "INSERT INTO admin_users (id ,email , name) VALUES (2 , 'jeevitha@bitsathy.ac.in', 'Jeevitha')"
# mycursor.execute(sql)

# mydb.commit()

# print(mydb)



mycursor.execute("SELECT * FROM admin_users")

myresult = mycursor.fetchall()

for x in myresult:
  print(x)
