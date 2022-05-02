import pandas as pd
import matplotlib.pyplot as plt


#######################서울시 건강지수######################################
from PIL.GifImagePlugin import _get_background

filename = '서울시 건강(표).csv'
df = pd.read_csv(filename, encoding='utf-8', index_col=0)

series = df['서울시']
plt.rcParams['font.family'] = 'Malgun Gothic'

plt.figure(figsize=(16, 5))
mycolors = ['dodgerblue','aqua','gold','mediumblue','olive','orange','pink','crimson','peru','darkgoldenrod']
series.plot(kind='bar', legend=False, title='서울시 건강지표', rot=10, fontsize=8, color=mycolors)
plt.savefig('서울시건강지수.png', dpi=400)

#######################서울시 건강관리 실천율######################################
filename = '서울시 건강관리 실천율.csv'
df2 = pd.read_csv(filename, encoding='utf-8', index_col=0)
print(df2)

plt.rcParams['font.family'] = 'Malgun Gothic'
mycolor = ['dodgerblue','red']
plt.figure(figsize=(16, 5))
df2.plot(kind='bar', legend=False, title='서울시 건강관리 실천율', rot=10, fontsize=8, color=mycolor)
plt.savefig('서울시건강관리실천율.png', dpi=400)

#######################서울시 규칙적인 운동 실천비율######################################
filename = '서울시 규칙적인 운동 실천비율.csv'
df3 = pd.read_csv(filename, encoding='utf-8', index_col=0)
print(df3)

plt.rcParams['font.family'] = 'Malgun Gothic'

plt.figure(figsize=(16, 5))
df3.plot(kind='bar', legend=False, title='서울시 규칙적인 운동 실천비율', rot=10, fontsize=8, color='aqua')
plt.savefig('서울시규칙적인운동실천비율.png', dpi=400)

#######################서울시 운동을 안하는 이유######################################
filename = '서울시 운동을 안하는 이유.csv'
df4 = pd.read_csv(filename, encoding='utf-8', index_col=0)
print(df4)

plt.rcParams['font.family'] = 'Malgun Gothic'

plt.figure(figsize=(16, 5))
df4.plot(kind='bar', legend=False, title='서울시 운동을 안하는 이유', rot=13, fontsize=8, color='gold')
plt.savefig('서울시 운동을 안하는 이유.png', dpi=400)

#######################서울시 주로 이용하는 운동장소######################################
filename = '서울시 주로 이용하는 운동장소.csv'
df5 = pd.read_csv(filename, encoding='utf-8', index_col=0)
print(df5)

plt.rcParams['font.family'] = 'Malgun Gothic'

plt.figure(figsize=(16, 5))
df5.plot(kind='bar', legend=False, title='서울시 주로 이용하는 운동장소', rot=13, fontsize=8, color='mediumblue')
plt.savefig('서울시 주로 이용하는 운동장소.png', dpi=400)

print('finished')