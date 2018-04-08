import matplotlib.pyplot as plt
import sys
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
#i = lines.split(' ',1)[0]
#q = lines.split(' ',1)[1]

#i_star = [i.split(' ')[0] for i in lines]
for i in lines[1:]:
    split_string = i.split();
    #print(split_string)
    AI.append(split_string[0])
    QI.append(split_string[1])
    #print(type(int(split_string[0])))
    amplitude.append(sqrt(pow(2,int(split_string[0])+pow(2,int(split_string[1])))));

f.close()
amplitude = np.asarray(amplitude)
samples = np.arange(0,len(lines)-1,1)
fig, ax = plt.subplots()
plt.plot(samples,amplitude)
plt.title('Wifi')
plt.ylabel('Magnitude')
plt.xlabel('Samples',fontdict=None, labelpad=None)
fig.savefig('Screenshots/Magnitude.png')
plt.show()
sys.exit()

