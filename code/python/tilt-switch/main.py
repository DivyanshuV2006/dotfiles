from flask import Flask, jsonify, render_template
import threading
import serial
import time

# Initialize Flask
app = Flask(__name__)

# Serial port setup
ser = serial.Serial('/dev/ttyACM0', 9600, timeout=1)
tilt_status = "NOT_TILTED"

# Serial reading thread
def read_serial():
    global tilt_status
    while True:
        try:
            line = ser.readline().decode('utf-8', errors='ignore').strip()
            if line:
                tilt_status = line
                # LED control
                if line == "TILTED":
                    ser.write(b"LED_ON\n")
                    print(tilt_status)
                else:
                    ser.write(b"LED_OFF\n")
                    print(tilt_status)
        except serial.SerialException:
            pass
        time.sleep(0.1)

threading.Thread(target=read_serial, daemon=True).start()

# Flask routes
@app.route("/")
def index():
    return render_template("index.html")

@app.route("/tilt")
def get_tilt():
    return jsonify({"tilt": tilt_status})

# Run Flask
if __name__ == "__main__":
    app.run(debug=True, use_reloader=False)
