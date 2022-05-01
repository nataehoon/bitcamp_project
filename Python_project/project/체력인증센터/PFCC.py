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

def getPDCCData(pageNo, numOfRows):
    end_point = 'http://www.kspo.or.kr/openapi/service/nfaTestInfoService/getNfaTestRsltList'

    access_key = 'mVraESIn9AuD3ruz9yDkppVvRNyqmtwxAzQmoLVQjxyhMG8UGkd8TAiAjnTQEnRWhopmB%2FFT1060zAL3%2FZ3qSg%3D%3D'

    # parameters = '?resultType=xml'
    parameters = '?serviceKey='+access_key
    parameters += '&pageNo='+str(pageNo)
    parameters += '&numOfRows='+str(numOfRows)

    url = end_point + parameters

    print('url')
    print(url)

    result = getRequstUrl(url)
    if(result == None):
        return None
    else:
        return result

xmlResult = []

pageNo = 1
numOfRows = 100
nPage = 0
while(True):
    print('pageNo : %d, nPage : %d' % (pageNo, nPage))
    xmlData = getPDCCData(pageNo, numOfRows)
    print(xmlData)
    # print('-'*40)
    xmlTree = et.fromstring(xmlData)

    if (xmlTree.find('header').find('resultMsg').text == 'NORMAL SERVICE.'):
        totalCount = int(xmlTree.find('body').find('totalCount').text)
        print('데이터 총 갯수 : ', totalCount)  # 전체 조회된 결과 수
        break
        listitems = xmlTree.find('body').find('items').findall('item')
        print(listitems)

        for node in listitems:
            ageClass = node.find("ageClass").text
            ageDegree = node.find("ageDegree").text
            ageGbn = node.find("ageGbn").text
            certGbn = node.find("certGbn").text
            itemF001 = node.find("itemF001").text
            itemF002 = node.find("itemF002").text
            itemF003 = node.find("itemF003").text
            itemF004 = node.find("itemF004").text
            itemF005 = node.find("itemF005").text
            itemF006 = node.find("itemF006").text
            itemF007 = node.find("itemF007").text
            itemF008 = node.find("itemF008").text
            itemF009 = node.find("itemF009").text
            itemF010 = node.find("itemF010").text
            # itemF011 = node.find("itemF011").text
            itemF012 = node.find("itemF012").text
            itemF013 = node.find("itemF013").text
            itemF014 = node.find("itemF014").text
            itemF015 = node.find("itemF015").text
            itemF016 = node.find("itemF016").text
            itemF017 = node.find("itemF017").text
            itemF018 = node.find("itemF018").text
            itemF019 = node.find("itemF019").text
            itemF020 = node.find("itemF020").text
            itemF021 = node.find("itemF021").text
            itemF022 = node.find("itemF022").text
            itemF023 = node.find("itemF023").text
            itemF024 = node.find("itemF024").text
            itemF025 = node.find("itemF025").text
            itemF026 = node.find("itemF026").text
            itemF027 = node.find("itemF027").text
            itemF028 = node.find("itemF028").text
            # itemF029 = node.find("itemF029").text
            itemF030 = node.find("itemF030").text
            itemF031 = node.find("itemF031").text
            itemF032 = node.find("itemF032").text
            itemF033 = node.find("itemF033").text
            itemF034 = node.find("itemF034").text
            itemF035 = node.find("itemF035").text
            itemF036 = node.find("itemF036").text
            itemF037 = node.find("itemF037").text
            itemF038 = node.find("itemF038").text
            itemF039 = node.find("itemF039").text
            itemF040 = node.find("itemF040").text
            itemF041 = node.find("itemF041").text
            presNote = node.find("presNote")
            if presNote == None:
                presNote = ""
            else:
                presNote = presNote.text
            testYm = node.find("testYm").text

            onedict = {'연령대':ageClass, '나이':ageDegree, '나이구분':ageGbn, '상장구분':certGbn, '신장':itemF001, '체중':itemF002,
                       '체지방율':itemF003, '허리둘레':itemF004, '이완기혈압':itemF005, '수축기혈압':itemF006, '악력(우)':itemF007, '악력(좌)':itemF008,
                       '윗몸일으키기':itemF009, '반복점프':itemF010,  '일리노이(초)':itemF012,
                       '체공시간(초)1':itemF014, '협응력시간(초)':itemF015, '협응력실시횟수':itemF016, '협응력계산결과값':itemF017,
                       'BMI':itemF018, '교차윗몸일으키기':itemF019, '왕복오래달리기1':itemF020, '10M4회왕복달리기':itemF021,
                       '제자리멀리뛰기':itemF022, '의자에앉았다일어서기':itemF023, '6분걷기':itemF024, '2분제자리걷기':itemF025,
                       '의자에앉아3M표적돌기':itemF026, '8자보행(초)':itemF027, '상대악력(%)':itemF028, '왕복오래달리기2':itemF030,
                       '트레드밀_안정시':itemF031, '트레드밀_3분(bpm)':itemF032, '트레드밀_6분(bpm)':itemF033, '트레드밀_9분(bpm)':itemF034,
                       '트레드밀(VO2max)':itemF035, '스텝검사_회복시':itemF036, '스텝검사(VO2max)':itemF037, '허벅지(좌)':itemF038,
                       '허벅지(우)':itemF039, '전신반응(초)':itemF040, '체공시간(초)2':itemF041, '운동처방': presNote, '측정년월':testYm}
            # '앉아윗몸앞으로굽히기': itemF011,
            xmlResult.append(onedict)

        if totalCount == 0:
            break
        nPage = math.ceil(totalCount / numOfRows)
        if (pageNo == nPage):
            print('aaaaa')
            break

        pageNo += 1
    else:
        break

print('aaa')
print(xmlResult)
savedFilename = 'PFCC.csv'
myframe = pd.DataFrame(xmlResult)
myframe.to_csv(savedFilename)
print((savedFilename + '파일 저장됨'))
