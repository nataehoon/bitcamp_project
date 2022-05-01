import  pandas as pd
import matplotlib.pyplot as plt
from matplotlib.pyplot import title

filename = 'elderyPFCC.csv'
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

plt.figure()
colors = ['#ff9999', '#ffc000', '#8fd9b6', '#d395d0']
wedgeprops = {'width':0.7, 'edgecolor':'w', 'linewidth':5}
chartdata.plot(kind='pie', colors=colors, wedgeprops=wedgeprops, legend=False, autopct='%1.2f%%', rot=90, title='상장구분(노인)', startangle=90)
savedfilename = 'getelderyInfo01.png'
plt.savefig(savedfilename, dpi=400)
print(savedfilename + '파일이 저장됨.')

colors = ['r', 'g', 'b', 'y']

plt.figure()
chartdata.plot(kind='bar', legend=False, title='상장구분', rot=0, color=colors)
savedfilename = 'getelderyInfo02.png'
plt.savefig(savedfilename, dpi=400)
print(savedfilename + '파일이 저장됨.')