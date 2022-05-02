from array import array

import pandas as pd

# filename='영업중병원.csv'
# df = pd.read_csv(filename, encoding='utf-8')
# # print(df)
#
#
# df = df[['사업장명', '구', '도로명주소', '좌표정보(X)', '좌표정보(Y)']]
# print(df)
#
# savedfilename = 'hospitalinfo.csv'
# myfile = pd.DataFrame(df)
# myfile.to_csv(savedfilename)

str = 'i love books everday'
print(str.find('e'))
print(str.rfind('e'))
print(str.count('e'))
print(len('e'))

varA = 95
if varA >= 60:
    print('d')
elif varA >= 70:
    print('c')
elif varA >= 80:
    print('b')
elif varA >= 90:
    print('a')
str1='123'
str2='2'

gop = int(str1) * int(str2)
print(gop)


def myaverage(a, b):
    s = (a + b)/2
    print(s)
    return s


average = myaverage(1, 10)
print(average)

# weight = input('몸무게를 입력하세요 : ')
# height = input('키(신장)를 입력하세요 : ')
# bmi = int(weight)/(int(height)*int(height)/10000)
# print(weight)
# print(height)
# print(bmi)

for i in range(2, 10):
    print('--------------------[' + str(i) + ']단------------------')
    for j in range(1, 10):
        print(i, 'x', j, '=', i*j)

