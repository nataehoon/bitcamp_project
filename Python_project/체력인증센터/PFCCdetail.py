import pandas as pd
import matplotlib.pyplot as plt
import numpy as np

class PFCCdtail():

    def __init__(self, workfile):
        self.workfile = workfile
        self.myframe = pd.read_csv(self.workfile, encoding='utf-8', index_col=0)
        # print(self.myframe.head())
        # print(self.myframe.info())

        self.myframe.sort_values(by=['연령대'], axis=0)
        # print(self.myframe.head(10))

        teenager = self.myframe[self.myframe['나이구분'] == '청소년']
        adult = self.myframe[self.myframe['나이구분'] == '성인']
        eldery = self.myframe[self.myframe['나이구분'] == '노인']

        self.myframe.to_csv('totalPFCC.csv', encoding='utf-8')
        teenager.to_csv('teenPFCC.csv', encoding='utf-8')
        adult.to_csv('adultPFCC.csv', encoding='utf-8')
        eldery.to_csv('elderyPFCC.csv', encoding='utf-8')

        self.teenage()
        self.adult()
        self.eldery()

    def teenage(self):
        filename = 'teenPFCC.csv'
        myframe = pd.read_csv(filename, encoding='utf-8')
        mygrouping = myframe.groupby(['상장구분'])['상장구분']
        chartdata = mygrouping.count()
        chartdata.name = ''

        plt.rcParams['font.family'] = 'Malgun Gothic'

        plt.figure()
        colors = ['#ff9999', '#ffc000', '#8fd9b6', '#d395d0']
        wedgeprops = {'width': 0.7, 'edgecolor': 'w', 'linewidth': 5}
        chartdata.plot(kind='pie', colors=colors, wedgeprops=wedgeprops, legend=False, autopct='%1.2f%%', rot=90,
                       title='상장구분(청소년)', startangle=90)
        savedfilename = 'getteenagerInfo01.png'
        plt.savefig(savedfilename, dpi=400)
        print(savedfilename + '파일이 저장됨.')

    def adult(self):
        filename = 'adultPFCC.csv'
        myframe = pd.read_csv(filename, encoding='utf-8')
        mygrouping = myframe.groupby(['상장구분'])['상장구분']
        chartdata = mygrouping.count()
        chartdata.name = ''

        plt.rcParams['font.family'] = 'Malgun Gothic'

        plt.figure()
        colors = ['#ff9999', '#ffc000', '#8fd9b6', '#d395d0']
        wedgeprops = {'width': 0.7, 'edgecolor': 'w', 'linewidth': 5}
        chartdata.plot(kind='pie', colors=colors, wedgeprops=wedgeprops, legend=False, autopct='%1.2f%%', rot=90,
                       title='상장구분(성인)', startangle=90)
        savedfilename = 'getadultInfo01.png'
        plt.savefig(savedfilename, dpi=400)
        print(savedfilename + '파일이 저장됨.')

    def eldery(self):
        filename = 'elderyPFCC.csv'
        myframe = pd.read_csv(filename, encoding='utf-8')
        mygrouping = myframe.groupby(['상장구분'])['상장구분']
        chartdata = mygrouping.count()
        chartdata.name = ''

        plt.rcParams['font.family'] = 'Malgun Gothic'

        plt.figure()
        colors = ['#ff9999', '#ffc000', '#8fd9b6', '#d395d0']
        wedgeprops = {'width': 0.7, 'edgecolor': 'w', 'linewidth': 5}
        chartdata.plot(kind='pie', colors=colors, wedgeprops=wedgeprops, legend=False, autopct='%1.2f%%', rot=90,
                       title='상장구분(노인)', startangle=90)
        savedfilename = 'getelderyInfo01.png'
        plt.savefig(savedfilename, dpi=400)
        print(savedfilename + '파일이 저장됨.')

filename = 'PFCC.csv'
PFCC = PFCCdtail(filename)
print('finished')
