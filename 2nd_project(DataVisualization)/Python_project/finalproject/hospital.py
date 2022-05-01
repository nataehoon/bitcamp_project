import pandas as pd

filename = '서울특별시 병원 인허가 정보.csv'
myframe = pd.read_csv(filename, encoding='utf-8', index_col=0)
# print(type(myframe))

openfit = myframe[myframe['상세영업상태명'] == '영업중']
df = pd.read_csv('구병원.csv', encoding='utf-8', index_col=0)

df = openfit['도로명주소']

addlist = df.values.tolist()

# print(addresslist)

addresslist = []
for oneitem in addlist:
    mydata = oneitem.split(' ')
    addresslist += mydata[1:2]

# print(addresslist)
# addresslist = pd.DataFrame(addresslist)

# print(type(addresslist))
print(set(addresslist))
result = list(set(addresslist))
result = pd.DataFrame(result)

result.to_csv('서울시 행정구.csv', encoding='utf-8')
#
# addresslist.to_csv('구병원.csv', encoding='utf-8')
# print('finished')
# openfit = pd.DataFrame(openfit)

# openfit.insert(loc=15, column='구', value=df, allow_duplicates=False)
# #
# print(openfit['구'])
#
# print(openfit.info)
# print(df)

# print(openfit.count())
#
# openfit.to_csv('영업중병원.csv', encoding='utf-8')
# print('finished')
