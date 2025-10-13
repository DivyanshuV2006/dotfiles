import serial
import time

ser = serial.Serial('/dev/ttyACM0', 9600, timeout=1)  # replace COM3 with your port
time.sleep(2)  # wait for Arduino to reset

# Send data
ser.write(b'Hello Arduino\n')

# Read response
response = ser.readline().decode().strip()
print(response)

ser.close()
