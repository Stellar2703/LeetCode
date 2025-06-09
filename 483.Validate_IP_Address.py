class Solution(object):
    def validIPAddress(self, queryIP):
        def ipv4(ip):
            if len(ip) != 4:
                return "Neither"
            for part in ip:
                if not part.isdigit():
                    return "Neither"
                if not 0 <= int(part) <= 255:
                    return "Neither"
                if part[0] == '0' and len(part) > 1:
                    return "Neither"
            return "IPv4"

        def ipv6(ip):
            if len(ip) != 8:
                return "Neither"
            for part in ip:
                if len(part) == 0 or len(part) > 4:
                    return "Neither"
                if not all(c in '0123456789abcdefABCDEF' for c in part):
                    return "Neither"
            return "IPv6"

        if queryIP.count('.') == 3:
            return ipv4(queryIP.split('.'))
        elif queryIP.count(':') == 7:
            return ipv6(queryIP.split(':'))
        else:
            return "Neither"
