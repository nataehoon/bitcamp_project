import datetime, math
import xml.etree.ElementTree as et
import urllib.request, urllib.parse

import pandas as pd


def getRequstUrl(url):
    req = urllib.request.Request(url)
    try:
        response = urllib.request.urlopen(url)
        if response.getcode() == 200:
            print('%s success' % (datetime.datetime.now()))
            return response.read().decode('utf-8')
    except Exception as e:
        print('%s failure' % (datetime.datetime.now()))
        print(e)
        return None

def getSeoulData():
    end_point = 'http://openapi.seoul.go.kr:8088/5373566c796e6174343467665a4d6c/xml/SdeTlSccoSigW/1/25'

    access_key = 'mVraESIn9AuD3ruz9yDkppVvRNyqmtwxAzQmoLVQjxyhMG8UGkd8TAiAjnTQEnRWhopmB%2FFT1060zAL3%2FZ3qSg%3D%3D'

    # parameters = '?resultType=xml'
    # parameters += 'serviceKey='+access_key
    # parameters += '&START_INDEX='+str(START_INDEX)
    # parameters += '&END_INDEX='+str(END_INDEX)

    url = end_point

    print('url')
    print(url)

    result = getRequstUrl(url)
    if(result == None):
        return None
    else:
        return result

xmlResult = []

# START_INDEX = 1
# END_INDEX = 5
# nPage = 0
while(True):
    # print('START_INDEX : %d, nPage : %d' % (START_INDEX, nPage))
    xmlData = getSeoulData()
    print(xmlData)
    # print('-'*40)
    xmlTree = et.fromstring(xmlData)

    if (xmlTree.find('RESULT').find('MESSAGE').text == '정상 처리되었습니다'):
        totalCount = int(xmlTree.find('list_total_count').text)
        print('데이터 총 갯수 : ', totalCount)  # 전체 조회된 결과 수

        listitems = xmlTree.findall('row')
        print(listitems)

        for node in listitems:
            OBJECTID = node.find("OBJECTID").text
            SIG_CD = node.find("SIG_CD").text
            SIG_KOR_NM = node.find("SIG_KOR_NM").text
            SIG_ENG_NM = node.find("SIG_ENG_NM").text
            ESRI_PK = node.find("ESRI_PK").text
            # SHAPE = node.find("SHAPE").text
            LAT = node.find("LAT").text
            LNG = node.find("LNG").text


            onedict = {'순번':OBJECTID, '시군구코드':SIG_CD, '시군구명_한글':SIG_KOR_NM, '시군구명_영문':SIG_ENG_NM, 'ESRI_PK':ESRI_PK, '위도':LAT, '경도':LNG}
            xmlResult.append(onedict)
            if OBJECTID == '25':
                break

    break
        # nPage = math.ceil(totalCount / END_INDEX)
        # if (START_INDEX == nPage):
        #     print('aaaaa')
        #     break
        #
        # START_INDEX += 1
    #
    # else:
    #     break

print('aaa')
print(xmlResult)
savedFilename = 'SeoulData.csv'
myframe = pd.DataFrame(xmlResult)
myframe.to_csv(savedFilename)
print((savedFilename + '파일 저장됨'))
