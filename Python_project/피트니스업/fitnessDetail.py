import pandas as pd

filename = 'fitness.csv'
myframe = pd.read_csv(filename, encoding='utf-8', index_col=0)
# print(type(myframe))

openfit = myframe[myframe['상세영업상태명'] == '영업중']
print(openfit)

openfit.to_csv('영업중센터.csv', encoding='utf-8')
print('finished')