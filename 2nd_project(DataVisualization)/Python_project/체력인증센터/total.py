import numpy as np
import  pandas as pd
import matplotlib.pyplot as plt
from matplotlib.pyplot import title

filename = 'totalPFCC.csv'
myframe = pd.read_csv(filename, encoding='utf-8')
print(myframe.info())
print('-'*40)

print(myframe.describe())
print('-'*40)

mygrouping = myframe.groupby(['상장구분'])['상장구분']
print(mygrouping)
print('-'*40)

chartdata = mygrouping.count()
print(type(chartdata))
chartdata.name = ''
print(chartdata)
print('-'*40)

plt.rcParams['font.family'] = 'Malgun Gothic'


###############################################################################################################
plt.figure()
colors = ['#ff9999', '#ffc000', '#8fd9b6', '#d395d0']
wedgeprops = {'width':0.7, 'edgecolor':'w', 'linewidth':5}
chartdata.plot(kind='pie', colors=colors, wedgeprops=wedgeprops, legend=False, autopct='%1.2f%%', rot=90, title='상장구분(전체)', startangle=90)
savedfilename = 'gettotalInfo(상장).png'
plt.savefig(savedfilename, dpi=400)
print(savedfilename + '파일이 저장됨.')
##############################################################################################################
agegrouping = myframe.groupby(['나이구분'])['나이구분']
agechart = agegrouping.count()
agechart.name=''

plt.figure()
colors = ['#ff9999', '#ffc000', '#8fd9b6']
agechart.plot.bar(color=colors, align='center', legend=False, rot=0, title='연령별 참여율')
savedfilename = 'gettotalInfo(나이).png'
plt.savefig(savedfilename, dpi=400)
print(savedfilename + '파일이 저장됨.')
##############################################################################################################
aggrouping = myframe.groupby(['연령대'])['연령대']
agchart = aggrouping.count()
agchart.name = ''

plt.figure()
colors = ['#ff9999', '#ffc000', '#8fd9b6', '#d395d0']
agchart.plot.bar(color=colors, align='center', legend=False, rot=0, title='연령별 참여율')
savedfilename = 'gettotalInfo(연령대).png'
plt.savefig(savedfilename, dpi=400)
print(savedfilename + '파일이 저장됨.')