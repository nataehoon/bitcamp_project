import  json
from pandas import DataFrame

jsonfile = '서울특별시 체력단련장업 인허가 정보.json'

myfile = open(jsonfile, 'rt', encoding='utf-8')
myfile = myfile.read()

jsonData = json.loads(myfile)
print(type(jsonData))
print('-'*30)

totallist = []
mycolumns = []
idx = 0
for oneitem in jsonData:
    print(type(oneitem))
    sublist = []
    for key in oneitem.keys():
        if idx == 0:
            mycolumns.append(key)
        sublist.append(oneitem[key])
    idx += 1
    totallist.append(sublist)
    print('-'*30)
    print(totallist)
#
# myframe = DataFrame(totallist, columns=mycolumns)
# filename = 'fitness2.csv'
# myframe.to_csv(filename, encoding='utf-8', index=False)
# print('finished')