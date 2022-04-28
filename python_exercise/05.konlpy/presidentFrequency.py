# https://www.nltk.org/install.html
import nltk
import matplotlib.pyplot as plt
import numpy as np

from wordcloud import WordCloud
from PIL import Image
from wordcloud import ImageColorGenerator

# try :
#     import jpype
#
#     import jpype1
# except :
#     import jpype

from konlpy.tag import Komoran



plt.rc('font', family='Malgun Gothic')

class Visualization:
    def __init__(self, wordList):
        self.wordList = wordList
        self.wordDict = dict(wordList)  # list를 사전으로 변경
        # print(wordDict)

    def makeWordCloud(self): # 워드 클라우드
        alice_color_file = 'alice_color.png'
        # alice_color_file = 'slice_pizza.jpg'
        alice_coloring = np.array(Image.open(alice_color_file))

        fontpath = 'malgun.ttf'
        wordcloud = WordCloud(font_path=fontpath, mask=alice_coloring, \
                              relative_scaling=0.2, background_color='lightyellow')
        print(self.wordDict)
        wordcloud = wordcloud.generate_from_frequencies(self.wordDict)

        image_colors = ImageColorGenerator(alice_coloring)

        # newwc = wordcloud.recolor(color_func=image_colors, random_state=42)

        plt.imshow(wordcloud)
        plt.axis('off')

        filename = 'myWordCloud.png'
        plt.savefig(filename, dpi=400, bbox_inches='tight')
        print(filename + ' 파일이 저장되었습니다.')
        plt.figure(figsize=(16, 8))
        # plt.show()
    # end def makeWordCloud(wordlist)

    def makeBarChart(self): # 막대 그래프 그리기
        barcount = 10  # 막대 갯수 : 10개만 그리겠다.
        xlow, xhigh = - 0.5, barcount - 0.5

        result = self.wordList[:barcount]
        chartdata = []  # 차트 수치
        xdata = []  # 글씨
        mycolor = ['r', 'g', 'b', 'y', 'm', 'c', '#FFF0F0', '#CCFFBB', '#05CCFF', '#11CCFF']

        for idx in range(len(result)):
            chartdata.append(result[idx][1])
            xdata.append(result[idx][0])

            value = str(chartdata[idx]) + '건'  # 예시 : 60건
            # 그래프의 위에 "건수" 표시
            plt.text(x=idx, y=chartdata[idx] - 5, s=value, fontsize=8, horizontalalignment='center')

        plt.xticks(range(barcount), xdata, rotation=45)
        plt.bar(range(barcount), chartdata, align='center', color=mycolor)

        plt.title('상위 ' + str(barcount) + '빈도수')
        plt.xlim([xlow, xhigh])
        plt.xlabel('주요 키워드')
        plt.ylabel('빈도수')

        filename = 'myBarChart.png'
        plt.savefig(filename, dpi=400, bbox_inches='tight')
        print(filename + ' 파일이 저장되었습니다.')
        # plt.show()
    # end def makeBarChart(wordlist):
# end class Visualization

filename = '문재인대통령신년사.txt'
ko_con_text = open(filename, encoding='utf-8').read()
print(type(ko_con_text)) # str
print('-' * 40)

# print(ko_con_text)
# print('-' * 40)

komo = Komoran(userdic='user_dic.txt')

tokens_ko = komo.nouns(ko_con_text)
# print(tokens_ko) # 형태소 분석된 각 단어들
# print('-' * 40)

stop_word_file = 'stopword.txt'
stop_file = open(stop_word_file, 'rt', encoding='utf-8')
stop_words = [ word.strip() for word in stop_file.readlines()]

# print(stop_words)

tokens_ko = [each_word for each_word in tokens_ko if each_word not in stop_words]
# print( tokens_ko )
# print('-' * 40)
#
# A Text is typically initialized from a given document or corpus. E.g.:
ko = nltk.Text(tokens=tokens_ko)

print(type(ko)) # <class 'nltk.text.Text'>
print(type(ko.vocab())) # <class 'nltk.probability.FreqDist'>
print(type(ko.vocab().most_common(50))) # <class 'list'>

# print( ko.vocab().most_common(10))
# print('-' * 40)

data = ko.vocab().most_common(500)
wordlist = list() # 튜플(단어, 빈도수)을 저장할 리스트

for word, count in data :
    # count는 빈도수를 의미하고, len(word)는 단어의 길이를 의미합니다.
    if (count >= 1 and len(word) >= 2) :
        wordlist.append((word, count))

print(wordlist)
visual = Visualization(wordlist)
visual.makeWordCloud()
visual.makeBarChart()

print('finished')