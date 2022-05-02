import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

class fitnessRegion():

    def __init__(self, workfile):

        self.workfile = workfile
        self.myframe = pd.read_csv(self.workfile, encoding='utf-8')
        self.myframe.loc[self.myframe['지번주소'] == '-', ['지번주소']] = self.myframe['도로명주소']

        self.insertionGu()
        # self.fitnessInfo()
        # self.fitnessLocation()

    def insertionGu(self):
        address = self.myframe['지번주소']
        # print(address)
        addlists = address.values.tolist()
        # print(type(addlists))
        # print(addlists)

        addresslists = []
        for oneitem in addlists:
            mydata = oneitem.split(' ')
            addresslists += mydata[1:2]
        print(addresslists)
        print(type(addresslists))
        print(type(address))
        addresslists = pd.DataFrame(addresslists)
        self.myframe = pd.DataFrame(self.myframe)
        print(type(addresslists))
        self.myframe.insert(loc=15, column='구', value=addresslists, allow_duplicates=False)

        print(self.myframe['구'])
        print(self.myframe['지번주소'])

        # myset = set(addresslists)
        # myaddress = myset
        # print(myaddress)

        savedfilename = 'newfitness.csv'
        myfile = pd.DataFrame(self.myframe)
        myfile.to_csv(savedfilename)
        print(savedfilename + '파일 저장됨')

    def fitnessInfo(self):
        fitnessinfo = pd.read_csv('newfitness.csv', encoding='utf-8')
        fitnessgroup = fitnessinfo.groupby(['구'])['구']
        chartdata = fitnessgroup.count()
        plt.rcParams['font.family'] = 'Malgun Gothic'

        plt.figure()
        mycolors = ['dodgerblue', 'aqua', 'gold', 'mediumblue', 'olive', 'orange', 'pink', 'crimson', 'peru',
                    'darkgoldenrod']
        chartdata.plot(kind='bar', legend=False, title='지역별 피트니스센터', rot=0, fontsize=4, color=mycolors)
        savedfilename = 'getfitGu.png'
        plt.savefig(savedfilename, dpi=400)
        print(savedfilename + '파일이 저장됨.')

    def fitnessLocation(self):
        fitness = pd.read_csv('newfitness.csv', encoding='utf-8')
        fitnessgroup = fitness.groupby(['구'])['구']
        chartdata = fitnessgroup.count()
        print(chartdata)

        savedfilename = 'Guincenter.csv'
        myfile = pd.DataFrame(chartdata)
        myfile.to_csv(savedfilename)
        print(savedfilename, '파일 저장됨')

filename = '영업중센터.csv'
fitness = fitnessRegion(filename)
print('finished')