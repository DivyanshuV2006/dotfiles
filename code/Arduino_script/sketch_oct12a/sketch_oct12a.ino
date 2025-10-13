int tiltPin = 13;
int ledPin = 9;
int tiltState = 0;

void setup() {
  pinMode(tiltPin, INPUT);
  pinMode(ledPin, OUTPUT);
  Serial.begin(9600);
}

void loop() {
  tiltState = digitalRead(tiltPin);

  // Send tilt status
  if (tiltState == HIGH) {
    Serial.println("TILTED");
    //digitalWrite(ledPin, HIGH);
  } else {
    Serial.println("NOT_TILTED");
    //digitalWrite(ledPin, LOW);
  }

  // Check for LED commands
  if (Serial.available() > 0) {
    String cmd = Serial.readStringUntil('\n');
    if (cmd == "LED_ON") digitalWrite(ledPin, HIGH);
    if (cmd == "LED_OFF") digitalWrite(ledPin, LOW);
  }

  delay(200);
}
