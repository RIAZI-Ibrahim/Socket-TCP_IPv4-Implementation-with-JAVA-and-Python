import socket


message = input()
msg = str.encode(message)
addressPort = ("127.0.0.1", 1234)
ClientUdp = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
ClientUdp.sendto(msg, addressPort)
