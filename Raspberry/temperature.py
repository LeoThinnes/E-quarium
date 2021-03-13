import time
import pyrebase
config = {
  "apiKey": "AIzaSyCG6-p16Z2AvMCJH6EaL0Zh_jLiSl8Sjsk",
  "authDomain": "monprojet-4763a.firebaseapp.com",
  "databaseURL": "https://monprojet-4763a-default-rtdb.firebaseio.com/",
  "storageBucket": "monprojet-4763a.appspot.com"
}

firebase = pyrebase.initialize_app(config)
database = firebase.database()

#Lecture du fichier à l'emplacement
def lireFichier (emplacement) :
        fichierTemperature = open(emplacement)
        contenuFichier = fichierTemperature.read()
        fichierTemperature.close()
        return contenuFichier

#Récupération de la température dans le fichier
def recupererTemperature (contenuFichier) :
        secondeLigne = contenuFichier.split("\n")[1]
        temperatureData = secondeLigne.split(" ")[9]
        temperature = float(temperatureData[2:])
        temperature = temperature/1000
        temperature = round(temperature,1)
        return temperature

#Envoi de la température à la base de donnée
while True :
    contenuFichier = lireFichier("/sys/bus/w1/devices/28-0414692f33ff/w1_sl$
    temperature = recupererTemperature(contenuFichier)
    database.child("ParamTemp/tempActuelle").set(temperature)
    time.sleep(6)


