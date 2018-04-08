#import matplotlib.pyplot as plt
import sys
import plotly
from plotly.graph_objs import Scatter, Layout
import plotly.offline as offline
import numpy as np
from datetime import datetime
from time import gmtime, strftime
from math import sqrt
f = open('HolyData.txt','r')
lines = f.read().split("\n")
AI = []
QI = []
amplitude = []
base = 10

for i in lines[1:]:
    split_string = i.split();
    AI.append(split_string[0])
    QI.append(split_string[1])
    amplitude.append(sqrt(pow(2,int(split_string[0])+pow(2,int(split_string[1])))));
f.close()

samples = list(range(0,len(lines)-1,1))

plotly.offline.plot(
    {
    "data": [Scatter(x=samples,y=amplitude)],
    "layout": Layout(title="hello world")},
    image='png',auto_open=False)
