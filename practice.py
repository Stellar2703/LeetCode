
# s="shashwath"
# for i in s:
#     if s.count(char)==1:
#         return 1
    
# return -1

queryIP="192:168.10.1"
if '.' in queryIP:
    ip=queryIP.split(".")
if ':' in queryIP:
    ip=queryIP.split(":")

print(ip)