import time
import datetime

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
    temperature = temperature / 1000
    return temperature

#Sauvegarde de la température
def sauvegarde (temperature, date, emplacement) :
    fichierSauvegarde = open(emplacement, "a")
    fichierSauvegarde.write(str(date)+"   ")
    fichierSauvegarde.write(str(temperature)+'\r\n')
    fichierSauvegarde.close()
    
while True :
    date = datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S')
    contenuFichier = lireFichier("/sys/bus/w1/devices/28-xxxxxxxx/w1_slave")
    temperature = recupererTemperature(contenuFichier)
    sauvegarde(temperature, date, "Temperature.txt")
    time.sleep(60)
