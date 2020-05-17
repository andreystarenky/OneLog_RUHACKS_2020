# app.py
from flask import Flask, request, render_template, send_from_directory
import time
from threading import Thread
import getVals
import datetime
import sys

print("RUNNING")

app = Flask(__name__)

timeSinceStarted = 0

@app.route("/")
def index():
    return "Welcome to my home page"

#@app.route("/time")
#def showTime():
    #return str(timeSinceStarted)

@app.route("/profile/")
@app.route("/profile/<name>")
def profile(name=None):
    return render_template("profile.html", name=name)

@app.route("/live_values")
def show_live_vals():
    testFile = open('output.logs', 'a+')
    testFile.write("live has been called at"+ datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S")+"/n")
    testFile.close()
    return send_from_directory("", "live_values.html")

@app.route("/chart_values")
def show_chart_vals():
    testFile = open('output.logs', 'a+')
    testFile.write("chart has been called at"+ datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S")+"/n")
    testFile.close()
    return send_from_directory("", "chart_vals.html")

@app.route("/post/<int:post_id>")
def hello3(post_id):
    return "<h2>Showing post " + str(post_id) +"</h2><p>Cool</p>"


@app.route("/index2")
def index2():
    return "Request Method: " + str(request.method)

@app.route("/index3", methods=['GET', 'POST']) # Can handle both GET and POST
def index3():
    if request.method == 'POST':
        return "USING POST"
    else:
        return "USING GET"


@app.route("/getCON")
def showConVals():
    return str(conValCall())

def conValCall():
    print("called")
    return getVals.getConVal()

def timeCounter():
    while(True):
        global timeSinceStarted
        timeSinceStarted+=1
        print("up 1")
        time.sleep(1)

def updateValues():
    while(True):
        print("CALLING GETVALS AT " + datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S"))
        getVals.getAllVals()
        time.sleep(14400)

def test():
    while (True):
        global timeSinceStarted
        timeSinceStarted += 1
        time.sleep(1)

@app.route("/dashboard")
def dashboard():
    return send_from_directory("ruhacks", "index.html")

@app.route("/login")
def login():
    return send_from_directory("ruhacks", "login.html")

if __name__ == "__main__" or __name__ == "app" or __name__ == "wsgi":  # on running python app.py
    print("started")
    #testFile = open('output.logs', 'a+')
    #testFile.write("main has been called at" + datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S") + "/n")
    #testFile.close()
    #print("VERSION: "+str(sys.version_info))
    #timeThread = Thread(target = timeCounter)
    #timeThread.start()
    #updateThread = Thread(target = updateValues)
    #updateThread.start()
    app.run(debug=False)     # run the flask app


