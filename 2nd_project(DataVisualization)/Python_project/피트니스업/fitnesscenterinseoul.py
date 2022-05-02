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

def getfitnessdata(START_INDEX, END_INDEX):
    end_point = 'http://openapi.seoul.go.kr:8088/79614866586e617437366f444a4745/xml/LOCALDATA_104201/1001/2000'

    access_key = 'mVraESIn9AuD3ruz9yDkppVvRNyqmtwxAzQmoLVQjxyhMG8UGkd8TAiAjnTQEnRWhopmB%2FFT1060zAL3%2FZ3qSg%3D%3D'

    # parameters = '?TYPE=xml'
    # parameters += 'SERVICE='+access_key
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

START_INDEX = 1
END_INDEX = 5
nPage = 0
while(True):
    print('START_INDEX : %d, nPage : %d' % (START_INDEX, nPage))
    xmlData = getfitnessdata(START_INDEX, END_INDEX)
    print(xmlData)
    # print('-'*40)
    xmlTree = et.fromstring(xmlData)

    if (xmlTree.find('RESULT').find('MESSAGE').text == '정상 처리되었습니다'):
        totalCount = int(xmlTree.find('list_total_count').text)
        print('데이터 총 갯수 : ', totalCount)  # 전체 조회된 결과 수

        listitems = xmlTree.findall('row')
        print(listitems)

        for node in listitems:

            OPNSFTEAMCODE = node.find('OPNSFTEAMCODE').text
            MGTNO = node.find('MGTNO').text
            APVPERMYMD = node.find('APVPERMYMD').text
            APVCANCELYMD = node.find('APVCANCELYMD').text
            TRDSTATEGBN = node.find('TRDSTATEGBN').text
            TRDSTATENM = node.find('TRDSTATENM').text
            DTLSTATEGBN = node.find('DTLSTATEGBN').text
            DTLSTATENM = node.find('DTLSTATENM').text
            DCBYMD = node.find('DCBYMD').text
            CLGSTDT = node.find('CLGSTDT').text
            ROPNYMD = node.find('ROPNYMD').text
            SITETEL = node.find('SITETEL').text
            SITEAREA = node.find('SITEAREA').text
            SITEPOSTNO = node.find('SITEPOSTNO').text
            SITEWHLADDR = node.find('SITEWHLADDR').text
            RDNWHLADDR = node.find('RDNWHLADDR').text
            RDNPOSTNO = node.find('RDNPOSTNO').text
            BPLCNM = node.find('BPLCNM').text
            LASTMODTS = node.find('LASTMODTS').text
            UPDATEGBN = node.find('UPDATEGBN').text
            UPDATEDT = node.find('UPDATEDT').text
            UPTAENM = node.find('UPTAENM').text
            X = node.find('X').text
            Y = node.find('Y').text
            CULPHYEDCOBNM = node.find('CULPHYEDCOBNM').text
            PUPRSENM = node.find('PUPRSENM').text
            INSURJNYNCODE = node.find('INSURJNYNCODE').text
            LDERCNT = node.find('LDERCNT').text
            BDNGDNGNUM = node.find('BDNGDNGNUM').text
            BDNGYAREA = node.find('BDNGYAREA').text
            MEMCOLLTOTSTFNUM = node.find('MEMCOLLTOTSTFNUM').text
            DRMKCOBNM = node.find('DRMKCOBNM').text
            BUPNM = node.find('BUPNM').text

            onedict = {'개방자치단체코드':OPNSFTEAMCODE, '관리번호':MGTNO, '인허가일자':APVPERMYMD, '인허가취소일자':APVCANCELYMD, '영업상태코드':TRDSTATEGBN, '영업상태명':TRDSTATENM,
                      '상세영업상태코드':DTLSTATEGBN, '상세영업상태명':DTLSTATENM, '폐업일자':DCBYMD, '휴업시작일자':CLGSTDT, '휴업종료일자':CLGSTDT, '제게업일자':ROPNYMD,
                      '전화번호':SITETEL, '소재지면적':SITEAREA, '소재지우편번호':SITEPOSTNO, '지번주소':SITEWHLADDR, '도로명주소':RDNWHLADDR,
                      '도로명우편번호':RDNPOSTNO, '사업장명':BPLCNM, '최종수정일자':LASTMODTS, '데이터갱신구분':UPDATEGBN, '데이터갱신일자':UPDATEDT, '업태명구분':UPTAENM,
                      '좌표정보(X)':X, '좌표정보(Y)':Y, '문화체육업종명':CULPHYEDCOBNM, '공사립구분명':PUPRSENM, '보험가입여부코드':INSURJNYNCODE,
                      '지도자수':LDERCNT, '건축물동수':BDNGDNGNUM, '건축물연면적':BDNGYAREA, '회원모집총인원':MEMCOLLTOTSTFNUM,
                      '세부업종명':DRMKCOBNM, '법인명':BUPNM }

            xmlResult.append(onedict)

        if totalCount == 0:
            break
        nPage = math.ceil(totalCount / END_INDEX)
        if (START_INDEX == nPage):
            print('aaaaa')
            break

        START_INDEX += 1
    else:
        break

print('aaa')
print(xmlResult)
savedFilename = 'fitness2.csv'
myframe = pd.DataFrame(xmlResult)
myframe.to_csv(savedFilename)
print((savedFilename + '파일 저장됨'))
