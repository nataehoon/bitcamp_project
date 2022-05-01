import pandas as pd

filename='newfitness.csv'
df = pd.read_csv(filename, encoding='utf-8', index_col=0)
# print(df)


df = df[['사업장명', '구', '지번주소', '좌표정보(X)', '좌표정보(Y)']]
print(df)

savedfilename = 'fitnessinfo.csv'
myfile = pd.DataFrame(df)
myfile.to_csv(savedfilename)

