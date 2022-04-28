import matplotlib.pyplot as plt
import pandas as pd

plt.rcParams['font.family'] = 'Malgun Gothic'

csv_flle = './../02.crawling/allStoreModified.csv'
myframe = pd.read_csv(csv_flle, index_col=0, encoding='utf-8')
# print(myframe.info())

print(myframe['brand'].unique())

mycolor = ['r', 'g', 'b', 'm']
brand_dict = {'cheogajip':'처가집', 'goobne':'굽네', 'kyochon':'교촌', 'pelicana':'페리카나', 'nene':'네네'}

mygrouping=myframe.groupby(['brand'])['brand']
chartData=mygrouping.count()

newindex=[brand_dict[idx] for idx in chartData.index]
chartData.index=newindex
print(chartData)

plt.figure()
chartData.plot(kind='pie', legend=False, autopct='%1.2f%%', colors=mycolor)
filename='makeChickenGraph01.png'
plt.savefig(filename, dpi=400, bbox_inches='tight')
print(filename + ' 파일이 저장되었습니다.')

plt.figure()

chartData.plot(kind='barh', rot=0, title='브랜드별 총 매장 개수', legend=False, color=mycolor)
filename='makeChickenGraph02.png'
plt.savefig(filename, dpi=400, bbox_inches='tight')
print(filename + ' 파일이 저장되었습니다.')
#
# seoulframe = myframe.loc[myframe['sido'] == '서울특별시']
# kkframe = myframe.loc[myframe['sido'] == '경기도']
#
# # '서울특별시', '경기도'를 합친 데이터
# newframe = pd.concat([seoulframe, kkframe], axis=0)
# print(newframe)
#
# mygrouping=newframe.groupby(['brand', 'sido'])['brand']
# chartData=mygrouping.count()
# print(chartData)
# plt.figure()
# chartData.plot(kind='bar', rot=0, title='매장별 지역별 점포 갯수', legend=True)
# filename='makeChickenGraph03.png'
# plt.savefig(filename, dpi=400, bbox_inches='tight')
# print(filename + ' 파일이 저장되었습니다.')
#
# print('finished')