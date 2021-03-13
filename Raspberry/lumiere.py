#!/usr/bin/python3
from datetime import datetime
import time
import RPi.GPIO as GPIO
import pyrebase
config = {
  "apiKey": "AIzaSyCG6-p16Z2AvMCJH6EaL0Zh_jLiSl8Sjsk",
  "authDomain": "monprojet-4763a.firebaseapp.com",
  "databaseURL": "https://monprojet-4763a-default-rtdb.firebaseio.com/",
  "storageBucket": "monprojet-4763a.appspot.com"
}

firebase = pyrebase.initialize_app(config)
database = firebase.database()

lum = database.child("Lumiere").get().val()
GPIO.setmode(GPIO.BOARD)
GPIO.setup(18, GPIO.OUT)
GPIO.setup(36, GPIO.OUT)

GPIO.output(18, GPIO.LOW)
GPIO.output(36, GPIO.LOW)

while True :
  lum = database.child("Lumiere").get().val()
  if lum==0:
          GPIO.output(18, GPIO.LOW)
          GPIO.output(36, GPIO.LOW)
  if lum==1:
          GPIO.output(18, GPIO.LOW)
          GPIO.output(36, GPIO.HIGH)
  if lum==2:
          GPIO.output(18, GPIO.HIGH)
          GPIO.output(36, GPIO.LOW)

